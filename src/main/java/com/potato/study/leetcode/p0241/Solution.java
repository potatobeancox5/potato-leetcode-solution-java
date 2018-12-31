package com.potato.study.leetcode.p0241;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
     *     241. Different Ways to Add Parentheses
 * 
 *Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10



 * 题目含义：
 *  输入一个String，带符号 求向字符串中添加（）后的计算结果
 * 思路：
 *  分治法
 *  记录字串对应数组 放在全局变量中
 *  https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51535462
 *
 */
public class Solution {

    /**
     * 缓存结果的map
     */
    Map<String, List<Integer>> resultCache = new HashMap<>();


    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        // 是不是数字 结束递归
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
            return result;
        }
        // 先从缓存中取
        if (resultCache.containsKey(input)) {
            return resultCache.get(input);
        }
        for (int i = 0; i < input.length(); i++) {
            // 按照运算符进行分割
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> leftResult = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightResult = diffWaysToCompute(input.substring(i + 1));
                for (int left : leftResult) {
                    for (int right : rightResult) {
                        if (input.charAt(i) == '+') {
                            result.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            result.add(left - right);
                        } else if (input.charAt(i) == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        resultCache.put(input, result);
        return result;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	String input = "2-1-1";
    	String input = "2*3-4*5";
        List<Integer> result = solution.diffWaysToCompute(input);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
