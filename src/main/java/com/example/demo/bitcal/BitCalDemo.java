package com.example.demo.bitcal;

public class BitCalDemo {

    /** 位运算实现加法 */
    public static int add(int a, int b) {
        int sum,carry;
        do {
            // 不计进位异或取 a 与 b 的和
            sum = a ^ b;
            // a 与 b 位与运算并左移一位取进位
            carry = ( a & b ) << 1;
            a = sum;
            b = carry;
        } while (b != 0);// 有进位则循环，没有进位后将 a 与 b 和返回
        return a;
    }

    /** 减法、乘法和除法可通过加法导出 */

    public static void main(String[] args) {
        int add = add(2, 5);
        System.out.println(add);
    }
}
