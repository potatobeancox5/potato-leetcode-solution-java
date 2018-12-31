package com.potato.study.leetcode.p0191;

/**
 * 
 * @author liuzhao11
 * 
 *         191. Number of 1 Bits
 * 
 *         Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Example 1:

Input: 11
Output: 3
Explanation: Integer 11 has binary representation 00000000000000000000000000001011 
Example 2:

Input: 128
Output: 1
Explanation: Integer 128 has binary representation 00000000000000000000000010000000

 * 
 *         思路：
 *         查找给定数字中有多少个1
 *         将n看成是无符号数
 *         times = 0；
 *         while（n ！= 0 ） 
 *          n = n & （n-1） //每进行一次次减少一个1 个bit 位置 
 *          times ++；
 *         返回times 
 *          
 *         
 * 		
 */
public class Solution {
	
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n-1);
			count++;
		}
		return count;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 128;
		int count = solution.hammingWeight(n);
		System.out.println(count);
	}
}
