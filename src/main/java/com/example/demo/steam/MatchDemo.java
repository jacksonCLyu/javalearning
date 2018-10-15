package com.example.demo.steam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchDemo {

    public static void main(String[] args) {
        MatchDemo limitSkipDemo = new MatchDemo();
        limitSkipDemo.testLimitAndSkip();
    }

    private void testLimitAndSkip() {

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(1, "name" + 1, 10));
        persons.add(new Person(1, "name" + 2, 21));
        persons.add(new Person(1, "name" + 3, 10));
        persons.add(new Person(1, "name" + 4, 10));
        persons.add(new Person(1, "name" + 5, 10));
        boolean isAllAudlt = persons.stream().allMatch(p -> p.getAge() > 18);

        System.out.println("All are adult? " + isAllAudlt);

        boolean isThereAnyChild = persons.stream().anyMatch(p -> p.getAge() < 12);

        System.out.println("Any child? " + isThereAnyChild);
    }

    private class Person {
        public int no;
        private String name;
        private int age;
        public Person ( int no, String name ) {
            this.no = no;
            this.name = name;
        }

        public Person ( int no, String name, int age ) {
            this.no = no;
            this.name = name;
            this.age = age;
        }

        public String getName() {
            System.out.println(name);
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
