package com.potato.study.leetcode.p0689;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         689. Maximum Sum of 3 Non-Overlapping Subarrays
 * 
 *         In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

Example:

Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.


Note:

nums.length will be between 1 and 20000.
nums[i] will be between 1 and 65535.
k will be between 1 and floor(nums.length / 3).
 *
 *         思路：
 *             给定一个数组 和一个 k 求子数组中 sum 最大的3个
 *             sum 相同组合 选择 小的那个返回
 *
 *
 *             https://www.cnblogs.com/lightwindy/p/9692653.html
 *
 *
 *
 */
public class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // 1. 求 每个位置的sum和
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        // 2. posLeft 是每个位置左边的index   posRight 是每个位置右边的index 分别计算着两个数组
        int[] posLetf = new int[n];
        posLetf[0] = 0;
        int total = sum[k] - sum[0];
        for (int i = k; i < n; i++) {
            // 如果当前比之前的大
            if (sum[i + 1] - sum[i + 1 - k] > total) {
                posLetf[i] = i+1-k;
                total = sum[i + 1] - sum[i + 1 - k];
            } else {
                // 没有比之前的大 那么之前的index 就跟之前的一样
                posLetf[i] = posLetf[i-1];
            }
        }

        // 3. posRight 确定中间的 开始位置
        int[] posRight = new int[n];
        posRight[n-k] = n - k;
        total = sum[n] - sum[n-k];
        for (int i = n - 1 - k; i >= 0; i--) {
            if (sum[i+k]-sum[i] >= total) {
                posRight[i] = i;
                total = sum[i+k]-sum[i];
            } else {
                posRight[i] = posRight[i+1];
            }
        }
        // 4. 确定中间位置的数字
        int maxSum = 0;
        int[] result = new int[3];
        for (int i = k; i <= n - 2 * k; i++) {
            int left = posLetf[i-1];
            int right = posRight[i+k];
            total = (sum[i+k]-sum[i]) + (sum[left+k]-sum[left]) + (sum[right+k]-sum[right]);
            if (total > maxSum) {
                maxSum = total;
                result[0] = left;
                result[1] = i;
                result[2] = right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,2,1,2,6,7,5,1};
        int k = 2;
        int[] res = solution.maxSumOfThreeSubarrays(nums, k);
        System.out.println(Arrays.toString(res)); // 0, 3, 5
    }

}
