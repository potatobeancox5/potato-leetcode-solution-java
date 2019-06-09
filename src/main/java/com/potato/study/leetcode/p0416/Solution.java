package com.potato.study.leetcode.p0416;

/**
 * 
 * @author liuzhao11
 * 
 *         416. Partition Equal Subset Sum
 * 
 *         Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.


Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].


Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 *
 *         题目含义：
 *            给定一个数组，判断能够将数组分割成两个相等的部分
 *         思路：
 *            https://segmentfault.com/a/1190000014001622?utm_medium=referral&utm_source=tuicool
 *
 *            先计算 nums / 2 = n 的值
 *            动态规划  i from 0 to nums / 2
 *            dt[i]  表示 i 能否被构建出来
 *
 *            遍历 j from 0 to nums.len - 1
 *              遍历 i from 1 到 n
 *              dt[i] = dt[i] || dt[i - num[j]]
 */
public class Solution {

    public boolean canPartition(int[] nums) {
        // 先计算 nums / 2 = n 的值
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        boolean[] dt = new boolean[sum + 1];
        dt[0] = true;
        for (int j = 0; j < nums.length; j++) {
            for (int i = sum; i >= 0; i--) {
                if (i - nums[j] < 0) {
                    continue;
                }
                dt[i] = dt[i] || dt[i - nums[j]];
            }
        }
        return dt[dt.length - 1];
    }
	
	
	public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1, 2, 3, 5};// false
//        int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 5};
        boolean res = solution.canPartition(nums);
        System.out.println(res);
    }
}
