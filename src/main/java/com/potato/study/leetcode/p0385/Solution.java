package com.potato.study.leetcode.p0385;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *       385. Mini Parser
 * 
 *      Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
i.  An integer containing value 456.
ii. A nested list with one element:
a. An integer containing value 789.
 *         
 *         思路：
 *         https://www.jianshu.com/p/7f4f91da8829
 *
 *
 *
 *
 */



public class Solution {

    // 解析 s 反序列化成 NestedInteger s 要么是一个数字 要么是一个list
    public NestedInteger deserialize(String s) {
        if ("".equals(s)) {
            return new NestedInteger();
        }
        if (!s.contains("[")) {
            int value = Integer.parseInt(s);
            return new NestedInteger(value);
        }
        if (s.length() <= 2) {
            return new NestedInteger();
        }
        // 记录每个数字字符串
        StringBuilder numStr = new StringBuilder();
        // 记录上一个 NestedInteger
        Stack<NestedInteger> stack = new Stack<>();
        // 1 遍历 string 如果当前是 数字 sb.app 如果当前是 [ 创建 NestedInteger  如果当前是] 如果当前是， 将
        NestedInteger currentNestedInteger = null;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                // 记录上一层的传，并申请新的船
                if (currentNestedInteger != null) {
                    stack.push(currentNestedInteger);
                }
                currentNestedInteger = new NestedInteger();
            } else if (ch == ']') {
                // 本层结束 设置本层的值，并设置到上一层的list中
                if (numStr.length() > 0) {
                    currentNestedInteger.add(new NestedInteger(Integer.parseInt(numStr.toString())));
                    numStr = new StringBuilder();
                }
                if (!stack.isEmpty()) {
                    NestedInteger upLayer = stack.pop();
                    upLayer.add(currentNestedInteger);
                    currentNestedInteger = upLayer;
                }
            } else if (ch == ',') {
                if (s.charAt(i - 1) != ']') {
                    currentNestedInteger.add(new NestedInteger(Integer.valueOf(numStr.toString())));
                    numStr = new StringBuilder();
                }
            } else {
                numStr.append(ch);
            }
        }
        return currentNestedInteger;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "[123,456,[788,799,833],[[]],10,[]]";
        String s = "[-1]";
        NestedInteger deserialize = solution.deserialize(s);
        System.out.println(deserialize);
    }
}
