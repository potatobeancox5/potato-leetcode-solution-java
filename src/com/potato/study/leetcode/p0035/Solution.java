package com.potato.study.leetcode.p0035;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;

import javax.swing.UIManager;

/**
 * 
 * @author liuzhao11
 * 
 *         35. Search Insert Position 
 *         Given a sorted array and a target value,
 *         return the index if the target is found. If not, return the index
 *         where it would be if it were inserted in order.
 * 
 *         You may assume no duplicates in the array.
 * 
 *         Example 1:
 * 
 *         Input: [1,3,5,6], 5 Output: 2 Example 2:
 * 
 *         Input: [1,3,5,6], 2 Output: 1 Example 3:
 * 
 *         Input: [1,3,5,6], 7 Output: 4 Example 1:
 * 
 *         Input: [1,3,5,6], 0 Output: 0
 * 
 *         思路：
 *         二分发查找
 *         找不到 返回left
 * 
 * 
 */
public class Solution {
	
	

	public int searchInsert(int[] nums, int target) {
        int left = 0 ;
        int right = nums.length - 1;
        while(left <= right) {
	        	int mid = ( left + right ) / 2;
	        	if(nums[mid] == target) {
	        		return mid;
	        	} else if(nums[mid] > target) {
	        		right = mid - 1;
	        	} else {//nums[mid] < target
	        		left = mid + 1;
	        	}
        }
        return left;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {0,1,2,3,5,6};
		int index = solution.searchInsert(nums,4);
		System.out.println(index);
	}
}
