package com.potato.study.leetcode.p1025;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1025. Divisor Game
 *  
 *        Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.

Return True if and only if Alice wins the game, assuming both players play optimally.



Example 1:

Input: 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.
Example 2:

Input: 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.


Note:

1 <= N <= 1000

 *         
 *         思路：
 *          动态规划
 *              dp i 代表 游戏数字i alice 先出的结果
 *              dp i = {!dp j | !dp j -1 | ... | !dp 1 } j from 1 - i - 1
 *
 */
public class Solution {

    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
//        dp[1] = true;
        for (int i = 1; i <= n; i++) {
            boolean curResult = false;
            for (int x = 1; x < i; x++) {
                if (i % x == 0) {
                    curResult = curResult || (!dp[i - x]);
                }
            }
            dp[i] = curResult;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int n = 2; // true
		int n = 3; // false
        boolean res = solution.divisorGame(n);
        System.out.println(res);
    }
}
