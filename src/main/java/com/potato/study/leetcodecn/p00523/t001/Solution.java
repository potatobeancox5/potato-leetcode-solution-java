package com.potato.study.leetcodecn.p00523.t001;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 *
 * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，
 * 其中 n 也是一个整数。

 示例 1：

 输入：[23,2,4,6,7], k = 6
 输出：True
 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 示例 2：

 输入：[23,2,6,4,7], k = 6
 输出：True
 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
  

 说明：

 数组的长度不会超过 10,000 。
 你可以认为所有数字总和在 32 位有符号整数范围内。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 前缀和 大小至少为2 怎么保证 缓存 上一个 prefixSum 在每次更新的时候才插入
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0;
        // key余数的值，value余数第一次出现的index -1 作为哨兵
        Map<Integer, Integer> remanderIndexMap = new HashMap<>();
        remanderIndexMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            // 放在这 更新 map 保证n大于等于2
            prefixSum += nums[i];

            int target = prefixSum;
            if (k != 0) {
                target = prefixSum % k;
            }
            // 从 map 中找到 k的余数 对应的次数
            if (remanderIndexMap.containsKey(target)) {
                Integer lastIndex = remanderIndexMap.get(target);
                if (i - lastIndex >= 2) {
                    return true;
                }
            } else {
                remanderIndexMap.put(target, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{23,2,4,6,7};
        int k = 6;
        boolean s = solution.checkSubarraySum(nums, k);
        System.out.println(s);
        Assert.assertEquals(true, s);

        nums = new int[]{23,2,6,4,7};
        k = 0;
        s = solution.checkSubarraySum(nums, k);
        System.out.println(s);
        Assert.assertEquals(false, s);
    }

}
