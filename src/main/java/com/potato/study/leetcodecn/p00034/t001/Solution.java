package com.potato.study.leetcodecn.p00034.t001;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果数组中不存在目标值，返回 [-1, -1]。

 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: [3,4]
 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: [-1,-1]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 分别 找到第一个 和最后一个位置
     * 不存在 返回 -1.-1
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        // 找第一个位置
        int firstIndex = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 移位 优化
            int mid = left + ((right - left) >> 1);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                // 相等 判断是不是第一个出现的位置
                if (mid == 0 || nums[mid - 1] != target) {
                    firstIndex = mid;
                    break;
                } else {
                    // 不是 还得往前找
                    right = mid - 1;
                }
            }
        }
        // 找最后一个位置
        int lastIndex = -1;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            // 移位 优化
            int mid = left + ((right - left) >> 1);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                // 相等 判断是不是最后一个出现的位置 不是 还得往后找
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    lastIndex = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }
        // 处理 返回
        return new int[] {firstIndex, lastIndex};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] indexPair = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(indexPair));
        Assert.assertEquals(Arrays.toString(new int[]{3, 4}), Arrays.toString(indexPair));

        target = 6;
        indexPair = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(indexPair));
        Assert.assertEquals(Arrays.toString(new int[]{-1, -1}), Arrays.toString(indexPair));

        nums = new int[]{2, 2};
        target = 2;
        indexPair = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(indexPair));
        Assert.assertEquals(Arrays.toString(new int[]{0, 1}), Arrays.toString(indexPair));
    }
}
