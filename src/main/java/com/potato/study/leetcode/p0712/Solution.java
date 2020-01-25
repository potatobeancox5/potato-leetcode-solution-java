package com.potato.study.leetcode.p0712;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	712. Minimum ASCII Delete Sum for Two Strings
 *  
 *         Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
Note:

0 < s1.length, s2.length <= 1000.
All elements of each string will have an ASCII value in [97, 122].
 *         
 *         思路：
 *          输入两个字符串 删除最少的 ASCII 能是两个字符串相同
 *          https://www.cnblogs.com/Dylan-Java-NYC/p/11450840.html
 *
 *          dp ij  减去的最小 ASCII 码  ij 是不包含在其中的
 *
 *          那么
 *           如果 i-1 == j-1
 *            dp i j == dp i - 1 j-1
 *           不相等
 *             dp i j = min {dp i - 1 j + 删除的 i-1,  dp i j-1 + 删除的j-1}
 *
 *             dp 0 0 = 0 初始化 0 j ,i 0
 *
 *
 *
 * 
 */
public class Solution {

    public int minimumDeleteSum(String s1, String s2) {
        // dp ij  减去的最小 ASCII 码  ij 是不包含在其中的
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        // 边界条件 dp 0 0 = 0 初始化 0 j ,i 0
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }
        // 正式开始dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
                }
            }
        }
        return dp[m][n];
    }
	

	
	public static void main(String[] args) {

		Solution solution = new Solution();

        String s1 = "sea";
        String s2 = "eat";
        int res = solution.minimumDeleteSum(s1, s2);
        System.out.println(res);
        Assert.assertEquals(231, res);

        s1 = "delete";
        s2 = "leet";
        res = solution.minimumDeleteSum(s1, s2);
        System.out.println(res);
        Assert.assertEquals(403, res);

    }
}
