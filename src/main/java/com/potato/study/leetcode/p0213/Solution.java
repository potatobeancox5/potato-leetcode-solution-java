package com.potato.study.leetcode.p0213;

/**
 * 
 * @author liuzhao11
 * 
 *         213. House Robber II
 * 
 * 			You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
    题目需求：
        动态规划问题
        不能抢劫相邻的两个房子 ，保证涉案金额最高
    思路：
        1。抢第一个房子
        2。抢第一个房子
        robMoney[n] 表示抢第n 个房子 获得的收入
        robMoney[n] = max {robMoney[n-3] + nums[n], robMoney[n-2] + nums[n]}

 */
public class Solution {

    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        if (nums.length == 3) {
            return max(max(nums[0], nums[1]) ,nums[2]);
        }
        int maxRobMoney = 0;
        // 分开统计-抢第一间房子 计算 2 - n-1 间房子
        int n3 = nums[0]; // 0
        int n2 = nums[1];//1
        int n1 = nums[2] + nums[0];
        maxRobMoney = max(n2, n1);
        for (int i = 3; i < nums.length - 1; i++) {
            int n = max(n3, n2) + nums[i];
            if (n > maxRobMoney) {
                maxRobMoney = n;
            }
            n3 = n2;
            n2 = n1;
            n1 = n;
        }
        // 分开统计-不抢第一间房子 计算 2 - n-1 间房子
        n3 = 0; //nums[0]
        n2 = nums[1];
        n1 = nums[2];
        if (maxRobMoney < max(n2, n1)) {
            maxRobMoney = max(n2, n1);
        }
        for (int i = 3; i < nums.length; i++) {
            int n = max(n3, n2) + nums[i];
            if (n > maxRobMoney) {
                maxRobMoney = n;
            }
            n3 = n2;
            n2 = n1;
            n1 = n;
        }
        return maxRobMoney;
    }

    private int max (int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {2,3,2};
//        int[] nums = {4,1,2,7,5,3,1};
        int[] nums = {1,2,3,1};
        int max = solution.rob(nums);
        System.out.println(max);

    }
}
