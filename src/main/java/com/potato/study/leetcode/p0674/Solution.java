package com.potato.study.leetcode.p0674;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         674. Longest Continuous Increasing Subsequence
 * 
 *         Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1.
Note: Length of the array will not exceed 10,000.
 *
 *
 *         思路：
 *
 *
 *
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                currentLength++;
            } else {
                // 判断当前数字相对之前数字是否是递增的
                if (nums[i - 1] < nums[i]) {
                    currentLength++;
                } else { // 递减比较
                    if (maxLength < currentLength) {
                        maxLength = currentLength;
                    }
                    currentLength = 1;
                }
            }
            if (i == nums.length - 1 && maxLength < currentLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1,3,5,4,7}; // 3
//        int[] nums = {2,2,2,2,2}; // 1
        int[] nums = {1}; // 1
        int value = solution.findLengthOfLCIS(nums);
        System.out.println(value);
    }
}
