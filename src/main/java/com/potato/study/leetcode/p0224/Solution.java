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
 */
public class Solution {
    public int calculate(String s) {
        // 操作数栈和符号栈
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!isNum(ch)) {
                //如果是操作符号
                if ('(' == ch) {
                    opStack.add(ch);
                } else if ('+' == ch || '-' == ch){
                    if (!opStack.isEmpty() && (opStack.peek() == '+' || opStack.peek() == '-')) {
                        // 计算最终的表达式的值  1 - 2 + 3
                        while (!opStack.isEmpty() && numStack.size() >= 2) {
                            dealNumAndOp(opStack, numStack);
                        }
                    }
                    opStack.add(ch);
                } else if (')' == ch && opStack.peek() == '(') {
                    opStack.pop();
                } else if (')' == ch) {
                    // + - 循环出操作数并计算直到 peek 为')'
                    while (!opStack.isEmpty() && numStack.size() >= 2 && opStack.peek() != '(') {
                        dealNumAndOp(opStack, numStack);
                    }
                    opStack.pop();
                }
            } else if (isNum(ch)){ // 判断是不是多位数字
                int j = i + 1;
                StringBuilder numSb = new StringBuilder();
                numSb.append(ch);
                while (j < s.length() && isNum(s.charAt(j))) {
                    numSb.append(s.charAt(j));
                    j++;
                    i++;
                }
                int opNum = Integer.parseInt(numSb.toString());
                // 数字处理
                numStack.add(opNum);
            }
            // 按照操作符号计算当前的值
            if (!opStack.isEmpty() && (opStack.peek() == '+' || opStack.peek() == '-')) {
                // + - 循环出操作数并计算直到 peek 为')'
                while (!opStack.isEmpty() && opStack.peek() != '(' && numStack.size() > 1) {
                    dealNumAndOp(opStack, numStack);
                }
            }
        }
        // 计算最终的表达式的值  1 - 2 + 3
        while (!opStack.isEmpty()) {
            dealNumAndOp(opStack, numStack);
        }
        return numStack.pop();
    }

    private void dealNumAndOp(Stack<Character> opStack, Stack<Integer> numStack) {
        int a = numStack.pop();
        int b = numStack.pop();
        char op = opStack.pop();
        int res = this.calculateSingleOp(a, b, op);
        numStack.add(res);
    }


    private int calculateSingleOp(int a, int b, char op) {
        int res = 0;
        switch (op) {
            case '+' :
                res = a + b;
                break;
            case '-' :
                res = b - a;
                break;
        }
        return res;
    }

    private boolean isNum (char ch) {
        if ('0' <= ch && '9' >= ch) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "(1+(4+5+2)-3)+(6+8)"; // 23
//        String s = "1 + 1";
//        String s = "2147483647";
//        String s = "(7)-(0)+(4)"; // 11
//        String s = "(5-(1+(5)))"; // -1
        String s = "1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10"; // -1
        int res = solution.calculate(s);
        System.out.println("res: " + res);
    }
}
