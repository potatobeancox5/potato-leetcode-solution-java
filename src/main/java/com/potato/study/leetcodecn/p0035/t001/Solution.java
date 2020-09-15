package com.potato.study.leetcodecn.p0035.t001;

import org.junit.Assert;

/**
 * 35. 搜索插入位置
 *
 * 定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 你可以假设数组中无重复元素。

 示例 1:

 输入: [1,3,5,6], 5
 输出: 2
 示例 2:

 输入: [1,3,5,6], 2
 输出: 1
 示例 3:

 输入: [1,3,5,6], 7
 输出: 4
 示例 4:

 输入: [1,3,5,6], 0
 输出: 0

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-insert-position
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 找到第一个 大于等于这个数字（target）的位置
     * 找mid  mid < target 往后找
     * 否则 判断 是不是第一个位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 移位 优化
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //  mid 位置 大于等于target 有可能是第一个哦
                if (mid == 0 || nums[mid - 1] < target) {
                    // 第一个
                    return mid;
                } else {
                    // 不是第一个 往前找
                    right = mid - 1;
                }
            }
        }
        //  理论上走不到这
        return nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,3,5,6};
        int target = 5;
        int index = solution.searchInsert(nums, target);
        System.out.println(index);
        Assert.assertEquals(2, index);

        nums = new int[]{1,3,5,6};
        target = 2;
        index = solution.searchInsert(nums, target);
        System.out.println(index);
        Assert.assertEquals(1, index);


        nums = new int[]{1,3,5,6};
        target = 7;
        index = solution.searchInsert(nums, target);
        System.out.println(index);
        Assert.assertEquals(4, index);
    }
}
