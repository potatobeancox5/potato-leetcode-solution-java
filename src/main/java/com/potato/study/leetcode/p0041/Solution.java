package com.potato.study.leetcode.p0041;

/**
 * 
 * @author liuzhao11
 * 
 *        41. First Missing Positive
 * 
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

 *         思路：
 *         给一个数组 找到第一个失踪的整数
 *         遍历两边数组
 *         第一遍  
 *         遍历数组 以value 为index 交换每个数
 *         		如果当前位置上的数 为 -1 或者 等于index continue 或者nums.len -1 continue
 *         		否则 将该数组该位置的数 与 index为value的数 交换 一直交换 这个位置 除非出现相等 或者上边越界的情况
 *         第二遍 比较 查看当前位置中存放的数 是否是index 不是的话 就找到了该数字
 * 
 */
public class Solution {
	
	public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 1;
        } 
        for(int i = 0 ; i < nums.length ; i++) {
        	if(nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
        		continue;
        	} else { // 交换两个位置的数字 
        		int tmp = nums[i];
        		if(nums[tmp - 1] == tmp) { // 待交换的位置已经ok了 那不 不进行这次交换了 目前的这个数组 舍去 
        			continue;
        		}
        		nums[i] = nums[tmp - 1];
        		nums[tmp - 1] = tmp;
        		i--;// 保证 下次还交换这个位置
        	}
        }
        //遍历移动后的数组 找到第一个value不等于index 就是所得
        for(int i = 0 ; i < nums.length ; i++) {
        	if(nums[i] != i + 1) {
        		return i + 1;
        	}
        }
        return nums.length + 1;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {1,2,0};
//		int[] nums = {3,4,-1,1};
		int[] nums = {1,1};
		int positive = solution.firstMissingPositive(nums);
		System.out.println(positive);
	}
}
