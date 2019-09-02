package com.hua.basic.chapter3;

/**
 * @author huazai
 * @date 2019/7/11 10:22
 */
@FunctionalInterface
public interface TaxStrategy {
    double calcuate(double salary ,double bonus);
}
