package com.potato.study.leetcode.p0518;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         518. Coin Change 2
 * 
 *         You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1


Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer

 * 
 * 
 *         思路：
 *      518. Coin Change 2

给一组硬币组合 判断有多少种组合数

排序硬币组合

dfs
参数列表
coin 硬币 大到小
coinIndex 当前找到的coin index 从这个位置后找
targetAmout 当前目标 量
global result 组合数量
usedCount 使用硬币数量

if target等于0 全局个数增加 return

for i cpinindex len-1
递归 i


主函数返回个数


https://blog.csdn.net/excellentlizhensbfhw/article/details/81545982


dp求解 dp i 代表 组成i的组合个数
遍历 vale
dp i +=  dp i-val (当前 i的处理次数 等于 i-val的次数)

dp 0 =1

for e val
for i val 到 amount
dp i 等于  dp i-val +1


返回dp n
 *          
 */
public class Solution {

    public int change(int amount, int[] coins) {
        // dp求解 dp i 代表 组成i的组合个数
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 遍历 coins
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // dp[i] += dp[i - coin];
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = 5;
        int[] coins = {1, 2, 5};
        int findMinMoves = solution.change(amount, coins);
        System.out.println(findMinMoves);
        Assert.assertEquals(4, findMinMoves);
    }
}
