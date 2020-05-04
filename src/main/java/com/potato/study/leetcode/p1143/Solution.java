package com.potato.study.leetcode.p1143;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1143. Longest Common Subsequence
 *  
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.



If there is no common subsequence, return 0.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
 *         
 *      思路：
 *          两个字符串的最长公共子序列
 *          https://leetcode-cn.com/problems/longest-common-subsequence/solution/marvelzhong-deng-de-xue-xi-bi-ji-1143-by-tyanyon-2/
 *
 *          t1[i]==t2[j]时，dp[i][j]=dp[i−1][j−1]+1;
t1[i] != t2[j]时，dp[i][j] = max(dp[i-1][j], dp[i][j-1])。t1[i]!=t2[j]时，dp[i][j]=max(dp[i−1][j],dp[i][j−1])
 *
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String text1 = "abcde";
        String text2 = "ace";
        int count = solution.longestCommonSubsequence(text1, text2);
        System.out.println(count);
        Assert.assertEquals(3, count);


        text1 = "abc";
        text2 = "abc";
        count = solution.longestCommonSubsequence(text1, text2);
        System.out.println(count);
        Assert.assertEquals(3, count);


        text1 = "abc";
        text2 = "def";
        count = solution.longestCommonSubsequence(text1, text2);
        System.out.println(count);
        Assert.assertEquals(0, count);
    }
}
