package com.potato.study.leetcode.p0303;

/**
 * 
 * @author liuzhao11
 * 
 *         303. Range Sum Query - Immutable
 * 
 *         Given an integer array nums, find the sum of the elements between
 *         indices i and j (i ≤ j), inclusive.
 * 
 *         Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 *         sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 Note:
 *         You may assume that the array does not change. There are many calls
 *         to sumRange function.
 * 
 *         思路： 保存数组data[i] 代表0 到i 的和(包括i) （构造方法初始化） 这样 i j 等于 data[j] -
 *         data[i-1]（sumRange方法）
 * 
 */
public class NumArray {

	private int[] data;// 存放计算结果

	public NumArray(int[] nums) {
		if (null == nums || nums.length == 0) {
			return;
		} else {
			data = new int[nums.length];
			data[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				data[i] = data[i - 1] + nums[i];
			}
		}
	}

	public int sumRange(int i, int j) {
//		if (i >= data.length || j >= data.length) {
//			return 0;
//		}
		if (i == 0) {
			return data[j];
		}
		return data[j] - data[i - 1];
	}

	/**
	 * Your NumArray object will be instantiated and called as such: NumArray
	 * obj = new NumArray(nums); int param_1 = obj.sumRange(i,j);
	 */
	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		NumArray numArray = new NumArray(nums);
		// int result = numArray.sumRange(0, 2);// 1
		// int result = numArray.sumRange(2, 5);// -1
		int result = numArray.sumRange(0, 5);// -3
		System.out.println(result);

	}
}
