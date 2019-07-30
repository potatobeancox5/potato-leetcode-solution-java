package com.potato.study.leetcode.p0239;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *      239. Sliding Window Maximum
 * 
 *Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
1 [3  -1  -3] 5  3  6  7       3
1  3 [-1  -3  5] 3  6  7       5
1  3  -1 [-3  5  3] 6  7       5
1  3  -1  -3 [5  3  6] 7       6
1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 * 思路：
 *
 *  https://blog.csdn.net/jmspan/article/details/51073879
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        // 大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            // 前k 个计算
            if(i < k) {
                priorityQueue.add(nums[i]);
            }
            if (i == k -1) {
                res[0] = priorityQueue.peek();
            }
            if (i >= k) {
                priorityQueue.remove(nums[i - k]);
                priorityQueue.add(nums[i]);
                res[i - k + 1] = priorityQueue.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
