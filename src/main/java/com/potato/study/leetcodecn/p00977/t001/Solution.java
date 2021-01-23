package com.potato.study.leetcodecn.p00977.t001;

/**
 * 977. 有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

  

 示例 1：

 输入：nums = [-4,-1,0,3,10]
 输出：[0,1,9,16,100]
 解释：平方后，数组变为 [16,1,0,9,100]
 排序后，数组变为 [0,1,9,16,100]
 示例 2：

 输入：nums = [-7,-3,2,3,11]
 输出：[4,9,9,49,121]
  

 提示：

 1 <= nums.length <= 104
 -104 <= nums[i] <= 104
 nums 已按 非递减顺序 排序
  

 进阶：

 请你设计时间复杂度为 O(n) 的算法解决本问题

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 找到 0点
     * 分别往左右进行计算
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[index]) > Math.abs(nums[i])){
                index = i;
            }
        }
        int[] res = new int[nums.length];
        int insertIndex = 0;
        res[insertIndex++] = nums[index] * nums[index];
        int left = index - 1;
        int right = index + 1;
        // 比较 最小的
        while (left >= 0 && right < nums.length) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[insertIndex++] = nums[right] * nums[right];
                right++;
            } else {
                res[insertIndex++] = nums[left] * nums[left];
                left--;
            }
        }
        while (left >= 0) {
            res[insertIndex++] = nums[left] * nums[left];
            left--;
        }
        while (right < nums.length) {
            res[insertIndex++] = nums[right] * nums[right];
            right++;
        }
        return res;
    }


}
