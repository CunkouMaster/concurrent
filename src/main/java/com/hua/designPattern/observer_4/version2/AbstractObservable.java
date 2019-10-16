package com.hua.designPattern.observer_4.version2;

/**
 * @author huazai
 * @date 2019/10/15 14:46
 */
public abstract class AbstractObservable implements Runnable{

    final protected LifeCycleListener listener;

    public AbstractObservable(LifeCycleListener listener) {
        this.listener = listener;
    }


    /**
     * 通知
     */
    protected void notifyChange(RunnableEvent event){

        listener.onEvent(event);

    }

    public static class RunnableEvent{

        private final State state;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(State state, Thread thread,Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public State getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }

}
