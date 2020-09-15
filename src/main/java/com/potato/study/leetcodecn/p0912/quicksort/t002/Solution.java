package com.potato.study.leetcodecn.p0912.quicksort.t002;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Random;

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
     * 实现快排 再来一遍 随机位置
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        sortArrayInterval(nums, 0, nums.length -1);
        return nums;
    }

    /**
     * 对数组 nums 从 start 位置 到 end 位置 进行排序
     * @param nums
     * @param start 都是 index
     * @param end
     */
    private void sortArrayInterval(int[] nums, int start, int end) {
        // 0 终止条件 1个元素 或者 下标非法
        if (start >= end) {
            return;
        }
        // 1. 选枢轴 返回枢轴位置 pivot
        int pivotIndex = getAndSetPivotPosition(nums, start, end);
        // 2. 递归排序 start - pivot - 1 ， pivot+1 - end
        sortArrayInterval(nums, start, pivotIndex -1);
        sortArrayInterval(nums, pivotIndex + 1, end);
    }

    /**
     * 安放枢轴位置 并返回index，枢轴选取 采用随机函数
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int getAndSetPivotPosition(int[] nums, int start, int end) {
        // 1. 选择枢轴
        Random random = new Random();
        // 保证能有 start 和 end的 返回
        int tmpPivotIndex = start + random.nextInt(end + 1 - start);
        // 记录枢轴 并将枢轴 交换到最后一个位置
        int pivot = nums[tmpPivotIndex];
        nums[tmpPivotIndex] = nums[end];
        nums[end] = pivot;
        // 2. 遍历 nums 将小于 枢轴的数字放在前边
        int swichIndex = start;
        for (int i = start; i < end; i++) {
            // 小于 枢轴的元素 交换到 swichIndex 位置
            if (nums[i] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[swichIndex];
                nums[swichIndex] = tmp;

                swichIndex++;
            }
        }
        // 3. 交换枢轴到正确index
        nums[end] = nums[swichIndex];
        nums[swichIndex] = pivot;
        // 4 返回枢轴 index
        return swichIndex;
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
