package com.potato.study.leetcode.p1328;



/**
 * 
 * @author liuzhao11
 * 
 * 	1328. Break a Palindrome
 *  
 *
Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the string becomes the lexicographically smallest possible string that isn't a palindrome.

After doing so, return the final string.  If there is no way to do so, return the empty string.



Example 1:

Input: palindrome = "abccba"
Output: "aaccba"
Example 2:

Input: palindrome = "a"
Output: ""


Constraints:

1 <= palindrome.length <= 1000
palindrome consists of only lowercase English letters.
 *         
 *         思路：
 *
 *
 *
 *

 *
 */
public class Solution {

    public String breakPalindrome(String palindrome) {
        int len = palindrome.length(), half = (len - 2) >> 1;
        if (len < 2) {
            return "";
        }
        char[] chArr = palindrome.toCharArray();
        for (int i = 0; i <= half; ++i)
            if (chArr[i] > 'a') {
                chArr[i] = 'a';
                return String.valueOf(chArr);
            }
        chArr[len - 1] = 'b';
        return String.valueOf(chArr);
    }
}
