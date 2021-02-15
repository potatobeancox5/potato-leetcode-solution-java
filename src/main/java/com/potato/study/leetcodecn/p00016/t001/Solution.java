package com.potato.study.leetcodecn.p00016.t001;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

  

 示例：

 输入：nums = [-1,2,1,-4], target = 1
 输出：2
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
  

 提示：

 3 <= nums.length <= 10^3
 -10^3 <= nums[i] <= 10^3
 -10^4 <= target <= 10^4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum-closest
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 完全没思路，要说正常的话 也就暴力 搜索 O3
     * 注意 数组中 肯定是有重复的数字 遇到 重复的数字 需要分析之前是不是搞过这个情况 搞过就别搞了
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        // 1. 排序 O nlongn
        Arrays.sort(nums);
        // 2. 对于每个点 i 使用两个指针 指向身后的点，并通过计算和，判断移动方向 每次移动都比较并记录最小值
        int closest = target + 20000;
        for (int i = 0; i < nums.length - 2; i++) {
            // 2.1 如果 当前非首元素 与之前的元素 相同，说明 这种情况之前遍历过 本次不考虑
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // 2.2 左右指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 2.3 因为数字有序 可以直接求和 计算 和与 target - nums[i] 关系决定
                int sum = nums[left] + nums[right];
                if (sum == target - nums[i]) {
                    return target;
                }
                // 比较记录最小值
                if (Math.abs(closest - target) > Math.abs(sum + nums[i] - target)) {
                    closest = sum + nums[i];
                }
                if (sum > target - nums[i]) {
                    right--;
                } else {
                    // sum < target - nums[i]
                    left++;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        int sum = solution.threeSumClosest(nums, target);
        System.out.println(sum);
        Assert.assertEquals(2, sum);


//        int[] nums = new int[]{-1,2,1,-4};
//        int target = 1;
//        int sum = solution.threeSumClosest(nums, target);
//        System.out.println(sum);
//        Assert.assertEquals(2, sum);
    }

}
