package com.potato.study.leetcode.p0902;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	902. Numbers At Most N Given Digit Set
 *  
 *       We have a sorted set of digits D, a non-empty subset of {'1','2','3','4','5','6','7','8','9'}.  (Note that '0' is not included.)

Now, we write numbers using these digits, using each digit as many times as we want.  For example, if D = {'1','3','5'}, we may write numbers such as '13', '551', '1351315'.

Return the number of positive integers that can be written (using the digits of D) that are less than or equal to N.



Example 1:

Input: D = ["1","3","5","7"], N = 100
Output: 20
Explanation:
The 20 numbers that can be written are:
1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
Example 2:

Input: D = ["1","4","9"], N = 1000000000
Output: 29523
Explanation:
We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
In total, this is 29523 integers that can be written using the digits of D.


Note:

D is a subset of digits '1'-'9' in sorted order.
1 <= N <= 10^9
 *         
 *         题目含义：
 *
 *         思路：
 *         https://leetcode-cn.com/problems/numbers-at-most-n-given-digit-set/solution/zui-da-wei-n-de-shu-zi-zu-he-by-leetcode/
 *         dp
 *
 *
 *
 */
public class Solution {

    public int atMostNGivenDigitSet(String[] d, int n) {
        String s = String.valueOf(n);
        int k = s.length();
        int[] dp = new int[k+1];
        dp[k] = 1;
        for (int i = k-1; i >= 0; --i) {
            // compute dp[i]
            int si = s.charAt(i) - '0';
            for (String dd : d) {
                if (Integer.valueOf(dd) < si) {
                    dp[i] += Math.pow(d.length, k-i-1);
                } else if (Integer.valueOf(dd) == si) {
                    dp[i] += dp[i+1];
                }
            }
        }

        for (int i = 1; i < k; ++i) {
            dp[0] += Math.pow(d.length, i);
        }
        return dp[0];
    }




    public static void main(String[] args) {
		Solution solution = new Solution();
        String[] d = new String[]{"1","3","5","7"};
        int n = 100;
        int result = solution.atMostNGivenDigitSet(d, n);
        System.out.println(result);
        Assert.assertEquals(20, result);
    }
}
