package com.potato.study.leetcode.p0796;

/**
 * 
 * @author liuzhao11
 * 
 * 	796. Rotate String
 *  
 *         We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
Note:

A and B will have length at most 100.
 *         
 *
 *         题目含义：
 *
 *         思路：
 *         796. Rotate String
给两个str a b
while i 《 a.len
while ai ！= b0 qie i合法
i++
分割a anzhaoi
拼接分割 与b 比较
相等 return true   不等 continue

return false
 *
 *
 * 
 */
public class Solution {

    public boolean rotateString(String a, String b) {
        if (a == null && a == b) {
            return true;
        }
        if ("".equals(a) && "".equals(b)) {
            return true;
        }

        int index = 0;
        // 找到 a中第i个字符与b中相同
        while (index < a.length()) {
            if (a.charAt(index) == b.charAt(0)) {
                String newStr = a.substring(index) + a.substring(0, index);
                if (b.equals(newStr)) {
                    return true;
                }
            }
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String a = "abcde";
//        String b = "cdeab";
        String a = "abcde";
        String b = "abced";
        boolean res = solution.rotateString(a, b);
        System.out.println(res);
    }
}
