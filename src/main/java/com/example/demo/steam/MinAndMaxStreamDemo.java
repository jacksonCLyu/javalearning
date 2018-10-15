package com.example.demo.steam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinAndMaxStreamDemo {

    public static void main(String[] args) {
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader("/home/young/Documents/java多线程学习笔记"));
            int longest = br.lines().
                    mapToInt(String::length).
                    max().getAsInt();
            System.out.println(longest);
//            br.lines().forEach(System.out::println);

            List<String> words = br.lines().
                    flatMap(line -> Stream.of(line.split(" "))).
                    filter(word -> word.length() > 0).
                    map(String::toLowerCase).distinct().
                    sorted().collect(Collectors.toList());
            br.close();
            System.out.println(words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
