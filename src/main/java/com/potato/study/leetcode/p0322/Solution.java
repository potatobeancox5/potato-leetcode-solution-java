package com.potato.study.leetcode.p0322;


import java.util.Arrays;

/**
 * 
 * @author Administrator
 *
 *         322. Coin Change
 *         
 *          
 *         You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 *         
 *         
 *         题目含义：
 *          给出货币个数，找到最少使用几个货币进行兑换
 *         思路：
 *         动态规划
 *         dp[i] 兑换i 需要使用多少个硬币
 *         dp[i] = min {dp[i], dp[i - coin[j]] + 1}
 *         https://www.jianshu.com/p/9208a4ac0df2
 *
 *         
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

	public static void main(String[] args) {
		Solution solution = new Solution();

//		int[] coins = {1, 2, 5};
//		int amount = 11;

        int[] coins = {2};
        int amount = 3;

        int count = solution.coinChange(coins, amount);
        System.out.println(count);
    }
}
