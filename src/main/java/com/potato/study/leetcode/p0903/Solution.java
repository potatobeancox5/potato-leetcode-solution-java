package com.potato.study.leetcode.p0903;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	903. Valid Permutations for DI Sequence
 *  
 *       We are given S, a length n string of characters from the set {'D', 'I'}. (These letters stand for "decreasing" and "increasing".)

A valid permutation is a permutation P[0], P[1], ..., P[n] of integers {0, 1, ..., n}, such that for all i:

If S[i] == 'D', then P[i] > P[i+1], and;
If S[i] == 'I', then P[i] < P[i+1].
How many valid permutations are there?  Since the answer may be large, return your answer modulo 10^9 + 7.



Example 1:

Input: "DID"
Output: 5
Explanation:
The 5 valid permutations of (0, 1, 2, 3) are:
(1, 0, 3, 2)
(2, 0, 3, 1)
(2, 1, 3, 0)
(3, 0, 2, 1)
(3, 1, 2, 0)


Note:

1 <= S.length <= 200
S consists only of characters from the set {'D', 'I'}.
 *         
 *         题目含义：
 *              https://leetcode-cn.com/problems/valid-permutations-for-di-sequence/solution/di-xu-lie-de-you-xiao-pai-lie-by-leetcode/
 *         思路：
 *
 *
 *
 */
public class Solution {

    public int numPermsDISequence(String str) {
        int mod = 1_000_000_007;
        int len = str.length();

        // dp[i][j] : Num ways to place P_i with relative rank j
        int[][] dp = new int[len+1][len+1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (str.charAt(i-1) == 'D') {
                    for (int k = j; k < i; ++k) {
                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= mod;
                    }
                } else {
                    for (int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= mod;
                    }
                }
            }
        }

        int ans = 0;
        for (int x: dp[len]) {
            ans += x;
            ans %= mod;
        }

        return ans;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        String s = "DID";
        int result = solution.numPermsDISequence(s);
        System.out.println(result);
        Assert.assertEquals(5, result);
    }
}
