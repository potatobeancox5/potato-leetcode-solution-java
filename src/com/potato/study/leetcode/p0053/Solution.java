package com.potato.study.leetcode.p0053;

/**
 * 
 * @author liuzhao11
 * 
 *         53. Maximum Subarray
 * 
 *         Find the contiguous subarray within an array (containing at least one
 *         number) which has the largest sum.
 * 
 *         For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous
 *         subarray [4,-1,2,1] has the largest sum = 6.
 * 
 *         click to show more practice.
 * 
 *         More practice: If you have figured out the O(n) solution, try coding
 *         another solution using the divide and conquer approach, which is more
 *         subtle.
 * 
 * 
 *         思路： 动态规划 计sub[i] 表示 以第i个字母为开头（必须包含i）的字符串的最大连续子串的最大值 则有公式 sub[i] = max
 *         {nums[i] , nums[i] + sub[i+1]};(只有一个num[i] , 或者num[i] + 后面的串) 压缩标记量
 *         分治法：
 * 
 */
public class Solution {

	public int maxSubArray(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int maxSubValue = nums[nums.length - 1];// 用于压缩标记量
		int currentValue = maxSubValue;
		for (int i = nums.length - 2; i >= 0; i--) {
			// sub[i] = max {nums[i] , nums[i] + sub[i+1]}
			currentValue = max(nums[i], nums[i] + currentValue);
			if (maxSubValue < currentValue) {
				maxSubValue = currentValue;
			}
		}
		return maxSubValue;
	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int largestSum = solution.maxSubArray(nums);
		System.out.println(largestSum);
	}
}
