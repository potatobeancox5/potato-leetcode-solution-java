package com.potato.study.leetcode.p0088;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         88. Merge Sorted Array
 *         
 *         Given two sorted integer arrays nums1 and
 *         nums2, merge nums2 into nums1 as one sorted array.
 * 
 *         Note: You may assume that nums1 has enough space (size that is
 *         greater or equal to m + n) to hold additional elements from nums2.
 *         The number of elements initialized in nums1 and nums2 are m and n
 *         respectively.
 * 
 * 
 *         思路：
 * 			典型的插入排序解法
 * 			从后向前进行插入  将最大的数直接放在最后边，一样大的一起放进目标数组（a）
 * 
 */
public class Solution {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(nums1 == null) {
			nums1 = nums2;
			return;
		}
		if(nums2 == null) {
			return;
		}
		// nums1 nums2 都不为空时 合并两个数组
		int i = m - 1;
		int j = n - 1;
		int index = m + n - 1;
		while(i >= 0 && j >= 0) { // j 先到最后的位置 结束合并  i先到位置 将j 合并到i的位置
			if(nums1[i] > nums2[j]) {
				nums1[index--] = nums1[i--];
			} else if (nums1[i] < nums2[j]) {
				nums1[index--] = nums2[j--];
			} else { // 相等
				nums1[index--] = nums1[i--];
				nums1[index--] = nums2[j--];
			}
		}
        //如果 nums2 串 还有剩余 挪到nums1中
		while(j >= 0 ) {
			nums1[index--] = nums2[j--];
		}
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = new int[4];
		int[] nums2 = {4,5};
		nums1[0] = 3;
		nums1[1] = 4;
		solution.merge(nums1, 2, nums2, nums2.length);
		System.out.println(Arrays.toString(nums1));
	}
}
