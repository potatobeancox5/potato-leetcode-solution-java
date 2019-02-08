package com.potato.study.leetcode.p0164;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *      164. Maximum Gap
 *         
 *          
 *   Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
(3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.

 *
 *      题目需求:
 *			给定未排序的数组，找到其排序形式中的连续元素之间的最大差异。
 *
 * 		解题思路：
 *
 * 	        https://www.cnblogs.com/bywallance/p/5761269.html
 * 	        题目要求线性时间 On
 * 	        那么就不能先进行排序了
 * 	        同排序 n个数字
 * 	        取顶 max - min 设置 除去 max和 min 设置n-1个 桶 这样 n-2 个元素 放到n-1 个桶里边 一定至少有一个位置空出来，
 * 	        这样 最大值一定出现在有空位的位置
 *
 * 	        遍历最终结果 求出来这个最大值 当前位置 min - 之前位置 max
 * 	        使用两个数组分别记录 每个位置的最大值和最小值
 *
 *
 *
 */
public class Solution {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (nums.length == 2 || max == min) {
            return max - min;
        }
        // 桶之间的间隔
        int bucketLen = (int) Math.ceil(((double) max - (double) min) / (nums.length - 1));
        // 桶数目
        int n = (max - min) / bucketLen;

        // 多一个桶 为了满足中间必然有空当
        int[] maxArr = new int[n + 1];
        int[] minArr = new int[n + 1];

        Arrays.fill(maxArr, Integer.MIN_VALUE);
        Arrays.fill(minArr, Integer.MAX_VALUE);

        for (int num : nums) {
            maxArr[(num - min) / bucketLen] = Math.max(num, maxArr[(num - min) / bucketLen]);
            minArr[(num - min) / bucketLen] = Math.min(num, minArr[(num - min) / bucketLen]);
        }
        // 计算最大位置
        int gap = 0;
        int preMax = maxArr[0];
        for (int i = 1; i < n + 1; i++) {
            if (minArr[i] != Integer.MAX_VALUE) {
                gap = Math.max(gap, minArr[i] - preMax);
                preMax = maxArr[i];
            }
        }
        return gap;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

//		int[] nums = {3,6,9,1};
		int[] nums = {10,3,6,9,1};

		int result = solution.maximumGap(nums);
		System.out.println(result);
	}

}
