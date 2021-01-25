package com.potato.study.leetcodecn.p00560.t001;


import org.junit.Assert;

/**
 * 560. 和为K的子数组
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

 示例 1 :

 输入:nums = [1,1,1], k = 2
 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 说明 :

 数组的长度为 [1, 20,000]。
 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 维护一个前缀和数组，然后遍历这个数组，n*n 依次求两个元素的差计数
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (null == nums) {
            return 0;
        }
        // 计算前缀和
        int[] prefixSum = new int[nums.length+1];
        int sum = 0;
        // 第一个sum 为哨兵
        prefixSum[0] = sum;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i+1] = sum;
        }
        // 依次遍历计算 差是否为k
        int count = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i+1; j < prefixSum.length; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,1,1};
        int k = 2;
        int count = solution.subarraySum(nums, k);
        System.out.println(count);
        Assert.assertEquals(2, count);

        nums = new int[] {1};
        k = 1;
        count = solution.subarraySum(nums, k);
        System.out.println(count);
        Assert.assertEquals(1, count);
    }
}
