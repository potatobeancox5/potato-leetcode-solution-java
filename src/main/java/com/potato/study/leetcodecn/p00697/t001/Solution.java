package com.potato.study.leetcodecn.p00697.t001;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 *
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 示例 1:

 输入: [1, 2, 2, 3, 1]
 输出: 2
 解释:
 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 连续子数组里面拥有相同度的有如下所示:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 最短连续子数组[2, 2]的长度为2，所以返回2.
 示例 2:

 输入: [1,2,2,3,1,4,2]
 输出: 6
 注意:

 nums.length 在1到50,000区间范围内。
 nums[i] 是一个在0到49,999范围内的整数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/degree-of-an-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * map 计数 遍历 每次变更最大值
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        int maxNum = -1;
        if (null == nums) {
            return 0;
        }
        // key 是数字，value int[] 3个元素 index0 出现次数 index1 第一次出现的位置，index2 最后一次出现位置
        Map<Integer, int[]> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] numInfo = countMap.getOrDefault(nums[i], new int[]{0, i, i});
            // 计数
            numInfo[0]++;
            numInfo[2] = i;
            countMap.put(nums[i], numInfo);
            if (maxNum == -1 || countMap.get(maxNum)[0] < numInfo[0]) {
                maxNum = nums[i];
            }
        }
        if (maxNum < 0) {
            return 0;
        }
        // 输出最后的长度
        int[] info = countMap.get(maxNum);
        return info[2] - info[1] + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,2,3,1,4,2};
        int shortestSubArray = solution.findShortestSubArray(nums);
        System.out.println(shortestSubArray);
        Assert.assertEquals(6, shortestSubArray);
    }

}
