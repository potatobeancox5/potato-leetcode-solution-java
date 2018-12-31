package com.potato.study.leetcode.p0357;

/**
 * 
 * @author liuzhao11
 * 
 *        357. Count Numbers with Unique Digits
 * 
 *     Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

Credits:
Special thanks to @memoryless for adding this problem and creating all test cases.      
 *         
 *         思路：给定数字中 去掉重复的数字 一共有多少个数字
 *         注意 这里边n = 3 计算范围在 100 - 999 
 *        	正向思维 按照位置选取数字 比较好想到也不容易出错 注意 1000 包含 三位数 两位数 一位数 和 0 
 *        https://www.cnblogs.com/godlei/p/5581947.html
 *        
 */
public class Solution {
	
	public int countNumbersWithUniqueDigits(int n) {
		if(n > 9) {
			return 0;
		}
		if(n == 0) {
			return 1; 
		}
		// 每一个位置的数组都不一样
		long total = 0;
		//控制几位数
		for(int j = 1 ; j <= n ; j++) {			
			long kinds = 9; // 首位只能是1 - 9
			for(int i = 0 ; i < j - 1 ; i++) {
				kinds *= (9 - i);
			}
			total += kinds;
		}
		return (int) total + 1;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int num = solution.countNumbersWithUniqueDigits(1);
		System.out.println(num);
	}
}
