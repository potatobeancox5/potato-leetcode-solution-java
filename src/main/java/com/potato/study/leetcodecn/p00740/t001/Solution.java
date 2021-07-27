package com.potato.study.leetcodecn.p00740.t001;

import org.junit.Assert;

/**
 * 740. 删除并获得点数
 *
 * 给你一个整数数组 nums ，你可以对它进行一些操作。

 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。

 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。

  

 示例 1：

 输入：nums = [3,4,2]
 输出：6
 解释：
 删除 4 获得 4 个点数，因此 3 也被删除。
 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 示例 2：

 输入：nums = [2,2,3,3,3,4]
 输出：9
 解释：
 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 总共获得 9 个点数。
  

 提示：

 1 <= nums.length <= 2 * 104
 1 <= nums[i] <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/delete-and-earn
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 统计sum i i的和
     *
     * dp i 到i最多多少
     *
     * dp i= max dpi-2+ sumi， dp
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];
        for (int num : nums) {
            sum[num] += num;
        }
        int[] dp = new int[10001];
        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = sum[1];
                continue;
            }
            dp[i] = Math.max(dp[i-1], dp[i-2] + sum[i]);
        }
        return dp[10000];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {
                3,4,2
        };
        int i = solution.deleteAndEarn(arr);
        System.out.println(i);
        Assert.assertEquals(6, i);

        arr = new int[] {
                2,2,3,3,3,4
        };
        i = solution.deleteAndEarn(arr);
        System.out.println(i);
        Assert.assertEquals(9, i);
    }
}
