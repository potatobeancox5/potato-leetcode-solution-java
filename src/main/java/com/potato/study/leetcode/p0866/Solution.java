package com.potato.study.leetcode.p0866;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	866. Prime Palindrome
 *  
 *         Find the smallest prime palindrome greater than or equal to N.

Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.

For example, 2,3,5,7,11 and 13 are primes.

Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.

For example, 12321 is a palindrome.



Example 1:

Input: 6
Output: 7
Example 2:

Input: 8
Output: 11
Example 3:

Input: 13
Output: 101


Note:

1 <= N <= 10^8
The answer is guaranteed to exist and be less than 2 * 10^8.
 *         
 *
 *         题目含义：
 *              给定n 找到大于等于 n的 最小数 素数 且是回文数

 *         思路：
 *          https://blog.csdn.net/xiaoqiu_cr/article/details/99707065

 *
 *
 *
 */
public class Solution {

    public int primePalindrome(int n) {

        while (true) {
            if (isPrime(n) && isPalindromeNum(n)) {
                return n;
            }
            n++;
            if (10_000_000 < n && n < 100_000_000) {
                n = 100_000_000;
            }
        }
    }

    /**
     * 判断是不是素数
     * @param num
     * @return
     */
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num) ; i++) {
            if (num / i * i == num) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断是不是回文数
     * @param num
     * @return
     */
    private boolean isPalindromeNum(int num) {
        String s = String.valueOf(num);
        int left = 0;
        int right = s.length() -1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }




	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 6;
        int targetNum = solution.primePalindrome(n);
        System.out.println(targetNum);
        Assert.assertEquals(7, targetNum);


        n = 8;
        targetNum = solution.primePalindrome(n);
        System.out.println(targetNum);
        Assert.assertEquals(11, targetNum);

        n = 13;
        targetNum = solution.primePalindrome(n);
        System.out.println(targetNum);
        Assert.assertEquals(101, targetNum);
    }
}
