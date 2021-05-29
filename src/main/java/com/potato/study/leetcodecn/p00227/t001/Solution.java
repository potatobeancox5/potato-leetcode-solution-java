package com.potato.study.leetcodecn.p00227.t001;

import org.junit.Assert;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

 整数除法仅保留整数部分。

  

 示例 1：

 输入：s = "3+2*2"
 输出：7
 示例 2：

 输入：s = " 3/2 "
 输出：1
 示例 3：

 输入：s = " 3+5 / 2 "
 输出：5
  

 提示：

 1 <= s.length <= 3 * 105
 s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 s 表示一个 有效表达式
 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 题目数据保证答案是一个 32-bit 整数

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 操作数栈 和 运算符 栈
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        // 干掉空格
        s = s.replace(" ", "");
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        // 遍历 s 如果当前是数字 那就 一直往后找数字 数字入栈
        int index = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                // 如果目前是 运算符，运算符根 运算符栈比较 如果优先级低，那么 pop 两个数字运算入栈，否则 运算符入栈
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num *= 10;
                    num += (s.charAt(index) - '0');
                    index++;
                }
                numStack.add(num);
            } else {
                if (!opStack.isEmpty() && compareOp(opStack.peek(), ch) <= 0) {
                    while (!opStack.isEmpty() && compareOp(opStack.peek(), ch) <= 0) {
                        Character op = opStack.pop();
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int target = compute(num2, num1, op);
                        numStack.add(target);
                    }
                }
                opStack.add(ch);
                index++;
            }
        }
        // 最后 一直出栈 计算
        while (!opStack.isEmpty()) {
            Character op = opStack.pop();
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int target = compute(num2, num1, op);
            numStack.add(target);
        }
        return numStack.peek();
    }

    /**
     * 计算
     * @param num1
     * @param num2
     * @param op
     * @return
     */
    private int compute(int num1, int num2, char op) {
        int num;
        if (op == '+') {
            num = num1 + num2;
        } else if (op == '-') {
            num = num1 - num2;
        } else if (op == '*') {
            num = num1 * num2;
        } else {
            num = num1 / num2;
        }
        return num;
    }

    /**
     * 判断两个运算符的优先级
     * @param op1
     * @param op2
     * @return -1 优先运算 op1， 1 优先运算 op2
     */
    private int compareOp(char op1, char op2) {
        if ('*' == op1 || '/' == op1) {
            return -1;
        }
        if ('*' == op2 || '/' == op2) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3+2*2";
        int num = solution.calculate(s);
        System.out.println(num);
        Assert.assertEquals(7, num);

        s = "3/2";
        num = solution.calculate(s);
        System.out.println(num);
        Assert.assertEquals(1, num);
    }

}
