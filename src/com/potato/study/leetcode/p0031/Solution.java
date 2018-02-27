package com.potato.study.leetcode.p0031;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 *         思路：题意 给定一个字典序列 求这个序列的下一个序列是什么
 *         字典序排列：
 *         　对于数字1、2、3......n的排列，不同排列的先后关系是从左到右逐个比较对应的数字的先后来决定的。例如对于5个数字的排列 12354和12345，排列12345在前，排列12354在后。按照这样的规定，5个数字的所有的排列中最前面的是12345，最后面的是 54321。

　　那么1234的全排列从小到大的顺序也就是字典序的顺序，依次如下：

　　　　1234,1243,1324,1342,1423,1432,2134,2143,2314,2341,2413,2431,3124,3142,3214,3241,3412,3421,4123,4132,4213,4231,4312,4321
 *
 *	求字典顺序排列的方法，
 * 1.从倒数第二个位置向前 找到第一个升序排列的位置： 如1，2，3，4 中的4
 * 2.在这个位置后面 比这个元素大的元素中 最小的那个 与之交换
 * 3.将该元素后的所有元素排序，使之成为最小的排列。
 * 
 */
public class Solution {

	public void nextPermutation(int[] nums) {
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
//		int[] nums = {1,2,3}; // 1.3.2
//		int[] nums = {3,2,1}; // 1,2,3
//		int[] nums = {1,3,2};// 2,1,3
		int[] nums = {2,3,1};
		solution.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
