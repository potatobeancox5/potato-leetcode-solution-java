package com.potato.study.leetcode.p0283;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 283. Move Zeroes
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
* 		思路：// 将0 放到末尾 两个index指针 一个用来记录当前遍历到的位置 
* 		另一个记录 如果当前位置移动 移动到的位置 
* 
 */
public class Solution {
	public void moveZeroes(int[] nums) {
		int index = 0;
        for(int i = 0 ; i < nums.length ; i++) {
        	if(nums[i] != 0) { //判断是否需要移动
        		if(i == index) {
        			index++;
        			continue;
        		} else {
        			nums[index] = nums[i];
        			index++;
        		}
        	}
        }
        //最后位置 置0
        while(index < nums.length) {
        	nums[index++] = 0;
        }
    }
	
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] nums = {0,1,0,3,12};
    	solution.moveZeroes(nums);
    	System.out.println(Arrays.toString(nums));
	}
}
