package com.potato.study.leetcode.p0150;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *      150. Evaluate Reverse Polish Notation
 *         
 *          
 *   Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

 *
 *         题目需求：
 *         计算逆波兰表达式的值
 *         思路：
 *         正常办法使用一个栈 进行计算
 *
 *
 */
public class Solution {

	public int evalRPN(String[] tokens) {
		if(null == tokens) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if(isNum(token)) {
				stack.push(Integer.parseInt(token));
			} else {
				int op2 = stack.pop();
				int op1 = stack.pop();
				switch (token) {
					case "+" :
						stack.push(op1 + op2);
						break;
					case "-" :
						stack.push(op1 - op2);
						break;
					case "*" :
						stack.push(op1 * op2);
						break;
					case "/" :
						stack.push(op1 / op2);
						break;
				}
			}
		}
		return stack.pop();
	}

	/**
	 * 判断是否是数字
	 * @param numStr
	 * @return
	 */
	private boolean isNum (String numStr) {
		try {
			Integer.parseInt(numStr);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		int result = solution.evalRPN(tokens);
		System.out.println(result);
	}
}
