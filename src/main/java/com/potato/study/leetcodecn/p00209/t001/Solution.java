package com.potato.study.leetcodecn.p00209.t001;

import org.junit.Assert;

/**
 * 209. 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。

  

 示例：

 输入：s = 7, nums = [2,3,1,2,4,3]
 输出：2
 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
  

 进阶：

 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 滑动窗口
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int left = -1;
        int right = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 加上当前值
            sum += nums[i];
            if (left == -1) {
                left = i;
            }
            right = i;
            while (sum >= s) {
                min = Math.min(min, right - left + 1);
                if (sum - nums[left] >= s) {
                    sum -= nums[left];
                    left++;
                } else {
                    break;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = 7;
        int[] nums = new int[] {2,3,1,2,4,3};
        int res = solution.minSubArrayLen(s, nums);
        System.out.println(res);
        Assert.assertEquals(2, res);
    }
}
