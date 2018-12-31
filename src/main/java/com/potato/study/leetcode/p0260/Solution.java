package com.potato.study.leetcode.p0260;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *      260. Single Number III
 * 
 *Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
* 
* 
* 		思路： 找到两个数的不同 然后将 数组分成两个数 然后对每个做异或 就能找到两个不同的数
* 		找出不同bit方法 先一次整体异或  然后找到结尾的数 最低位不同的位置 按照这个分离数组
* 
* 	找到数字最小的bit 为1的方法
* int difBit = allNums & ~(allNums-1);
 */
public class Solution {
	
	public int[] singleNumber(int[] nums) {
        int dif = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
        	dif ^= nums[i];
        }
        int reference = findTheDifBit(dif);
        // 按照dif将数组分成两个不同的部分 分别异或
        int part1 = 0;
        int part2 = 0;
        for(int i = 0 ; i < nums.length ; i++) {
        	if((int)(nums[i] & reference) == 0) {
        		part1 ^= nums[i];
        	} else {
        		part2 ^= nums[i];
        	}
        	dif ^= nums[i];
        }
        return new int[]{part1,part2};
    }
	
	private int findTheDifBit(int num) {
		int n = 1;
		while((int)(n & num) == 0) {
			n  = n << 1;
		}
		return n;
	}
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] nums = {1,2,1,3,2,5};
    	int[]result = solution.singleNumber(nums);
    	System.out.println(Arrays.toString(result));
	}
}
