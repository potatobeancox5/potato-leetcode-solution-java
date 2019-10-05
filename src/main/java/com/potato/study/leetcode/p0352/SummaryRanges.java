package com.potato.study.leetcode.p0352;

import com.potato.study.leetcode.util.ArrayUtil;

import java.util.*;

/**
 * 
 * @author liuzhao11
 * 
 *        352. Data Stream as Disjoint Intervals
 * 
 *      Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]


Follow up:

What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 *         
 *         
 *         思路：
 *         TreeSet 中的方法
 *         floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.

ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
https://www.cnblogs.com/apanda009/p/7854333.html


			0。 构造区间对象 Interval start end
 			// 1. 利用treeset 存储目前的区间 按照start 升序

 			2。 每次插入时 找到 pre 区间 和 next 区间
 			2。1 如果 val 落在 pre和 next之间 直接返回
 			2。2 如果 val 在pre的下一个 将pre 删除，并修改cur的 start
 			2。3 如果 val 在next 的前一个 将next 删除 并修改cur放入 end
 			将 2。2 2。3 结果放入list中

 *        
 */
public class SummaryRanges {

	class Interval {
		public int start;
		public int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	private TreeSet<Interval> intervals;

	/** Initialize your data structure here. */
	public SummaryRanges() {
		intervals = new TreeSet<>(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
	}


	/**
	 * 向目前区间中 增加一个数字
	 * @param val
	 */
	public void addNum(int val) {
		Interval current = new Interval(val, val);
		Interval pre = this.intervals.floor(current);
		Interval next = this.intervals.ceiling(current);
		if (null != pre && pre.start <= val && val <= pre.end) {
			return;
		}
		if (null != next && next.start <= val && val <= next.end) {
			return;
		}
		if (null != pre && val == pre.end + 1) {
			current.start = pre.start;
			intervals.remove(pre);
		}
		if (null != next && val == next.start - 1) {
			current.end = next.end;
			intervals.remove(next);
		}
		intervals.add(current);
	}


	/**
	 * 返回所有的序列列表
	 * @return
	 */
	public int[][] getIntervals() {
		int[][] array = new int[this.intervals.size()][2];
		int i = 0;

		Iterator<Interval> iterator = intervals.iterator();

		while (iterator.hasNext()) {
			Interval cur = iterator.next();
			array[i++] = new int[]{cur.start, cur.end};
		}
		return array;
	}
	
	public static void main(String[] args) {

		// 1, 3, 7, 2, 6
		SummaryRanges summaryRanges = new SummaryRanges();
		summaryRanges.addNum(1);
		ArrayUtil.printMatrix(summaryRanges.getIntervals());
		summaryRanges.addNum(3);
		ArrayUtil.printMatrix(summaryRanges.getIntervals());


//		summaryRanges.addNum(7);
//		summaryRanges.addNum(2);
//		summaryRanges.addNum(6);
//		ArrayUtil.printMatrix(summaryRanges.getIntervals());
	}
}
