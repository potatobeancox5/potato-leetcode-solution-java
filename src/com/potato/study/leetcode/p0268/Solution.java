package com.potato.study.leetcode.p0268;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 268. Missing Number
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

* 		思路： 对n 求和 然后对num求和 两个和做差 dif
* 		最后的结果就是 n+ 1 - dif
* 
 */
public class Solution {
	public int missingNumber(int[] nums) {
        int sum1 = (nums.length - 1) * (nums.length) / 2;
        int sum2 = 0;
        for(int i = 0 ; i < nums.length ; i++) {
        	sum2 += nums[i];
        }
        int dif = sum2 - sum1;
        return nums.length - dif;
    }
	
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	int[] nums = {3,0,1};
    	int[] nums = {9,6,4,2,3,5,7,0,1};
    	int num = solution.missingNumber(nums);
    	System.out.println(num);
	}
}
