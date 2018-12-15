package com.potato.study.leetcode.p0153;

/**
 * 
 * @author liuzhao11
 * 
 *      153. Find Minimum in Rotated Sorted Array
 *         
 *          
 *   Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 *
 *         题目需求：
 *			找到一个旋转数组的最小值
 *         思路：
 *			二分法查找
 *			若 当前 left + 1 = right  那么直接比较吧
 *			如果遇到 left < mid < right 说明该数组没有进行过旋转 left 位置就是最小值
 *
 *			如果  left < mid > right  在 mid 到 right 中寻找
 *
 *			如果 left > mid < right   在left 到 mid 中查找
 *
 *
 */
public class Solution {

	public int findMin(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while(right > left + 1) {
			int mid = ( right + left ) / 2;
			if (nums[mid] < nums[left]) {
				right = mid;
			} else if (nums[mid] > nums[right]) {
				left = mid;
			} else { // 旋转过的数组不可能出现这个事
				return nums[0];
			}
		}
		return nums[left] < nums[right] ? nums[left] : nums[right];
	}

	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {3,4,5,1,2};
		int index = solution.findMin(nums);
		System.out.println("min:" + index);
	}
}
