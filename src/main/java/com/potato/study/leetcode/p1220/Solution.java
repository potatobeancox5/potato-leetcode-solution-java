package com.potato.study.leetcode.p1220;


/**
 * 
 * @author liuzhao11
 * 
 * 	1220. Count Vowels Permutation
 *  
 *
Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.



Example 1:

Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
Example 3:

Input: n = 5
Output: 68


Constraints:

1 <= n <= 2 * 10^4
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/count-vowels-permutation/solution/java-dong-tai-gui-hua-shi-xian-by-lsz/
 *
 *

 *
 */
public class Solution {

    public int countVowelPermutation(int n) {
        if(n <= 0) {
            return 0;
        }
        long[][] dp = new long[n][5];
        //a->0  ,  e->1,  i->2,  o->3,  u->4
        for(int i = 0;i < 5;i++) {
            dp[0][i] = 1L;
        }
        int mod = (int)Math.pow(10,9) + 7;

        for(int i = 1;i < n;i++){
            //a前面可能为e,i,u
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
            //e前面可能为a,i
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            //i前面可能为e,o
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            //o前面可能为i,
            dp[i][3] = dp[i - 1][2];
            //u前面可能为i,o
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
        }

        int res = 0;
        for(int i = 0;i < 5;i++){
            res += dp[n - 1][i];
            res %= mod;
        }
        return res;
    }
}
