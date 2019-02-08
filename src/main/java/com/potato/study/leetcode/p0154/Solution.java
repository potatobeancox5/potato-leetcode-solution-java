package com.potato.study.leetcode.p0154;

/**
 * 
 * @author liuzhao11
 * 
 *      154. Find Minimum in Rotated Sorted Array II
 *         
 *          
 *   Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
 *
 *         题目需求：
 *			找到一个旋转数组的最小值 数组中有重复的数字
 *         思路：
 *          https://blog.csdn.net/linhuanmars/article/details/40449299
 *          相等的时候 不能直接通过
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
            } else { // 相等的情况 移动一侧
                right--;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {2,2,2,0,1};
//		int[] nums = {1,3,5};
		int index = solution.findMin(nums);
		System.out.println("min:" + index);
	}
}
