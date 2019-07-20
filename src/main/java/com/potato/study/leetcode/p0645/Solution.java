package com.potato.study.leetcode.p0645;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         645. Set Mismatch
 * 
 *         The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.
 * 
 *         思路：
 *         遍历数组 每次将 出现的value 对应的index 变成相反数，
 *
 *         遍历数组 找出两个正数 即可
 *
 *
 */
public class Solution {

	public int[] findErrorNums(int[] nums) {

		int appearTwice = 0;

		for (int num : nums) {
			int index = Math.abs(num) - 1;
			// 出现两次
			if (nums[index] < 0) {
				appearTwice = index + 1;
			}
			nums[index] *= -1;
		}
		// 第二次遍历
		int disappear = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && (i + 1) != appearTwice) {
				disappear = i + 1;
				break;
			}
		}
		return new int[]{appearTwice, disappear};
	}

	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {1,2,2,4};
		int[] nums = {2,2};
		int[] res = solution.findErrorNums(nums);
		System.out.println(Arrays.toString(res));
	}
}
