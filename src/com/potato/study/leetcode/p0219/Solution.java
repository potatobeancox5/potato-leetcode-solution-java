package com.potato.study.leetcode.p0219;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *      219. Contains Duplicate II
 * 
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: [1,2,3,1], k = 3
Output: true
Example 2:

Input: [1,0,1,1], k = 1
Output: true
Example 3:

Input: [1,2,1], k = 0
Output: false		
 * *         
 * 思路：  使用HashMap 记录 当前位置 i i - k 位置 到 i + k 位置 是否存在重复存在 返回true 否则 移动 i 
 * 并修改hashMap map的value 记录 当前数组出现的次数
 * 还可以采用map记录 上次出现的index 这个方式 然后 每次重复进行index 比较 这种方式实现
 */
public class Solution {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (null == nums || nums.length <= 1 || k == 0) {
			return false;
		}
		Set<Integer> appear = new HashSet<>();
		// 初始化 map
		for (int i = 0; i <= k && i < nums.length; i++) {
			if (appear.contains(nums[i])) {
				return true;
			} else {
				appear.add(nums[i]);
			}
		}
		for (int i = k + 1; i < nums.length; i++) {
			// 每加入一个 就要删除一个元素
			appear.remove(nums[i - k - 1]);
			if (appear.contains(nums[i])) {
				return true;
			} else {
				appear.add(nums[i]);
			}
		}
		return false;
	}
	
//	public boolean containsNearbyDuplicate(int[] nums, int k) {
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for(int i=0;i<nums.length;i++){
//			if(!map.containsKey(nums[i])){
//				map.put(nums[i], i);
//			}
//			else{
//				int index = map.get(nums[i]);
//				if(i - index <= k){
//					return true;
//				}
//				else{
//					map.put(nums[i], i);
//				}
//			}
//		}
//		return false;
//	}
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,1};
		int k = 2;
		boolean result = solution.containsNearbyDuplicate(nums, k);
		System.out.println(result);
	}
}
