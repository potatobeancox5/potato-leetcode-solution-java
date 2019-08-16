package com.potato.study.leetcode.p0312;


/**
 * 
 * @author Administrator
 *
 *         312. Burst Balloons
 *          
 *        Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *         
 *         
 *         题目含义：
 *          打气球 每次打破气球 都计算两侧的乘积 并返回乘积最大值
 *
 *         思路：
 *         312. Burst Balloons


https://segmentfault.com/a/1190000008366615?utm_medium=referral&utm_source=tuicool

dp ij 是从 i 到j的最大值
从ij 中选k
k

lvalue k左边的value
rvalue k 右边的value
 *
 *
 *         dp ij 是从 i 到j的最大值
 *
 *          k from j - j
 *         那么 dp ij = max （dp ij， lValue * num[k] rValue + leftSum + rightSum）
 *         
 *         
 *         
 *         
 */
public class Solution {

    public int maxCoins(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int k = 0; k < len; k++) {
            for (int i = 0 ; i < len - k; i++) {
                int j = i + k;
                for (int l = i; l <= j; l++) {
                    int lValue = i > 0 ? nums[i-1] : 1;
                    int rValue = j < len-1 ? nums[j+1] : 1;
                    int leftsum = (l == i) ? 0 : dp[i][l - 1];
                    int rightSum = (l == j) ? 0 : dp[l + 1][j];
                    dp[i][j] = Math.max(dp[i][j], leftsum + rightSum + lValue * rValue * nums[l]);
                }
            }
        }
        return dp[0][len - 1];
    }






	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {3,1,5,8};
        int max = solution.maxCoins(nums);
        System.out.println(max);
    }
}
