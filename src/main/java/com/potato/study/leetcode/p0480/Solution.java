package com.potato.study.leetcode.p0480;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *         480. Sliding Window Median
 * 
 *        Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
1 [3  -1  -3] 5  3  6  7       -1
1  3 [-1  -3  5] 3  6  7       -1
1  3  -1 [-3  5  3] 6  7       3
1  3  -1  -3 [5  3  6] 7       5
1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note:
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 * 
 *         思路:
 *          https://segmentfault.com/a/1190000008357502
 *
 *
 *          滑动窗口内部 使用两个堆 大跟堆 一个小根堆 大根堆里边的都小于小根堆
 *
 *
 *          首先 滑动时，将划掉的值删除，然后增加新值
 *
 *
 *         
 * 
 */
public class Solution {

    // 大于中间值的小根堆
    private PriorityQueue<Integer> minPriorityQueue;
    // 小于中间值的大跟堆
    private PriorityQueue<Integer> maxPriorityQueue;

    public double[] medianSlidingWindow(int[] nums, int k) {
        // 0. 初始化数据结构
        minPriorityQueue = new PriorityQueue<>();
        maxPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 > o1 ? 1 : (o2 < o1 ? -1 : 0);
            }
        });
        double[] resArr = new double[nums.length - k + 1];
        // 1. 组装初始的滑动窗口
        for (int i = 0; i < k; i++) {
            addValueToHeap(nums[i]);
        }
        int index = 0;
        resArr[index++] = getMedian();
        // 2. 滑动生成结果
        for (int i = k; i < nums.length; i++) {
            slideWindow(nums, i, k);
            resArr[index++] = getMedian();
        }
        return resArr;
    }

    /**
     * 滑动窗口，从min max中 除去数据，然后 添加新数据
     * @param nums
     * @param newIndex  新增的index
     * @param k         窗口大小
     */
    private void slideWindow (int[] nums, int newIndex, int k) {
        int deleteVal = nums[newIndex - k];
        int addVal = nums[newIndex];
        if (maxPriorityQueue.contains(deleteVal)) {
            maxPriorityQueue.remove(deleteVal);
        } else if (minPriorityQueue.contains(deleteVal)) {
            minPriorityQueue.remove(deleteVal);
        }
        // add
        this.addValueToHeap(addVal);
    }


    /**
     * 向组合堆里边添加数据
     * 前提 min 堆可能 size 会大于 max 1 再多了就不行了
     */
    private void addValueToHeap(int val){
        minPriorityQueue.add(val);
        while (minPriorityQueue.size() - maxPriorityQueue.size() > 1) {
            maxPriorityQueue.add(minPriorityQueue.poll());
        }
        // 整理数据
        if (minPriorityQueue.size() == 0 || maxPriorityQueue.size() == 0) {
            return;
        }
        while (minPriorityQueue.peek() < maxPriorityQueue.peek()) {
            maxPriorityQueue.add(minPriorityQueue.poll());
            minPriorityQueue.add(maxPriorityQueue.poll());
        }
    }

    private double getMedian() {
        if ((minPriorityQueue.size() + maxPriorityQueue.size()) % 2 == 1) {
            return minPriorityQueue.peek();
        } else {
            return (1.0 * minPriorityQueue.peek() + maxPriorityQueue.peek()) / 2;
        }
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		double[] dd = solution.medianSlidingWindow(nums, k);
		System.out.println(Arrays.toString(dd));
        Assert.assertArrayEquals( "result error", new double[]{1, -1, -1,3,5,6}, dd, 0.0);


        int[] nums1 = {-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        k = 6;
        dd = solution.medianSlidingWindow(nums1, k);
        System.out.println(Arrays.toString(dd));
        Assert.assertArrayEquals( "result error", new double[]{-1073741823.5,-1073741823.5,-49.5,-49.5,2.0,5.5,-46.0,-46.0,12.5,19.5,1073741834.5,2147483647.0,2147483647.0,2147483647.0,2147483647.0}, dd, 0.0);


	}
}
