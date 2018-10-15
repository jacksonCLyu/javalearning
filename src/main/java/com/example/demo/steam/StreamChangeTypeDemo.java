package com.example.demo.steam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamChangeTypeDemo {

    private static String[] arr = new String[]{"aa","ab","ac","bb","bc","bd","be","cc","cd","ce"};

    // 注意：Stream 对象调用终端操作后即“用光”，不可复用
    public static void main(String[] args) {

        // 转换类型
        Stream stream = Stream.of("1","2","3","4");
        List<Integer> list = (List<Integer>) stream.collect(Collectors.toCollection(ArrayList::new));
        Stream stream2 = Stream.of("1","2","3","4");
        List<Integer> list2 = (List<Integer>) stream2.collect(Collectors.toList());

        // 转大写
        List<String> uppercaseArrList = Stream.of(arr).map(String::toUpperCase).collect(Collectors.toList());
        uppercaseArrList.forEach(System.out::print);
        System.out.println();

        // 一对一映射
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        List<Integer> squareNums = nums.stream().map(n -> n*n).collect(Collectors.toList());
        squareNums.forEach(System.out::print);
        System.out.println();

        // 一对多映射
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1,2),
                Arrays.asList(2,3,4),
                Arrays.asList(5,4,5,3)
        );
        // 将 inputStream 结构扁平化，即将底层元素抽出来放在一起，最终 output 的新 stream 里已经没有 list 了，都是直接的数字
        Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());
        outputStream.forEach(System.out::print);
        System.out.println();

        // filter 过滤
        Integer[] sixNums = { 1,2,3,4,5,6 };
        Integer[] evens = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        Arrays.stream(evens).forEach(System.out::print);
        System.out.println();

        String A = "abc"; String B = null;
        print(A);
        print("");
        print(B);
        System.out.println(getLength(A));
        System.out.println(getLength(""));
        System.out.println(getLength(B));

    }

    // Optional 好处是提供编译时检查，这样会极大的降低 NPE 这种 Runtime Exception 对程序的影响
    private static void print(String text) {
        Optional.ofNullable(text).ifPresent(System.out::println);
        // pre-java8
//        if (null != text)
//            System.out.println(text);
    }

    private static int getLength(String text) {
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // pre-java8
//        return null == text ? text.length() : -1;
    }

}
