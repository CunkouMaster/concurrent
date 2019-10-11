//package com.hua.basic.chapter11;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author huazai
// * @date 2019/10/11 14:12
// */
//public class SimpleThreadPool2 {
//
//    private final int size;
//    private final int queueSize;
//    private final DiscardPolicy discardPolicy;
//
//    private final static int DEFAULT_SIZE = 10;
//
//    private final static int DEFAULT_TASK_QUEUE_SIZE = 1000;
//
//    private static volatile int seq = 0;
//
//    private final static String THREAD_PREFIX = "Simple_Thread_Pool-";
//
//    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");
//
//    private final static DiscardPolicy DEFAULT_DISCARD_POLICY = () ->{throw new DiscardException("===== discard this task =====");};
//
//    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();
//
//    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();
//
//    private SimpleThreadPool2() {
//        this(DEFAULT_SIZE, DEFAULT_TASK_QUEUE_SIZE, DEFAULT_DISCARD_POLICY);
//    }
//
//    private SimpleThreadPool2(int size, int queueSize ,DiscardPolicy discardPolicy) {
//        this.size = size;
//        this.queueSize = queueSize;
//        this.discardPolicy = discardPolicy;
//        init();
//    }
//
//    private void init(){
//        for(int i=0;i<size;i++){
//            createWorkerTask();
//        }
//    }
//
//    private void submit(Runnable runnable){
//        synchronized (TASK_QUEUE){
//            if(TASK_QUEUE.size() > queueSize){
//                discardPolicy.discard();
//            }
//            TASK_QUEUE.addLast(runnable);
//            TASK_QUEUE.notifyAll();
//        }
//
//    }
//
//    private void createWorkerTask(){
//        WorkerTask task = new WorkerTask(GROUP,THREAD_PREFIX + (seq++));
//        task.start();
//        THREAD_QUEUE.add(task);
//    }
//
//    public void shutdown() throws InterruptedException {
//        while (!TASK_QUEUE.isEmpty()){
//            Thread.sleep(50);
//        }
//
//        int intVal = TASK_QUEUE.size();
//        while (intVal >0){
//            for(WorkerTask task : THREAD_QUEUE){
//                if(task.getTaskState() == TaskState.BLOCKED){
//                    task.interrupt();
//                    task.close();
//                    intVal--;
//                } else {
//                    Thread.sleep(50);
//                }
//
//            }
//
//        }
//    }
//
//    /**
//     * 拒绝策略
//     */
//    public interface  DiscardPolicy{
//        void discard() throws DiscardException;
//    }
//
//    public static class DiscardException extends RuntimeException{
//
//        public DiscardException(String message) {
//            super(message);
//        }
//    }
//
//    private static class WorkerTask extends Thread {
//
//        private volatile TaskState taskState = TaskState.FREE;
//
//        public WorkerTask(ThreadGroup group, String name) {
//            super(group, name);
//        }
//
//        @Override
//        public void run() {
//            OUTER:
//            while (this.taskState!= TaskState.DEAD){
//                Runnable runnable;
//                synchronized (TASK_QUEUE) {
//                    while (TASK_QUEUE.isEmpty()){
//                        try {
//                            taskState = TaskState.BLOCKED;
//                            TASK_QUEUE.wait();
//                        } catch (InterruptedException e) {
//                            break OUTER;
//                        }
//
//                    }
//                    runnable = TASK_QUEUE.removeFirst();
//
//                }
//                if(runnable != null){
//                    taskState = TaskState.RUNNING;
//                    runnable.run();
//                    taskState = TaskState.FREE;
//                }
//
//            }
//        }
//
//        public TaskState getTaskState(){
//            return this.taskState;
//        }
//
//        public void close(){
//            this.taskState = TaskState.DEAD;
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        SimpleThreadPool2 pool = new SimpleThreadPool2();
//        for(int i = 0 ; i < 30; i++){
//            int finalI = i;
//            pool.submit(() -> {
//                System.out.println("runnable " + finalI + " be serviced by " + Thread.currentThread() + "start");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("runnable " + finalI + " be serviced by " + Thread.currentThread() + "finish");
//            });
//
//        }
//
//    }
//}
