package com.potato.study.leetcode.p0621;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         621. Task Scheduler
 * 
 *         Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.



Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.


Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 *
 * 	思路：
 * 		621. Task Scheduler

https://blog.csdn.net/yuhq3/article/details/78018948

没太整明白计算idle时间的规则

要么有空格 要么 没有空格

下面是计算有空格的情况


https://leetcode.com/problems/task-scheduler/discuss/104496/concise-Java-Solution-O(N)-time-O(26)-space

1. 计数 char 26
2. 按照次数排序
3 找到没有达到最多次数的任务个数

4 返回 框架个数加最后一行的个数
 *
 */
public class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] taskCount = new int[26];
//        1. 计数 char 26
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
//        2. 按照次数排序
        Arrays.sort(taskCount);
//        3 找到没有达到最多次数的任务个数
        int i = 25;
        while (i >= 0 && taskCount[i] == taskCount[25]) {
            i--;
        }
//        4 返回 框架个数加最后一行的个数
        int time = (taskCount[25] - 1) * (n + 1) + 25 - i;
        time = Math.max(time, tasks.length);
        return time;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 2;
        char[] tasks = {'A','A','A','B','B','B'};
		int leastInterval = solution.leastInterval(tasks, n);
		System.out.println(leastInterval);
        Assert.assertEquals(8, leastInterval);

	}
}
