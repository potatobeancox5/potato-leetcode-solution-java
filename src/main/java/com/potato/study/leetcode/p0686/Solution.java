package com.potato.study.leetcode.p0686;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *         686. Repeated String Match
 * 
 *         Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
 *
 *         思路：
 *          https://www.cnblogs.com/king-3/archive/2018/06/15/9188140.html
 *
 *
 *
 */
public class Solution {


    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        String newA = "";
        while (newA.length() < b.length()) {
            newA += a;
            count++;
        }
        if (newA.contains(b)) {
            return count;
        } else {
            newA += a;
        }

        if (newA.contains(b)) {
            return count + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "abcd";
        String b = "cdabcdab";
        int times = solution.repeatedStringMatch(a, b);
        System.out.println(times);
    }

}
