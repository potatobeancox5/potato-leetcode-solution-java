package com.potato.study.leetcode.p0921;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	921. Minimum Add to Make Parentheses Valid
 *  
 *      Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.



Example 1:

Input: "())"
Output: 1
Example 2:

Input: "((("
Output: 3
Example 3:

Input: "()"
Output: 0
Example 4:

Input: "()))(("
Output: 4


Note:

S.length <= 1000
S only consists of '(' and ')' characters.
 *         
 *         题目含义：
 *              判定需要添加多少个括号
 *         思路：
 *              设置一个栈，
 *                  如果 出现（ -> 进栈
 *                  如果 出现 ）->  如果栈不空 出栈
 *                                  否则 计数器++
 *
 *
 * 
 */
public class Solution {


    public int minAddToMakeValid(String str) {
        int num = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if ('(' == ch) {
                stack.push(ch);
            } else if (')' == ch) {
                if (stack.isEmpty()) {
                    num++;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            num += stack.size();
        }
        return num;
    }




    public static void main(String[] args) {
		Solution solution = new Solution();
//        String str = "()))((";
        String str = "(((";
        int num = solution.minAddToMakeValid(str);
        System.out.println(num);
    }
}
