package com.potato.study.leetcode.p0532;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         532. K-diff Pairs in an Array
 * 
 *        Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].

 *         思路：
 *         先进行排序
 *         遍历数组 使用 两个指针left right 进行移动
 *              left - right 相差太小 right 移动
 *              left - right 相差太大 left 移动向右边
 *
 *              如果n个数字一样 计算成1个pair
 */
public class Solution {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int leftIndex = 0;
        int rightIndex = 1;

        int pairCount = 0;

        while (rightIndex < nums.length) {
            int leftValue = nums[leftIndex];
            int rightValue = nums[rightIndex];
            if (rightValue - leftValue > k) {
                leftIndex++;
            } else if (rightValue - leftValue < k) {
                rightIndex++;
            } else {
                // 相等 计数
                pairCount++;
                leftIndex++;
                // 移动窗体
                while (leftIndex < nums.length && nums[leftIndex] == leftValue) {
                    leftIndex++;
                }
                while (rightIndex < nums.length && nums[rightIndex] == rightValue) {
                    rightIndex++;
                }
            }
            if (leftIndex == rightIndex) {
                rightIndex++;
            }
        }
        return pairCount;
    }
	
	public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1, 2, 3, 4, 5};
//        int k = 1;

        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;

        int pairs = solution.findPairs(nums, k);
        System.out.println(pairs);
    }
}
