package com.potato.study.leetcode.p0640;

import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 *         640. Solve the Equation
 * 
 *        Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.

If there is no solution for the equation, return "No solution".

If there are infinite solutions for the equation, return "Infinite solutions".

If there is exactly one solution for the equation, we ensure that the value of x is an integer.

Example 1:
Input: "x+5-3+x=6+x-2"
Output: "x=2"
Example 2:
Input: "x=x"
Output: "Infinite solutions"
Example 3:
Input: "2x=x"
Output: "x=0"
Example 4:
Input: "2x+3x-6x=x+2"
Output: "x=-1"
Example 5:
Input: "x=x+2"
Output: "No solution"
 * 
 *         思路：640. Solve the Equation

计算方程

给一个表达式 解方程



x+5-3+x=6+x-2

1. 按照等号分割


exp.split("(?=[-+])");

得到的是 包含 + - 的 x 字母

https://blog.csdn.net/huanghanqian/article/details/77340481
 *
 *
 *
 */
public class Solution {


    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        int[] left = evaluateEquation(split[0]);
        int[] right = evaluateEquation(split[1]);

        // 系数和常量都相等
        if (left[0] == right[0] && left[1] == right[1]) {
            return "Infinite solutions";
        } else if (left[0] == right[0]) {
            // 只有系数相等
            return "No solution";
        } else {
            // has result
            return "x=" + ((left[1] - right[1]) / (right[0] - left[0]));
        }

    }


    /**
     * 计算x表达式 0 x前面系数  1 常量
     * @param equation
     * @return
     */
    public int[] evaluateEquation(String equation) {
        // 将等式分割成 数字 符号 x的字符 判断是不是 x 或者 -x 如果包含 x 获取 数字 ，不包含 x 直接转成数字
        String[] eachToken = equation.split("(?=[-+])");
        int[] result = new int[2];
        for (String token : eachToken) {
            if ("+x".equals(token)) {
                result[0] += 1;
            } else if ("-x".equals(token)) {
                result[0] -= 1;
            } else if ("x".equals(token)) {
                result[0] += 1;
            } else if (token.contains("x")) {
                // 获取系数
                String coefficient = token.substring(0, token.indexOf("x"));
                result[0] += Integer.parseInt(coefficient);
            } else {
                // only Num
                result[1] += Integer.parseInt(token);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String equation = "x+5-3+x=6+x-2";
        String res = solution.solveEquation(equation);
        System.out.println(res);
        Assert.assertEquals("x=2", res);


    }
}
