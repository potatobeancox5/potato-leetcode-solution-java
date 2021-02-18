package com.potato.study.leetcodecn.p01752.t001;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 1752. 检查数组是否经排序和轮转得到
 *
 * 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。

 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。

 源数组中可能存在 重复项 。

 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。

  

 示例 1：

 输入：nums = [3,4,5,1,2]
 输出：true
 解释：[1,2,3,4,5] 为有序的源数组。
 可以轮转 x = 3 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
 示例 2：

 输入：nums = [2,1,3,4]
 输出：false
 解释：源数组无法经轮转得到 nums 。
 示例 3：

 输入：nums = [1,2,3]
 输出：true
 解释：[1,2,3] 为有序的源数组。
 可以轮转 x = 0 个位置（即不轮转）得到 nums 。
 示例 4：

 输入：nums = [1,1,1]
 输出：true
 解释：[1,1,1] 为有序的源数组。
 轮转任意个位置都可以得到 nums 。
 示例 5：

 输入：nums = [2,1]
 输出：true
 解释：[1,2] 为有序的源数组。
 可以轮转 x = 5 个位置，使新数组从值为 2 的元素开始：[2,1] 。
  

 提示：

 1 <= nums.length <= 100
 1 <= nums[i] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/check-if-array-is-sorted-and-rotated
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param nums
     * @return
     */
    public boolean check(int[] nums) {
        // A[i] == B[(i+x) % A.length]
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        // x从 0 到 A.length
        for (int x = 0; x < nums.length; x++) {
            boolean match = true;
            for (int i = 0; i < nums.length; i++) {
                if (copy[i] != nums[(i+x) % nums.length]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {3,4,5,1,2};
        boolean res = solution.check(nums);
        System.out.println(res);
        Assert.assertEquals(true, res);

        nums = new int[] {2,1,3,4};
        res = solution.check(nums);
        System.out.println(res);
        Assert.assertEquals(false, res);

        nums = new int[] {1,2,3};
        res = solution.check(nums);
        System.out.println(res);
        Assert.assertEquals(true, res);

    }
}
