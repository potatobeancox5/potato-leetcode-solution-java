package com.potato.study.leetcode.p0828;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	828. Count Unique Characters of All Substrings of a Given String
 *  
 *         Let's define a function countUniqueChars(s) that returns the number of unique characters on s, for example if s = "LEETCODE" then "L", "T","C","O","D" are the unique characters since they appear only once in s, therefore countUniqueChars(s) = 5.

On this problem given a string s we need to return the sum of countUniqueChars(t) where t is a substring of s. Notice that some substrings can be repeated so on this case you have to count the repeated ones too.

Since the answer can be very large, return the answer modulo 10 ^ 9 + 7.



Example 1:

Input: s = "ABC"
Output: 10
Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
Evey substring is composed with only unique letters.
Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
Example 2:

Input: s = "ABA"
Output: 8
Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
Example 3:

Input: s = "LEETCODE"
Output: 92


Constraints:

0 <= s.length <= 10^4
s contain upper-case English letters only.
 *         
 *         思路：
 *
https://www.cnblogs.com/grandyang/p/11616485.html
 解法2
 *
 * 
 */
public class Solution {

    public int uniqueLetterString(String s) {
        int mod = 1000000000 + 7;
        int[] first = new int[26];
        int[] second = new int[26];
        int cur = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            cur = cur + i + 1 - first[c] * 2 + second[c];
            res = (res + cur) % mod;
            second[c] = first[c];
            first[c] = i + 1;
        }

        return res;
    }



	public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "ABC";
        int res = solution.uniqueLetterString(s);
        System.out.println(res);
        Assert.assertEquals(10, res);


        s = "ABA";
        res = solution.uniqueLetterString(s);
        System.out.println(res);
        Assert.assertEquals(8, res);


        s = "ABA";
        res = solution.uniqueLetterString(s);
        System.out.println(res);
        Assert.assertEquals(8, res);
    }
}
