package com.hua.designPattern.observer_4.version2;

/**
 * @author huazai
 * @date 2019/10/15 14:51
 */
public interface LifeCycleListener {

    void onEvent(AbstractObservable.RunnableEvent event);
}
