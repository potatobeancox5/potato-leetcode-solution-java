package com.potato.study.leetcode.p0378;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *       378. Kth Smallest Element in a Sorted Matrix
 * 
 *      Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
[ 1,  5,  9],
[10, 11, 13],
[12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 *         
 *         思路：
 *         给定一个数组，求第k大的数字是多少
 *         利用优先队列 先将第一行入队，每次pop 根据这个元素的位置信息，将该元素同列的下一个元素入队
 *
 *         https://www.cnblogs.com/mydesky2012/p/5763967.html
 *
 *
 *
 */
public class Solution {

    class Element {
        public int value;
        public int i;
        public int j;

        public Element(int value, int i, int j) {
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }


    public int kthSmallest(int[][] matrix, int k) {
        int currentIndex = 0;
        int currentCount = 0;
        // 利用优先队列 先将第一行入队，小根堆
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.value - o2.value;
            }
        });
        for (int i = 0; i < matrix[0].length; i++) {
            priorityQueue.add(new Element(matrix[0][i], 0, i));
        }
        // 每次pop 根据这个元素的位置信息，将该元素同列的下一个元素入队
        int target = 0;
        while (currentCount < k) {
            Element cur = priorityQueue.poll();
            currentCount++;
            if (currentCount == k) {
                target = cur.value;
            }
            // 将列放进去
            if (cur.i < matrix.length - 1) {
                priorityQueue.add(new Element(matrix[cur.i + 1][cur.j], cur.i + 1, cur.j));
            }
        }
        return target;
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] matrix = {{1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        int k = 8;
        int res = solution.kthSmallest(matrix, k);
		System.out.println(res);
        Assert.assertEquals(13, res);
	}
}
