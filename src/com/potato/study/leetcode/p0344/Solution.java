package com.potato.study.leetcode.p0344;

/**
 * 
 * @author liuzhao11
 * 
 *         344. Reverse String
 * 
 *         Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh". 
 *         思路：交换字符串
 *        
 */
public class Solution {
	
	public String reverseString(String s) {
		if(null == s || s.length() == 0) {
			return s;
		}
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < s.length() / 2 ; i++) {
        	char tmp = arr[i];
        	arr[i] = arr[s.length() - 1 - i];
        	arr[s.length() - 1 - i] = tmp;
        }
        return new String(arr);
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "hello";
		String str = solution.reverseString(s);
		System.out.println(str);
	}
}
