package com.potato.study.leetcodecn.p00045.t001;

import org.junit.Assert;

/**
 * 45. 跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 示例:

 输入: [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 说明:

 假设你总是可以到达数组的最后一个位置。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/jump-game-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dp i 记录 跳到 index i 最小的步数
     * dp 0 = 0
     * dp i =  min {i之前index j + nums[j] >= i}
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        // 初始化
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) {
                    break;
                }
                dp[i +j] = Math.min(dp[i +j], dp[i] + 1);
            }
        }
        // 不可达
        if (Integer.MAX_VALUE == dp[nums.length - 1]) {
            return -1;
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {2,3,1,1,4};
        int jump = solution.jump(nums);
        System.out.println(jump);
        Assert.assertEquals(2, jump);


//        int[] nums = new int[] {2,3,1,1,4};
//        int jump = solution.jump(nums);
//        System.out.println(jump);
//        Assert.assertEquals(2, jump);
    }
}
