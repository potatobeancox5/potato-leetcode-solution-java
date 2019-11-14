package com.potato.study.leetcode.p0516;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         516. Longest Palindromic Subsequence
 * 
 *         Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

 * 
 * 
 *         思路：
 *          516. Longest Palindromic Subsequence

https://blog.csdn.net/xiaocong1990/article/details/54976319

求最长回文子序列 长度

dp i j 表示从i到j 都包含 中最大回文串长度
dp ii 初始值为1
如果 i等于 j
那么dp i j = dp i+1dp j-1 +2
否则 就是 i j-1 和 i-1 j中最大值
for i len到 0
for j i+1 到 len

返回len 0 len-1
 *          
 */
public class Solution {

    public int longestPalindromeSubseq(String s) {
//        dp i j 表示从i到j 都包含 中最大回文串长度
        int[][] dp = new int[s.length()][s.length()];


        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // i j 字母相同 回文串比 [i+1][j-1] 多2
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    // 原来越往里 不会有数组溢出
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "bbbab";
        int subLen = solution.longestPalindromeSubseq(s);
        System.out.println(subLen);
        Assert.assertEquals(4, subLen);

        s = "cbbd";
        subLen = solution.longestPalindromeSubseq(s);
        System.out.println(subLen);
        Assert.assertEquals(2, subLen);
    }
}
