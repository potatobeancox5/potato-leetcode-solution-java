package com.potato.study.leetcode.p0027;

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
 *         27. Remove Element Given an array and a value, remove all instances
 *         of that value in-place and return the new length.
 * 
 *         Do not allocate extra space for another array, you must do this by
 *         modifying the input array in-place with O(1) extra memory.
 * 
 *         The order of elements can be changed. It doesn't matter what you
 *         leave beyond the new length.
 * 
 *         Example:
 * 
 *         Given nums = [3,2,2,3], val = 3,
 * 
 *         Your function should return length = 2, with the first two elements
 *         of nums being 2.
 * 
 *         思路：
 *         设置左右两个位置left = 0 right = 第一个不是val的index
 *         左边负责查询当前值是否是给定值 右边一直标记第一个不是val的值的位置
 *         while(left <= right) 
 *         	如果nums[left] != val left++
 *         	否则nums[left] = nums[right] 移动right（最多移动到0） 到下一个不是val的index left++ 
 *         
 * 
 */
public class Solution {
	
	public int removeElement(int[] nums, int val) {
		if(null == nums || nums.length ==0) {
			return 0;
		}
		int left = 0 ;
		int right = nums.length - 1;
		while(right >= 0 ) {
			if(nums[right] != val) {
				break;
			} else {
				right--;
			}
		}
		while(left <= right) {
//		*   如果nums[left] != val left++
			if(nums[left] != val) {
				left++;
			} else {
//		*   否则nums[left] = nums[right] 移动right（最多移动到0） 到下一个不是val的index left++ 			
				nums[left++] = nums[right--];
				while(right >= 0) {
					if(nums[right] != val) {
						break;
					} else {
						right--;
					}
				}
			}
		}
		return left;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {3};
//		int[] nums = {3,2,2,3};
		int val = 2;
		int len = solution.removeElement(nums, val);
		System.out.println(len);
		System.out.println(Arrays.toString(nums));
	}

}
