package com.example.demo.steam;

import java.util.stream.Stream;

public class ReduceDemo {

    public static void main(String[] args) {

        String concat = Stream.of("A","B","C","D").reduce("", String::concat);

        double minValue = Stream.of(0.15,-1.5,-2.3,-3.0,2.0).reduce(Double.MAX_VALUE, Double::min);
        // 无起始值
        int sumValue = Stream.of(1,2,3,4).reduce(Integer::sum).get();
        // 有起始值
        sumValue = Stream.of(1,2,3,4).reduce(0, Integer::sum);

        concat = Stream.of("a","B","c","D","e","F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);

    }
}
