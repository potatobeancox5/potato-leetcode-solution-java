package com.potato.study.leetcode.p0877;

/**
 * @author liuzhao11
 * <p>
 * 877. Stone Game
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.



Example 1:

Input: [5,3,4,5]
Output: true
Explanation:
Alex starts first, and can only take the first 5 or the last 5.
Say he takes the first 5, so that the row becomes [3, 4, 5].
If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alex, so we return true.


Note:

2 <= piles.length <= 500
piles.length is even.
1 <= piles[i] <= 500
sum(piles) is odd.
 *
 *
 * 题目含义：
 * https://blog.csdn.net/androidchanhao/article/details/81271077
    dp[i][j] 表示 先走的人 在i - j 中 最多赢后走的人多少分
    dp[i][i]  开始 等于 piles[i]
    dp[i][j] = max {pile[i] - dp[i+1][j], pile[j] - dp[i][j -1]}
    每次操作完 dp表示的最大胜利值就是后接下来拿的人赢得分
 *
 * 思路：
 *

 *
 */
public class Solution {
    public boolean stoneGame(int[] piles) {

        return false;
    }
}
