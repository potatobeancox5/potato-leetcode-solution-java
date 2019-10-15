package com.potato.study.leetcode.p0436;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 *   436. Find Right Interval
 * 
 *   Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:

You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.


Example 1:

Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.


Example 2:

Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.


Example 3:

Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * 			
 *     思路：
 *     https://www.cnblogs.com/liujinhong/p/6399135.html
 *
 *     题目含义是给定多个区间 找到前面区间紧紧挨着的 区间的index 数组
 *
 *     按照 start排序 然后使用每个interval的end 找到 第一个大于这个值的indx
 *
 *     TreeMap
 *     ceilingEntry(K key) 方法用来返回与该键至少大于或等于给定键，如果不存在这样的键的键 - 值映射，则返回null相关联。

 * 			
 * 	
 */	
public class Solution {

    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> start2IndexMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            start2IndexMap.put(intervals[i][0], i);
        }
        int[] rightIndex = new int[intervals.length];
        for (int i = 0; i < rightIndex.length; i++) {
            Map.Entry<Integer, Integer> entry = start2IndexMap.ceilingEntry(intervals[i][1]);
            if (null == entry) {
                rightIndex[i] = -1;
            } else {
                rightIndex[i] = entry.getValue();
            }
        }
        return rightIndex;
    }
	
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] intervals = {};
        int[] rightInterval = solution.findRightInterval(intervals);


    }
}
