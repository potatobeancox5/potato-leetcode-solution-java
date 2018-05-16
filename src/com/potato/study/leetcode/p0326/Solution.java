package com.potato.study.leetcode.p0326;


/**
 * 
 * @author Administrator
 *
 *         326. Power of Three
 *         
 *          
 *         Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
 *         
 *         
 *         
 *         思路： 
 *         // 一致 int 最大3 的倍数 1162261467
 *         任意的3的指数 都能被这个数整除 
 *         
 *         
 */
public class Solution {
	
	public boolean isPowerOfThree(int n) {
		if(n <= 0) {
			return false;
		}
        return 1162261467L % n == 0;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 727;
		boolean result = solution.isPowerOfThree(n);
		System.out.println(result);
	}
}
