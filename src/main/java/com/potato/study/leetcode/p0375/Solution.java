package com.potato.study.leetcode.p0375;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *       375. Guess Number Higher or Lower II
 * 
 *      We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 *         
 *         思路：
 *         https://blog.csdn.net/adfsss/article/details/51951658
 *         https://www.jianshu.com/p/f0008085f3d7
 *          猜 i 事 成本为 i + max(dp 1 ~ i-1, dp i + 1 ~ len)
 *
 *
 *
 */
public class Solution {


    public int getMoneyAmount(int n) {

        // dp 存储从i-j 猜中所付出的最少钱
        int[][] dp = new int[n+1][n+1];
        return getMoney(dp, 1, n);
    }

    private int getMoney (int[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] > 0) {
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int sum = i + Math.max(getMoney(dp, start, i-1), getMoney(dp, i+1, end));
            min = Math.min(min, sum);
        }
        dp[start][end] = min;
        return min;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int n = 10;
        int res = solution.getMoneyAmount(n);
		System.out.println(res);
        Assert.assertEquals(16, res);



	}
}
