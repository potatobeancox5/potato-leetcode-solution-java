package com.potato.study.leetcodecn.p00494.t001;

import org.junit.Assert;

/**
 * 494. 目标和
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

  

 示例：

 输入：nums: [1, 1, 1, 1, 1], S: 3
 输出：5
 解释：

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 一共有5种方法让最终目标和为3。
  

 提示：

 数组非空，且长度不会超过 20 。
 初始的数组的和不会超过 1000 。
 保证返回的最终结果能被 32 位整数存下。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/target-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dfs 对于 每个 nums的位置 分别使用 + - 进行计算
     *
     * @param nums
     * @param s
     * @return
     */
    public int findTargetSumWays(int[] nums, int s) {
        if (null == nums) {
            return s == 0 ? 1 : 0;
        }
        return findTargetSumWays(nums, s, 0, 0, false)
                + findTargetSumWays(nums, s, 0, 0, true);
    }


    /**
     *
     * @param nums
     * @param s
     * @param index     当前需要访问的点
     * @param current   当前累计和
     * @param negative  是否是 负数
     * @return
     */
    private int findTargetSumWays(int[] nums, int s, int index, int current, boolean negative) {
        if (nums.length == index) {
            if (s == current && !negative) {
                return 1;
            } else {
                return 0;
            }
        }
        // 计算当前的点
        if (negative) {
            current -= nums[index];
        } else {
            current += nums[index];
        }
        // 获取两个孩子的种类数 然后返回
        int sum = findTargetSumWays(nums, s, index + 1, current, false);
        sum += findTargetSumWays(nums, s, index + 1, current, true);
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 1, 1, 1, 1};
        int s = 3;
        int ways = solution.findTargetSumWays(nums, s);
        System.out.println(ways);
        Assert.assertEquals(5, ways);

//        int[] nums = new int[] {1, 1, 1, 1, 1};
//        int s = 3;
//        int ways = solution.findTargetSumWays(nums, s);
//        System.out.println(ways);
//        Assert.assertEquals(5, ways);
    }

}
