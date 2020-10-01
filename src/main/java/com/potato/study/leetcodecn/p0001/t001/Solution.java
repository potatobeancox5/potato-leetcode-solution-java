package com.potato.study.leetcodecn.p0001.t001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。



 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 *
 */
public class Solution {
    /**
     * 思路：
     * 1. 第一遍 hashSet 记录每个值
     * 2. 第二遍 对于 每个 taget 去 hash set里 找 （如果 差等于 原来那个数 那肯定是没有的 抛异常吧）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 1. 第一遍 hashMap 记录每个值2index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 2. 第二遍 对于 每个 taget 去 hash set map 里 找
        for (int i = 0; i < nums.length; i++) {
            // 限制条件不能有重复的数字
            int remind = target - nums[i];
            if (map.containsKey(remind)) {
                // 后一个总会覆盖前一个的
                if (map.get(remind) == i) {
                    continue;
                }
                return new int[]{i, map.get(remind)};
            }
        }
        // 异常情况
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,4};
        int target = 6;
        int[] sum = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(sum));


        nums = new int[]{3,3};
        target = 6;
        sum = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(sum));
    }
}
