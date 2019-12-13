package com.potato.study.leetcode.p0630;


import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *         630. Course Schedule III
 * 
 *         There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day.

Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.

Example:

Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
Output: 3
Explanation:
There're totally 4 courses, but you can take 3 courses at most:
First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.
Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.


Note:

The integer 1 <= d, t, n <= 10,000.
You can't take two courses simultaneously.
 *
 * 	思路：
 *  630. Course Schedule III

https://leetcode.com/problems/course-schedule-iii/discuss/104845/Short-Java-code-using-PriorityQueue
 *
 *
 *      贪心算法
 *
 *      1. 按照截止时间排序
 *
 *      2. queue 保存课程 大跟堆
 *
 *      3. 遍历课程 修改开始时间 如果开始时间大于结束时间 将queue pop
 */
public class Solution {

    public int scheduleCourse(int[][] courses) {

        // 1. 按照截止时间排序
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 2. queue 保存课程 大跟堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 3. 遍历课程 修改开始时间 如果开始时间大于结束时间 将queue pop
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            // 当前时间已经不足以上完这个课了
            priorityQueue.add(course[0]);
            if (time > course[1]) {
                // 删除时间最长的那个
                time -= priorityQueue.poll();
            }
        }
        return priorityQueue.size();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
		int scheduleCourse = solution.scheduleCourse(courses);
		System.out.println(scheduleCourse);
        Assert.assertEquals(3, scheduleCourse);
	}
}
