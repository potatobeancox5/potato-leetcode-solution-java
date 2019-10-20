package com.potato.study.leetcode.p0479;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         479. Largest Palindrome Product
 * 
 *        Find the largest palindrome made from the product of two n-digit numbers.

Since the result could be very large, you should return the largest palindrome mod 1337.



Example:

Input: 2

Output: 987

Explanation: 99 x 91 = 9009, 9009 % 1337 = 987



Note:

The range of n is [1,8].
 * 
 *         思路:
 *
 *
 *
 *
 *
 *         
 * 
 */
public class Solution {

    public int largestPalindrome(int n) {
        // 0 边界条件
        if (n == 1) {
            return 9;
        }
        if (n == 0) {
            return 0;
        }
        // 1. 根据n 生成上线值，通过这个值 构建 回文数
        int max = (int)Math.pow(10, n) - 1;
        int min = (int)Math.pow(10, n-1);
        for (int i = max; i > min; i--) {
            long palindrome = this.buildPalindromeByNum(i);
            // 2. 根据回文数，从 n 开始往下找，知道 某个数 平方都 小于回文数，可以尝试下一个回文数了
            for (int j = max; (long)j * j >= palindrome ; j--) {
                if (palindrome % j  == 0) {
                    return (int) (palindrome % 1337);
                }
            }
        }
        return  -1;
    }


    /**
     * num = 123 retuen 123321
     * @param num
     * @return
     */
    private long buildPalindromeByNum (int num) {
        StringBuilder sb = new StringBuilder("" + num);
        String res = sb.toString();
        res += sb.reverse().toString();
        return Long.parseLong(res);
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 2;
		int res = solution.largestPalindrome(n);
		System.out.println(res);
        Assert.assertEquals( "result error", 987, res);

        n = 5;
        res = solution.largestPalindrome(n);
        System.out.println(res);
        Assert.assertEquals( "result error", 677, res);


	}
}
