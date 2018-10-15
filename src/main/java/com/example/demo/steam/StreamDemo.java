package com.example.demo.steam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
//        Stream stream = Stream.of("aa","ab","ac","bb","bc","bd","be","cc","cd","ce");
//        stream.forEach(System.out::println);
//        String[] array = (String[]) stream.toArray(String[]::new);

        String[] arr = new String[]{"aa","ab","ac","bb","bc","bd","be","cc","cd","ce"};

        Stream stream = Stream.of(arr);
        stream = Arrays.stream(arr);

        List<String> list = Arrays.asList(arr);
        stream = list.stream();
    }

}
