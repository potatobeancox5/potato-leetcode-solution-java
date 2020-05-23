package com.potato.study.leetcode.p1234;


/**
 * 
 * @author liuzhao11
 * 
 * 	1234. Replace the Substring for Balanced String
 *  
 *      You are given a string containing only 4 kinds of characters 'Q', 'W', 'E' and 'R'.

A string is said to be balanced if each of its characters appears n/4 times where n is the length of the string.

Return the minimum length of the substring that can be replaced with any other string of the same length to make the original string s balanced.

Return 0 if the string is already balanced.



Example 1:

Input: s = "QWER"
Output: 0
Explanation: s is already balanced.
Example 2:

Input: s = "QQWE"
Output: 1
Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
Example 3:

Input: s = "QQQW"
Output: 2
Explanation: We can replace the first "QQ" to "ER".
Example 4:

Input: s = "QQQQ"
Output: 3
Explanation: We can replace the last 3 'Q' to make s = "QWER".


Constraints:

1 <= s.length <= 10^5
s.length is a multiple of 4
s contains only 'Q', 'W', 'E' and 'R'.
 *         
 *
 *
 *         思路：
 *          https://leetcode-cn.com/problems/replace-the-substring-for-balanced-string/solution/java-hua-dong-chuang-kou-by-im1gw0/
 *
 *
 */
public class Solution {

    public int balancedString(String s) {
        if(s == null || s.length() <= 0){
            return 0;
        }
        int len = s.length();
        int left = 0;
        int res = len;
        int[] freq = new int[26];
        for(int i = 0;i<len;i++) {
            freq[s.charAt(i)-'A']++;
        }
        for(int right = 0;right<len;right++){
            freq[s.charAt(right)-'A']--;
            while(left<len && freq['Q'-'A']<=len/4 && freq['W'-'A']<=len/4
                    && freq['E'-'A']<=len/4 && freq['R'-'A']<=len/4){
                res = Math.min(res, right - left + 1);
                freq[s.charAt(left++)-'A']++;
            }
        }
        return res;
    }
}
