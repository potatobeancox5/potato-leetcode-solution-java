package com.potato.study.leetcodecn.p01014.t001;

import org.junit.Assert;

/**
 * 1014. 最佳观光组合
 *
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。

 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。

 返回一对观光景点能取得的最高分。

  

 示例 1：

 输入：values = [8,1,5,2,6]
 输出：11
 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 示例 2：

 输入：values = [1,2]
 输出：2
  

 提示：

 2 <= values.length <= 5 * 104
 1 <= values[i] <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int[] sum = new int[values.length];
        int[] minus = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            sum[i] = values[i] + i;
            minus[i] = values[i] - i;
        }
        // left 从左边开始 最大值 rihgt 是右边开始 最小值 到i
        int[] left = new int[values.length];
        left[0] = sum[0];
        for (int i = 1; i < values.length; i++) {
            left[i] = Math.max(left[i-1], sum[i]);
        }
        int[] right = new int[values.length];
        right[values.length - 1] = minus[values.length - 1];
        for (int i = values.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], minus[i]);
        }
        int max = 0;
        for (int i = 0; i < values.length - 1; i++) {
            max = Math.max(left[i] + right[i + 1], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {
                8,1,5,2,6
        };
        int i = solution.maxScoreSightseeingPair(arr);
        System.out.println(i);
        Assert.assertEquals(11, i);
    }
}
