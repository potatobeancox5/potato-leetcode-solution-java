package com.potato.study.leetcodecn.p01877.t001;

import java.util.Arrays;

import org.junit.Assert;

/**
 * 1877. 数组中最大数对和的最小值
 *
 * 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
 *
 * 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
 * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
 *
 * nums 中每个元素 恰好 在 一个 数对中，且
 * 最大数对和 的值 最小 。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,5,2,3]
 * 输出：7
 * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
 * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
 * 示例 2：
 *
 * 输入：nums = [3,5,4,2,4,6]
 * 输出：8
 * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
 * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 2 <= n <= 105
 * n 是 偶数 。
 * 1 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
     * 数据推导看 上面那个链接
     * 经过推理 第一个和最后一个组成一组，依次类推这种的最大数对和是最小的
     * 因此
     * 1. nums 进行排序
     * 2. 按照上面说的 组合方式 记录最大值
     * @param nums
     * @return
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(max, nums[i] + nums[nums.length - 1 - i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {
                3,5,2,3
        };
        int i = solution.minPairSum(nums);
        System.out.println(i);
        Assert.assertEquals(7, i);

        nums = new int[] {
                3,5,4,2,4,6
        };
        i = solution.minPairSum(nums);
        System.out.println(i);
        Assert.assertEquals(8, i);
    }
}
