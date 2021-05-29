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
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (null == nums || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        if (canPartition(nums, 0, sum / 2, 0)) {
            return true;
        }
        return false;
    }


    /**
     *
     * @param nums
     * @param index
     * @param targetSum
     * @param currentSum
     * @return
     */
    private boolean canPartition(int[] nums, int index, int targetSum, int currentSum) {
        if (index >= nums.length) {
            return false;
        }
        // 1 <= nums[i] <= 100 因为
        if (currentSum > targetSum) {
            return false;
        } else if (targetSum == currentSum) {
            return true;
        }
        // 剩下小于的情况了
        return canPartition(nums, index+1, targetSum, currentSum + nums[index])
                || canPartition(nums, index+1, targetSum, currentSum);
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
    }
}
