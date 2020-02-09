package com.potato.study.leetcode.p0786;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	786. K-th Smallest Prime Fraction
 *  
 *        A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.

What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.

Examples:
Input: A = [1, 2, 3, 5], K = 3
Output: [2, 5]
Explanation:
The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
The third fraction is 2/5.

Input: A = [1, 7], K = 1
Output: [1, 7]
Note:

A will have length between 2 and 2000.
Each A[i] will be between 1 and 30000.
K will be between 1 and A.length * (A.length - 1) / 2.


 *
 *
 *   解题思路：
 *      https://blog.csdn.net/u014688145/article/details/79335163
 *      分别n路 记录最小的 然后依次放入最小的后继 pop时计数 直到达到 最终的k
 *
 * 
 */
public class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // int[] 0 横坐标 1 纵坐标
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return arr[o1[0]] * arr[o2[1]] - arr[o1[1]] * arr[o2[0]];
            }
        });
        // 0 放入初始
        for (int i = 0; i < arr.length - 1; i++) {
            priorityQueue.add(new int[] {i, arr.length - 1});
        }

        // 1 依次找到 前k个数字
        while (k > 1) {
            int[] index = priorityQueue.poll();
            if (index[1] - 1 > index[0] ) {
                index[1]--;
                priorityQueue.offer(index);
            }
            k--;
        }
        int[] peek = priorityQueue.peek();
        return new int[]{arr[peek[0]], arr[peek[1]]};
    }



	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = {1, 2, 3, 5};
        int k = 3;
        int[] list = solution.kthSmallestPrimeFraction(arr, k);
        System.out.println(Arrays.toString(list)); // 2, 5

        int[] arr1 = {1, 7};
        k = 1;
        list = solution.kthSmallestPrimeFraction(arr1, k);
        System.out.println(Arrays.toString(list)); // 1, 7
    }
}
