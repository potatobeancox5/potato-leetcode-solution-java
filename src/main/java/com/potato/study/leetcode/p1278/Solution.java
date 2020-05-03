package com.potato.study.leetcode.p1278;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1278. Palindrome Partitioning III
 *  
 *
You are given a string s containing lowercase letters and an integer k. You need to :

First, change some characters of s to other lowercase English letters.
Then divide s into k non-empty disjoint substrings such that each substring is palindrome.
Return the minimal number of characters that you need to change to divide the string.



Example 1:

Input: s = "abc", k = 2
Output: 1
Explanation: You can split the string into "ab" and "c", and change 1 character in "ab" to make it palindrome.
Example 2:

Input: s = "aabbc", k = 3
Output: 0
Explanation: You can split the string into "aa", "bb" and "c", all of them are palindrome.
Example 3:

Input: s = "leetcode", k = 8
Output: 0


Constraints:

1 <= k <= s.length <= 100.
s only contains lowercase English letters.
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/palindrome-partitioning-iii/solution/javadp-by-z446979478/
 *
 *          https://leetcode-cn.com/problems/palindrome-partitioning-iii/solution/javadp-by-z446979478

1278. Palindrome Partitioning III
 *
 *
 *
 *

 *
 */
public class Solution {

    public int palindromePartition(String s, int k) {
        // 计算从 i-j 变成回文需要改多少字符
        int len = s.length();
        int [][] palin = new int[len+1][len+1];
        for (int i = len; i > 0 ; i--) {
            for (int j = i; j <= len; j++) {
                if (j - i >= 2) {
                    palin[i][j] = palin[i + 1][j - 1];
                }
                // 根据 i j 位置判定需要怎么记性变换
                if (s.charAt(i-1) != s.charAt(j-1)) {
                    palin[i][j]++;
                }
            }
        }
        // 计算分割成k个字符串后让每个字符串变成回文字符串的最少修改次数 用dp[i][j]表示，i表示切割成i个 j表示当前字符串的长度
        int[][] dp = new int[k+1][s.length()+1];
        for (int i = 1; i <= k ; i++) {
            for (int j = i; j <= len; j++) {
                if (i == 1) {
                    dp[i][j] = palin[i][j];
                } else {
                    dp[i][j] = dp[i-1][i-1] + palin[i][j];
                    for(int x = i; x < j; x++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][x] + palin[x + 1][j]);
                    }
                }
            }
        }
        return dp[k][s.length()];
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "abc";
        int k = 2;
        int res = solution.palindromePartition(s, k);
        System.out.println(res);
        Assert.assertEquals(1, res);


        s = "aabbc";
        k = 3;
        res = solution.palindromePartition(s, k);
        System.out.println(res);
        Assert.assertEquals(0, res);

        s = "leetcode";
        k = 8;
        res = solution.palindromePartition(s, k);
        System.out.println(res);
        Assert.assertEquals(0, res);
    }
}
