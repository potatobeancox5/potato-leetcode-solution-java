package com.potato.study.leetcode.p0949;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	949. Largest Time for Given Digits
 *  
 *       Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.



Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""


Note:

A.length == 4
0 <= A[i] <= 9
 *         
 *         题目含义：
 *          给四个数 求最大时间
 *
 *         思路：
 *          https://leetcode-cn.com/problems/largest-time-for-given-digits/solution/gei-ding-shu-zi-neng-zu-cheng-de-zui-da-shi-jian-b/
 *
 *
 * 
 */
public class Solution {

    public String largestTimeFromDigits(int[] arr) {
        // 遍历 枚举组成最大时间
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < arr.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    for (int l = 0; l < arr.length; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }
                        int h = 10 * arr[i] + arr[j];
                        int m = 10 * arr[k] + arr[l];
                        // 有效性
                        if (h < 0 || h > 23) {
                            continue;
                        }
                        if (m < 0 || m > 59) {
                            continue;
                        }
                        ans = Math.max(ans, h * 60 + m);

                    }
                }
            }
        }
        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
    }


    public static void main(String[] args) {
		Solution solution = new Solution();


        int[] arr = new int[]{1,2,3,4};
        String result = solution.largestTimeFromDigits(arr);
        System.out.println(result);
        Assert.assertEquals("23:41", result);
    }
}
