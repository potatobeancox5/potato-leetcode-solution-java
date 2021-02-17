package com.potato.study.leetcodecn.p00031.t001;

import java.util.Arrays;

/**
 * 31. 下一个排列
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须 原地 修改，只允许使用额外常数空间。

  

 示例 1：

 输入：nums = [1,2,3]
 输出：[1,3,2]
 示例 2：

 输入：nums = [3,2,1]
 输出：[1,2,3]
 示例 3：

 输入：nums = [1,1,5]
 输出：[1,5,1]
 示例 4：

 输入：nums = [1]
 输出：[1]
  

 提示：

 1 <= nums.length <= 100
 0 <= nums[i] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/next-permutation
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 如果完全降序 ，按照升序排列
     * 2. 否则 找到
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // 找到最后一个 升序排列的位置 等同于 从后往前 找到第一个 大于 后边的位置
        int lastIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                lastIndex = i;
                break;
            }
        }
        // 如果没找到，直接返回 升序排列
        if (lastIndex == -1) {
            Arrays.sort(nums);
            return;
        }
        // 找到了 按照下列算法计算 lastIndex 之后 最接近的 大于 这个位置的数字，找到 lastIndex++ 原来的位置 放入 lastIndex位置上面的元素，将 lastIndex位置之后数字排序
        int target = nums[lastIndex];
        // 找到第一个 大于 target 的最小的位置
        int minIndex = lastIndex + 1;
        for (int i = lastIndex + 2; i < nums.length; i++) {
            // 最接近 minIndex
            if (target < nums[i] && nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        // 交换 lastIndex 和 minIndex
        int temp = nums[lastIndex];
        nums[lastIndex] = nums[minIndex];
        nums[minIndex] = temp;
        Arrays.sort(nums, lastIndex + 1, nums.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,2,3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {3,2,1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1,1,5};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
