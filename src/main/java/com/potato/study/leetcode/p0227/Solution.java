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

https://www.jianshu.com/p/24a172a74e9f
 先计算 * ／  最终求和
 *  
 */
public class Solution {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        s = s.replace(" ", "");
        char op = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            // 解析数字
            if (Character.isDigit(ch)) { // 找到数字
                num = ch - '0';
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                    i++;
                }
            }

            if (!Character.isDigit(ch) || i == s.length() - 1) {
                if (op == '+') {
                     stack.push(num);
                } else if (op == '-') {
                    stack.push(-1 * num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                // 归零
                op = ch;
                num = 0;
            }
        }
        if (stack.isEmpty()) {
            return 0;
        }
        int res = 0;
        for (int ss : stack) {
            res += ss;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3+2*2";// 7
        int calculate = solution.calculate(s);
        System.out.println(calculate);//7
        s = "3/2";
        calculate = solution.calculate(s);
        System.out.println(calculate);//1
        s = "3+5 / 2";
        calculate = solution.calculate(s);
        System.out.println(calculate);//5
        s = "1*2-3/4+5*6-7*8+9/10";
        calculate = solution.calculate(s);
        System.out.println(calculate);// -24
        s = " 3/2 ";
        calculate = solution.calculate(s);
        System.out.println(calculate);//1

    }

}
