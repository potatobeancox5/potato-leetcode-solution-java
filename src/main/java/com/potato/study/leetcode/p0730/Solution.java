package com.potato.study.leetcode.p0730;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	730. Count Different Palindromic Subsequences
 *  
 *         Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.

A subsequence of a string S is obtained by deleting 0 or more characters from S.

A sequence is palindromic if it is equal to the sequence reversed.

Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.

Example 1:
Input:
S = 'bccb'
Output: 6
Explanation:
The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
Note that 'bcb' is counted only once, even though it occurs twice.
Example 2:
Input:
S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
Output: 104860361
Explanation:
There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
Note:

The length of S will be in the range [1, 1000].
Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.

 *         
 *         思路：
 *         给定一个字符串 求这个字符串包含的回文序列有多少
 *
 *              https://www.jianshu.com/p/d1d4414c97d2
 * 
 */
public class Solution {

    public int countPalindromicSubsequences(String s) {
        int mod = 1000000007;
        int[][] dp = new int[s.length()][s.length()];
        // init
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        // len > 2
        for (int len = 1; len <= s.length(); len++) {
            // 开始位置
            for (int i = 0; i < s.length() - len; i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] * 2;
                    int left = i + 1;
                    int right = j - 1;
                    while (left <= right && s.charAt(left) != s.charAt(i)) {
                        left++;
                    }
                    while (left <= right && s.charAt(right) != s.charAt(j)) {
                        right--;
                    }
                    if (left == right) {
                        dp[i][j] += 1;
                    } else if (left > right) {
                        dp[i][j] += 2;
                    } else {
                        dp[i][j] -= dp[left + 1][right - 1];
                    }
                } else {
                    // i j 位置不相等
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
                // 结果处理到mod 范围之内 且是positive
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + mod : dp[i][j] % mod;
            }
        }
        return dp[0][s.length() - 1];
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();

		String s = "bccb";
        int res = solution.countPalindromicSubsequences(s);
        System.out.println(res);
        Assert.assertEquals(6, res);


        s = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
        res = solution.countPalindromicSubsequences(s);
        System.out.println(res);
        Assert.assertEquals(104860361, res);
    }
}
