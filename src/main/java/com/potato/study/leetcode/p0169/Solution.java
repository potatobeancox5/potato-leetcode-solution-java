package com.potato.study.leetcode.p0169;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *     169. Majority Element
 *         
 *          
 *   Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

 *         思路：
 *        某个数出现次数多于 n / 2 那么对数组进行排序后 中间的那个值一定是多数的那个数
 */
public class Solution {
	
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {3,2,3};
//		int[] nums = {2,2,1,1,1,2,2};
		int[] nums = {2};
		int element = solution.majorityElement(nums);
		System.out.println(element);
		
	}
}
