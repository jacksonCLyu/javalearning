package com.example.demo.datatrans;

public class BaseDataTypeTranslationTest {

    // 调用方法前 num 的值：1
    // 我是 num 在栈上的副本，我的值更改为：2
    // 调动方法后 num 的值：1
    // 由结果可以看出，java中值传递后，同样对原值没有影响，传递的为栈上本地变量表中的副本
    public static void main(String[] args) {

        int num = 1;
        System.out.println("调用方法前 num 的值：" + num);
        change(num);
        System.out.println("调动方法后 num 的值：" + num);
    }

    private static void change(int num) {
        num = 2;
        System.out.println("我是 num 在栈上的副本，我的值更改为：" + num);
    }
}
