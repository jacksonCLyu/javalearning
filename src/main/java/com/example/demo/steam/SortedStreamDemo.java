package com.example.demo.steam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedStreamDemo {

    public static void main(String[] args) {

        SortedStreamDemo sortedStreamDemo = new SortedStreamDemo();
        sortedStreamDemo.testLimitAndSkip();
    }

    private void testLimitAndSkip() {
        List<Person> persons = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        List<Person> personList2 = persons.stream().limit(4).sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
//        System.out.println(personList2);
        personList2.forEach(p -> System.out.print(p.no));
    }

    private class Person {
        public int no;
        private String name;
        public Person ( int no, String name ) {
            this.no = no;
            this.name = name;
        }

        public String getName() {
            System.out.println(name);
            return name;
        }
    }
}
