package com.potato.study.leetcode.p1433;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1433. Check If a String Can Break Another String
 *  
 *
Given two strings: s1 and s2 with the same size, check if some permutation of string s1 can break some permutation of string s2 or vice-versa (in other words s2 can break s1).

A string x can break string y (both of size n) if x[i] >= y[i] (in alphabetical order) for all i between 0 and n-1.



Example 1:

Input: s1 = "abc", s2 = "xya"
Output: true
Explanation: "ayx" is a permutation of s2="xya" which can break to string "abc" which is a permutation of s1="abc".
Example 2:

Input: s1 = "abe", s2 = "acd"
Output: false
Explanation: All permutations for s1="abe" are: "abe", "aeb", "bae", "bea", "eab" and "eba" and all permutation for s2="acd" are: "acd", "adc", "cad", "cda", "dac" and "dca". However, there is not any permutation from s1 which can break some permutation from s2 and vice-versa.
Example 3:

Input: s1 = "leetcodee", s2 = "interview"
Output: true


Constraints:

s1.length == n
s2.length == n
1 <= n <= 10^5
All strings consist of lowercase English letters.
 *         
 *
 *
 *
 * 思路：
 *      是否存在一组排列 使得 a 全部位置大于 b  或者 b的全部位置大于 a
 *
 *      分别对
 *      https://leetcode-cn.com/problems/check-if-a-string-can-break-another-string/solution/pai-xu-bi-jiao-da-xiao-by-feng-qi-feng-luo/
 *
 *
 *
 */
public class Solution {


    public boolean checkIfCanBreak(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        int count = 0;
        while (count < s1.length() && ch1[count] >= ch2[count] ) {
            count++;
        }
        if (count == s1.length()) {
            return true;
        }

        count = 0;
        while (count < s2.length() && ch2[count] >= ch1[count] ) {
            count++;
        }
        if (count == s2.length()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "abc";
        String s2 = "xya";
        boolean res = solution.checkIfCanBreak(s1, s2);
        System.out.println(res);
        Assert.assertEquals(true, res);

    }
}
