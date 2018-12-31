package com.potato.study.leetcode.p0349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *        349. Intersection of Two Arrays
 * 
 *       Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*         
 *         
 *         
 *         思路：求交集
 *         弄一个set 第一个int中数组 放入 set 用第二个一次找 并放到交集中
 *        
 */
public class Solution {
	
	public int[] intersection(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2) {
			return null;
		}
        Set<Integer> set = new HashSet<>();
        Set<Integer> interSet = new HashSet<>();
        for (int ele : nums1) {
			set.add(ele);
		}
        for (int ele : nums2) {
        	if(set.contains(ele)) {
        		interSet.add(ele);
        	}
        }
        int[] arr = new int[interSet.size()];
        Integer[] arrInteger = new Integer[interSet.size()];
        arrInteger = interSet.toArray(arrInteger);;
        for(int i = 0 ; i < arr.length ;i++) {
        	arr[i] = arrInteger[i];
        }
        return arr;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		int[] arr = solution.intersection(nums1, nums2);
		System.out.println(Arrays.toString(arr));
	}
}
