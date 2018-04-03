package com.potato.study.leetcode.p0080;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 80. Remove Duplicates from Sorted Array II
 * 
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

 *   
 *  思路：
 *  开一个map 计数
 *  设置一个insertIndex 记录当前插入位置
 *  index 记录当前比较的数字
 *  遍历一遍数组 
 *  	若当前数字 出现次数小于2 将数字放在 insertIndex 更新map的计数器 insertIndex++
 *  	若当前数字出现次数大于等于2 insertIndex保持不变
 *    index++
 *  
 *  
 *   
 */
public class Solution {
	
	public int removeDuplicates(int[] nums) {
		if(null == nums || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> timeMap = new HashMap<>();
		int index = 0;
		int insertIndex = 0;
		while(index < nums.length) {
			if(timeMap.containsKey(nums[index])) {
				if(timeMap.get(nums[index]) < 2) {
					timeMap.put(nums[index], timeMap.get(nums[index]) + 1);
					nums[insertIndex++] = nums[index++];
				} else { // 出现次数超过2次
					index++;
				}
			} else { // 根本没有出现过
				timeMap.put(nums[index], 1);
				nums[insertIndex++] = nums[index++];
			}
		}
		return insertIndex;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,1,1,2,2,3};
		int len = solution.removeDuplicates(nums);
		System.out.println("len:" + len);
		System.out.println(Arrays.toString(nums));
	}
}
