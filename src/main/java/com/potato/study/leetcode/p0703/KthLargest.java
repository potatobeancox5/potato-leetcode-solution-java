package com.potato.study.leetcode.p0703;

import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	703. Kth Largest Element in a Stream
 *
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note:
You may assume that nums' length ≥ k-1 and k ≥ 1.
 *         
 *         题目解释：
 *          向二叉搜索树中插入一个值
 *         思路：
 *          小根堆 比较当前值与根
 *          大于根 放入堆中 删除根
 *         
 *
 *
 * 
 */
public class KthLargest {

    private PriorityQueue<Integer> priorityQueue;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(k);
        // 初始化成最小根堆
        for (int i = 0; i < k; i++) {
            priorityQueue.add(Integer.MIN_VALUE);
        }
        if (null == nums || nums.length == 0) {

        }
        for (int num : nums) {
            if (priorityQueue.peek() < num) {
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
    }

    public int add(int val) {
        if (priorityQueue.peek() < val) {
            int returnVal = priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }


    public static void main(String[] args) {

        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(3));// returns 4
        System.out.println(kthLargest.add(5));// returns 5
        System.out.println(kthLargest.add(10));// returns 5
        System.out.println(kthLargest.add(9));// returns 8
        System.out.println(kthLargest.add(4));// returns 8
    }
}

