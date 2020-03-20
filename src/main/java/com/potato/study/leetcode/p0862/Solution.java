package com.potato.study.leetcode.p0862;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	862. Shortest Subarray with Sum at Least K
 *  
 *         Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

If there is no non-empty subarray with sum at least K, return -1.



Example 1:

Input: A = [1], K = 1
Output: 1
Example 2:

Input: A = [1,2], K = 4
Output: -1
Example 3:

Input: A = [2,-1,2], K = 3
Output: 3


Note:

1 <= A.length <= 50000
-10 ^ 5 <= A[i] <= 10 ^ 5
1 <= K <= 10 ^ 9
 *         
 *
 *         题目含义：
 *
            给定一个 值k 返回 arr 中 连续的子数组 sum = k 的length  如果没有返回 -1
                小根堆 维护 sum index 关系
 *         思路：
 *
 *          https://www.cnblogs.com/grandyang/p/11300071.html
 *
 *
 *
 */
public class Solution {

    public int shortestSubarray(int[] arr, int k) {
        int sum = 0;
        // 0 sum 1 index
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int shortestSubarrayLen = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= k) {
                shortestSubarrayLen = Math.min(shortestSubarrayLen, i + 1);
            }
            while (!priorityQueue.isEmpty() && (sum - priorityQueue.peek()[0] >= k)) {
                shortestSubarrayLen = Math.min(shortestSubarrayLen, i - priorityQueue.peek()[1]);
                priorityQueue.poll();
            }
            priorityQueue.add(new int[]{sum, i});
        }
        return shortestSubarrayLen == Integer.MAX_VALUE ? -1 : shortestSubarrayLen;
    }




	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr = new int[]{1};
        int k = 1;
        int result = solution.shortestSubarray(arr, k);
        System.out.println(result);
        Assert.assertEquals(1, result);

        arr = new int[]{1, 2};
        k = 4;
        result = solution.shortestSubarray(arr, k);
        System.out.println(result);
        Assert.assertEquals(-1, result);

        arr = new int[]{2,-1,2};
        k = 3;
        result = solution.shortestSubarray(arr, k);
        System.out.println(result);
        Assert.assertEquals(3, result);


        arr = new int[]{17,85,93,-45,-21};
        k = 150;
        result = solution.shortestSubarray(arr, k);
        System.out.println(result);
        Assert.assertEquals(2, result);
    }
}
