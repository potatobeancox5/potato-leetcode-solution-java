package com.potato.study.leetcode.p0494;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         494. Target Sum
 * 
 *         You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

 *
 *
 *         题目含义：
 *          给一串数，能加能减，计算有多少种可能是的 最终结果对的上
 *         思路：
 *         https://www.cnblogs.com/wxisme/p/6690954.html
 *
 *         dfs 深度优先搜索
 *
 *
 */
public class Solution {

    private int resultCount = 0;

    public int findTargetSumWays(int[] nums, int sum) {
        this.dfsGetTheSum(sum, 0, nums, 0);
        return resultCount;
    }


    private void dfsGetTheSum (int targetSum, int targetIndex, int[] nums, int currentResult) {
        // 到达最终点 进行返回
        if (targetIndex == nums.length) {
            if (targetSum == currentResult) {
                resultCount++;
            }
            return;
        }
        // 直接对下一个节点进行计算
        this.dfsGetTheSum(targetSum, targetIndex + 1, nums, currentResult + nums[targetIndex]);
        this.dfsGetTheSum(targetSum, targetIndex + 1, nums, currentResult - nums[targetIndex]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 1, 1, 1, 1};
        int sum = 3;
        int du = solution.findTargetSumWays(nums, sum);
        System.out.println(du);
        Assert.assertEquals(5, du);
    }
}
