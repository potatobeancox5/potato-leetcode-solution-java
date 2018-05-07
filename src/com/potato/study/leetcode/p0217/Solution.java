package com.potato.study.leetcode.p0217;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *      217. Contains Duplicate
 * 
 * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true			
 * *         
 * 思路：  使用set
 */
public class Solution {
	
	public boolean containsDuplicate(int[] nums) {
		if(nums == null) {
			return false;
		}
		Set <Integer> set = new HashSet<>();
		for(int num : nums) {
			if(set.contains(num)) {
				return true;
			} else {
				set.add(num);
			}
		}
		return false;
	}
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,3};
		boolean result = solution.containsDuplicate(nums);
		System.out.println(result);
	}
}
