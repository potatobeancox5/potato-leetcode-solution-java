package com.potato.study.leetcode.p0673;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         673. Number of Longest Increasing Subsequence
 * 
 *         Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 *
 *
 *
 *         思路：
 *
 *          给定一个数组，求这个数组的最长递增子序列 的个数
 *
 *
 *
 *          len i  表示 到达i位置 的最长 子序列长度
 *          count i 表示 完成 len i长度的种类数
 *          max 记录当前最长的子序列长度
 *
 *          for i 0 len - 1
 *              for j 0 i-1
 *                  if num j 小于 num i
 *                      if 当前 len i == len j + 1 说明 当前 i 又多了 从j到达i的路径 种类数
 *                          count i += count j
 *                      else if len i < len j + 1 说明 当前 当前i 的值应该依赖与 j 产生
 *                          count i = count j
 *                          len i = len j + 1
 *                      esle 此时 len i > len j + 1 说明 次数 i 不收到 j的影响
 *
 *                  求当前子序列长度 max
 *
 *
 *          根据max 找到 len 中等于max的index 然后返回其中的cnt 如果有多组 那么直接求和
 *
 *          https://blog.csdn.net/u014688145/article/details/77923593
 */
public class Solution {


    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // len i  表示 到达i位置 的最长 子序列长度
        int[] len = new int[n];
        // count i 表示 完成 len i长度的种类数
        int[] count = new int[n];
        // max 记录当前最长的子序列长度
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // for i 0 len - 1
            len[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                //  for j 0 i-1
                if (nums[j] < nums[i]) {
                    if (len[i] == len[j] + 1) {
                    //  if 当前 len i == len j + 1 说明 当前 i 又多了 从j到达i的路径 种类数
                        count[i] += count[j];
                    } else if (len[i] < len[j] + 1) {
                    // else if len i < len j + 1 说明 当前 当前i 的值应该依赖与 j 产生
                        count[i] = count[j];
                        len[i] = len[j] + 1;
                    } else {
                    //  esle 此时 len i > len j + 1 说明 次数 i 不收到 j的影响
                    }

                }
            }
            // 求当前子序列长度 max
            max = Math.max(max, len[i]);
        }
        // 根据max 找到 len 中等于max的index 然后返回其中的cnt 如果有多组 那么直接求和
        int kindNum = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == max) {
                kindNum += count[i];
            }
        }
        return kindNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,5,4,7};
        int value = solution.findNumberOfLIS(nums);
        System.out.println(value);
        Assert.assertEquals(2, value);

        int[] nums1 = {2,2,2,2,2};
        value = solution.findNumberOfLIS(nums1);
        System.out.println(value);
        Assert.assertEquals(5, value);

        int[] nums2 = {1};
        value = solution.findNumberOfLIS(nums2);
        System.out.println(value);
        Assert.assertEquals(1, value);
    }
}
