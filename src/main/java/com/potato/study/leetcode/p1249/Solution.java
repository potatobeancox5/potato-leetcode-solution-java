package com.potato.study.leetcode.p1249;


import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 * 	1249. Minimum Remove to Make Valid Parentheses
 *  
 *      Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"


Constraints:

1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
 *         
 *
 *
 *         思路：
 *         移除无效的括号
 *         https://www.cnblogs.com/Dylan-Java-NYC/p/11980982.html
 *

 *
 */
public class Solution {

    public String minRemoveToMakeValid(String s) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        // 从左往右 左括号 ++  遇到右括号时 如果此时没有左括号 那么这个右括号删掉 ，
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                count++;
                builder.append(s.charAt(i));
            } else if (')' == s.charAt(i)) {
                if (count == 0) {
                    continue;
                }
                builder.append(s.charAt(i));
                count--;
            } else {
                builder.append(s.charAt(i));
            }
        }
        // 从右往左再来一遍
        s = builder.toString();
        builder = new StringBuilder();
        count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (')' == s.charAt(i)) {
                count++;
                builder.append(s.charAt(i));
            } else if ('(' == s.charAt(i)) {
                if (count == 0) {
                    continue;
                }
                builder.append(s.charAt(i));
                count--;
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.reverse().toString();
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "lee(t(c)o)de)";
        String valid = solution.minRemoveToMakeValid(s);
        System.out.println(valid);
        Assert.assertEquals("lee(t(c)o)de", valid);


        s = "a)b(c)d";
        valid = solution.minRemoveToMakeValid(s);
        System.out.println(valid);
        Assert.assertEquals("ab(c)d", valid);

        s = "))((";
        valid = solution.minRemoveToMakeValid(s);
        System.out.println(valid);
        Assert.assertEquals("", valid);

        s = "(a(b(c)d)";
        valid = solution.minRemoveToMakeValid(s);
        System.out.println(valid);
        Assert.assertEquals("a(b(c)d)", valid);
    }
}
