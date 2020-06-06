package com.potato.study.leetcode.p1405;


/**
 * 
 * @author liuzhao11
 * 
 * 	1405. Longest Happy String
 *  
 *
A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.

Given three integers a, b and c, return any string s, which satisfies following conditions:

s is happy and longest possible.
s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
s will only contain 'a', 'b' and 'c' letters.
If there is no such string s return the empty string "".



Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
Example 2:

Input: a = 2, b = 2, c = 1
Output: "aabbc"
Example 3:

Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It's the only correct answer in this case.


Constraints:

0 <= a, b, c <= 100
a + b + c > 0
 *         
 *         思路：
 *
 *https://leetcode-cn.com/problems/longest-happy-string/solution/javashuang-bai-jie-fa-by-duan-zhi-zhu-ruo-su-chi/
 *
 *
 *
 */
public class Solution {

    private int[] counts;

    public String longestDiverseString(int a, int b, int c) {
        counts = new int[]{a, b, c};
        char[] res = new char[a + b + c];

        int index = 0;
        char nowchar;
        while (a != 0 || b != 0 || c != 0) {
            if (index < 2 || res[index - 1] != res[index - 2]) {
                nowchar = maxCountChar(' ');
            } else {
                nowchar = maxCountChar(res[index-1]);
            }
            //结束循环，避免出现快乐字符串（其中一个字符数量太大）
            if(counts[nowchar-'a']<=0) {
                break;
            }
            --counts[nowchar-'a'];
            res[index++] = nowchar;
        }
        return new String(res,0,index);
    }

    public char maxCountChar(char c) {
        if (c == 'a') {
            c = counts[1] > counts[2] ? 'b' : 'c';
        } else if (c == 'b') {
            c = counts[0] > counts[2] ? 'a' : 'c';
        } else if (c == 'c') {
            c = counts[0] > counts[1] ? 'a' : 'b';
        } else {
            //取a,b,c中数量最多的字符
            c = counts[0] > counts[1] ? 'a' : 'b';
            c = counts[c - 'a'] > counts[2] ? c : 'c';
        }
        return c;
    }
}
