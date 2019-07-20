package com.potato.study.leetcode.p0643;

/**
 * 
 * @author liuzhao11
 * 
 *         643. Maximum Average Subarray I
 * 
 *         Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75


Note:

1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
 * 
 *         思路：
 *
 */
public class Solution {

	public double findMaxAverage(int[] nums, int k) {
		int max = Integer.MIN_VALUE;
		if (null == nums || nums.length == 0 || k == 0) {
			return 0;
		}
		int sumK = 0;
		for (int i = 0; i < nums.length; i++) {
			// 前4个计算
			if (i < k) {
				sumK += nums[i];
				if (i == k - 1) {
					max = sumK;
				}
				continue;
			}
			// 后面每算一次 比较一次
			sumK += nums[i];
			sumK -= nums[i - k];
			if (sumK > max) {
				max = sumK;
			}
		}
		return max * 1.0d / k ;
	}

	
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		double count = solution.findMaxAverage(nums, k);
		System.out.println(count);
	}
}
