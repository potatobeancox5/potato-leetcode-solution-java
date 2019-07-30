package com.potato.study.leetcode.p0233;

/**
 * 
 * @author liuzhao11
 * 
 *      233. Number of Digit One
 * 
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example:

Input: 13
Output: 6
Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * 
 * 思路： 有公式
    https://blog.csdn.net/xudli/article/details/46798619
入参n
公式 for m= 1  m《= n   m *= 10

a = n/ m
b = n % m
times =times +（ a +8）/10 * m
if a % 10 == 1
times += b + 1
 * 		
 *  
 */
public class Solution {
    public int countDigitOne(int n) {
        long times = 0;
        for (long m = 1; m <= n ; m *= 10) {
            long a = n / m;
            long b = n % m;
            times += ((a + 8) /10 * m);
            if (a % 10 == 1) {
                times += (b + 1);
            }
        }
        return (int)times;
    }
}
