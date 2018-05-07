package com.potato.study.leetcode.p0167;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *     167. Two Sum II - Input array is sorted
 *         
 *          
 *   Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

 *         思路：
 *         前提 数组中没有重复   每一组数据均有解
 *         在给定数组中 找到两个数字的和 是给定的target
 */
public class Solution {
	
	public int[] twoSum(int[] numbers, int target) {
        int[] params = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
        	if(numbers[left] + numbers[right] < target) {
        		left++;
        	} else if (numbers[left] + numbers[right] > target) {
        		right--;
        	} else {
        		params[0] = left + 1;
        		params[1] = right + 1;
        		return params;
        	}
        }
        return params;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] numbers = {2,7,11,15};
		int target = 9;
		int[] indexes = solution.twoSum(numbers, target);
		System.out.println(Arrays.toString(indexes));
	}
}
