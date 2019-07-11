package com.hua.basic.chapter3;

/**
 * @author huazai
 * @date 2019/7/11 10:14
 */
public class TaxCalaculator {

    private final double salary;

    private final double bonus;

    private TaxStrategy taxStrategy;

    public TaxCalaculator(double salary,double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    /**
     * 设置方法
     * @param taxStrategy
     */
    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    protected double calcTax(){
        return taxStrategy.calcuate(salary,bonus);
    }

    public double calcuate(){
        return this.calcTax();
    }
}
