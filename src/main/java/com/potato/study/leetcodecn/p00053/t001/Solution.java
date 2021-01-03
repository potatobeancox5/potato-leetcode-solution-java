package com.potato.study.leetcodecn.p00053.t001;


import org.junit.Assert;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4]
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 进阶:

 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-subarray
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * fi 选择当前位置 能获得的最大子序列和
     * fi = max i， i+ f i-1
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(nums[i], f[i-1] + nums[i]);
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int res = solution.maxSubArray(arr);
        System.out.println(res);
        Assert.assertEquals(6, res);
    }
}
