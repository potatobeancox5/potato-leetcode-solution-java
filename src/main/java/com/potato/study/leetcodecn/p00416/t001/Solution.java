package com.potato.study.leetcodecn.p00416.t001;

import org.junit.Assert;

/**
 * 416. 分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution {

    /**
     * dp i j 使用 了 index = i 个数字，能达到 和为j的 bool true 能达到 j false 达到不了
     * dp ij = dpi-1j || dp i-1 j-num i
     * dp 0 0 = true
     * dp 0 nums0 = true
     *
     * 
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        if (max > half) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length][half + 1];
        dp[0][0] = true;
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < half + 1; j++) {
                if (!dp[i-1][j]) {
                    continue;
                }
                dp[i][j] = true;
                if (j + nums[i] > half) {
                    continue;
                }
                dp[i][j + nums[i]] = true;
            }
        }
        // 找到 dp half
        for (int i = 0; i < nums.length; i++) {
            if (dp[i][half]) {
                return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[] {
                1,5,11,5
        };
        boolean b = solution.canPartition(num);
        System.out.println(b);
        Assert.assertEquals(true, b);

        num = new int[] {
                1,2,3,5
        };
        b = solution.canPartition(num);
        System.out.println(b);
        Assert.assertEquals(false, b);

        num = new int[] {
                1
        };
        b = solution.canPartition(num);
        System.out.println(b);
        Assert.assertEquals(false, b);
    }
}
