package com.potato.study.leetcodecn.p01671.t001;

import java.util.Arrays;

import org.junit.Assert;

/**
 * 1671. 得到山形数组的最少删除次数
 *
 * 我们定义 arr 是 山形数组 当且仅当它满足：
 *
 * arr.length >= 3
 * 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给你整数数组 nums​ ，请你返回将 nums 变成 山形状数组 的​ 最少 删除次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,1]
 * 输出：0
 * 解释：数组本身就是山形数组，所以我们不需要删除任何元素。
 * 示例 2：
 *
 * 输入：nums = [2,1,1,5,6,2,3,1]
 * 输出：3
 * 解释：一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
 * 示例 3：
 *
 * 输入：nums = [4,3,2,1,1,2,3,1]
 * 输出：4
 * 提示：
 *
 * 输入：nums = [1,2,3,4,4,3,2,1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * 1 <= nums[i] <= 109
 * 题目保证 nums 删除一些元素后一定能得到山形数组。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-removals-to-make-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 1671
    public int minimumMountainRemovals(int[] nums) {
        // 使用 left 和 right 维护 最长增加序列 初始化都是 1
        int[] left = new int[nums.length];
        // 每个位置 至少有一个长短
        Arrays.fill(left, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 闪灯和山脚都是开区间
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[j]+1, left[i]);
                }
            }
        }
        int[] right = new int[nums.length];
        Arrays.fill(right, 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                // 闪灯和山脚都是开区间
                if (nums[i] > nums[j]) {
                    right[i] = Math.max(right[j]+1, right[i]);
                }
            }
        }
        // 然后遍历 left 和 right 找到最大值
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left[i] == 1 || right[i] == 1) {
                continue;
            }
            max = Math.max(max, left[i] + right[i]);
        }
        // 返回最小删除的就是 长度减去最大值
        return nums.length - max + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[] {
                1,3,1
        };
        int i = solution.minimumMountainRemovals(num);
        System.out.println(i);
        Assert.assertEquals(0, i);


        num = new int[] {
                2,1,1,5,6,2,3,1
        };
        i = solution.minimumMountainRemovals(num);
        System.out.println(i);
        Assert.assertEquals(3, i);

        // [9,8,1,7,6,5,4,3,2,1]
        num = new int[] {
                9,8,1,7,6,5,4,3,2,1
        };
        i = solution.minimumMountainRemovals(num);
        System.out.println(i);
        Assert.assertEquals(2, i);
    }

}
