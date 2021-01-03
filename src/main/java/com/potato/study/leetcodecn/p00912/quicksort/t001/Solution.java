package com.potato.study.leetcodecn.p00912.quicksort.t001;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 912. 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。

  

 示例 1：

 输入：nums = [5,2,3,1]
 输出：[1,2,3,5]
 示例 2：

 输入：nums = [5,1,1,2,0,0]
 输出：[0,0,1,1,2,5]
  

 提示：

 1 <= nums.length <= 50000
 -50000 <= nums[i] <= 50000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sort-an-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 实现快排
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        this.sortArrayByInterval(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 排序 数组 的 start - end 部分的数据 并返回
     * @param nums
     * @param start
     * @param end
     */
    private void sortArrayByInterval(int[] nums, int start, int end) {
        // 一个点 不需要排序
        if (start >= end) {
            return;
        }
        // 1. 选枢轴 并将 枢轴 放置到指定位置，返回 枢轴 左边
        int pivotIndex = getAndSetPivotPosition(nums, start, end);
        // 2. 递归 排序 start - 枢轴左边 ， 枢轴右边 - end 位置
        sortArrayByInterval(nums, start, pivotIndex - 1);
        sortArrayByInterval(nums, pivotIndex + 1, end);
    }

    /**
     *  选取枢轴 ，将枢轴放到 该放的位置 返回枢轴最终位置左边
     * @param nums      原始数组
     * @param start     排序开始位置
     * @param end       排序结束位置
     * @return  枢轴的位置
     */
    private int getAndSetPivotPosition(int[] nums, int start, int end) {
        // 1. 选 枢轴 简单选end 元素
        int pivot = nums[end];
        // 2. 从左边开始 保证 左边小于 枢轴
        int insertIndex = start;
        // start 位置 也需要进行交换，因为要保证insert 之前的数字都必须必pivot 小
        for (int i = start; i < end; i++) {
            // 如果 i位置 比枢轴小 那么放置到 insert位置
            if (nums[i] < pivot) {
                int tmp = nums[insertIndex];
                nums[insertIndex] = nums[i];
                nums[i] = tmp;

                insertIndex++;
            }
        }
        // 3. 将枢轴放到指定位置 枢轴的位置就是 目前insertIndex 的位置
        nums[end] = nums[insertIndex];
        nums[insertIndex] = pivot;

        return insertIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{5,2,3,1};
        int[] arr  = solution.sortArray(nums);
        // 1,2,3,5
        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{1,2,3,5}, arr);

        nums = new int[]{5,1,1,2,0,0};
        arr  = solution.sortArray(nums);
        // 0,0,1,1,2,5
        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{0,0,1,1,2,5}, arr);


        nums = new int[]{-1,2,-8,-10};
        arr  = solution.sortArray(nums);
        // 0,0,1,1,2,5
        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(new int[]{-10,-8,-1,2}, arr);
    }
}
