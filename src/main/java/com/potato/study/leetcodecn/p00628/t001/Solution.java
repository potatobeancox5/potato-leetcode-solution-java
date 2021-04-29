package com.potato.study.leetcodecn.p00628.t001;


import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 628. 三个数的最大乘积
 *
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

  

 示例 1：

 输入：nums = [1,2,3]
 输出：6
 示例 2：

 输入：nums = [1,2,3,4]
 输出：24
 示例 3：

 输入：nums = [-1,-2,-3]
 输出：-6
  

 提示：

 3 <= nums.length <= 104
 -1000 <= nums[i] <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 排序 取最后三个数 乘积 或者 最开始2个数与 最后的数字乘积
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        if (null == nums || nums.length < 3) {
            return 0;
        }
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int result1 = nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
        int result2 = nums[nums.length-1] * nums[0] * nums[1];
        return result1 > result2 ? result1 : result2;
    }

}
