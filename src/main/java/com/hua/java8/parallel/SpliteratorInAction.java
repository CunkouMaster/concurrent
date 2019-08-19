package com.hua.java8.parallel;

import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author huazai
 * @date 2019/8/14 14:54
 */
public class SpliteratorInAction {
    public static void main(String[] args) {
        IntStream intStream  = IntStream.range(0,10);
        Spliterator.OfInt spliterator = intStream.spliterator();
        Consumer<Integer> consumer = System.out::println;
        spliterator.forEachRemaining(consumer);

        System.out.println("======================");

        MySpliteratorText myText = new MySpliteratorText(text);
//        Optional.ofNullable(myText.stream().count()).ifPresent(System.out::println);
        myText.stream().forEach(System.out::println);
    }

    private static String text = "Nam orci arcu, rhoncus sit amet posuere ac, adipiscing quis sem. " +
            "\n" +
            "Integer sit amet dolor dolor, ac interdum ipsum. " +
            "\n" +
            "Curabitur vehicula semper augue vitae gravida. " +
            "\n" +
            "sed id ipsum dolor, et feugiat. " +
            "\n" +
            "Etiam eu enim gravida lacus ultricies suscipit";

}
