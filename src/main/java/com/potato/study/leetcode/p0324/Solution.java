package com.potato.study.leetcode.p0324;


import java.util.Arrays;

/**
 * 
 * @author Administrator
 *
 *         324. Wiggle Sort II
 *         
 *          
 *         Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 *         
 *         
 *         题目含义：
 *
 *         思路：先排序，偶数index 按照中位数之前的进行排序
 *         奇数按照从后到前选择数字
 *          https://www.liangzl.com/get-article-detail-40382.html
 *
 *         
 */
public class Solution {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] newArr = new int[nums.length];

        // 全是倒序
        int index = nums.length - 1;
        for (int i = 1; i < nums.length; i+=2 ) {
            newArr[i] = nums[index--];
        }
        for (int i = 0; i < nums.length; i+=2) {
            newArr[i] = nums[index--];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArr[i];
        }
    }

	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] nums = {4,5,5,6};

        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
