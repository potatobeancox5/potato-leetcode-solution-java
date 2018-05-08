package com.potato.study.leetcode.p0476;

/**
 * 
 * @author liuzhao11
 * 
 *         476. Number Complement
 * 
 *        Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * 
 *         思路：  计算这个数字的反码 去掉先导0 然后用 int 数表示
 *         
 * 
 */
public class Solution {
	
	public int findComplement(int num) {
        // 找到这个数 最接近的2的power数 n 
		long n = 1;
		while(n <= num) {
			n = n << 1;
		}
		// 然后对这个数取反码
		int temp = ~ num;
		// 反码与 （n -1 ） 做 & 运算 
		return (int)(temp & (n - 1));
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int num = 2147483647;
		int result = solution.findComplement(num);
		System.out.println(result);
	}
}
