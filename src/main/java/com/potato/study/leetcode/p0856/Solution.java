package com.potato.study.leetcode.p0856;

import org.junit.Assert;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	856. Score of Parentheses
 *  
 *         Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.


Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6


Note:

S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50
 *         
 *
 *         题目含义：
 *
 *         思路：
 *
 *          https://www.cnblogs.com/grandyang/p/10634116.html
 *
 *
 */
public class Solution {

    public int scoreOfParentheses(String s) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(num);
                num = 0;
            } else {
                num = stack.pop() + Math.max(num * 2, 1);
            }
        }
        return num;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "()";
        int result = solution.scoreOfParentheses(s);
        System.out.println(result);
        Assert.assertEquals(1, result);


        s = "(())";
        result = solution.scoreOfParentheses(s);
        System.out.println(result);
        Assert.assertEquals(2, result);

        s = "()()";
        result = solution.scoreOfParentheses(s);
        System.out.println(result);
        Assert.assertEquals(2, result);

        s = "(()(()))";
        result = solution.scoreOfParentheses(s);
        System.out.println(result);
        Assert.assertEquals(6, result);
    }
}
