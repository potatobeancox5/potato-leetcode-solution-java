package com.potato.study.leetcode.p0151;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *      151. Reverse Words in a String
 *         
 *          
 *   Given an input string, reverse the string word by word.

Example:

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.

 *
 *         题目需求：
 *				用一个栈
 *         思路：
 *
 *
 *
 */
public class Solution {

	public String reverseWords(String s) {
		String[] words = s.split(" ");
		StringBuilder builder = new StringBuilder();
		Stack<String> stack = new Stack<>();
		for (String word : words) {
			if(null != word && !"".equals(word)) {
				stack.push(word);
			}
		}
		while(!stack.isEmpty()) {
			String word = stack.pop();
			builder.append(word.trim()).append(" ");
		}
		if(builder.length() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}
		return builder.toString();
	}



	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
//		int result = solution.evalRPN(tokens);
//		System.out.println(result);
	}
}
