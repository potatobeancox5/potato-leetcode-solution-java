package com.potato.study.leetcodecn.p00560.t002;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

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
     * 维护一个前缀和的 countMap
     * 使用 map 做优化
     * O（n） 时间复杂度
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // key 是 出现过的前缀和 value是 该前缀和出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        // 处理 012 组成前缀和的情况
        countMap.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            // prefixSum - prefixSumX == k
            int target = prefixSum - k;
            if (countMap.containsKey(target)) {
                count += countMap.get(target);
            }
            // 记录当前 prefixSum 的个数
            Integer currentCount = countMap.getOrDefault(prefixSum, 0);
            currentCount++;
            countMap.put(prefixSum, currentCount);
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
