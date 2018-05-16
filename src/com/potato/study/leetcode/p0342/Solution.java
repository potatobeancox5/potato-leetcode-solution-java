package com.potato.study.leetcode.p0342;

/**
 * 
 * @author liuzhao11
 * 
 *         342. Power of Four
 * 
 *         Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Credits:
Special thanks to @yukuairoy for adding this problem and creating all test cases.
 * 
 *         思路： 不能像之前3 的倍数样了 因为 如果是 8的话也能被最大的int4 power 除开
 *         判断是不是2的倍数num & （num - 1） == 0 是2的power 因为 2的power只有最高位是1 其他是0
 *       
 *         https://www.cnblogs.com/grandyang/p/5403783.html
 *        
 * 
 */
public class Solution {
	
	public boolean isPowerOfFour(int num) {
		// 判断是不是 2的倍数
		if((num & (num - 1)) == 0){
			// 判断是不是 4倍数的bit位是不是1
			int tmp = 0x55555555;
			if((num & tmp) != 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int num = 32;
		boolean result = solution.isPowerOfFour(num);
		System.out.println(result);
	}
}
