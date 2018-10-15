package com.example.demo.binarysearch;

public class BinarySearch {

    // 循环实现二分查找
    public static int rank(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) hi = mid - 1;
            else if (key > arr[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    // 递归实现二分查找
    public static int reciveSearch(int[] arr, int key, int begin, int end) {
        int mid = (begin + end) / 2;
        if (key < arr[begin] || key > arr[end] || begin > end) {
            return -1;
        }
        if (key < arr[mid]) return reciveSearch(arr, key, begin, mid - 1);
        else if (key > arr[mid]) return reciveSearch(arr, key, mid + 1, end);
        else return mid;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 12, 33, 87, 90, 97, 108, 561 };
        System.out.println("循环实现：" + (rank(arr, 87)));
        System.out.println("递归实现：" + reciveSearch(arr, 87, 0, arr.length - 1));
    }
}
