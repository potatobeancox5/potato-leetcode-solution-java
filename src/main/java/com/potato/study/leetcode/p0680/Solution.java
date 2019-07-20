package com.potato.study.leetcode.p0680;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *         680. Valid Palindrome II
 * 
 *         Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 *
 *         思路：
 *         1、定义左、右标记，分别为left,right

2、判断如果当前最左和最右的字符相等，则继续往中间移动

3、如果最左和最右不相等，则判断如果删除最左边的字符是否对称（对应left+1），如果删除最右边字符是否对称（对应right-1）

https://blog.csdn.net/excellentlizhensbfhw/article/details/82534361
 *
 *
 *
 */
public class Solution {


    public boolean validPalindrome(String str) {
        // 判断是否是回文 如果遇到 左右不一致的情况下 删除left 或者 right 试一下
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return isPalindrome(str, left + 1, right) || isPalindrome(str, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * 判断子串是否是 回文字符串
     * @param str
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindrome(String str, int left, int right) {

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "aba"; // t
        String s = "abca"; // t
        boolean res = solution.validPalindrome(s);
        System.out.println(res);
    }

}
