package com.potato.study.leetcode.p0704;

/**
 * 
 * @author liuzhao11
 * 
 * 	704. Binary Search
 *  
 *         Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].
 *         
 *         题目解释：
 *
 *
 *         
 *
 *
 * 
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid  = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {-1,0,3,5,9,12};
//        int target = 9;

//        int[] nums = {2};
        int target = 2;

		int index = solution.search(nums, target);
        System.out.println(index);
    }
}
