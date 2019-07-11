package com.hua.basic.chapter3;

/**
 * @author huazai
 * @date 2019/7/11 10:16
 */
public class TaxCommon {
    public static void main(String[] args) {
        /*
         * 传统
         */
        TaxCalaculator calaculator = new TaxCalaculator(10000d,2000d){
            @Override
            protected double calcTax() {
                return getSalary() * 0.1 + getBonus() * 0.15;
            }
        };

        double tax = calaculator.calcuate();
        System.out.println(tax);


        /*
            策略模式
         */
        TaxCalaculator calacu = new TaxCalaculator(10000d,2000d);
        TaxStrategy strategy = new TaxStrategyImpl();
        calacu.setTaxStrategy(strategy);
        System.out.println(calacu.calcuate());

    }
}
