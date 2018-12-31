package com.potato.study.leetcode.p0055;

/**
 * 
 * @author liuzhao11
 * 
 *      55. Jump Game
 *      
 *        Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 * 
 *         思路： 给定数组 按照数组中值为最远跳的距离 判断是否能跳到最后一个index
 *         记录当前位置index
 *         记录当前步最远能够达到的距离 maxIndex
 *         
 *         如果 maxIndex >= nums.lenght - 1 证明可以达到终点
 *         
 *         当index <= maxIndex 更新 maxIndex 
 *         
 *         		
 *         当 index > maxIndex 证明无法走到终点
 *         
 *         判断当前位置 > currentStepMax 
 * 
 */
public class Solution {

	
	public boolean canJump(int[] nums) {
		int index = 0;
		int maxIndex = 0;
		while(index < nums.length) {
			if( maxIndex >= nums.length - 1) {
				return true;
			}
			if(index <= maxIndex) {
				maxIndex = maxIndex >= index + nums[index] ? maxIndex :index + nums[index];
				index ++;
			} else {// index > maxIndex
				return false;
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {2,3,1,1,4};
		int[] nums = {3,2,1,0,4};
		boolean result = solution.canJump(nums);
		System.out.println(result);
		
	}
}
