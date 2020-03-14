package com.potato.study.leetcode.p1374;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1374. Generate a String With Characters That Have Odd Counts
 *  
 *
Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.

The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.



Example 1:

Input: n = 4
Output: "pppz"
Explanation: "pppz" is a valid string since the character 'p' occurs three times and the character 'z' occurs once. Note that there are many other valid strings such as "ohhh" and "love".
Example 2:

Input: n = 2
Output: "xy"
Explanation: "xy" is a valid string since the characters 'x' and 'y' occur once. Note that there are many other valid strings such as "ag" and "ur".
Example 3:

Input: n = 7
Output: "holasss"


Constraints:

1 <= n <= 500
 *         
 *         思路：
 *
 *
 *

 *
 */
public class Solution {



    public String generateTheString(int n) {

        int index = 0;

        StringBuilder builder = new StringBuilder();

        while (n != 0) {
            if (n % 2 == 1) {
                char[] ch = new char[n];
                Arrays.fill(ch, (char)('a' + index));
                builder.append(new String(ch));
                return builder.toString();
            }
            int tmp = n / 2;
            if (tmp % 2 == 0) {
                tmp += 1;
            }
            n -= tmp;
            char[] ch = new char[tmp];
            Arrays.fill(ch, (char)('a' + index));
            index++;
            builder.append(ch);
        }
        return builder.toString();
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        String string = solution.generateTheString(n);
        System.out.println(string);

        n = 2;
        string = solution.generateTheString(n);
        System.out.println(string);

        n = 7;
        string = solution.generateTheString(n);
        System.out.println(string);
    }
}
