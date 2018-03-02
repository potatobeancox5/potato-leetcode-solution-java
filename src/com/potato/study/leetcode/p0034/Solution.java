package com.potato.study.leetcode.p0034;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 34. Search for a Range
 * 
 * 
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

 *         思路：
 *         给定一个数组 和一个target 在数组中查找这个target开始的位置和结束的位置
 *         二分法进行查找
 *         left = 0 right = len -1
 *         mid = （left + right） / 2
 *         nums[mid] <= taget left = mid 
 *         nums[mid] > target right = mid - 1;  
 *         
 * 
 */
public class Solution {

	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return new int[] {-1,-1};
		}
		int left = findLeftRange(nums, target);
		int right = findLeftRange(nums, target + 1);
		
		
		if(nums[left] == target && nums[right] == target) {
			return new int[] {left,right};
		} else if (nums[left] == target && nums[right] > target) {
			return new int[] {left,right - 1};			
		}else {
			return new int[] {-1,-1};
		}
    }
	
	//target <= nums[mid] 可能在左边
	//target > nums[mid] 一定在右边
	private int findLeftRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = (left + right) / 2;
			if(target <= nums[mid]) {
				right = mid;
			} else { // target > nums[mid]
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] result = solution.searchRange(nums, target);
		System.out.println(Arrays.toString(result));

	}
}
