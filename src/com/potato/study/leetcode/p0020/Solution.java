package com.potato.study.leetcode.p0020;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not. 
 * 
 * 思路 ：符号匹配问题
 * 开一个栈， 每次正括号 入栈 负括号出栈 出栈符号必须与当前符号匹配 否则返回false
 *
 * 
 * @author Administrator
 *
 */
public class Solution {
	public boolean isValid(String s) {
		if(null == s || "".equals(s.trim())) {
			return true;
		}
		Stack<Character> symbols = new Stack<>();
		for(int i = 0 ; i < s.length() ; i++) {
			char current = s.charAt(i);
			if(current == '(' || current == '{' || current == '[') {
				symbols.push(current);
			} else if (current == ')' || current == '}' || current == ']') {
				if(symbols.isEmpty()) {
					return false;
				}
				char temp = symbols.pop();
				if((temp == '(' && current == ')') 
						|| (temp == '[' && current == ']') 
						|| (temp == '{' && current == '}')) {
					//匹配上了
					continue;
				} else {
					return false;
				}
			}
		}
		if(!symbols.isEmpty()) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "]";
		boolean result = solution.isValid(s);
		System.out.println(result);
	}
}
