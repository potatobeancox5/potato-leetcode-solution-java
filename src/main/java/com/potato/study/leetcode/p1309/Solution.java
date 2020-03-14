package com.potato.study.leetcode.p1309;


import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 * 	1309. Decrypt String from Alphabet to Integer Mapping
 *  
 *
Given a string s formed by digits ('0' - '9') and '#' .
We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

It's guaranteed that a unique mapping will always exist.



Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
Example 2:

Input: s = "1326#"
Output: "acz"
Example 3:

Input: s = "25#"
Output: "y"
Example 4:

Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
Output: "abcdefghijklmnopqrstuvwxyz"


Constraints:

1 <= s.length <= 1000
s[i] only contains digits letters ('0'-'9') and '#' letter.
s will be valid string such that mapping is always possible.
 *         
 *         思路：
 *          按照 # 分割 两位数 判断 10 - 26 是 字母 否则 分割开
 *
 *
 *
 *

 *
 */
public class Solution {

    public String freqAlphabets(String s) {
        // 遍历 判断第三个字符
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (i + 2 < s.length() && s.charAt(i+2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));
                char ch = (char) ('a' + num - 1);
                builder.append(ch);
                i += 3;
            } else {
                builder.append((char)(s.charAt(i) - '0' - 1 + 'a'));
                i++;
            }
        }
        return builder.toString();
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "10#11#12";
        String str = solution.freqAlphabets(s);
        System.out.println(str);
        Assert.assertEquals("jkab", str);

        s = "1326#";
        str = solution.freqAlphabets(s);
        System.out.println(str);
        Assert.assertEquals("acz", str);

        s = "25#";
        str = solution.freqAlphabets(s);
        System.out.println(str);
        Assert.assertEquals("y", str);

        s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        str = solution.freqAlphabets(s);
        System.out.println(str);
        Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", str);
    }
}
