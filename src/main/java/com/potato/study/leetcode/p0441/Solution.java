package com.potato.study.leetcode.p0441;

/**
 * 
 * @author liuzhao11
 * 
 *   441. Arranging Coins
 * 
 *    You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
 * 			
 *     思路：	
 *     
 * 			
 * 	
 */	
public class Solution {
	
	public int arrangeCoins(int n) {
		long parm = (long)Math.sqrt(n);
		while(parm * (parm + 1) / 2 <= n) {
			parm++;
		}
		return (int)parm - 1;
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 2147483647;
		int line = solution.arrangeCoins(n);
		System.out.println(line);
	}
}
