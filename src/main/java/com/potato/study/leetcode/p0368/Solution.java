package com.potato.study.leetcode.p0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *        368. Largest Divisible Subset
 * 
 *     Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
 *
 *         distinct 不同的
 *          set 内 各个 元素之间进行 % 操作 全满足都是0
 *         思路：
 *           状态转移方程
 *           状态转移方程 如果 num[i] % num[j] == 0 dp[i] = max(dp[i], dp[j]+1), j从 0 到 i 都遍历一遍 并记录每个节点的前驱
 *
 *           https://blog.csdn.net/qq508618087/article/details/51767785
 *
 *        
 */
public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return result;

        }
        // 1. 排序 升序
        Arrays.sort(nums);
        int[] dpTimes = new int[nums.length];
        // 记录前驱
        int[] path = new int[nums.length];
        for (int i = 0; i < path.length; i++) {
            path[i] = -1;
        }
        int maxLen = 0;
        int maxIndex = 0;
        // 2. 状态转移方程 如果 num[i] % num[j] == 0 dp[i] = max(dp[i], dp[j]+1), j从 0 到 i 都遍历一遍
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] != 0) {
                    continue;
                }
                // 能整除增加 并记录前驱
                if (dpTimes[j] + 1 > dpTimes[i]) {
                    dpTimes[i] = dpTimes[j] + 1;
                    path[i] = j;
                }
                if (maxLen < dpTimes[i]) {
                    maxLen = dpTimes[i];
                    maxIndex = i;
                }
            }
        }
        // 3. 通过maxIndex 找到path
        int k = maxIndex;
//        if (nums[0] == 1 || nums.length == 1) {
//            result.add(nums[0]);
//        }
        while (-1 != k) {
            result.add(nums[k]);
            k = path[k];
        }

//        result.add(nums[k]);
        return result;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,3};
        List<Integer> res = solution.largestDivisibleSubset(nums);
		System.out.println(res);


        int[] nums1 = {8,1,2,4};
        res = solution.largestDivisibleSubset(nums1);
        System.out.println(res);
	}
}
