package com.potato.study.leetcode.p0922;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	922. Sort Array By Parity II
 *  
 *      Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.



Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


Note:

2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000

 *         
 *         题目含义：
 *
 *         思路：
 *              数组按照特定规则进行排序
        奇数index 存的是奇数
        偶数index 存的是偶数
        遍历一遍数组
        找第一个奇数位置 存的是偶数
        找第一个偶数位置 存的是奇数
        交换偶数位置和奇数位置的两个数

 *
 *
 * 
 */
public class Solution {


    public int[] sortArrayByParityII(int[] arr) {
        int leftIndex = 1;
        int rightIndex = (arr.length - 1) % 2 == 0 ? arr.length - 1 : arr.length - 2;
        int leftChangeIndex = 0;
        int rightChangeIndex = arr.length - 1;
        while (leftIndex < arr.length && rightIndex >= 0) {
            // find 左边替换的点
            while (leftIndex < arr.length && arr[leftIndex] % 2 == 1) {
                leftIndex += 2;
            }
            // find 右边替换的点
            while (rightIndex >= 0 && arr[rightIndex] % 2 == 0) {
                rightIndex -= 2;
            }
            // 替换
            if (leftIndex < arr.length && rightIndex >= 0){
                int tmp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = tmp;
                leftIndex += 2;
                rightIndex -= 2;
            }
        }
        return arr;
    }




    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr = {4,2,5,7};
        int[] num = solution.sortArrayByParityII(arr);
        System.out.println(Arrays.toString(num));
    }
}
