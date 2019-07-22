package com.hua.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author huazaiqd
 * @date 2019/7/20 10:09
 */
public class CreateStream {

    private static Stream<String> createFromCollection(){
        List<String> list = Arrays.asList("a", "b", "c", "d");
        return list.stream();
    }

    private static Stream<String> createFromValues(){
        return Stream.of("a", "b", "c", "d");
    }

    private static Stream<String> createFromArrays(){
        String [] s = {"a", "b", "c", "d"};
        return Arrays.stream(s);
    }

    private static Stream<String> createFromFile(){
        Path path = Paths.get("D:\\Download\\notes\\zookeeper");
        try {
            Stream<String> lines = Files.lines(path);
            lines.forEach(System.out::println);
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


    private static Stream<Integer> createFromIterator(){
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2).limit(10);
        return iterate;
    }

    private static Stream<Double> createFromGenerate(){
        Stream<Double> generate = Stream.generate(Math::random);
        return generate;
    }
}

