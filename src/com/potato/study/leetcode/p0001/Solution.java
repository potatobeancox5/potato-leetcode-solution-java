package com.potato.study.leetcode.p0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author liuzhao11 1.Two Sum
 *
 *
 *         Given an array of integers, return indices of the two numbers such
 *         that they add up to a specific target.
 * 
 *         You may assume that each input would have exactly one solution, and
 *         you may not use the same element twice.
 * 
 *         思路： 利用HashMap集合，<value index> 遍历nums 计算 target - nums[i] 值是否在map中出现过，
 *         出现过 输出{map中值index ，和当前 i（当前值的实际index）} 没出现过 讲当前值放入map (value , index)
 * 
 */
public class Solution {

	public int[] twoSum(int[] nums, int target) {

		if (null == nums || nums.length <= 1 ) {
			return new int[0];
		}
		Map<Integer, Integer> existedMap = new HashMap<>();
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			int remind = target - nums[i];
			if (existedMap.containsKey(remind)) {
				return new int[] { existedMap.get(remind), i};
			} else {
				existedMap.put(nums[i], i);//因为只可能有一种解，所以直接覆盖index
			}
		}
		return new int[0];
	}
	
	public static void main(String[] args) {
//		int [] arr = {2, 7, 11, 15};
//		int target = 9;
		
		int [] arr = {3, 2, 3};
		int target = 6;
		Solution solution = new Solution();
		int [] result = solution.twoSum(arr, target);
		System.out.println(Arrays.toString(result));
	}
}
