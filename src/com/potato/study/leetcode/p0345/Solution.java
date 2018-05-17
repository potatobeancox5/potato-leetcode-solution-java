package com.potato.study.leetcode.p0345;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *        345. Reverse Vowels of a String
 * 
 *         Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 *         思路：交换字符串中的元音字母
 *        
 */
public class Solution {
	
	public String reverseVowels(String s) {
		if(null == s || s.length() == 0) {
			return s;
		}
		Set<Character> vowelSet = new HashSet<>();
		vowelSet.add('a');
		vowelSet.add('e');
		vowelSet.add('i');
		vowelSet.add('o');
		vowelSet.add('u');
		vowelSet.add('A');
		vowelSet.add('E');
		vowelSet.add('I');
		vowelSet.add('O');
		vowelSet.add('U');
		int left = 0;
		int right = s.length() - 1;
		char[] arr = s.toCharArray();
		while(left < right) {
			//找左边和右边第一个元音
			while(left < right && !vowelSet.contains(arr[left])) {
				left++;
			}
			while(left < right && !vowelSet.contains(arr[right])) {
				right--;
			}
			if(left < right) { // 交换
				char tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				left++;
				right--;
			}
		}
		return new String(arr);
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "hello";
		String newS = solution.reverseVowels(s);
		System.out.println(newS);
	}
}
