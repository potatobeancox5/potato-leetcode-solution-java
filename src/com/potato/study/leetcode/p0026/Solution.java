package com.potato.study.leetcode.p0026;

/**
 * 
 * @author liuzhao11 26. Remove Duplicates from Sorted Array
 * 
 *         Given a sorted array, remove the duplicates in-place such that each
 *         element appear only once and return the new length.
 * 
 *         Do not allocate extra space for another array, you must do this by
 *         modifying the input array in-place with O(1) extra memory.
 * 
 *         Example:
 * 
 *         Given nums = [1,1,2],
 * 
 *         Your function should return length = 2, with the first two elements
 *         of nums being 1 and 2 respectively. It doesn't matter what you leave
 *         beyond the new length.
 * 
 *         思路：
 *         遍历一遍数组从 index 1 开始
 *         纪录之前的数字before 数字出现的次数time=1 没有重复的数字写位置 uniqueWriteIndex
 *         	如果当前数字current与之前的数字一致	
 *         		continue
 *         	如果当前数字与之前出现的不一致
 *         		纪录之前数字before到uniqueWriteIndex uniqueWriteIndex++
 *     			修改before = current 
 * 		  处理最后一个数字 写入uniqueWriteIndex++
 * 		返回 uniqueWriteIndex
 */
public class Solution {
	
	public int removeDuplicates(int[] nums) {
		if(null == nums || nums.length == 0) {
			return 0;
		} 
		if(nums.length == 1) {
			return 1;
		}
		int before = nums[0];
		int uniqueWriteIndex = 0;
		for (int i = 1; i < nums.length; i++) {
			int current = nums[i];
			if(current == before) {
				continue;
			} else { // 不一致 检查是否是独特的
				nums[uniqueWriteIndex++] = before;
				before = current;
			}
		}
		//处理最后一个字符的情况
		nums[uniqueWriteIndex++] = nums[nums.length - 1];
		return uniqueWriteIndex;
	}

	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {1,2};
		int[] nums = {1,1,2};
		int length = solution.removeDuplicates(nums);
		System.out.println(length);
	}

}
