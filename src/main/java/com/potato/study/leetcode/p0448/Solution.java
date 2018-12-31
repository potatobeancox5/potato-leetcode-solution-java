package com.potato.study.leetcode.p0448;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *   448. Find All Numbers Disappeared in an Array
 * 
 *     Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 * 
 *         思路： 利用数组nums 记录 当前位置（index + 1） 是否有值  0 为没有遍历过 -1 带表已经有值了 
 *         遍历数组 i 
 *         	若 nums i 》 0 说明还米有找过这个数字 
 *         	int tmp = nums【i】；
 *         while nums[tmp - 1] > 0
 *          nums[i] = 0;
 *          int otherTmp = nums【tmp - 1】;
 *          num[tmp - 1] = -1;
 *          tmp = otherTmp;
 *          最终遍历整个数组 找到为0 的下标 + 1 就是所求
 * 				
 */	
public class Solution {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> numsList = new ArrayList<>();
		if( null == nums || nums.length == 0) {
			return numsList;
		}
		for(int i = 0 ; i < nums.length ; i++) {
			if(nums[i] > 0) {
				int tmp = nums[i];
				nums[i] = 0;
				while(nums[tmp - 1] > 0) {
					int otherTmp = nums[tmp - 1];
					nums[tmp - 1] = -1;
					tmp = otherTmp;
				} 
				if(nums[tmp - 1] == 0) {
					nums[tmp - 1] = -1;
				}
			}
		}
		for(int i = 0 ; i < nums.length ; i++) {
			if(nums[i] == 0) {
				numsList.add(i + 1);
			}
		} 
		return numsList;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> list = solution.findDisappearedNumbers(nums);
		System.out.println(list);
	}
}
