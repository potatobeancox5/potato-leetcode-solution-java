package com.potato.study.leetcodecn.p00164.t001;

import org.junit.Assert;

/**
 * 164. 最大间距
 *
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

 如果数组元素个数小于 2，则返回 0。

 示例 1:

 输入: [3,6,9,1]
 输出: 3
 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 示例 2:

 输入: [10]
 输出: 0
 解释: 数组元素个数小于 2，因此返回 0。
 说明:

 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-gap
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 遍历一遍 max min n个数
     那么最大距离一定大于 k
     max-min /n-1

     jiang max-min 分成 多个长度为k的区间

     所以区间内部不会出现 最大距离
     求每个区间最大 最小值

     比较两个区间之间max 和min 最大差距就是max
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        // 遍历一遍 max min n个数
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) {
            return 0;
        }

        // n 个数字，如果均匀分配有 n-1 个空间
        int n = nums.length;
        // 计算每个空间长度
        int length = (max - min) / (n-1);
        // 0 - min, 1 - max
        int[][] minMax = new int[n+1][2];
        for (int i = 0; i < minMax.length; i++) {
            minMax[i][0] = Integer.MAX_VALUE;
            minMax[i][1] = Integer.MIN_VALUE;

        }
        // 遍历nums 将 其中 每个 数字 num 定位到上述的空间中
        for (int num : nums) {
            int index = (num - min) / length;
            if (minMax[index] == null) {
                minMax[index] = new int[] {num, num};
            } else {
                minMax[index][0] = Math.min(minMax[index][0], num);
                minMax[index][1] = Math.max(minMax[index][1], num);
            }
        }
        // 遍历 之前 划分的空间 比较 该空间的最小值和 上一个空间最大值
        int maxGap = 0;
        int lastMax = minMax[0][1];
        for (int i = 1; i < minMax.length; i++) {
            if (minMax[i][0] != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, minMax[i][0] - lastMax);
                lastMax = minMax[i][1];
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {3,6,9,1};
        int gap = solution.maximumGap(nums);
        System.out.println(gap);
        Assert.assertEquals(3, gap);


        nums = new int[] {10};
        gap = solution.maximumGap(nums);
        System.out.println(gap);
        Assert.assertEquals(0, gap);


        nums = new int[] {1,1,1,1,1,5,5,5,5,5};
        gap = solution.maximumGap(nums);
        System.out.println(gap);
        Assert.assertEquals(4, gap);
    }
}
