package com.potato.study.leetcode.p0371;

/**
 * 
 * @author liuzhao11
 * 
 *       371. Sum of Two Integers
 * 
 *      Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.

Credits:
Special thanks to @fujiaozhu for adding this problem and creating all test cases.      
 *         
 *         思路：两个数相加 不能用 时+ -
 *         https://blog.csdn.net/shenzhu0127/article/details/51810349
 *         
 *         0 + 0 = 0
 *         0 + 1 = 1
 *         1 + 0 = 1
 *         1 + 1 = 0
 *        用异或摸摸你不进位加法 进位使用与运算表示，递归进行两个操作直到进位为0
 */
public class Solution {
	
	public int getSum(int a, int b) {
        if(b == 0) {
        	return a;
        }
		int base = a ^ b;
        int carry = (a & b) << 1;
        return getSum(base, carry);
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int a = 9;
		int b = 1;
		int num = solution.getSum(a, b);
		System.out.println(num);
	}
}
