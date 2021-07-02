package com.potato.study.leetcodecn.p00241.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 遍历 expression与之前的数字组合
     * 如果遇到 运算符合 分割 求两边计算 值
     * 遍历两边计算值 计算表达式
     *
     * 如果遍历一遍都没有 运算符 直接转成数字
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int leftNum : left) {
                    for (int rightNum : right) {
                        if (ch == '+') {
                            result.add(leftNum + rightNum);
                        } else if (ch == '-') {
                            result.add(leftNum - rightNum);
                        } else {
                            result.add(leftNum * rightNum);
                        }
                    }
                }
            }
        }
        // 判断 是不是没有生成结果
        if (result.size() == 0) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String exp = "2-1-1";
        List<Integer> list = solution.diffWaysToCompute(exp);
        // 0 2
        System.out.println(list);

        exp = "2*3-4*5";
        list = solution.diffWaysToCompute(exp);
        // [-34, -14, -10, -10, 10]
        System.out.println(list);
    }
}
