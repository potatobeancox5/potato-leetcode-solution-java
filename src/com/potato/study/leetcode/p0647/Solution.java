package com.potato.study.leetcode.p0647;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         647. Palindromic Substrings
 * 
 *         Given a string, your task is to count how many palindromic substrings
 *         in this string.
 * 
 *         The substrings with different start indexes or end indexes are
 *         counted as different substrings even they consist of same characters.
 * 
 *         Example 1: Input: "abc" Output: 3 Explanation: Three palindromic
 *         strings: "a", "b", "c". Example 2: Input: "aaa" Output: 6
 *         Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa",
 *         "aaa". Note: The input string length won't exceed 1000.
 * 
 *         思路：
 *         两部分 
 *         1.  计算以left 和 right 为中心的字符串有多少个回文字符串
 * 		   2.  从不同index 开始遍历 找到 回文字符串
 */
public class Solution { 
	
	public int countSubstrings(String s) {
		int count = 0;
		for(int i = 0 ; i < s.length() ; i++) {
			count += countPalindromicSubstrings(s, i,i); // 单数串
			if(i + 1 < s.length()) {
				count += countPalindromicSubstrings(s, i,i+1); // 偶数串
			}
		}
        	return count;
    }
	
	
	private int countPalindromicSubstrings(String str, int left, int right) {
		int count = 0;
		while(left >= 0 && right < str.length()) {
			if(str.charAt(left) == str.charAt(right)) {
				count++;
			} else {
				break;
			}
			left--;
			right++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int count = solution.countSubstrings("fdsklf");
		System.out.println(count);
	}
}
