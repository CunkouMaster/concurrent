package com.hua.basic.chapter11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huazai
 * @date 2019/10/11 14:12
 */
public class SimpleThreadPool2 {

    private final int size;
    private final int queueSize;
    private final DiscardPolicy discardPolicy;

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    private final static int DEFAULT_SIZE = 10;

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

    public SimpleThreadPool2() {
        this(DEFAULT_SIZE, DEFAULT_TASK_QUEUE_SIZE, DEFAULT_DISCARD_POLICY);
    }

    public SimpleThreadPool2(int size, int queueSize ,DiscardPolicy discardPolicy) {
        this.size = size;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    /**
     * 初始化
     */
    private void init(){
        for(int i=0;i<size;i++){
            createWorkerTask();
        }
    }

    private void createWorkerTask(){
        WorkerTask task = new WorkerTask(GROUP,THREAD_PREFIX + (seq++));
        task.start();
        THREAD_QUEUE.add(task);
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
