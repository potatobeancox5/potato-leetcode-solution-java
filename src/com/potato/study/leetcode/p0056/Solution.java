package com.potato.study.leetcode.p0056;

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
 *      56. Merge Intervals
 *      
 *       Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * 
 *         思路： 给定的list转成数组并排序 
 *         遍历排序后数组 如果不是第一个且满足结合条件，将其结合  直到不能结合的时候 将信息插入list 
 *         
 *         处理最后一个节点信息
 * 
 */
public class Solution {

	
	public List<Interval> merge(List<Interval> intervals) {
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
		String string = "[1,3],[2,6],[8,10],[15,18]";
		List<Interval> intervals = IntervalUtil.str2IntervalList(string);
		List<Interval> list = solution.merge(intervals);
		System.out.println(list);
	}
}
