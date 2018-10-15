package com.example.demo.steam;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateStreamDemo {

    public static void main(String[] args) {

        // 生成十个随机数
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;

        Stream.generate(random).limit(10).forEach(System.out::println);
        // Another way
        IntStream.generate(() -> (int)(System.nanoTime() % 100)).
                limit(10).forEach(System.out::println);


        // 自实现 Supplier
        Stream.generate(new PersonSupplier()).limit(10).forEach(p -> System.out.println(
                p.getName() + ", " + p.getAge()
        ));

    }

    private static class PersonSupplier implements Supplier<Person> {

        private int index = 0;
        private Random random = new Random();

        @Override
        public Person get() {
            return new Person(index++, "StormTestUser" + index, random.nextInt(100));
        }
    }

    private static class Person {
        public int no;
        private String name;
        private int age;

        public Person ( int no, String name ) {
            this.no = no;
            this.name = name;
        }

        public Person (int no, String name, int age) {
            this.no = no;
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
