package com.potato.study.leetcodecn.p00152.t001;

import org.junit.Assert;

/**
 * 152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

  

 示例 1:

 输入: [2,3,-2,4]
 输出: 6
 解释: 子数组 [2,3] 有最大乘积 6。
 示例 2:

 输入: [-2,0,-1]
 输出: 0
 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * max i 以i结尾 的子数组 最大乘积
     * min i 以i结尾 的子数组 最小乘积
     * 上述 数组 index = 0 时 值为 nums[0]
     * max i = max {nums[i], nums[i] * max, nums[i] * min}
     * min i = min {nums[i], nums[i] * max, nums[i] * min}
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        // init
        max[0] = nums[0];
        min[0] = nums[0];
        int totalMax = max[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], Math.max(nums[i] * max[i-1], nums[i] * min[i-1]));
            min[i] = Math.min(nums[i], Math.min(nums[i] * max[i-1], nums[i] * min[i-1]));
            totalMax = Math.max(totalMax, max[i]);
        }
        return totalMax;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,3,-2,4};
        int min = solution.maxProduct(arr);
        System.out.println(min);
        Assert.assertEquals(6, min);


        arr = new int[]{-2,0,-1};
        min = solution.maxProduct(arr);
        System.out.println(min);
        Assert.assertEquals(0, min);

        arr = new int[]{-1,-2,-9,-6};
        min = solution.maxProduct(arr);
        System.out.println(min);
        Assert.assertEquals(108, min);
//
//
//        arr = new int[]{1};
//        min = solution.findMin(arr);
//        System.out.println(min);
//        Assert.assertEquals(1, min);
//
//        arr = new int[]{11,13,15,17};
//        min = solution.findMin(arr);
//        System.out.println(min);
//        Assert.assertEquals(11, min);
//
//
//        arr = new int[]{4,5,1,2,3};
//        min = solution.findMin(arr);
//        System.out.println(min);
//        Assert.assertEquals(1, min);
    }
}
