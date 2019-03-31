package com.potato.study.leetcode.p0227;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *      227. Basic Calculator II
 * 
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.

 *
 * 题目解释：
 *
 * 思路：
 *     栈 操作数入栈
 *     开一个栈 计算 按照符号优先级进行计算
        抽一个判断符号优先级的方法
 *  
 */
public class Solution {

    public int calculate(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        int numStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*'|| s.charAt(i) == '/') {

            }
        }

        return 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

    }

}
