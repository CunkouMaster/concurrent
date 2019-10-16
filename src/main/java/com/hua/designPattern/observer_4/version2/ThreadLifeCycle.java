package com.hua.designPattern.observer_4.version2;

import java.util.List;

/**
 * @author huazai
 * @date 2019/10/16 14:26
 */
public class ThreadLifeCycle implements LifeCycleListener {

    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids){
        if(ids == null || ids.isEmpty()){
            return;
        }

        ids.stream().forEach(id -> new Thread(new AbstractObservable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(State.RUNNING,Thread.currentThread(),null));

                    System.out.println("query【id】：" + id);
                    Thread.sleep(2000);
                    int i = 3/(3-(Integer.valueOf(id)));
                    notifyChange(new RunnableEvent(State.DONE,Thread.currentThread(),null));
                } catch (Exception e) {
                    notifyChange(new RunnableEvent(State.ERROR,Thread.currentThread(),e));

                }

            }
        },id).start());
    }

    @Override
    public void onEvent(AbstractObservable.RunnableEvent event) {
        synchronized (LOCK) {
            System.out.println("runnable 【" + event.getThread().getName() + "】 data change and state is 【" + event.getState() + "】");
            if(event.getCause() != null){
                System.out.println("runnable 【" + event.getThread().getName() + "】 failed");
                event.getCause().printStackTrace();
            }
        }
    }
}
