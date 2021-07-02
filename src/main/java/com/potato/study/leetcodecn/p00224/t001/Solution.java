package com.potato.study.leetcodecn.p00224.t001;

import java.util.Stack;

import org.junit.Assert;

/**
 * 224. 基本计算器
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 224 只有加减 和 括号
    // 使用一个 栈记录 当前数字之前的符号 无非是加好或者减号， 利用乘法 记录 加好为 sigh = 1 否则-1
    // 用一个栈存储 还没有使用的符号
    // 遍历 s 对于每个位置 ch 有几种情况：
    //    1. ch = + 或者 ch = -，此时需要将之前的符号 ，然后更新 这个符号 此时看下括号外边是啥符号，修改就行
    //    2. 如果 是数字 那么就直接生成数字 ，利用目前外露的sign 机型计算
    //    3. if ( 当前sign 可以入栈了，然后sigh 设置成1
    //    4. 如果遇到 了 ） 说明 stack 中的字符串被用过了 直接 pop吧
    public int calculate(String s) {
        int index = 0;
        int result = 0;
        // signStack 记录绝对的路径
        Stack<Integer> signStack = new Stack<>();
        int sign = 1;
        // 初始插入一个正好 防止出现
        signStack.add(1);
        while (index < s.length()) {
            char ch = s.charAt(index);
            // 数字
            if (Character.isDigit(ch)) {
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num *= 10;
                    num += (s.charAt(index) - '0');
                    index++;
                }
                // 获取sigh 计算值
                result += (sign * num);
            } else if ('+' == ch) {
                sign = 1 * signStack.peek();
                index++;
            } else if ('-' == ch) {
                sign = -1 * signStack.peek();
                index++;
            } else if ('(' == ch) {
                // sign 为之前的符号 入栈吧
                signStack.push(sign);
                index++;
            } else if (')' == ch) {
                // 之前的num 也计算过 stack 直接出栈吧
                signStack.pop();
                index++;
            } else if (' ' == ch) {
                index++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "1+2+3";
        int result = solution.calculate(s);
        Assert.assertEquals(6, result);
        System.out.println(result);

        s = "1+2-3";
        result = solution.calculate(s);
        Assert.assertEquals(0, result);
        System.out.println(result);

        s = "1-(1-(2-3))";
        result = solution.calculate(s);
        Assert.assertEquals(-1, result);
        System.out.println(result);
    }

}
