package com.potato.study.leetcode.p0046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         46. Permutations
 * 
 * 
 *         Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * 
 * 
 *         思路：求给出数字的排列
 *         使用之前得出排列的函数 每次求出排列 然后用排列的记过继续求排列
 *         
 * 
 * 
 */
public class Solution {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		int length = nums.length;
		long times = factorial(length);
		for(int i = 0 ; i < times ; i++ ) {
			nextPermutation(nums,result);
		}
		return result;
    }
	
	public long factorial(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		return factorial(n-1) * n;
	}
	
	private void nextPermutation(int[] nums,List<List<Integer>> result) {
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
			List<Integer> list = new ArrayList<>();
			for (Integer integer : nums) {
				list.add(integer);
			}
			result.add(list);
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
		List<Integer> list = new ArrayList<>();
		for (Integer integer : nums) {
			list.add(integer);
		}
		result.add(list);
		return;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,3,4};
		List<List<Integer>>  list = solution.permute(nums);
		System.out.println(list);
		System.out.println("size:" + list.size());
	}
}
