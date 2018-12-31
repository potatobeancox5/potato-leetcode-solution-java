package com.potato.study.leetcode.p0189;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *    189. Rotate Array
 *         
 *          
 *   Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?



 *         思路： 
 *          旋转数组 从第n个位置开始旋转
 *
 *         
 *        
 */
public class Solution {

    /**
     * 旋转数组
     * 先旋转  1 - 7 所有数组
     * 在旋转  0 - n
     * 再旋转  n ～
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        while(k > nums.length) {
            k -= nums.length;
        }

        rotatePart(nums, 0,nums.length - 1);
        rotatePart(nums, 0,k - 1);
        rotatePart(nums, k,nums.length - 1);

    }

    /**
     * 旋转部分数组 部分（start - end 包括start和end两个位置）
     * @param nums
     * @param start
     * @param end
     */
    private void rotatePart(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
