package com.potato.study.leetcode.p0801;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	801. Minimum Swaps To Make Sequences Increasing
 *  
 *         We have two integer sequences A and B of the same non-zero length.

We are allowed to swap elements A[i] and B[i].
Note that both elements are in the same index position in their respective sequences.

At the end of some number of swaps, A and B are both strictly increasing.
(A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)

Given A and B, return the minimum number of swaps to make both sequences strictly increasing.

It is guaranteed that the given input always makes it possible.

Example:
Input: A = [1,3,5,4], B = [1,2,3,7]
Output: 1
Explanation:
Swap A[3] and B[3].  Then the sequences are:
A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
which are both strictly increasing.
Note:

A, B are arrays with the same length, and that length will be in the range [1, 1000].
A[i], B[i] are integer values in the range [0, 2000].
 *         
 *
 *        题目含义：
 *          交换相同位置的两个数字，最小交换使得两个序列都变成递增序列
 *
 *        思路：
 *
 *        dp[i][0]表示不交换i，使得[0, i]严格递增的最小swap数
          dp[i][1]表示交换i，使得[0, i]严格递增的最小swap数 （交换过 ）
 *          https://www.jianshu.com/p/9ab839a48d23
 *
 *          解释
 *          https://blog.csdn.net/wilzxu/article/details/90898285
 *
 * 
 */
public class Solution {

    public int minSwap(int[] arr, int[] brr) {

        int len = arr.length;
        int[][] dp = new int[len][2];
        for (int[] each: dp) {
            Arrays.fill(each, Integer.MAX_VALUE);
        }

        // 不交货 0 点已经交换了一次
        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < len; i++) {
            // 可以不用交换
            if (arr[i-1] < arr[i] && brr[i-1] < brr[i]) {
                dp[i][0] = Math.min(dp[i-1][0], dp[i][0]);
                dp[i][1] = Math.min(dp[i-1][1] + 1, dp[i][1]);
            }

            if (arr[i-1] < brr[i] && brr[i-1] < arr[i]) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i][0]);
                dp[i][1] = Math.min(1 + dp[i-1][0], dp[i][1]);
            }
        }
        return Math.min(dp[len-1][0], dp[len-1][1]);
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr = new int[]{1,3,5,4};
        int[] brr = new int[]{1,2,3,7};
        int result = solution.minSwap(arr, brr);
        System.out.println(result);
        Assert.assertEquals(1, result);
    }
}
