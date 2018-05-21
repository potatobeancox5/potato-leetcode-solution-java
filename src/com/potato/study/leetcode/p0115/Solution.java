package com.potato.study.leetcode.p0115;

/**
 * 
 * @author liuzhao11
 * 115. Distinct Subsequences
 * 
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^

 *         思路： s 和 t  和计算s的子序列中有多少个t
 *         初始化时 从 j = 1 开始试一遍 s[i] 相等的话 dp[i][1] = 1,不相等的话 dp[i][0] = 0;
 *         
 *         dp[i][j] 表示  s 前i个字符能够表示 t 的前 j 个字符的子序列数 (其中si 一定能表示 tj)
 *         dp[i][j] = 
 *         	当前 s[i] == t[j] 
 *         		那么 dp[i][j] = dp[i-1][j-1] + dp[i-2][j-1] .. + dp[i-k][j-1];
 * 			当前 s[i] != t[j]	那么 dp[i][j] = 0 
 * 
 * 			可以压缩成两行 但为了编程方便 还是不进行压缩了
 * 			另外的思路
 * https://blog.csdn.net/fly_yr/article/details/50408457
 */
public class Solution {

	
	public int numDistinct(String s, String t) {
		if(t == null || s == null || t.length() == 0 || s.length() ==0) {
			return 0;
		}
        int[][] dp = new int[s.length()][t.length()];
        for(int j = 0 ; j < t.length() ; j++) {
        	for(int i = 0 ; i < s.length() ; i++) {
        		if(j == 0 && t.charAt(j) == s.charAt(i)) {
        			dp[i][j] = 1;
        		} else if(t.charAt(j) == s.charAt(i)){ // 不是第一列的情况
        			for(int k = i - 1 ; k >= j - 1 ; k--) {
        				if(dp[k][j-1] > 0) {
        					dp[i][j] += dp[k][j - 1];
        				}
        			}
        		}
        	}
        }
        // 计算总共有多少个组合
        int count = 0;
        for(int i = s.length() - 1 ; i >= t.length() - 1 ; i--) {
        	count += dp[i][t.length() - 1];
        }
        return count;
    }

	public static void main(String[] args) {
		 Solution solution = new Solution();
//		 String s = "rabbbit";
//		 String t = "rabbit";
		 String s = "babgbag";
		 String t = "bag";
		 int count = solution.numDistinct(s, t);
		 System.out.println("count:" + count);
	}
}
