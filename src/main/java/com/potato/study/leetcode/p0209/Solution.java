package com.potato.study.leetcode.p0209;

/**
 * 
 * @author liuzhao11
 * 
 *         209. Minimum Size Subarray Sum
 * 
 * 			Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
    题目需求：

    思路：
        https://www.cnblogs.com/grandyang/p/4501934.html
        左右两个指针 从0开始 异动right until和大于给的值，再移动left 直到小于s 计算最小长度


 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = left + 1;
        int sum = nums[left];
        int minLen = Integer.MAX_VALUE;
        do {
            // 移动right 使sum变大
            while (sum < s && right < nums.length) {
                sum += nums[right];
                right++;
            }
            // 记录当前值
            if (sum >= s && minLen > right - left) {
                minLen = right - left;
            }
            // 移动left 是的sum 变小
            while (sum >= s && left <= right) {
                sum -= nums[left];
                left++;
                // 记录当前值
                if (sum >= s && minLen > right - left) {
                    minLen = right - left;
                }
            }
        } while(right < nums.length);
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = 7;
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {};
        int i = solution.minSubArrayLen(s, nums);
        System.out.println(i);
    }
}
