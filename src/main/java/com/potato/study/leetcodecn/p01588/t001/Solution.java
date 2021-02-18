package com.potato.study.leetcodecn.p01588.t001;

import org.junit.Assert;

/**
 * 1588. 所有奇数长度子数组的和
 *
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。

 子数组 定义为原数组中的一个连续子序列。

 请你返回 arr 中 所有奇数长度子数组的和 。

  

 示例 1：

 输入：arr = [1,4,2,5,3]
 输出：58
 解释：所有奇数长度子数组和它们的和为：
 [1] = 1
 [4] = 4
 [2] = 2
 [5] = 5
 [3] = 3
 [1,4,2] = 7
 [4,2,5] = 11
 [2,5,3] = 10
 [1,4,2,5,3] = 15
 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 示例 2：

 输入：arr = [1,2]
 输出：3
 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 示例 3：

 输入：arr = [10,11,12]
 输出：66
  

 提示：

 1 <= arr.length <= 100
 1 <= arr[i] <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 求前缀和 然后 遍历 前缀和 求 技术 子序列长度的和
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        long[] prefixSum = new long[arr.length];
        // 第一遍求前缀和，并且 可以直接求和
        long totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                prefixSum[i] = arr[i];
            } else {
                prefixSum[i] = arr[i] + prefixSum[i-1];
            }
            // 求包含这个元素的连续子序列 奇数长度的和
            for (int j = 1; j <= i; j+=2) {
                totalSum += (prefixSum[i] - prefixSum[i-j]);
            }
            if (i % 2 == 0) {
                totalSum += prefixSum[i];
            }
        }
        return (int)totalSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,4,2,5,3};
        int num = solution.sumOddLengthSubarrays(arr);
        System.out.println(num);
        Assert.assertEquals(58, num);


        arr = new int[]{1,2};
        num = solution.sumOddLengthSubarrays(arr);
        System.out.println(num);
        Assert.assertEquals(3, num);

        arr = new int[]{10,11,12};
        num = solution.sumOddLengthSubarrays(arr);
        System.out.println(num);
        Assert.assertEquals(66, num);
    }
}
