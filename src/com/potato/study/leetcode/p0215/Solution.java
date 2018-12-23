package com.potato.study.leetcode.p0215;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         215. Kth Largest Element in an Array
 * 
 * 			Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
    题目需求：
        快速排序 返回
    思路：


 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
