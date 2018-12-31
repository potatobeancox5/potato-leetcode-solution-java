package com.potato.study.leetcode.p0132;

/**
 * 
 * @author liuzhao11
 * 
 *       132. Palindrome Partitioning II
 *         
 *    Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *         
 *         思路：
 *         https://www.cnblogs.com/ganganloveu/p/3982561.html
 *         
 *         使用dp求解 
 *         boolean [][] isPalindrome  纪录 【i，j】是否是回文字符串 
 *         int【】 cutNum 纪录当前 i 位置进行切割 从 i位置到 字符串末尾 一共需要切割的最少次数
 *         从cutNum数组可以看出 需要从 i = len - 1 位置开始求解 动态规划数组 
 *         isPalindrome 数组求解遵循最小间隔的原则
 *         isPalindrome[i][j] = true 前提 s[i] == s[j] && (j - i <= 1 || (j - i > 1 && isPalindrome[i+1][j-1]))  
 *         从i位置切割字符串得到的最小切割长度为i切割 或者 j+1 切割 加上 当前的串
 *         cutNum[i] = min{cutNum[i],cutNum[j+1] + 1}
 *        
 * 
 */
public class Solution {
	
	
	public int minCut(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		boolean [][] isPalindrome = new boolean[s.length()][s.length()];
		int[] cutNum = new int[s.length() + 1]; // 加一为了防止最后一个位置溢出
		for(int i = s.length() - 1 ; i>=0 ;i--) {
			// min[i]初始化为min[i+1]+1，即初始化s[i]与s[i+1]之间需要切一刀。这里考虑边界问题，因此min数组设为n+1长度。
			//切一刀一定能保证都是回文
			cutNum[i] = cutNum[i + 1] + 1;
			for(int j = i ; j < s.length() ; j++) {
				if(s.charAt(i) == s.charAt(j) 
						&& (j - i <= 1 || (j - i > 1 && isPalindrome[i+1][j-1]))) {
					isPalindrome[i][j] = true;
					cutNum[i] = min(cutNum[i],cutNum[j+1] + 1);
				}
			}
		}
		return cutNum[0] - 1;
    }
	
	private int min(int a, int b) {
		return a > b ? b : a;
	}
	
	
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "aaa";
		int min = solution.minCut(s);
		System.out.println(min);
	}
}
