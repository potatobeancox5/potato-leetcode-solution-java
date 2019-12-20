package com.potato.study.leetcode.p0715;


import org.junit.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * 
 * @author liuzhao11
 * 
 * 	715. Range Module
 *  
 *         A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.

addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
Example 1:
addRange(10, 20): null
removeRange(14, 16): null
queryRange(10, 14): true (Every number in [10, 14) is being tracked)
queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
Note:

A half open interval [left, right) denotes all real numbers left <= x < right.
0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
The total number of calls to addRange in a single test case is at most 1000.
The total number of calls to queryRange in a single test case is at most 5000.
The total number of calls to removeRange in a single test case is at most 1000.
 *         
 *         思路：
 *          按照理解 就是 维护一个区间 判断 当前给的区间是不是包含 查询的区间
 *
 *          https://blog.csdn.net/laputafallen/article/details/79830206
 *
 *
 * 
 */
public class RangeModule {

    private TreeSet<Interval> set;

    public RangeModule() {
        set = new TreeSet<>();
    }


    public void addRange(int left, int right) {
        // 1. 获取大于等于 left 的 set
        Iterator<Interval> iterator = set.tailSet(new Interval(0, left)).iterator();
        // 2. 遍历 如果当前有 没有重叠了 break 否则 计算当前最左边和最有边的值 每次遍历 remove
        while (iterator.hasNext()) {
            Interval interval = iterator.next();
            // 出现了空隙
            if (right < interval.left) {
                break;
            }
            left = Math.min(left, interval.left);
            right = Math.max(right, interval.right);
            iterator.remove();
        }
        // 3. 将生成的值 插入 set
        set.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        // 获取第一个大于left的right 看一下 是否是包含关系
        Interval firstBigger = set.higher(new Interval(0, left));
        if (null == firstBigger) {
            return false;
        }
        if (firstBigger.left <= left && right <= firstBigger.right) {
            return true;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        // 比left 大的interval
        Iterator<Interval> iterator = set.tailSet(new Interval(0, left)).iterator();
        List<Interval> tmpList = new ArrayList<>();
        // 遍历 比如果错开了 就不删除了 否则 删除切碎成小段
        while (iterator.hasNext()) {
            Interval interval = iterator.next();
            // 错开了 不用删除了
            if (right < interval.left) {
                break;
            }
            if (right < interval.right) {
                tmpList.add(new Interval(right, interval.right));
            }
            if (interval.left < left) {
                tmpList.add(new Interval(interval.left, left));
            }
            iterator.remove();
        }
        set.addAll(tmpList);
    }

    // 数据结构 interval
    class Interval implements Comparable<Interval>{
        public int left;
        public int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        // right 升序
        @Override
        public int compareTo(Interval o) {
            if (this.right == o.right) {
                return this.left - o.left;
            }
            return this.right - o.right;
        }
    }


    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        boolean res = rangeModule.queryRange(10, 14);
        System.out.println(res);
        Assert.assertEquals(true, res);

        res = rangeModule.queryRange(13, 15);
        System.out.println(res);
        Assert.assertEquals(false, res);

        res = rangeModule.queryRange(16, 17);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}