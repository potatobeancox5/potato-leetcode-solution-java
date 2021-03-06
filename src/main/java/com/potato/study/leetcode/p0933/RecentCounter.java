package com.potato.study.leetcode.p0933;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	933. Number of Recent Calls
 *  
 *       Write a class RecentCounter to count recent requests.

It has only one method: ping(int t), where t represents some time in milliseconds.

Return the number of pings that have been made from 3000 milliseconds ago until now.

Any ping with time in [t - 3000, t] will count, including the current ping.

It is guaranteed that every call to ping uses a strictly larger value of t than before.



Example 1:

Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
Output: [null,1,2,3,3]


Note:

Each test case will have at most 10000 calls to ping.
Each test case will call ping with strictly increasing values of t.
Each call to ping will have 1 <= t <= 10^9.
 *         
 *         题目含义：
 *
 *
 *         思路：
 *          队列解决
 *          https://blog.csdn.net/u011732358/article/details/83833428
 *          还可以使用二分查找
 *
 *
 * 
 */
public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.remove();
        }
        queue.add(t);
        return queue.size();
    }
}
