package com.potato.study.leetcode.p0747;

/**
 * 
 * @author liuzhao11
 * 
 * 	747. Largest Number At Least Twice of Others
 *  
 *         In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Example 1:

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.


Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.


Note:

nums will have a length in the range [1, 50].
Every nums[i] will be an integer in the range [0, 99].
 * 
 */
public class Solution {

    /**
     * 暴力搜索找到最大的和次大的比较
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int largestIndex = nums[0] > nums[1] ? 0 : 1;
        int largerIndex = nums[0] > nums[1] ? 1 : 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[largestIndex]) {
                largerIndex = largestIndex;
                largestIndex = i;
            } else if (nums[largestIndex] > nums[i] && nums[i] > nums[largerIndex]) {
                largerIndex = i;
            }
        }

        if (nums[largerIndex] == 0) {
            return largestIndex;
        }

        if (nums[largestIndex] / nums[largerIndex] >= 2) {
            return largestIndex;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {3, 6, 1, 0};//1
//		int[] nums = {1, 2, 3, 4};//-1
		int[] nums = {0,0,0,1};// 3
		int totalCost = solution.dominantIndex(nums);
		System.out.println(totalCost);
	}
}
