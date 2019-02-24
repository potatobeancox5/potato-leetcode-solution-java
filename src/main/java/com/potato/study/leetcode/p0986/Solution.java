package com.potato.study.leetcode.p0986;


import com.potato.study.leetcode.domain.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	986. Interval List Intersections
 *  
 *         Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)



Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.


Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 *         
 *         思路：
 *         Max(a.x, b.x) , min(a.y, b.y)
            遍历求
            http://www.bubuko.com/infodetail-2944475.html
 *
 */
public class Solution {

    public Interval[] intervalIntersection(Interval[] a, Interval[] b) {
        List<Interval> intersectionList = new ArrayList<>();
        if (null == a || a.length == 0 || null == b || b.length == 0) {
            return new Interval[0];
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int s = Math.max(a[i].start, b[j].start);
                int e = Math.min(a[i].end, b[j].end);
                if (s <= e) {
                    intersectionList.add(new Interval(s, e));
                } else {
                    continue;
                }
            }
        }
        // 转换结果
        Interval[] res = new Interval[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); i++) {
            res[i] = intersectionList.get(i);
        }
        return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

    }
}
