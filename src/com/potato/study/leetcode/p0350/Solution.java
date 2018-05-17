package com.potato.study.leetcode.p0350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *        350. Intersection of Two Arrays II
 * 
 *      Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*         
 *         
 *         
 *         思路：排序 大的到小的找 找到 放到list中保存
 *        
 */
public class Solution {
	
	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
        	return null;
        }
		int[] big;
        int[] small;
        if(nums1.length > nums2.length) {
        	big = nums1;
        	small = nums2;
        } else {
        	big = nums1;
        	small = nums2;
        }
        Arrays.sort(big);
        Arrays.sort(small);
        // 大的向小的中查找
        int bigIndex = 0;
        int smallIndex = 0;
        List<Integer> list = new ArrayList<>();
        while(bigIndex < big.length && smallIndex < small.length) {
        	if(big[bigIndex] == small[smallIndex]) {
        		list.add(big[bigIndex]);
        		bigIndex++;
        		smallIndex++;
        	} else if(big[bigIndex] > small[smallIndex]) {
        		smallIndex++;
        	} else {//big[bigIndex] < small[smallIndex]
        		bigIndex++;
        	}
        }
        int[] arr = new int[list.size()];
        for(int i = 0 ; i < arr.length ;i++) {
        	arr[i] = list.get(i);
        }
        return arr;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		int[] arr = solution.intersect(nums1, nums2);
		System.out.println(Arrays.toString(arr));
	}
}
