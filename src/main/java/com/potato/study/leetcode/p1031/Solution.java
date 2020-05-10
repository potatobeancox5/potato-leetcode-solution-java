package com.potato.study.leetcode.p1031;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1031. Maximum Sum of Two Non-Overlapping Subarrays
 *  
 *        Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays, which have lengths L and M.  (For clarification, the L-length subarray could occur before or after the M-length subarray.)

Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:

0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
0 <= j < j + M - 1 < i < i + L - 1 < A.length.


Example 1:

Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
Example 2:

Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
Example 3:

Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
Output: 31
Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.


Note:

L >= 1
M >= 1
L + M <= A.length <= 1000
0 <= A[i] <= 1000
 *         
 *         思路：
 *
非重叠 子数组 的max sum

https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays/solution/shuang-zhong-hua-dong-chuang-kou-by-joseph_liujian


滑动找a 每个a位置滑动找b
 *
 *
 *
 *
 */
public class  Solution {

    /**
     *
     * @param arr     总的数组
     * @param l       子数组1的长度
     * @param m       子数组2的长度
     * @return        最大的和
     */
    public int maxSumTwoNoOverlap(int[] arr, int l, int m) {

        int a = maxSum(arr, l, m);
        int b = maxSum(arr, m, l);
        return Math.max(a, b);
    }

    /**
     * 按顺序求 l m 的最大值
     * @param arr
     * @param l
     * @param m
     * @return
     */
    private int maxSum(int[] arr, int l, int m) {
        if (l + m > arr.length) {
            return 0;
        }
        // 先求 前 l-1 的sumn
        int sumL = 0;
        for (int i = 0; i < l - 1; i++) {
            sumL += arr[i];
        }
        // 从l的下一个位置开始 依次求 m的值 并求最大和
        int max = 0;
        for (int i = l-1; i < arr.length - m; i++) {
            sumL += arr[i];
            // 求 m-1
            int sumM = 0;
            for (int j = i+1; j < i + m; j++) {
                sumM += arr[j];
            }
            // m从每个位置 求 max
            for (int j = i + m; j < arr.length; j++) {
                sumM += arr[j];
                max = Math.max(max, sumL + sumM);
                sumM -=  arr[j-m+1];
            }

            sumL -= arr[i - l + 1];
        }
        return max;
    }

    public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = new int[]{0,6,5,2,2,5,1,9,4};
        int l = 1;
        int m = 2;
        int res = solution.maxSumTwoNoOverlap(arr, l, m);
        System.out.println(res);
        Assert.assertEquals(20, res);


    }
}
