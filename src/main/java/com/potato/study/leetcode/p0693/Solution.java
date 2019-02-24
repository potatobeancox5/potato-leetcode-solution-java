package com.potato.study.leetcode.p0693;

/**
 * 
 * @author liuzhao11
 * 
 * 	693. Binary Number with Alternating Bits
 *  
 *        Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
Example 2:
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
Example 3:
Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.
Example 4:
Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.*
 *         题目解释：
 *          直接进行无符号右移位 每次两位 判断出来的数是不是 0 1 相间隔
 *         思路：
 *          直接进行无符号右移位 每次两位 判断出来的数是不是 0 1 相间隔
 *         
 *
 *
 * 
 */
public class Solution {

    public boolean hasAlternatingBits(int n) {
        int tmp = n;
        while (tmp > 0) {
            int bit1 = tmp & 1;
            tmp = tmp >>> 1;
            if (tmp == 0) {
                return true;
            }
            int bit2 = tmp & 1;
            if ((bit1 ^ bit2) == 1) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();
//        boolean b = solution.hasAlternatingBits(5);
//        boolean b = solution.hasAlternatingBits(7);
//        boolean b = solution.hasAlternatingBits(11);
        boolean b = solution.hasAlternatingBits(10);
        System.out.println(b);
    }
}
