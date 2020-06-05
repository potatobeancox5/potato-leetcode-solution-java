package com.potato.study.leetcode.p1223;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1223. Dice Roll Simulation
 *  
 *
A die simulator generates a random number from 1 to 6 for each roll. You introduced a constraint to the generator such that it cannot roll the number i more than rollMax[i] (1-indexed) consecutive times.

Given an array of integers rollMax and an integer n, return the number of distinct sequences that can be obtained with exact n rolls.

Two sequences are considered different if at least one element differs from each other. Since the answer may be too large, return it modulo 10^9 + 7.



Example 1:

Input: n = 2, rollMax = [1,1,2,2,2,3]
Output: 34
Explanation: There will be 2 rolls of die, if there are no constraints on the die, there are 6 * 6 = 36 possible combinations. In this case, looking at rollMax array, the numbers 1 and 2 appear at most once consecutively, therefore sequences (1,1) and (2,2) cannot occur, so the final answer is 36-2 = 34.
Example 2:

Input: n = 2, rollMax = [1,1,1,1,1,1]
Output: 30
Example 3:

Input: n = 3, rollMax = [1,1,1,2,2,3]
Output: 181


Constraints:

1 <= n <= 5000
rollMax.length == 6
1 <= rollMax[i] <= 15
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/dice-roll-simulation/solution/java-2wei-dp-by-zdxiq125/
 *
 *
 *
 */
public class Solution {

    private static int mod = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        int[][] dp = new int[n][6];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                dp[i][j] = Arrays.stream(dp[i-1]).reduce(0, (a, b) -> (a + b) % mod);
                // 参见算法部分第2条
                if (i == rollMax[j]) {
                    dp[i][j]--;
                } else if (i > rollMax[j]) {
                    for (int k = 0; k < 6; k++) {
                        if (j != k) {
                            dp[i][j] = (dp[i][j] - dp[i - rollMax[j] - 1][k] + mod) % mod;
                        }
                    }
                }
            }
        }
        return Arrays.stream(dp[n-1]).reduce(0, (a, b) -> (a + b) % mod);
    }

}
