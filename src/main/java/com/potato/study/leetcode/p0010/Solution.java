package com.potato.study.leetcode.p0010;

/**
 * 动态规划 搞了好多便
 * @author liuzhao11 
 * 
 * 
 * 10. Regular Expression Matching
 * 
 *         Implement regular expression matching with support for '.' and '*'.
 *         '.' Matches any single character. '*' Matches zero or more of the
 *         preceding element.
 * 
 *         The matching should cover the entire input string (not partial).
 * 
 *         The function prototype should be: bool isMatch(const char *s, const
 *         char *p)
 * 
 *         Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 *         isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa",
 *         ".*") → true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") →
 *         true
 * 
 *         思路：
 *         申请boolean dp [i][j] ; 存放结果
 *         dp[0][0] = true
 *         dp[0][i] 表示字符串“” 与pattern i 之前字符对比
 *         dp[i][0] 表示 source 前i个字符 与pattern "" 匹配
 *         表示 s️ource "" 到 i 与 pattern 比较结果
 * 			从后边向前匹配
 * 				当前j+1字符是‘*’
 * 					j字符为'.'或者j字符与 i 相同	
 * 						可能匹配上一个，可能匹配上多个，可能一个都没匹配上
 * 							dp[i+1][j+1] = (dp[i][j-1](匹配1个)|| dp[i][j+1] (匹配多个) || dp[i+1][j-1] (没匹配));
 * 					j-1 字符与 i 不相同		dp[i+1][j+1] = dp[i+1][j-1] // 废掉两个字符
 * 				当前j字符不是'*'
 * 					当前j字符是‘.’ 或者 与i字符相同      dp[i+1][j+1] = dp[i][j];
 * 					当前j 字符与 i 字符不同    			dp[i][j] = false;(无法匹配)
 * 
 * 
 */
public class Solution {
	
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		//动态规划初始化 第一行和第一列
		dp[0][0] = true;
		//初始化第0行,除了[0][0]全为false，毋庸置疑，因为空串p只能匹配空串，其他都无能匹配
		//初始化第0列，只有X*能匹配空串，如果有*，它的真值一定和p[0][j-2]的相同（略过它之前的符号）
		for (int i = 0; i < p.length(); i++) {
	        if (p.charAt(i) == '*' && dp[0][i-1]) {//dp[0][i-1]不可能第一个字符就出现 *
	            dp[0][i+1] = true;
	        }
	    }
		for(int i = 0 ; i < s.length() ; i++) {
			for(int j = 0 ; j < p.length() ; j++) {
				if(p.charAt(j) == '*') {
					if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i))  {
						dp[i+1][j+1] = (dp[i][j-1]|| dp[i][j+1]|| dp[i+1][j-1]);
					} else {
						dp[i+1][j+1] = dp[i+1][j-1];
					}
				} else {
					if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
						dp[i+1][j+1] = dp[i][j];
					} else {
						dp[i+1][j+1] = false;
					}
				}
			}
		}
		return dp[s.length()][p.length()];
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
//		String s = "aa";
//		String p = "a";
		String s = "aa";
		String p = "a*";
		boolean result = solution.isMatch(s, p);
		System.out.println(result);
	}

}
