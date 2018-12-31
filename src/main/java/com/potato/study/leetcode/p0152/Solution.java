package com.potato.study.leetcode.p0152;

/**
 * 
 * @author liuzhao11
 * 
 *      152. Maximum Product Subarray
 *         
 *          
 *   Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *         题目需求：
 *				动态规划题目 遍历数组 每次记录当前最小值 除0外 以及最大值
 *         思路：
 *
 *
 *
 */
public class Solution {

	/**
	 * 子数列的最大或者最小product
	 * 分别记录 当前连续最大值和最小值 当前值 num
	 * maxValue 记录最大值
	 * maxTmpValue = max{num[i], num[i] * maxTmpValue, num[i] * minTmpValue}
	 * minTmpValue = min{num[i], num[i] * maxTmpValue, num[i] * minTmpValue}
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
		if(null == nums || nums.length == 0) {
			return 0;
		}
		int maxValue = nums[0];
		int maxTempValue = nums[0];
		int minTempValue = nums[0];
		for (int i = 1; i < nums.length ; i++) {
			int temp = maxTempValue;
			maxTempValue = max(nums[i], nums[i] * maxTempValue, nums[i] * minTempValue);
			minTempValue = min(nums[i], nums[i] * temp, nums[i] * minTempValue);
			if(maxValue < maxTempValue) {
				maxValue = maxTempValue;
			}
		}
		return maxValue;
	}


	private int max(int a, int b, int c) {
		if(a > b) {
			return a > c ? a : c;
		} else {
			return b > c ? b : c;
		}
	}

	private int min(int a, int b, int c) {
		if(a < b) {
			return a < c ? a : c;
		} else {
			return b < c ? b : c;
		}
	}

	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {2,3,-2,4};
		int max = solution.maxProduct(nums);
		System.out.println("max:" + max);
	}
}
