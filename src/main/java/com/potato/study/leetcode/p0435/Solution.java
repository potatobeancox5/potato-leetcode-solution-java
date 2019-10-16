package com.potato.study.leetcode.p0435;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author liuzhao11
 * 
 *   435. Non-overlapping Intervals
 * 
 *   Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.



Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.


Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * 			
 *     思路：
 *     435. Non-overlapping Intervals
返回最小的移出数量  使得区间没有重合



按照start升序排列
遍历
第一个记录end 值
否则 start 形同 end取小的 删count++
否则 start 小于

https://www.cnblogs.com/grandyang/p/6017505.html

start排序
遍历 每两个 删除end 大的区间 记录保留区间用于下次比较

 * 			
 * 	
 */	
public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照 start 排序 升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 遍历 intervals 记录留下的区间 留下end 大的
        int stayIndex = 0;
        int deleteCount = 0;
        for (int i = 1; i < intervals.length; i++) {
            // 判断是否重叠
            if (intervals[i][0] >= intervals[stayIndex][1]) {
                // 不重叠
                stayIndex = i;
            } else {
                // 重叠 选择留下end 小的那个
                if (intervals[i][1] < intervals[stayIndex][1]) {
                    stayIndex = i;
                }
                deleteCount++;
            }
        }
        return deleteCount;
    }
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int count = solution.eraseOverlapIntervals(intervals);
        System.out.println(count);
        Assert.assertEquals(1, count);

        int[][] intervals1 = {{1,2},{1,2},{1,2}};
        count = solution.eraseOverlapIntervals(intervals1);
        System.out.println(count);
        Assert.assertEquals(2, count);

        int[][] intervals2 = {{1,2},{2,3}};
        count = solution.eraseOverlapIntervals(intervals2);
        System.out.println(count);
        Assert.assertEquals(0, count);
    }
}
