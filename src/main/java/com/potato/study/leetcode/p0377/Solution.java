package com.potato.study.leetcode.p0377;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *       377. Combination Sum IV
 * 
 *      Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.


Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.
 *         
 *         思路：
 *          dp[i] = sum (dp [i - nums[j]])
 *
 *
 */
public class Solution {


    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }
        // 存储何为 i 的组合个数
        int[] dp = new int[target + 1];
        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == nums[j]) {
                    dp[i] += 1;
                } else if (i > nums[j]) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int target = 4;
        int res = solution.combinationSum4(nums, target);
		System.out.println(res);
        Assert.assertEquals(7, res);
	}
}
