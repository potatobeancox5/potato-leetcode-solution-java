package com.potato.study.leetcodecn.p00414.t001;

import org.junit.Assert;

import java.util.PriorityQueue;

/**
 * 414. 第三大的数
 *
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。

  

 示例 1：

 输入：[3, 2, 1]
 输出：1
 解释：第三大的数是 1 。
 示例 2：

 输入：[1, 2]
 输出：2
 解释：第三大的数不存在, 所以返回最大的数 2 。
 示例 3：

 输入：[2, 2, 3, 1]
 输出：1
 解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
 存在两个值为2的数，它们都排第二。
  

 提示：

 1 <= nums.length <= 104
 -231 <= nums[i] <= 231 - 1
  

 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/third-maximum-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 注意 可能有重复的数字 怎么办
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        if (null == nums) {
            return -1;
        }
        // 小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            // 处理重复数字
            if (priorityQueue.contains(num)) {
                continue;
            }
            if (priorityQueue.size() < 3) {
                priorityQueue.add(num);
                continue;
            }
            if (priorityQueue.peek() < num) {
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
        if (priorityQueue.size() == 3) {
            return priorityQueue.peek();
        }
        while (priorityQueue.size() > 1) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {2,2,3,1};
        int res = solution.thirdMax(nums);
        System.out.println(res);
        Assert.assertEquals(1, res);
    }
}
