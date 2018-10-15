package com.example.demo.steam;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

    public static void main(String[] args) {

        // 按照年龄分组，同龄人一组
        Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).
                limit(100).collect(Collectors.groupingBy(Person::getAge));
        Iterator<Map.Entry<Integer, List<Person>>> it = personGroups.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Person>> persons = it.next();
            System.out.println("Age " + persons.getKey() + " = " + persons.getValue().size());
        }

        // 按未成年人和成年人分组
        Map<Boolean, List<Person>> children = Stream.generate(new PersonSupplier()).
                limit(100).collect(Collectors.partitioningBy(p -> p.getAge() < 18));
        System.out.println("Children number: " + children.get(true).size());
        System.out.println("Adult number: " + children.get(false).size());
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
