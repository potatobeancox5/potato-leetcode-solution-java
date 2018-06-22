package com.potato.study.leetcode.p0131;

import java.util.ArrayList;
import java.util.List;

import com.potato.study.leetcode.util.ListUtil;

/**
 * 
 * @author liuzhao11
 * 
 *       131. Palindrome Partitioning
 *         
 *    Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]*        
 *         
 *         思路：
 *         如何分割一个字符串 让其变成一个回文串
 *         从 0 开始 到i 将字符串分割 判断 前i个字符是不是回文 
 *         是的话 对后边的字符串 进行 前面的判断操作 直到到达最后一个节点 将之前分割的路径 写入result中
 *        
 * 
 */
public class Solution {
	
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> path = new ArrayList<>();
		writeResult(result, path, s, 0);
		return result;
	}
	
	/**
	 * 
	 * @param result		最终结果
	 * @param path		当前分割方式
	 * @param s			目标字符串
	 * @param start		开始位置
	 */
	private void writeResult(List<List<String>> result, List<String> path, String s, int start) {
		// 判断是否达到当前分割的最终位置 达到的话 将当前path 加入result
		if(start == s.length()) {
			result.add(path);
			return;
		}
		// 当前还需要继续走
		for(int i = start + 1 ; i <= s.length() ; i++) {			
			// 当前字符串
			String str = s.substring(start, i);
			// is str Palindrome? 
			if(isPalindrome(str)) {
				List<String> current = new ArrayList<>();
				current.addAll(path);
				current.add(str);
				// 对之后的字符串进行判断 分治了
				writeResult(result, current, s, i);
			} 
		}
	}
	
	
	/**
	 * 判断一个字符串是否是一个字串
	 * @param s
	 * @return
	 */
	private boolean isPalindrome(String s) {
		if(null == s || s.length() == 0) {
			return false;
		}
		int i = 0;
		int j = s.length() - 1;
		while(i < j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "aab";
		List<List<String>> list = solution.partition(s);
		ListUtil.printListList(list);
	}
}
