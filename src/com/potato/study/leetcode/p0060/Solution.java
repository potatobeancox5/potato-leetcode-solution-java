package com.potato.study.leetcode.p0060;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 
 *         60. Permutation Sequence
 *     
 *       The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 * 
 * 
 *         思路：给定 n 输出第k 个排列数字
 *         找到当前字符串升序
 */
public class Solution {
	
	public String getPermutation(int n, int k) {
		// 初始化  数组  int[] num
		int [] nums = new int[n];
		for(int i = 0 ; i < n ; i++) {
			nums[i] = i + 1;
		}
		//循环找下一个位置的数字并 增加计数器 直到k
        int count = 1;
        while(count < k) {        	
        	nextPermutation(nums);
        	count++;
        }
        StringBuilder builder = new StringBuilder();
        for(int num : nums) {
        	builder.append(num);
        }
        return builder.toString();
    }
	
	private void nextPermutation(int[] nums) {
		if(nums == null || nums.length == 0) {
			return ;
		}
//		1.从倒数第二个位置向前 找到第一个升序排列的位置： 如1，2，3，4 中的4
		int baseIndex = -1;// 等待交换的位置
		int max = nums.length - 1; // 纪录历史最大值 第二阶段使用
		for (int i = nums.length - 2 ; i >= 0 ; i--) {
			if(nums[i] < nums[i+1]) { // 找到第一个升序 严格
				baseIndex = i;
				break;
			}
			if(nums[i] > nums[max]) {
				max = i;
			}
		}
		if(baseIndex == -1) { // 已经是倒叙排列的序列 下一个是正向排列
			Arrays.sort(nums);
			return;
		}
//		 * 2.在这个位置后面 比这个元素大的元素中 最小的那个 与之交换
		int min = max; // 比交换位置 数大的数中最小的那个数的位置
		for(int i = baseIndex + 1 ; i < nums.length ; i++) {
			if(nums[i] > nums[baseIndex] && nums[i] < nums[min]) {
				min = i;
			}
		}
		//交换
		int tmp = nums[min];
		nums[min] = nums[baseIndex];
		nums[baseIndex] = tmp;
//		 * 3.将该元素后的所有元素排序，使之成为最小的排列。
		Arrays.sort(nums, baseIndex + 1, nums.length);
		return;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.getPermutation(3, 5);
		System.out.println(result);
	}
}
