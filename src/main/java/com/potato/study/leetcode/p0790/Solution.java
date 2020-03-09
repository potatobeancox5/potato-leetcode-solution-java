package com.potato.study.leetcode.p0790;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	790. Domino and Tromino Tiling
 *  
 *        We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.

XX  <- domino

XX  <- "L" tromino
X
Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.

(In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)

Example:
Input: 3
Output: 5
Explanation:
The five different ways are listed below, different letters indicates different tiles:
XYZ XXZ XYY XXY XYY
XYZ YYZ XZZ XYY XXY
Note:

N  will be in range [1, 1000].
 *         
 *
 *         题目含义：
 *         铺地板 有两种地板砖 一种I 形状 一种L形状 问一共有多少种铺法
 *
 *
 *         思路：
 *             dp
 *             转移方程
 *             dp[i]][0]表示第i列铺满，dp[i][1]表示第i列有一块
 *              i-1 列铺满 （I）数量  i-1 铺了1块 L形 数量 i-2铺满的数量 用横着的两个i
 *             dp[i][0]=(int)((dp[i-1][0]+dp[i-1][1]+dp[i-2][0])%(1e9+7));

                dp[i][1]=(int)((dp[i-2][0]*2+dp[i-1][1])%(1e9+7));

                i-2 两种L， i-1 横着的一个i

https://blog.csdn.net/qq_36718317/article/details/79791825
 *
 *
 * 
 */
public class Solution {

    public int numTilings(int n) {

        // init情况
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        long[][] dp = new long[n + 1][2];
        dp[1][0]=1;
        dp[1][1]=0;
        dp[2][0]=2;
        dp[2][1]=2;
        // 转移方程
        for (int i = 3; i <= n; i++) {
            dp[i][0]=(int)((dp[i-1][0]+dp[i-1][1]+dp[i-2][0])%(1e9+7));
            dp[i][1]=(int)((dp[i-2][0]*2+dp[i-1][1])%(1e9+7));
        }
        return (int)dp[n][0];
    }


	

	public static void main(String[] args) {
		Solution solution = new Solution();

		int n = 3;
        int res = solution.numTilings(n);
        System.out.println(res);
        Assert.assertEquals(5, res);

    }
}
