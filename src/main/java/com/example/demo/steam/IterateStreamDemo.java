package com.example.demo.steam;

import java.util.stream.Stream;

public class IterateStreamDemo {

    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 3).limit(10).forEach(x -> System.out.println(x + " "));
    }
}
