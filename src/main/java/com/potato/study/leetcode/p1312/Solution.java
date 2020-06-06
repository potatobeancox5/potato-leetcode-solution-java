package com.potato.study.leetcode.p1312;


/**
 * 
 * @author liuzhao11
 * 
 * 	1312. Minimum Insertion Steps to Make a String Palindrome
 *  
 *
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.



Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we don't need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
Example 4:

Input: s = "g"
Output: 0
Example 5:

Input: s = "no"
Output: 1


Constraints:

1 <= s.length <= 500
All characters of s are lower case English letters.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/solution/dong-tai-gui-hua-jie-zui-chang-zi-xu-lie-zi-chuan-/
 *
 *
 *

 *
 */
public class Solution {

    private char[] arr;
    private int[][] memo;  // 递归记忆化数组，避免重复计算

    private int backTrack(int from, int to) {
        if (from >= to) {
            return 0;
        }

        if (memo[from][to] != -1) {
            return memo[from][to];
        }

        // 头尾相等
        if (arr[from] == arr[to]) {
            return backTrack(from + 1, to - 1);
        }

        // 头尾不相等的最小次数是插入头字符或者插入尾字符的最小值 + 1
        memo[from][to] = Math.min(backTrack(from + 1, to) , backTrack(from, to - 1)) + 1;
        return memo[from][to];
    }

    public int minInsertions(String s) {
        arr = s.toCharArray();
        int len = arr.length;
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                memo[i][j] = -1;
            }
        }
        return backTrack(0, len - 1);
    }
}
