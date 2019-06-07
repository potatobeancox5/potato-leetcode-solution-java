package com.potato.study.leetcode.p0367;

/**
 * 
 * @author liuzhao11
 * 
 *        367. Valid Perfect Square
 * 
 *     Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
 *         
 *         思路：
 *         直接计算
 *        
 */
public class Solution {

    public boolean isPerfectSquare(int num) {
        long i = 0;
        do {
            long square = i * i;
            if (square == num) {
                return true;
            }
            if (square > num) {
                return false;
            }
            i++;
        } while (true);
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean res = solution.isPerfectSquare(2147483647);
		System.out.println(res);
	}
}
