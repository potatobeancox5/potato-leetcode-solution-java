package com.potato.study.leetcode.p1043;


import org.junit.Assert;

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
 *             https://www.cnblogs.com/rookielet/p/10852452.html
 *
 *              dp[i] = Math.max(dp[i], prev + maxInPart * (i - j + 1));
 *
 *              dp i 代表 到了 位置 能到达到的最大值
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
        // 遍历 arr 找到每个阶段 的最大值 计算到某个位置 的最大值 缓存到dp中

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int maxPart = arr[j];
            // 往前找
            for (; j >= 0 && j > i - k ; j--) {
                maxPart = Math.max(maxPart, arr[j]);
                // 前边多少
                int previous = 0;
                if (j >= 1) {
                    previous = dp[j-1];
                }
                dp[i] = Math.max(dp[i], maxPart * (i - j + 1) + previous);
            }
        }
        return dp[arr.length-1];
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {1,15,7,9,2,5,10};
		int k = 3;
        int res = solution.maxSumAfterPartitioning(arr, k);
        System.out.println(res);
        Assert.assertEquals(84, res);
    }
}
