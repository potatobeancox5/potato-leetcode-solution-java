package com.potato.study.leetcode.p0172;

/**
 * 
 * @author liuzhao11
 * 
 *    172. Factorial Trailing Zeroes
 *         
 *          
 *   Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.



 *         思路： 
 *         求 n！ 中有多少个0 要求 对数时间复杂度
 *         n 中有几个5 m = n /5 
 *         这几个5中有介个25  m / 5 一次类推 知道m = 0
 *         
 *        
 */
public class Solution {
	
	public int trailingZeroes(int n) {
		int count = 0;
		while(n >=5 ) {
			n = n / 5;
			count += n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 10;
		int num = solution.trailingZeroes(n);
		System.out.println(num);
	}
}
