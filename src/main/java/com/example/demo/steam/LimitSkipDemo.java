package com.example.demo.steam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LimitSkipDemo {

    public static void main(String[] args) {
        LimitSkipDemo limitSkipDemo = new LimitSkipDemo();
        limitSkipDemo.testLimitAndSkip();
    }

    private void testLimitAndSkip() {

        List<Person> persons = new ArrayList<Person>();
        for (int i = 1; i <= 10000; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }

        // 由于 limit 惰性限制，虽然 map 方法在 limit 之前，persons 最终也只调用十次 getName 方法
        // name1
        // name2
        // name3
        // name4
        // name5
        // name6
        // name7
        // name8
        // name9
        // name10
        List<String> personList2 = persons.stream().
                map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
        // 这里输出结果，skip 跳过了前三个：[name4, name5, name6, name7, name8, name9, name10]
        System.out.println(personList2);

        // 注意：sorted 操作后 limit 和 skip 无法限制排序时的操作次数！
        // 对一个 parallel 的 Steam 管道来说，如果其元素是有序的，那么 limit 操作的成本会比较大！
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
