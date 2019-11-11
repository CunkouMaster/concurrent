package com.hua.designPattern.threadSpecificStorage_10;

/**
 * @author huazai
 * @date 2019/11/11 14:20
 */
public class Log {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();
    public static void println(String s) {
        getTSLog().println(s);
    }
    public static void close() {
        getTSLog().close();
    }
    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }
}