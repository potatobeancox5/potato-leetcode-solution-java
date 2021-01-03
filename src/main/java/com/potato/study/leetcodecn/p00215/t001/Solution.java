package com.potato.study.leetcodecn.p00215.t001;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:

 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
 说明:

 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 小顶堆 先放k哥元素 如果i比堆顶大 删除堆顶 插入i
     * 最终返回堆顶
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 默认就是小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        // k 开始
        for (int i = k; i < nums.length; i++) {
            if (priorityQueue.peek() < nums[i]) {
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {

    }
}
