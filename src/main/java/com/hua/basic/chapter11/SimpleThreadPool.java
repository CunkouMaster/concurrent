package com.hua.basic.chapter11;

import java.util.LinkedList;

/**
 * @author huazai
 * @date 2019/10/11 14:12
 */
public class SimpleThreadPool {

    private final int size;

    private final static int DEFAULT_SIZE = 10;

    private static volatile int seq = 0;

    private final static String THREAD_PREFIX = "Simple_Thread_Pool-";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    private SimpleThreadPool(int size) {
        this.size = size;
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

    /**
     * 创建
     */
    private void createWorkerTask(){
        WorkerTask task = new WorkerTask(GROUP,THREAD_PREFIX + (seq++));
        task.start();
    }

    /**
     * 提交
     * @param runnable
     */
    public void submit(Runnable runnable){
        synchronized (TASK_QUEUE){
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }

    }

    class WorkerTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState!=TaskState.DEAD){
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

    }
}
