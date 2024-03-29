package com.potato.study.leetcodecn.p01438.t001;

import org.junit.Assert;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 *
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。

 如果不存在满足条件的子数组，则返回 0 。

  

 示例 1：

 输入：nums = [8,2,4,7], limit = 4
 输出：2
 解释：所有子数组如下：
 [8] 最大绝对差 |8-8| = 0 <= 4.
 [8,2] 最大绝对差 |8-2| = 6 > 4.
 [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 [2] 最大绝对差 |2-2| = 0 <= 4.
 [2,4] 最大绝对差 |2-4| = 2 <= 4.
 [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 [4] 最大绝对差 |4-4| = 0 <= 4.
 [4,7] 最大绝对差 |4-7| = 3 <= 4.
 [7] 最大绝对差 |7-7| = 0 <= 4.
 因此，满足题意的最长子数组的长度为 2 。
 示例 2：

 输入：nums = [10,1,2,4,7,2], limit = 5
 输出：4
 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 示例 3：

 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 输出：3
  

 提示：

 1 <= nums.length <= 10^5
 1 <= nums[i] <= 10^9
 0 <= limit <= 10^9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 滑动庄口 nums。lem - limit
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int minWindow = Integer.MAX_VALUE;
        int total = 0;
        int windowLen = 0;
        int windowTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            windowLen++;
            windowTotal += nums[i];
            if (windowLen > nums.length - limit) {
                windowTotal -= nums[i - windowLen];
                windowLen--;
            }
            if (windowLen == nums.length - limit) {
                minWindow = Math.min(minWindow, windowTotal);
            }
        }
        return total - minWindow;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[] {1,0,0,0,1,0,0,1};
//        int k = 2;
//        boolean res = solution.kLengthApart(nums, k);
//        System.out.println(res);
//        Assert.assertEquals(true, res);
//
//        nums = new int[] {1,0,0,1,0,1};
//        k = 2;
//        res = solution.kLengthApart(nums, k);
//        System.out.println(res);
//        Assert.assertEquals(false, res);
//
//
//        nums = new int[] {0,1, 0,0,1,0,0,};
//        k = 2;
//        res = solution.kLengthApart(nums, k);
//        System.out.println(res);
//        Assert.assertEquals(true, res);
//    }
}
