package com.potato.study.leetcode.p0264;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 264. Ugly Number II
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.

        题目需求：
        给定一个数字n
        找到第n哥 Ugly Number - > {1,2,3,4,5,6,8,9,10}
* 		思路：
* 
 */
public class Solution {

    public int nthUglyNumber(int n) {
        int tmp = 1;
        Queue<Integer> twoQueue = new ArrayDeque<>();
        Queue<Integer> threeQueue = new ArrayDeque<>();
        Queue<Integer> fiveQueue = new ArrayDeque<>();
        Set<Integer> resultSet = new HashSet<>();
        resultSet.add(1);
        if (n == 1) {
            return tmp;
        }
        for (int i = 1; i < n; i++) {
            if (!twoQueue.contains(tmp * 2)) {
                twoQueue.add(tmp * 2);
            }
            if (!threeQueue.contains(tmp * 3)) {
                threeQueue.add(tmp * 3);
            }
            if (!fiveQueue.contains(tmp * 5)) {
                fiveQueue.add(tmp * 5);
            }
            int min = popTheMin(twoQueue, fiveQueue, threeQueue);
            while (resultSet.contains(min)) {
                min = popTheMin(twoQueue, fiveQueue, threeQueue);
            }
            resultSet.add(min);
            tmp = min;
        }
        return tmp;
    }

    private int popTheMin(Queue<Integer> a, Queue<Integer> b, Queue<Integer> c) {
        if (a.peek() < b.peek()) {
            return a.peek() < c.peek() ? a.remove() : c.remove();
        } else {
            return b.peek() < c.peek() ? b.remove() : c.remove();
        }
    }
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
        int result = solution.nthUglyNumber(11);
        System.out.println(result);
    }
}
