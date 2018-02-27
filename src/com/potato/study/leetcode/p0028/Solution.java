package com.potato.study.leetcode.p0028;


/**
 * 
 * @author liuzhao11
 * 28. Implement strStr()
 *         
 *         Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
 * 
 *         思路： 找到str出现的字串的位置
 *         最好办法是cmp 这里直接遍历 维护一个数组 如果 这个地方不同的话 从 哪里 开始继续匹配 来减少比较次数
 *         
 *         创建数组cmp[] 
 *         abcab
 *         
 *         
 * 
 */
public class Solution {
	
	/**
	 * 暂时没有采用 cmp 算法 直接进行比较 不行后移
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		if (haystack == null) {
			return -1;
		}
		if(needle == null || "".equals(needle)) {
			return 0;
		}
		if(haystack.length() < needle.length()) {
			return -1;
		}
		for(int i = 0 ; i <= haystack.length() - needle.length() ; i++) { // 控制比较次数
			boolean isSame = true;
			for(int j = 0 ; j < needle.length() ; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					isSame = false;
					break;
				} 
			}
			if (isSame) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String haystack = "a";
		String needle = "a";
		int index = solution.strStr(haystack, needle);
		System.out.println(index);
	}

}
