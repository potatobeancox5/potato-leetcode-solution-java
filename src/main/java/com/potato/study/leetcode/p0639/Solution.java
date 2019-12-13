package com.potato.study.leetcode.p0639;

import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 *         639. Decode Ways II
 * 
 *        A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
The length of the input string will fit in range [1, 105].
The input string will only contain the character '*' and digits '0' - '9'.
 * 
 *         思路：
 *         给出一个字符串 * 可以代表 0 -9 问有多少种解码的方式
 *
 *
 *         https://www.cnblogs.com/lightwindy/p/9552028.html
 *
 *         for i 2 - len
 *
 *          // 当前字母 这是一个字符
 *          当前i 时 *
 *              dp i = 9 * dp i-1
 *          当前i 不是 *
 *              dp i += dp i-1
 *
 *
 */
public class Solution {

    public int numDecodings(String s) {
        char[] charArray = s.toCharArray();
        // dp 代表有多少中解码的可能
        long[] dp = new long[charArray.length + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[1] = (s.charAt(0) == '*' ? 9 : 1);

        long mod = 1000000007;

        for (int i = 2; i <= charArray.length; i++) {
            char first = charArray[i-2];
            char second = charArray[i-1];

            if (second == '*') {
                dp[i] += 9 * dp[i-1];
            } else if (second > '0'){
                dp[i] += dp[i-1];
            }

            if (first == '*') {
                if (second == '*') {
                    dp[i] += 15 * dp[i-2];
                } else if (second <= '6') {
                    dp[i] += 2 * dp[i-2];
                } else {
                    dp[i] += dp[i-2];
                }
            } else if (first == '1' || first == '2') {
                if(second == '*'){
                    if(first == '1'){
                        dp[i] += 9 * dp[i-2];
                    }else{
                        // first == '2'
                        dp[i] += 6 * dp[i-2];
                    }
                }else if(((first-'0')*10 + (second-'0')) <= 26 ){
                    dp[i] += dp[i-2];
                }
            }
            dp[i] %= mod;
        }
        return (int)dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "*";
        int res = solution.numDecodings(s);
        System.out.println(res);
        Assert.assertEquals(9, res);


        s = "1*";
        res = solution.numDecodings(s);
        System.out.println(res);
        Assert.assertEquals(18, res);
    }
}
