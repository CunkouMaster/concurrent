package com.hua.basic.chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huazai
 * @date 2019/10/11 14:12
 */
public class SimpleThreadPool3 extends Thread{

    private int size;//线程池数量
    private final int queueSize;
    private final DiscardPolicy discardPolicy;

    private int min;
    private int max;
    private int active;

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getActive() {
        return active;
    }

    public boolean isDestroy(){
        return this.isDestroy;
    }


    /**
     * 缓冲队列默认数量
     */
    private final static int DEFAULT_TASK_QUEUE_SIZE = 1000;

    private static volatile int seq = 0;

    private final static String THREAD_PREFIX = "Simple_Thread_Pool-";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    /**
     * 默认拒绝策略
     */
    private final static DiscardPolicy DEFAULT_DISCARD_POLICY = () ->{throw new DiscardException("===== discard this task =====");};

    private volatile boolean isDestroy = false;




    /**
     * 任务缓冲队列
     */
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    public SimpleThreadPool3() {
        this(4,8,12, DEFAULT_TASK_QUEUE_SIZE, DEFAULT_DISCARD_POLICY);
    }

    private SimpleThreadPool3(int min,int active,int max, int queueSize, DiscardPolicy discardPolicy) {
        this.min = min;
        this.active = active;
        this.max = max;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    @Override
    public void run() {
        while (!isDestroy) {
            System.out.printf("=== pool#min:%d，active:%d，max:%d，current:%d，queueSize:%d ===\n",
                    this.min,this.active,this.max,this.size,TASK_QUEUE.size());
            try {
                Thread.sleep(2000);
                if(TASK_QUEUE.size() > active && size < active){
                    for(int i=size ; i< active; i++){
                        createWorkerTask();
                    }
                    System.out.println(" the pool incremented to active");
                    size = active;
                } else if(TASK_QUEUE.size() > max && size < max){
                    for(int i=size ; i< max; i++){
                        createWorkerTask();
                    }
                    System.out.println(" the pool incremented to max");
                    size = max;
                }

                if(TASK_QUEUE.isEmpty() && size > active){
                    System.out.println("===== reduce =====");
                    synchronized (THREAD_QUEUE) {
                        int releaseSize = size - active;
                        for(Iterator<WorkerTask> it = THREAD_QUEUE.iterator(); it.hasNext();){
                            if(releaseSize <= 0){
                                break;
                            }
                            WorkerTask task = it.next();
                            task.close();
                            task.interrupt();
                            it.remove();
                            releaseSize--;

                        }
                        size = active;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 初始化
     */
    private void init(){
        for(int i=0;i< this.min;i++){
            createWorkerTask();
        }
        this.size = min;
        this.start();
    }

    private void createWorkerTask(){
        WorkerTask task = new WorkerTask(GROUP,THREAD_PREFIX + (seq++));
        task.start();
        THREAD_QUEUE.add(task);
    }

    /**
     * 拒绝策略
     */
    public interface  DiscardPolicy{
        void discard() throws DiscardException;
    }

    static class DiscardException extends RuntimeException{

        DiscardException(String message) {
            super(message);
        }
    }

    /**
     * 提交
     * @param runnable
     */
    public void submit(Runnable runnable){
        if(isDestroy){
            throw new IllegalStateException(" the thread pool already destroy and not allow submit task ");
        }

        synchronized (TASK_QUEUE){
            if(TASK_QUEUE.size() > queueSize){
                discardPolicy.discard();
            }
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }

    }

    /**
     * 关闭
     * @throws InterruptedException
     */
    public void shutdown() throws InterruptedException {
        while (!TASK_QUEUE.isEmpty()){
            Thread.sleep(50);
        }

        int intVal = THREAD_QUEUE.size();
        while (intVal >0){
            for(WorkerTask task : THREAD_QUEUE){
                if(task.getTaskState() == TaskState.BLOCKED){
                    task.interrupt();
                    task.close();
                    intVal--;
                } else {
                    Thread.sleep(10);
                }

            }

        }
        this.isDestroy = true;
        System.out.println(" the thread pool disposed ");
    }


    private static class WorkerTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState!= TaskState.DEAD){
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()){
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }

                    }
                    runnable = TASK_QUEUE.removeFirst();

                }
                if(runnable != null){
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }

            }
        }

        TaskState getTaskState(){
            return this.taskState;
        }

        void close(){
            this.taskState = TaskState.DEAD;
        }

    }

}
