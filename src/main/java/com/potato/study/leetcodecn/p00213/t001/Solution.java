package com.potato.study.leetcodecn.p00213.t001;

import org.junit.Assert;

/**
 * 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

  

 示例 1：

 输入：nums = [2,3,2]
 输出：3
 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 示例 2：

 输入：nums = [1,2,3,1]
 输出：4
 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
      偷窃到的最高金额 = 1 + 3 = 4 。
 示例 3：

 输入：nums = [0]
 输出：0
  

 提示：

 1 <= nums.length <= 100
 0 <= nums[i] <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/house-robber-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 两种情况 如果第一个偷 和第一个不偷

     dp i 等于 max num i + dp i-2 dpi-1

     dp i 到i 天 最多多少钱
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 第一个不偷窃
        int[] dp1 = new int[nums.length];
        dp1[1] = nums[1];
        // 第1个偷窃
        int[] dp2 = new int[nums.length];
        dp2[0] = nums[0];
        dp2[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp1[i] = Math.max(dp1[i-1], nums[i] + dp1[i-2]);
            // 偷最后一个的时候，要看第一个是否被偷
            if (i != nums.length - 1) {
                dp2[i] = Math.max(dp2[i-1], nums[i] + dp2[i-2]);
            } else {
                dp2[i] = dp2[i-1];
            }
        }
        return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {2,3,2};
        int rob = solution.rob(nums);
        System.out.println(rob);
        Assert.assertEquals(3, rob);

        nums = new int[] {1,2,3,1};
        rob = solution.rob(nums);
        System.out.println(rob);
        Assert.assertEquals(4, rob);

        nums = new int[] {0};
        rob = solution.rob(nums);
        System.out.println(rob);
        Assert.assertEquals(0, rob);
    }
}
