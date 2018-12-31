package com.potato.study.leetcode.p0005;

/**
 * 
 * @author liuzhao11 5. Longest Palindromic Substring Given a string s, find the
 *         longest palindromic substring in s. You may assume that the maximum
 *         length of s is 1000.
 * 
 *         Example:
 * 
 *         Input: "babad"
 * 
 *         Output: "bab"
 * 
 *         Note: "aba" is also a valid answer. Example:
 * 
 *         Input: "cbbd"
 * 
 *         Output: "bb"
 * 
 *         思路：遍历字符串 从中间位置i或者 向两端比较 若比传入最大值大，则返回最大子串，否则返回空 返回不是空时 更新最长子串长度
 * 
 * 
 * 
 * 
 */
public class Solution {

	public String longestPalindrome(String s) {
		int maxLength = 0;
		String string = "";
		for (int i = 0; i < s.length(); i++) {
			String result1 = subStrPalindrome(s ,i, i+1 , maxLength);
			if(result1.length() > maxLength) {
				maxLength = result1.length();
				string = result1;
			}
			String result2 = subStrPalindrome(s ,i - 1 , i + 1 , maxLength);
			if(result2.length() > maxLength) {
				maxLength = result2.length();
				string = result2;
			}
		}
		return string;
	}

	private String subStrPalindrome(String s ,int left , int right , int maxLength) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		int currentLength = right - left - 1;
		if(maxLength < currentLength) {
			return s.substring(left + 1, right);
		}
		return "";
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String longestPalindrome = solution.longestPalindrome("cbbd");
		System.out.println(longestPalindrome);
	}

}
