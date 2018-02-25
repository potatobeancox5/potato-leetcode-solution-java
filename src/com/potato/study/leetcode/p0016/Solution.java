package com.potato.study.leetcode.p0016;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11 16. 3Sum Closest
 * 
 *         Given an array S of n integers, find three integers in S such that
 *         the sum is closest to a given number, target. Return the sum of the
 *         three integers. You may assume that each input would have exactly one
 *         solution.
 * 
 *         For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *         The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 *         思路： 题目含义 给定数组中找到三个数的和与给定的目标数最接近的组合,
 *         思路就是想办法固定一个 然后从两端开始查找 这样可以将围度
 *         采用一次固定一个数，然后对另外的两个数采用left，right 一次缩小范围的比较方式比较，
 *         1.排序给定数组
 *         2.以此固定i j k 
 *         		i from 0 to n-3(包含)
 *         			j from i+1   ->       
 *         			k from n-1   <- 
 *         		通过计算 ijk的和纪录并完成遍历 
 * 
 */
public class Solution {
	
	
	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
		if(null == nums || nums.length == 0) {
    	   		return 0;
        } 
		if(nums.length < 3) {
			int sum = 0;
			for (int ele : nums) {
				sum += ele;
			}
			return sum;
		}
		int distance = Integer.MAX_VALUE;// 纪录历史最小差值
		int closest = 0;
		//数组大于3,排序 数组 升序
		Arrays.sort(nums);
		for(int i = 0 ; i < nums.length - 2 ; i++) {
			int j = i+1;
			int k = nums.length - 1;
			while(j < k) {
				int tempSum = nums[i] + nums[j] + nums[k];
				if(tempSum > target) { // 向前移k
					if(distance > tempSum - target) {
						distance = tempSum - target;
						closest = tempSum;
					}
					k--;
				} else if (tempSum < target) { // 向后移动j
					if(distance > target - tempSum) {
						distance = target - tempSum;
						closest = tempSum;
					}
					j++;
				} else { // 相等直接返回
					return target;
				}
			}
		}
		return closest;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		int closest = solution.threeSumClosest(nums, target);
		System.out.println(closest);
	}

}
