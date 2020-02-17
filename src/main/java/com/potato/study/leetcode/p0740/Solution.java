package com.potato.study.leetcode.p0740;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	740. Delete and Earn
 *  
 *         Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:

Input: nums = [3, 4, 2]
Output: 6
Explanation:
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.


Example 2:

Input: nums = [2, 2, 3, 3, 3, 4]
Output: 9
Explanation:
Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.


Note:

The length of nums is at most 20000.
Each element nums[i] is an integer in the range [1, 10000].
 *
 * 思路：
 *  每次选择一个 num i 删除 并且得到 num i 分
 *  然后往前 val （num i ）+ 1 或者 val （num i ）- 1 删除
 *  求最终获得的分数
 *
 *  从某个位置依次往前或者往后 获得的最大得分
 *
 *  https://www.cnblogs.com/stAr-1/p/7989860.html
 *
 *  动态规划
 *
 *  0 首先 通过一个桶 value 计算 index == num时 类似的总数
 *  动态转移方程 dp 代表 到i位置 最多能earn 多少
 *  dp i = max {选 数字为i， 不选数字为i} 选 = dp[i-2] + value i ,不选 dp i-1
 *
 */
public class Solution {

    public int deleteAndEarn(int[] nums) {
        // 0 首先 通过一个桶 value 计算 index == num时 类似的总数 dp [1, 10000]
        int[] value = new int[10001];
        for (int num : nums) {
            value[num] += num;
        }
        // 1 遍历 value 通过状态转移方程 p i = max {选 数字为i， 不选数字为i} 选 = dp[i-2] + value i ,不选 dp i-1 计算
        int[] dp = new int[10001];
        dp[1] = value[1];
        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i-2] + value[i], dp[i-1]);
        }
        // 2 返回 dp 最大值
        return dp[10000];
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] nums = {3, 4, 2};
        int res = solution.deleteAndEarn(nums);
		System.out.println(res);
        Assert.assertEquals(6, res);

        nums = new int[]{2, 2, 3, 3, 3, 4};
        res = solution.deleteAndEarn(nums);
        System.out.println(res);
        Assert.assertEquals(9, res);
    }
}
