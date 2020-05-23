package com.potato.study.leetcode.p0906;

import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 * 	906. Super Palindromes
 *  
 *       Let's say a positive integer is a superpalindrome if it is a palindrome, and it is also the square of a palindrome.

Now, given two positive integers L and R (represented as strings), return the number of superpalindromes in the inclusive range [L, R].



Example 1:

Input: L = "4", R = "1000"
Output: 4
Explanation: 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.


Note:

1 <= len(L) <= 18
1 <= len(R) <= 18
L and R are strings representing integers in the range [1, 10^18).
int(L) <= int(R)
 *         
 *         题目含义：
 *
 *
 *
 */
public class Solution {

    /**
     *
     * @param sL
     * @param sR
     * @return
     */
    public int superpalindromesInRange(String sL, String sR) {
        long left = Long.valueOf(sL);
        long right = Long.valueOf(sR);
        int magic = 100000;
        int ans = 0;

        // count odd length;
        for (int k = 1; k < magic; ++k) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 2; i >= 0; --i) {
                sb.append(sb.charAt(i));
            }
            long v = Long.valueOf(sb.toString());
            v *= v;
            if (v > right) {
                break;
            }
            if (v >= left && isPalindrome(v)) {
                ans++;
            }
        }
        // count even length;
        for (int k = 1; k < magic; ++k) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 1; i >= 0; --i) {
                sb.append(sb.charAt(i));
            }
            long v = Long.valueOf(sb.toString());
            v *= v;
            if (v > right) {
                break;
            }
            if (v >= left && isPalindrome(v)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 判断 是否是回文数
     * @param x
     * @return
     */
    private boolean isPalindrome(long x) {
        return x == reverse(x);
    }

    /**
     * 反转数字
     * @param x
     * @return
     */
    private long reverse(long x) {
        long ans = 0;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        return ans;
    }



    public static void main(String[] args) {
		Solution solution = new Solution();
        String l = "4";
        String r = "1000";
        int result = solution.superpalindromesInRange(l, r);
        System.out.println(result);
        Assert.assertEquals(4, result);
    }
}
