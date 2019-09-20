package com.potato.study.leetcode.p1043;


/**
 * 
 * @author liuzhao11
 * 
 * 	1043. Partition Array for Maximum Sum
 *  
 *        Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning.



Example 1:

Input: A = [1,15,7,9,2,5,10], K = 3
Output: 84
Explanation: A becomes [15,15,15,9,10,10,10]


Note:

1 <= K <= A.length <= 500
0 <= A[i] <= 10^6
 *         
 *
 *         题目含义：
 *             一道动态规划题
 *
 *             dp i 表示 从0 到 最大值
 *             dp i = max {dp k(1,i) + (k+1,i)最大值 * （i- k）}
 *
 *
 *
 */
public class Solution {
    /**
     *
     * @param arr target数组
     * @param k   每段切割的最大数字
     * @return
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        // 控制次数
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < k; j++) {
                int m = this.maxValue(arr, j + 1, i);
                dp[i] = Math.max(max, dp[k] + m * (i - j));
            }
        }
        return dp[arr.length];
    }
    /**
     * 找数据最大值
     * @param arr
     * @param from
     * @param to
     * @return
     */
    private int maxValue(int[] arr, int from, int to) {
        int max = 0;
        for (int i = from; i <= to; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {1,15,7,9,2,5,10};
		int k = 3;
        int res = solution.maxSumAfterPartitioning(arr, k);
        System.out.println(res);
    }
}
