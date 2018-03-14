package com.potato.study.leetcode.p0045;

/**
 * 
 * @author liuzhao11
 * 
 *      45. Jump Game II
 *      
 *      Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.

 * 
 * 
 *         思路：
 *         记录当前遍历到的位置index
 *         记录index 并记录下一步所能能达到的最大位置 maxIndex 每遍历到一个新位置（没到本步达到的最大位置） 更新maxIndex（下一步能达到的最大位置）
 *         记录上一次能达到的最大位置，超出了上一步达到的最大位置 需要增加步数
 *         
 *        http://blog.csdn.net/whzyb1991/article/details/46942025
 *        
 *
 */
public class Solution {
	
	
	public int jump(int[] nums) {
		int currentStep = 0;
		int nextMaxStep = nums[0];
		int lastMaxStep = 0;
		for(int i = 0; i < nums.length ; i++) {
			if(currentStep == nums.length - 1) {
				return currentStep;
			}
			if(nextMaxStep >= nums.length - 1) {
				return currentStep + 1;
			}
			if(i <= lastMaxStep) {
				nextMaxStep = nextMaxStep > i + nums[i] ? nextMaxStep : i + nums[i];
			} else {//i > lastMaxStep 当前位置过了上一步的最大位置
				currentStep++;
				lastMaxStep = nextMaxStep;
				nextMaxStep = i + nums[i];
			}
		}
		return -1;
	}
	
	
	

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {2,3,1,1,4};
		int[] nums = {1};
		int step = solution.jump(nums);
		System.out.println(step);
	}
}
