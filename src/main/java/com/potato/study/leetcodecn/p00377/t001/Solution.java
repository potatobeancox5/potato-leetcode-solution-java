package com.potato.study.leetcodecn.p00377.t001;

import org.junit.Assert;

/**
 * 377. 组合总和 Ⅳ
 *
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 *
 * 输入：nums = [9], target = 3
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 *  
 *
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 377 组合数量
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // dpi 和为 i的组合种类数 店铺0 = 1
        dp[0] = 1;
        // dp i 等于 遍历 nums sum {dp i - num}
        for (int i = 0; i < target + 1; i++) {
            for (int num : nums) {
                if (i - num < 0) {
                    continue;
                }
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }


//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[] {
//                1,7,4,9,2,5
//        };
//        int i = solution.wiggleMaxLength(nums);
//        System.out.println(i);
//        Assert.assertEquals(6, i);
//
//        nums = new int[] {
//                1,17,5,10,13,15,10,5,16,8
//        };
//        i = solution.wiggleMaxLength(nums);
//        System.out.println(i);
//        Assert.assertEquals(7, i);
//    }


}
