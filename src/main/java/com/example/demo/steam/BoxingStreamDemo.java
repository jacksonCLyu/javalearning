package com.example.demo.steam;

import java.util.stream.IntStream;

public class BoxingStreamDemo {

    public static void main(String[] args) {

        IntStream.of(1,2,3,4,5).forEach(System.out::println);

        System.out.println();

        IntStream.range(1,3).forEach(System.out::println);

        System.out.println();

        IntStream.rangeClosed(1,3).forEach(System.out::println);

    }
}
