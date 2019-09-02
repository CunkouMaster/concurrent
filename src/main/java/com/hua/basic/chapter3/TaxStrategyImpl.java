package com.hua.basic.chapter3;

/**
 * @author huazai
 * @date 2019/7/11 10:27
 */
public class TaxStrategyImpl implements  TaxStrategy {
    private final static double SALARY_RATE = 0.1D;
    private final static double BONUS_RATE = 0.15D;

    @Override
    public double calcuate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
