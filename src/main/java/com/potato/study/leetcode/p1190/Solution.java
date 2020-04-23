package com.potato.study.leetcode.p1190;


import org.junit.Assert;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	1190. Reverse Substrings Between Each Pair of Parentheses
 *  
 *
You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.



Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"


Constraints:

0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/solution/chong-dong-fa-yi-ge-zhi-zhen-de-qi-huan-piao-liu-b/
 *
 *
 *
 *
 *
 *

 *
 */
public class Solution {

    public String reverseParentheses(String s) {
        // 栈存储 （ 位置 遇到 ） 翻转内部的字符串
        char[] charArray = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            } else if (charArray[i] == ')') {
                Integer left = stack.pop();
                reverse(charArray, left + 1, i-1);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char ch : charArray) {
            if (ch != '(' && ch != ')') {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    /**
     * 翻转 i- j 元素
     * @param charArray
     * @param i
     * @param j
     */
    private void reverse(char[] charArray, int i, int j) {
        while (i < j) {
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(abcd)";
        String res = solution.reverseParentheses(s);
        System.out.println(res);
        Assert.assertEquals("dcba", res);
    }
}
