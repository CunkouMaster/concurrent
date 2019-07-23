package com.hua.java8.stream;

import com.hua.java8.Base;
import com.hua.java8.Trader;
import com.hua.java8.Transaction;

import java.util.Comparator;

/**
 * @author huazai
 * @date 2019/7/22 16:38
 */
public class StreamInAction {
    public static void main(String[] args) {
        //1.Find all transactions in 2011 and sort by value (small to high)
        Base.initTransaction().stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println("=====================================");

        //2.What are all the unique cities where the traders work?
        Base.initTransaction().stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().forEach(System.out::println);
        System.out.println("=====================================");

        //3.Find all traders from Cambridge and sort them by name
        Base.initTransaction().stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        System.out.println("=====================================");

        //4.Return a string of all traders’ names sorted alphabetically
        Base.initTransaction().stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(Comparator.comparing(String::toString))
                .forEach(System.out::println);
        System.out.println("=====================================");

        //5.Are any traders based in Milan?
        Base.initTransaction().stream()
                .filter(transaction -> "Milan".equals(transaction.getTrader().getCity()))
                .findAny().ifPresent(System.out::println);
        boolean b = Base.initTransaction().stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        System.out.println("any traders based in Milan：" + b);
        System.out.println("=====================================");

        //6.Print all transactions’ values from the traders living in Cambridge
        Base.initTransaction().stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .forEach(transaction -> System.out.println(transaction.getYear() + "--" + transaction.getValue()));
        System.out.println("=====================================");

        //7.What’s the highest value of all the transactions?
        Base.initTransaction().stream()
                .map(Transaction::getValue)
                .mapToInt(Integer::intValue)
                .max().ifPresent(System.out::println);

        Base.initTransaction().stream()
                .map(Transaction::getValue)
                .reduce(Integer::max).ifPresent(System.out::println);

        System.out.println("=====================================");

        //8.Find the transaction with the smallest value
        Base.initTransaction().stream()
                .reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1 :t2)
                .ifPresent(System.out::println);

    }
}
