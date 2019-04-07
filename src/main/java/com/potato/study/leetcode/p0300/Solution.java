package com.potato.study.leetcode.p0300;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Administrator
 *
 *         300. Longest Increasing Subsequence
 *         
 *          
 *         Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 *         
 *         
 *         
 *         题目含义：
 *          最长的子序列 子序列是原来传的一些片段的组合
 *          动态规划
 *          dp[i] 代表 包含i的 递增子序列的长度
 *          dp[i] = max (dp[j 从 0-j] + 1) 且 ch i > ch j
 *          dp[0] = 1
 *
 *         思路：
 *
 *          https://www.jianshu.com/p/a3cd9df6d9d1
why
https://www.jianshu.com/p/a3cd9df6d9d1一个数组 记录当前最大串
升序
遍历target 当前数字比最大值大 加在最后 否则替换数组中第一个大于这个数的数
https://segmentfault.com/a/1190000007322972?utm_medium=referral&utm_source=tuicool
 *          https://www.cnblogs.com/yrbbest/p/5047816.html
 *
 *      这种解法的原因数组中的个数总是最长的增长串
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        if (null != nums) {
            for (int i = 0; i < nums.length; i++) {
                if (lis.size() == 0 || nums[i] > lis.get(lis.size() - 1)) {
                    lis.add(nums[i]);
                } else { // 替换list中第一个大于 这个树的值
                    for (int j = 0; j < lis.size(); j++) {
                        if (lis.get(j) > nums[i]) {
                            lis.set(j, nums[i]);
                            break;
                        } else if (lis.get(j) == nums[i]) {
                            break;
                        }
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>(lis);
        return set.size();
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {2,2};
//        int[] nums = {4,10,4,3,8,9}; // 3
        int res = solution.lengthOfLIS(nums);
        System.out.println(res);
    }
}
