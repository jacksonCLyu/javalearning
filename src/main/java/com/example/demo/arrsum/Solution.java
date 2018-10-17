package com.example.demo.arrsum;

import java.util.*;

public class Solution {

    /**
     * 二元和
     */
    public int[] twoSum (int[] arr, int target) {
        int[] ans = new int[2];
        if (null == arr || arr.length < 2)
            return ans;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(target - arr[i])){
                map.put(arr[i], i);
            } else {
                ans = new int[]{map.get(target - arr[i]), i};
                return ans;
            }
        }
        return ans;
    }

    /**
     * 三元和
     */
    public List<List<Integer>> threeSum (int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i=0; i<arr.length; ++i){
            if (i>0 && arr[i-1]==arr[i]) continue; // 去重
            for (int j=i+1, k=arr.length-1; j<k;){
                if (j>i+1 && arr[j-1] == arr[j]) {
                    ++j;
                    continue;
                }
                if (k<arr.length-1 && arr[k] == arr[k+1]) {
                    --k;
                    continue;
                }
                int sum = arr[i] + arr[j] + arr[k];
                if (sum > target) --k;
                else if (sum < target) ++j;
                else {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(arr[i]);
                    sub.add(arr[j++]);
                    sub.add(arr[k--]);
                    result.add(sub);
                }
            }
        }
        return result;
    }

    /**
     * 四元和
     */
    public List<List<Integer>> fourSum (int[] arr, int target) {
        return null;
    }

    public static void main(String[] args) {

        System.out.println("两数和：");

        Solution solution = new Solution();
        int[] ints = solution.twoSum(new int[]{2, 5, 7, 8, 12, 4, 31}, 10);
        Arrays.stream(ints).forEach(System.out::print);

        System.out.println();
        System.out.println("三数和：");

        List<List<Integer>> threeSums = solution.threeSum(new int[]{2, 5, 5, 6, 7, 8, 1, 12, 31}, 14);
        threeSums.forEach(sub -> {
            System.out.print("[");sub.forEach(System.out::print);
            System.out.println("]");});
    }
}
