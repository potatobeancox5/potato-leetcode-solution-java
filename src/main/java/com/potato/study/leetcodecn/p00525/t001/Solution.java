package com.potato.study.leetcodecn.p00525.t001;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 *
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。

  

 示例 1:

 输入: nums = [0,1]
 输出: 2
 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 示例 2:

 输入: nums = [0,1,0]
 输出: 2
 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
  

 提示：

 1 <= nums.length <= 105
 nums[i] 不是 0 就是 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/contiguous-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     *
     * 用一个 map 记录达到 val 时 第一次的位置

     遍历数组 1的时候加加 0的时候减减

     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        // 用一个 map 记录达到 val 时 第一次的位置
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组 1的时候加加 0的时候减减 如果计算的值 不在map里边 就插入map
        int current = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                current--;
            } else {
                current++;
            }
            if (!map.containsKey(current)) {
                map.put(current, i);
            } else {
                Integer lastIndex = map.get(current);
                max = Math.max(i - lastIndex, max);
            }
            if (current == 0) {
                max = Math.max(i + 1, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {
                0,1
        };
        int maxLength = solution.findMaxLength(nums);
        System.out.println(maxLength);
        Assert.assertEquals(2, maxLength);


        nums = new int[] {
                0,1,0
        };
        maxLength = solution.findMaxLength(nums);
        System.out.println(maxLength);
        Assert.assertEquals(2, maxLength);
    }
}
