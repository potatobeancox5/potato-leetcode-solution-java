package com.potato.study.leetcode.p0231;

/**
 * 
 * @author liuzhao11
 * 
 *      231. Power of Two
 * 
 * Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Example 2:

Input: 16
Output: true
Example 3:

Input: 218
Output: false * *         
 * 
 * 思路： 如果是2的power 那么只有 最高位置是1 其他位置都是0 所以做n & ( n-1) 结果为0 说明是2的power数
 *  
 */
public class Solution {
	
	public boolean isPowerOfTwo(int n) {
		if(n <= 0) {
			return false;
		}
        return (n & (n-1)) == 0;
    }
	
    public static void main(String[] args) {
		Solution solution = new Solution();
		boolean result = solution.isPowerOfTwo(127);
		System.out.println(result);
	}
}
