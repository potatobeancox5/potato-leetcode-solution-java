package com.potato.study.leetcode.p0032;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *         
 *         
 *         思路：
 对于当前字符，如果是"(",直接压入栈中。如果是")"，要分以下几种情况讨论：

（1）如果当前栈为空，说明不存在与当前右括号配对的左括号，直接continue.

（2）如果当前栈大小为1：

       a.如果栈顶元素是"("，则找到一个有效的括号序列，弹出栈顶元素，并压入这个序列的长度2；

       b.如果栈顶元素是数字，说明不存在与当前右括号配对的左括号，且由于插入了一个右括号，
       之前得到的括号序列无法更长，需要弹出栈顶元素。

（3）如果当前栈的大小大于等于2：

       弹出栈顶元素

       a.如果是"(",则找到一个为2的有效序列，再检查栈顶元素，如果是数字，
       说明可以与前面找到的括号序列合并为一个更大的序列，与其相加后压入栈，否则直接将2压入栈；

       b.如果是数字，由于当前的栈大小大于等于2，则下一个栈的元素一定是“（”，
       弹出后压入合并后的序列长度，压之前再检查，如果栈顶元素还是为数字，则再合并，再压入。
       
       联系的括号经过遍历 只能保存一个数字
 *         
 * 
 */
public class Solution {

	public int longestValidParentheses(String s) {
		if(null == s || "".equals(s)) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for(int i = 0 ; i < s.length() ; i++) {
			char symbol = s.charAt(i);
			if('(' == symbol) {
				stack.push(0); // 0 代表 （
			} else if(stack.isEmpty()){ // 直接遇到） 非法
				 continue;
			} else if(stack.size() == 1) { //
				int popValue = stack.pop();
				if(popValue == 0) {
					if(max < 2) {
						max = 2;
					}
					stack.push(2);
				} else { // （））非法 直接比较最大值
					max = max > popValue ? max : popValue;
				}
			} else { // stack size >=2
				int popValue = stack.pop();
				if(popValue == 0) {
					int temp = 2;
					while(!stack.isEmpty() && stack.peek() != 0) {
						temp += stack.pop();
					}
					stack.push(temp);
					max = max > temp ? max : temp;
				} else {
					int temp = popValue + 2;
					stack.pop();
					while(!stack.isEmpty() && stack.peek() != 0) {
						temp += stack.pop();
					}
					stack.push(temp);
					max = max > temp ? max : temp;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = ")()())";
		int count = solution.longestValidParentheses(s);
		System.out.println(count);

	}
}
