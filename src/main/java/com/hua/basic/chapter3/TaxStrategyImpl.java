package com.hua.basic.chapter3;

/**
 * @author huazai
 * @date 2019/7/11 10:27
 */
public class TaxStrategyImpl implements  TaxStrategy {

    @Override
    public double calcuate(double salary, double bonus) {
        return salary * 0.1 + bonus * 0.15;
    }
}
