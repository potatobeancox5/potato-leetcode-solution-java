package com.potato.study.leetcodecn.p01887.t001;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Assert;

/**
 * 1887. 使数组元素相等的减少操作次数
 *
 * 给你一个整数数组 nums ，你的目标是令 nums 中的所有元素相等。完成一次减少操作需要遵照下面的几个步骤：
 *
 * 找出 nums 中的 最大 值。记这个值为 largest 并取其下标 i （下标从 0 开始计数）。如果有多个元素都是最大值，则取最小的 i 。
 * 找出 nums 中的 下一个最大 值，这个值 严格小于 largest ，记为 nextLargest 。
 * 将 nums[i] 减少到 nextLargest 。
 * 返回使 nums 中的所有元素相等的操作次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,1,3]
 * 输出：3
 * 解释：需要 3 次操作使 nums 中的所有元素相等：
 * 1. largest = 5 下标为 0 。nextLargest = 3 。将 nums[0] 减少到 3 。nums = [3,1,3] 。
 * 2. largest = 3 下标为 0 。nextLargest = 1 。将 nums[0] 减少到 1 。nums = [1,1,3] 。
 * 3. largest = 3 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 * 解释：nums 中的所有元素已经是相等的。
 * 示例 3：
 *
 * 输入：nums = [1,1,2,2,3]
 * 输出：4
 * 解释：需要 4 次操作使 nums 中的所有元素相等：
 * 1. largest = 3 下标为 4 。nextLargest = 2 。将 nums[4] 减少到 2 。nums = [1,1,2,2,2] 。
 * 2. largest = 2 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1,2,2] 。
 * 3. largest = 2 下标为 3 。nextLargest = 1 。将 nums[3] 减少到 1 。nums = [1,1,1,1,2] 。
 * 4. largest = 2 下标为 4 。nextLargest = 1 。将 nums[4] 减少到 1 。nums = [1,1,1,1,1] 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * 1 <= nums[i] <= 5 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reduction-operations-to-make-the-array-elements-equal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * 每次都要将 最大值 变更的次大值，最后变成到最小值  达到都相等的状态
     *
     * 那么 我们先记录，每个值出现的次数
     *
     * 假设 最大值 到 最小值 出现次数依次为
     *
     * X1，x2,x3…….xk
     * 那么 总的 次数等于
     *
     * X1 + (x1 + x2) + (x1 + x2 +x3)  … (x1 + x2 +x3 + … + xk-1) (将 所有的都变成最小值)
     *
     * 整理等于
     *
     *
     * X1 * （k-1） + x2 * （k-2） + x3 * （k-3）….. x k-1 * 1
     * @param nums
     * @return
     */
    public int reductionOperations(int[] nums) {
        java.util.SortedMap<Integer, Integer> map = new java.util.TreeMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        // 默认 从小到大 排序的map 计算 总大小
        int sum = 0;
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 最小的不用移动
            if (index == 0) {
                index++;
                continue;
            }
            int count = entry.getValue();
            sum += count * index;
            index++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {5,1,3};
        int i = solution.reductionOperations(nums);
        System.out.println(i);
        Assert.assertEquals(3, i);

        nums = new int[] {1,1,1};
        i = solution.reductionOperations(nums);
        System.out.println(i);
        Assert.assertEquals(0, i);

        nums = new int[] {1,1,2,2,3};
        i = solution.reductionOperations(nums);
        System.out.println(i);
        Assert.assertEquals(4, i);
    }

}