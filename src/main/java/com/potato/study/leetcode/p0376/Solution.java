package com.potato.study.leetcode.p0376;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *       376. Wiggle Subsequence
 * 
 *      A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Example 1:

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
Example 3:

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?
 *         
 *         思路：
 *          on 时间复杂度 找到最长的 wiggle 序列，找到拐点，拐点个数就是目前的个数
 *
 *          boolean isIncreasing 记录当前序列是否
 *
 *          // 先计算前两个点的 isIncreasing 从index = 2 开始遍历 找拐点 true 标示 递增 false 标示递减 null 标示首点
 *
 *          https://blog.csdn.net/wdlsjdl2/article/details/51986424
 *
 *
 */
public class Solution {


    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // 1. 先计算前两个点的isIncreasing 状态
        int count = 1;
        Boolean isIncreasing = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && (isIncreasing == null || !isIncreasing)) {
                count++;
                isIncreasing = true;
            } else if (nums[i] < nums[i - 1] && (isIncreasing == null || isIncreasing)) {
                count++;
                isIncreasing = false;
            }
        }
        return count;
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {1,7,4,9,2,5};
        int res = solution.wiggleMaxLength(nums);
		System.out.println(res);
        Assert.assertEquals(6, res);


        int[] nums1 = {1,17,5,10,13,15,10,5,16,8};
        res = solution.wiggleMaxLength(nums1);
        System.out.println(res);
        Assert.assertEquals(7, res);


        int[] nums2 = {1,2,3,4,5,6,7,8,9};
        res = solution.wiggleMaxLength(nums2);
        System.out.println(res);
        Assert.assertEquals(2, res);

	}
}
