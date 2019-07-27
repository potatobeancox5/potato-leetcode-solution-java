package com.potato.study.leetcode.p0224;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *      224. Basic Calculator
 * 
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 * *         
 *
 * 题目含义：
 *      (1+(4+5+2)-3)+(6+8)
 *      给定一个字符串，计算字符串的值
 * 思路：
 *     两个栈， 一个操作符号栈 一个操作数栈，计算规则如下
 *     如果是操作符号， 如果是'(' 入栈 是 + - 入栈
 *          如果是')'
 *              如果前面是'(' 直接出栈
 *              如果 前面是 + - 出栈操作数并计算
 *
 *     否则，是数字 peek 下符号栈
 *          如果是'(' 数字入栈
 *          否则 如果是运算符号 + -  出栈运算符号和操作数 计算 直到 操作符号消耗尽或者为'(' ,再操作符号入栈
 *
 *          注意多位数字兼容
 *
 *          https://www.cnblogs.com/tonyluis/p/4579092.html
 *
 */
public class Solution {

    public int calculate(String s) {

        // 记录当前符号 只push 不出
        Stack<Integer> sign = new Stack<>();
        sign.push(1);

        int lastOp = 1;

        long res = 0; // 记录当前的结果
        for (int i = 0; i < s.length(); i++) {
            char op = s.charAt(i);
            switch (op) {
                case ' ':
                    break;
                case '+' :
                    lastOp = 1;
                    break;
                case '-' :
                    lastOp = -1;
                    break;
                case '(' :
                    sign.push(sign.peek() * lastOp);
                    lastOp = 1;
                    break;
                case ')' :
                    sign.pop();
                    break;
                default: // 数字
                    long num = op - '0';
                    int j = i + 1;
                    while (j < s.length() && Character.isDigit(s.charAt(j))) {
                        num = num * 10 + s.charAt(j) - '0';
                        j++;
                        i++;
                    }
                    // 计算结果
                    res = res + num * lastOp * sign.peek();
            }
        }
        return (int)res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int res;
        String s = "(1+(4+5+2)-3)+(6+8)"; // 23
        res = solution.calculate(s);
        System.out.println("res: " + res);

        s = "1 + 1";// 2
        res = solution.calculate(s);
        System.out.println("res: " + res);

        s = "2147483647";
        res = solution.calculate(s);
        System.out.println("res: " + res);

        s = "(7)-(0)+(4)"; // 11
        res = solution.calculate(s);
        System.out.println("res: " + res);

        s = "(5-(1+(5)))"; // -1
        res = solution.calculate(s);
        System.out.println("res: " + res);


        s = "1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10"; // -1
        res = solution.calculate(s);
        System.out.println("res: " + res);
    }
}
