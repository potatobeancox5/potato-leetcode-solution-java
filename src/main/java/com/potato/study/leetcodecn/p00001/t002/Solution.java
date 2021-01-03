package com.potato.study.leetcodecn.p00001.t002;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
     * 1. 遍历nums hash map 记录 num index list
     * 2. 遍历 nums num 在map 中找 num - target ，
     *      if num == num - target 看map 是否list 长度大于2
     *
     *
     * nums 中可能有不同的元素
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> num2IndexListMap = new HashMap<>();
        // 1. 遍历nums hash map 记录 num index list
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexList = num2IndexListMap.getOrDefault(nums[i], new ArrayList<>());
            indexList.add(i);

            num2IndexListMap.put(nums[i], indexList);
        }
        // 2.遍历 nums num 在map 中找 num - target ，
        for (int i = 0; i < nums.length; i++) {
            int remind = target - nums[i];
            if (num2IndexListMap.containsKey(remind)) {
                List<Integer> indexList = num2IndexListMap.get(remind);
                if (remind == nums[i]) {
                    if (indexList.size() >= 2) {
                        return new int[]{indexList.get(0), indexList.get(1)};
                    }
                } else {
                    return new int[]{i, indexList.get(0)};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,4};
        int target = 6;
        int[] sum = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(sum));
        Assert.assertArrayEquals(new int[]{1, 2}, sum);


        nums = new int[]{3,3};
        target = 6;
        sum = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(sum));
        Assert.assertArrayEquals(new int[]{0, 1}, sum);
    }
}
