package com.hua.designPattern.threadSpecificStorage_10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 实际执行记录日志的类，每个线程都会拥有一个该类的实例
 * @author huazai
 * @date 2019/11/11 14:20
 */
public class TSLog {
    private PrintWriter writer = null;
    public TSLog(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void println(String s) {
        writer.println(s);
    }
    public void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}