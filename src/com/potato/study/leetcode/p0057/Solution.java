package com.potato.study.leetcode.p0057;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.potato.study.leetcode.domain.Interval;
import com.potato.study.leetcode.util.IntervalUtil;

/**
 * 
 * @author liuzhao11
 * 
 *      57. Insert Interval
 *      
 *      Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 *         思路：给一个排序之后的间隔list 在加上一个新的间隔
 *         将新的间隔插入list 并且如果可以的话进行合并
 *         和之前一题一样 遍历数组，达到合并条件时进行合并，当没有达到时将之前的结果放到新的串中，最后处理最终的节点
 *         当前节点是否可以和new节点合并
 *         		可以 - 合并
 *         		不可以 -跳过并 插入结果
 * 
 */
public class Solution {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<>();
		if(intervals == null || intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}
		// 合并
		intervals.add(newInterval);
		return merge(intervals);
	}
	
	private List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if(null == intervals || intervals.size() == 0) {
			return result;
		}
		Collections.sort(intervals,new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if(intervals.get(i).start >= start && intervals.get(i).start <= end) { // 合并 修改end
				end = end > intervals.get(i).end ? end : intervals.get(i).end;
			} else { // 不是包含关系  存储上一个 修改当前的
				result.add(new Interval(start, end));
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}
		//处理剩下的最后一个
		result.add(new Interval(start, end));
		return result;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		String string = "[1,5]";
		List<Interval> intervals = IntervalUtil.str2IntervalList(string);
		Interval newInterval = new Interval(0, 0);
		List<Interval> result = solution.insert(intervals, newInterval);
		System.out.println(result);
	}
}
