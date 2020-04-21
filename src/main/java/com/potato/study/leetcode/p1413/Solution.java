package com.potato.study.leetcode.p1413;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1413. Minimum Value to Get Positive Step by Step Sum
 *  
 *
Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.



Example 1:

Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
step by step sum
startValue = 4 | startValue = 5 | nums
(4 -3 ) = 1  | (5 -3 ) = 2    |  -3
(1 +2 ) = 3  | (2 +2 ) = 4    |   2
(3 -3 ) = 0  | (4 -3 ) = 1    |  -3
(0 +4 ) = 4  | (1 +4 ) = 5    |   4
(4 +2 ) = 6  | (5 +2 ) = 7    |   2
Example 2:

Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive.
Example 3:

Input: nums = [1,-2,-3]
Output: 5


Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
 *         
 *         思路：
 *          求 sum 最小值 1 - min
 *          如果结果小于 1 返回 1
 *
 *          https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum/solution/he-de-zui-xiao-zhi-by-deng__/
 *
 */
public class Solution {


    public int minStartValue(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 1;
        }
        int minSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(sum, minSum);
        }
        int val = 1 - minSum;
        if (val < 1) {
            val = 1;
        }
        return val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{-3,2,-3,4,2};
        int res = solution.minStartValue(nums);
        System.out.println(res);
        Assert.assertEquals(5, res);

        nums = new int[]{1,2};
        res = solution.minStartValue(nums);
        System.out.println(res);
        Assert.assertEquals(1, res);

        nums = new int[]{1,-2,-3};
        res = solution.minStartValue(nums);
        System.out.println(res);
        Assert.assertEquals(5, res);
    }
}
