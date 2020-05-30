package com.potato.study.leetcode.p1392;


/**
 * 
 * @author liuzhao11
 * 
 * 	1392. Longest Happy Prefix
 *  
 *
A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

Given a string s. Return the longest happy prefix of s .

Return an empty string if no such prefix exists.



Example 1:

Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
Example 2:

Input: s = "ababab"
Output: "abab"
Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
Example 3:

Input: s = "leetcodeleet"
Output: "leet"
Example 4:

Input: s = "a"
Output: ""


Constraints:

1 <= s.length <= 10^5
s contains only lowercase English letters.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/longest-happy-prefix/solution/java-deng-jie-yu-qiu-kmp-de-next-shu-zu-by-aerysn/
 *
 *
 */
public class Solution {


    public String longestPrefix(String s) {
        int[] next = getNext(s);
        int n = next[s.length()];
        return s.substring(0, n);
    }

    private int[] getNext(String s) {
        int[] next = new int[s.length() + 1];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < s.length()) {
            // 已有 [0, ..., j - 1] 与 [i - j, ..., i - 1] 匹配, 同时 s[j] == s[i]
            if (j == -1 || s.charAt(j) == s.charAt(i)) {
                next[++i] = ++j;
                // 匹配长度增加 1, 查看下一个匹配位置
            }
            else {
                // 不匹配, 说明当前查看的前缀太长, 将 j 跳回到上一个可能的匹配位置
                j = next[j];
            }
        }
        return next;
    }
}
