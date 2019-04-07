package com.potato.study.leetcode.p0214;

/**
 * 
 * @author liuzhao11
 * 
 *         214. Shortest Palindrome
 * 
 * 			You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

    题目类型：
    题目需求：

    思路：
        https://blog.csdn.net/qq508618087/article/details/51641392
        转换问题 求 串的前缀回文
        https://blog.csdn.net/tingting256/article/details/50454924
        https://segmentfault.com/a/1190000008395015?utm_medium=referral&utm_source=tuicool
        将字符字符串 reverse 拼接到最后 然后使用kmp中寻找模式匹配串的方式找每个的位置 知道第n个字符


        p[20] = p[8]

        abcddcbaxx#xxabcddcba
                     abcddcbaxx#xxabcddcba

        subString 8

        abcddcba 找到自后一个字符串不匹配如何移动

 */
public class Solution {
    public String shortestPalindrome(String s) {
        String patternStr = s + "#" + new StringBuilder(s).reverse().toString();
        int[] index = new int[patternStr.length()];
        //生成模式字符串匹配
        int i = 0;
        int j = 1;
        while (j < patternStr.length()) {
            if (patternStr.charAt(i) == patternStr.charAt(j)) {
                index[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    j++;
                } else {
                    i = index[i - 1];
                }
            }
        }
        // 生成index[length - 1] 指向位置
        int subIndex = index[patternStr.length() - 1];
        StringBuilder sb = new StringBuilder(s.substring(subIndex));
        return sb.reverse() + s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.shortestPalindrome("aacecaaa");
//        String s = solution.shortestPalindrome("abcd");
        System.out.println(s);
    }
}
