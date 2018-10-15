package com.example.demo.datatrans;

import java.util.ArrayList;
import java.util.List;

public class ReferenceTranslationTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        // 这里传递的是栈上 copy 的本地变量 list 值的副本，
        add(list);
        list.forEach(System.out::println);
    }

    private static void add(List<Integer> list) {
        // 这里副本依然指向原引用类型
        list.add(3);
        // 这里副本指向了新的引用类型，因此 4 不会被打印
        list = new ArrayList<>();
        list.add(4);
    }
}
