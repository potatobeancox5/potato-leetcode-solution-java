package com.potato.study.leetcode.p0136;

/**
 * 
 * @author liuzhao11
 * 
 *         136. Single Number
 *         
 *          
 *       Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4       
 *         思路：
 *         	遍历数组 ，做异或 最后剩下的数 就是所求
 *         
 *         
 * 
 */
public class Solution {
	
	public int singleNumber(int[] nums) {
        int num = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
        	num = num ^ nums[i];
        }
        return num;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {4,1,2,1,2};
		int target = solution.singleNumber(nums);
		System.out.println(target);
	}
}
