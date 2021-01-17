package com.potato.study.leetcodecn.p01464.t001;

import org.junit.Assert;

import java.util.PriorityQueue;

/**
 * 1464. 数组中两元素的最大乘积
 *
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。

 请你计算并返回该式的最大值。

  

 示例 1：

 输入：nums = [3,4,5,2]
 输出：12
 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 示例 2：

 输入：nums = [1,5,4,5]
 输出：16
 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 示例 3：

 输入：nums = [3,7]
 输出：12
  

 提示：

 2 <= nums.length <= 500
 1 <= nums[i] <= 10^3
 通过次数18,965提交次数24,600

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 找到最大值和次大值
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        // 小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(2);
        for (int num : nums) {
            if (priorityQueue.size() < 2) {
                priorityQueue.add(num);
                continue;
            }
            Integer peek = priorityQueue.peek();
            if (num > peek) {
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
        Integer ele1 = priorityQueue.poll();
        Integer ele2 = priorityQueue.poll();
        return (ele1 -1) * (ele2 -1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,4,5,2};
        int i = solution.maxProduct(nums);
        System.out.println(i);
        Assert.assertEquals(12, i);
    }
}
