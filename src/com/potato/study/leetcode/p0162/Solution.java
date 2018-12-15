package com.potato.study.leetcode.p0162;

/**
 * 
 * @author liuzhao11
 * 
 *      162. Find Peak Element
 *         
 *          
 *   A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.

 *
 *         题意:
 *         寻找任意数组的任意一个极大值点
 *
 * 			解题思路：
 * 				首先假设数列的两边都是负无穷
 * 				极大值点一般出现在
 * 				1 2 ... n ... 2 1 这种增减的情况
 * 				那么，利用二分法查找这个类型的区间
 * 					利用 mid mid + 1 进行比较
 * 					如果mid  < mid + 1那么 极限值 可能出现在右侧 mid 到末尾的某个位置
 * 					如果 mid > mid + 1 那么peak 出现在 0 - mid + 1之间
 *
 * 			https://www.jianshu.com/p/308ad7e4f824
 *
 */
public class Solution {

	public int findPeakElement(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1){
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if(nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else if (nums[mid] > nums[mid + 1]) {
				right = mid;
			}
		}
		// 选择 left right 中比较大的
		return nums[left] > nums[right] ? left : right;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,3,1};
		int peak = solution.findPeakElement(nums);
		System.out.println(peak);
	}
}
