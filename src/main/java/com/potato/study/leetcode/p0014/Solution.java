package com.potato.study.leetcode.p0014;

/**
 * 
 * @author liuzhao11 14. Longest Common Prefix 
 * 
 * Write a function to find the
 *         longest common prefix string amongst an array of strings.
 * 
 * 思路：遍历字符串 第一次遍历的时候 纪录字符串数组中最短的串 
 * 每次遍历 纪录当前字符 并当字母不相同时 纪录boolean isSame default=true；
 * 	之后的当当前字符串不存在字符或者不同时 改变并跳出循环
 * 
 */
public class Solution {
	
	public String longestCommonPrefix(String[] strs) {
		if (null == strs || strs.length == 0) {
			return new String();
		} 
		if (strs.length == 1) {
			return strs[0];
		}
		int index = 0;
		int length = strs[0].length();
		if(length == 0) {
			return "";
		}
		StringBuilder resultStr = new StringBuilder();
		while(index < length) {	
			boolean isAllSame = true;
			for (int i = 1; i < strs.length; i++) {
				// 判断需要遍历多少次字符串数组
				if (index == 0 && length > strs[i].length()) {
					length = strs[i].length();
				}
				if(index >= strs[i].length() || strs[0].charAt(index) != strs[i].charAt(index)) {
					isAllSame = false;
					break;
				}
			}
			if(isAllSame) {
				resultStr.append(strs[0].charAt(index));
				index++;
			} else { // 存在不一致的情况 已经结束了遍历
				break;
			}
		}
        return resultStr.toString();
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
//		String[] strs = {"abc","abd","abcd","abababab"};
		String[] strs = {"","abd","abcd","abababab"};
		String longestCommonPrefix = solution.longestCommonPrefix(strs);
		System.out.println(longestCommonPrefix);
	}

}
