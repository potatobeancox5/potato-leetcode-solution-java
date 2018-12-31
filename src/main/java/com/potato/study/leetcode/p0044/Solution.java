package com.potato.study.leetcode.p0044;

/**
 * 
 * @author liuzhao11
 * 
 *      44. Wildcard Matching
 *      
 *      Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

 * 
 * 
 *         思路：通配符匹配问题
 *         两个指针 遇到*递归比较
 *         遇到相同的直接 比较下一个位置 不同的返回false 遇到？ 同上
 *         遇到* 分三种情况    如aaabb <==> *ab*b    
 *         		*代表一个字符    aabb <==> ab*b
 *         		*代表空字符        aaabb <==> ab*b
 *         		*代表很多字符    aabb <==> *ab*b
 *         
 *         直接递归遇到了TLE 想到开一个数组二维作为优化 最开始 
 *
 */
public class Solution {
	
	public boolean isMatch(String s, String p) {
		
		if ((null == s && null == p) || "".equals(s) && "".equals(p)) {
			return true;
		}
		int [][] result = new int[s.length() + 1][p.length() + 1];
		
		return isMatch(s, p, 0, 0, result);
		
		
	}
	
	private boolean isMatch(String s, String p, int indexS, int indexP,int [][] result) {
		if(result[indexS][indexP] == 1) {
			return true;
		} else if(result[indexS][indexP] == -1){
			return false;
		} else {
			if(indexS >= s.length() && indexP >= p.length()) {
				return true;
			} else if(indexS < s.length() && indexP < p.length()) {
				if(s.charAt(indexS) == p.charAt(indexP)) { // 暂时默认s中没有通配符
					boolean tmpResult = isMatch(s, p, indexS + 1, indexP + 1, result);
					result[indexS][indexP] = tmpResult ? 1 : -1;
					return tmpResult;
				} else if(p.charAt(indexP) == '?') {
					boolean tmpResult = isMatch(s, p, indexS + 1, indexP + 1, result);
					result[indexS][indexP] = tmpResult ? 1 : -1;
					return tmpResult;
				} else if(p.charAt(indexP) == '*') {
					boolean tmpResult = isMatch(s, p, indexS + 1, indexP + 1, result) 
							|| isMatch(s, p, indexS, indexP + 1, result) 
							|| isMatch(s, p, indexS + 1, indexP, result);
					result[indexS][indexP] = tmpResult ? 1 : -1;
					return tmpResult;
				} else { // 没有通配符且不相同
					result[indexS][indexP] = -1;
					return false;
				}
			} else if (indexS == s.length() && indexP < p.length()) {
				if("*".equals(p.substring(indexP))) {
					result[indexS][indexP] = 1;
					return true;
				} else if(p.charAt(indexP) == '*') {
					boolean tmpResult = isMatch(s, p, indexS, indexP + 1, result);
					result[indexS][indexP] = tmpResult ? 1 : -1;
					return tmpResult;
				} else {
					result[indexS][indexP] = -1;
					return false;
				}
			} else { // 一个为null 一个不为null
				return false;
			}
		}
	}
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
		String p = "***bba**a*bbba**aab**b";
		boolean result = solution.isMatch(s, p);
		System.out.println(result);
	}
}
