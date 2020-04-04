package com.potato.study.leetcode.p1288;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author liuzhao11
 * 
 * 	1288. Remove Covered Intervals
 *  
 *
Given a list of intervals, remove all intervals that are covered by another interval in the list. Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals.



Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.


Constraints:

1 <= intervals.length <= 1000
0 <= intervals[i][0] < intervals[i][1] <= 10^5
intervals[i] != intervals[j] for all i != j
 *         
 *         思路：
 *
 *          删除已经被覆盖的区间
 *
 *          https://www.cnblogs.com/wentiliangkaihua/p/12208051.html
 *
 *
 *
 */
public class Solution {


    public int removeCoveredIntervals(int[][] intervals) {
        // 按照区间开始 升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 遍历区间数组 如果开始 和结束 均大于 当前left和right 那么留下这个区间 修改left 和right 返回计数器
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int remainCount = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > left && intervals[i][1] > right) {
                left = intervals[i][0];
                remainCount++;
            }
            right = Math.max(right, intervals[i][1]);
        }
        return remainCount;
    }

}
