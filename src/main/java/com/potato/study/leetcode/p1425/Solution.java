package com.potato.study.leetcode.p1425;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author liuzhao11
 * 
 * 	1425. Constrained Subsequence Sum
 *  
 *
Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.

A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.



Example 1:

Input: nums = [10,2,-10,5,20], k = 2
Output: 37
Explanation: The subsequence is [10, 2, 5, 20].
Example 2:

Input: nums = [-1,-2,-3], k = 1
Output: -1
Explanation: The subsequence must be non-empty, so we choose the largest number.
Example 3:

Input: nums = [10,-2,-10,-5,20], k = 2
Output: 23
Explanation: The subsequence is [10, -2, -5, 20].


Constraints:

1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/constrained-subsequence-sum/solution/dong-tai-gui-hua-hua-dong-chuang-kou-dan-diao-dui-/
 *
 */
public class Solution {


    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        Deque<Integer> deque = new ArrayDeque<>();//单调递减队列，队首是窗口的最大值，
        deque.addFirst(dp[0]);
        //当窗口大小没有达到k的时候
        for (int i = 1; i < k; i++) {
            dp[i] = Math.max(deque.getFirst() + nums[i] , nums[i]);
            res = Math.max(res,dp[i]);
            while (!deque.isEmpty() && deque.getLast() < dp[i]) {
                deque.removeLast();
            }
            deque.addLast(dp[i]);
        }
        for (int i = k; i < nums.length; i++){
            dp[i] = Math.max(deque.getFirst() + nums[i] , nums[i]);
            res = Math.max(res,dp[i]);
            while (!deque.isEmpty() && deque.getLast() < dp[i]) {
                deque.removeLast();
            }
            deque.addLast(dp[i]);
            if (dp[i - k] == deque.getFirst()) {
                deque.removeFirst();
            }
        }
        return res;
    }
}
