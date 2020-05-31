package com.potato.study.leetcode.p0940;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	940. Distinct Subsequences II
 *  
 *       Given a string S, count the number of distinct, non-empty subsequences of S .

Since the result may be large, return the answer modulo 10^9 + 7.



Example 1:

Input: "abc"
Output: 7
Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
Example 2:

Input: "aba"
Output: 6
Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
Example 3:

Input: "aaa"
Output: 3
Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".




Note:

S contains only lowercase letters.
1 <= S.length <= 2000
 *         
 *         题目含义：
 *
 *         思路：
 *
 *          https://leetcode-cn.com/problems/distinct-subsequences-ii/solution/bu-tong-de-zi-xu-lie-ii-by-leetcode/
 *
 */
public class Solution {


    public int distinctSubseqII(String str) {
        int mod = 1_000_000_007;
        int length = str.length();
        int[] dp = new int[length+1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < length; ++i) {
            int x = str.charAt(i) - 'a';
            dp[i+1] = dp[i] * 2 % mod;
            if (last[x] >= 0) {
                dp[i+1] -= dp[last[x]];
            }
            dp[i+1] %= mod;
            last[x] = i;
        }

        dp[length]--;
        if (dp[length] < 0) {
            dp[length] += mod;
        }
        return dp[length];
    }
}
