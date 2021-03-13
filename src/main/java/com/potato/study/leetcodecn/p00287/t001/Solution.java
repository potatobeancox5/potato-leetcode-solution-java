package com.potato.study.leetcodecn.p00287.t001;


import org.junit.Assert;

/**
 * 287. 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

  

 示例 1：

 输入：nums = [1,3,4,2,2]
 输出：2
 示例 2：

 输入：nums = [3,1,3,4,2]
 输出：3
 示例 3：

 输入：nums = [1,1]
 输出：1
 示例 4：

 输入：nums = [1,1,2]
 输出：1
  

 提示：

 2 <= n <= 3 * 104
 nums.length == n + 1
 1 <= nums[i] <= n
 nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
  

 进阶：

 如何证明 nums 中至少存在一个重复的数字?
 你可以在不修改数组 nums 的情况下解决这个问题吗？
 你可以只用常量级 O(1) 的额外空间解决这个问题吗？
 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     * 使用数组 记录 出现过的数
     * 二分法
     * 基于技术 因为  1 <= nums[i] <= n
     * 那么可以认为
     *  如果 数字 i 小于 nums中小于等于 i 的数字 与 小于 i 说明 重复的肯定在 【i+1 到n】 left = mid + 1
     *  如果 数字 nums中 小于等于 i的数字 个数 比 i 多 说明 重复发生在 【left - mid】 这    right = mid
     *
     * 如何计算mid  left + right  )/ 2 极端情况  2 3 mid = 2    3 3 mid = 3
     * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {

        int left = 1;
        // 注意 题目是 n+1的长度
        int right = nums.length - 1;

        // 超过 2个 数字位置就是没有确定
        int cnt;
        while (left < right) {
            // 遍历 计数 小于等于 target的个数 使用无符号右移 移除时也能正确
            int mid = (left + right) >>> 1;
            cnt = countNum(nums, mid);
            if (cnt > mid) {
                // 如果当前数量 比 位置多 说明 1233 123 那一定是这样
                right = mid;
            } else {
                // 如果 当前数量比 值小 或者等于，说明问题一定出在后边 1233 123   or 1244 12  当前数字为 3
                left = mid + 1;
            }
        }
        // 终止条件 是 left == right
        return left;
    }

    /**
     * 计算 nums 中 小于等于 mid 的个数
     * @param nums
     * @param mid
     * @return
     */
    private int countNum(int[] nums, int mid) {
        int count = 0;
        for (int num : nums) {
            if (num <= mid) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {
                1,3,4,2,2
        };
        int duplicate = solution.findDuplicate(arr);
        System.out.println(duplicate);
        Assert.assertEquals(2, duplicate);


        arr = new int[] {
                3,1,3,4,2
        };
        duplicate = solution.findDuplicate(arr);
        System.out.println(duplicate);
        Assert.assertEquals(3, duplicate);
    }


}
