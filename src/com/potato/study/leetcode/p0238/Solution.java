package com.potato.study.leetcode.p0238;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *      238. Product of Array Except Self
 * 
 *Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 * 
 * 思路：返回数组是每个是除去这个位置数 的其他数的乘积
 * 	最好采用 常数空间 除了返回数组 不要使用除法 时间复杂度 O n
 * 用返回数组记录 左侧到目前位置 乘积 
 * 用一个变量从右侧开始计算乘积 然后与左侧的 指定index 相乘 就可以返回
 * https://blog.csdn.net/sunao2002002/article/details/47089053
 */
public class Solution {
	
	public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1 ; i < left.length ; i++) {
        	left[i] = nums[i-1] * left[i-1];
        }
        int right = 1;
        for(int i = nums.length - 2 ; i >= 0; i--) {
        	right = right * nums[i+1];
        	left[i] = right * left[i];
        }
        return left;
    }
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] nums = {1,2,3,4};
    	int[] result = solution.productExceptSelf(nums);
    	System.out.println(Arrays.toString(result));
	}
}
