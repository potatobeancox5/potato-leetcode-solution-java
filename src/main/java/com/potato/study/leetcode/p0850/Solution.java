package com.potato.study.leetcode.p0850;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	850. Rectangle Area II
 *  
 *        We are given a list of (axis-aligned) rectangles.  Each rectangle[i] = [x1, y1, x2, y2] , where (x1, y1) are the coordinates of the bottom-left corner, and (x2, y2) are the coordinates of the top-right corner of the ith rectangle.

Find the total area covered by all rectangles in the plane.  Since the answer may be too large, return it modulo 10^9 + 7.



Example 1:

Input: [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
Output: 6
Explanation: As illustrated in the picture.
Example 2:

Input: [[0,0,1000000000,1000000000]]
Output: 49
Explanation: The answer is 10^18 modulo (10^9 + 7), which is (10^9)^2 = (-7)^2 = 49.
Note:

1 <= rectangles.length <= 200
rectanges[i].length = 4
0 <= rectangles[i][j] <= 10^9
The total area covered by all rectangles will never exceed 2^63 - 1 and thus will fit in a 64-bit signed integer.
 *         
 *
 *         题目含义：
 *         https://blog.csdn.net/spring_translate/article/details/86770478
 *         850. Rectangle Area II

题目含义

求 给出的矩形 覆盖的面积

https://leetcode-cn.com/problems/rectangle-area-ii/solution/ju-xing-mian-ji-ii-by-leetcode

容chi 定律

计算面积   返回 坐标 乘积
 *
 *
 *
 */
public class Solution {
    /**
     * 线段树 求解
     * @param rectangles
     * @return
     */
    public int rectangleArea(int[][] rectangles) {
        int open = 1;
        int close = -1;
        int[][] events = new int[rectangles.length * 2][];
        Set<Integer> xVals = new HashSet<>();
        int t = 0;
        for (int[] rec: rectangles) {
            events[t++] = new int[]{rec[1], open, rec[0], rec[2]};
            events[t++] = new int[]{rec[3], close, rec[0], rec[2]};
            xVals.add(rec[0]);
            xVals.add(rec[2]);
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        Integer[] x = xVals.toArray(new Integer[0]);
        Arrays.sort(x);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; ++i) {
            map.put(x[i], i);
        }

        Node active = new Node(0, x.length - 1, x);
        long ans = 0;
        long curXSum = 0;
        int curY = events[0][0];

        for (int[] event: events) {
            int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];
            ans += curXSum * (y - curY);
            curXSum = active.update(map.get(x1), map.get(x2), typ);
            curY = y;

        }

        ans %= 1_000_000_007;
        return (int) ans;
    }

    /**
     * 线段树节点
     */
    class Node {
        int start;
        int end;
        Integer[] x;
        Node left;
        Node right;
        int count;
        long total;

        public Node(int start, int end, Integer[] x) {
            this.start = start;
            this.end = end;
            this.x = x;
            left = null;
            right = null;
            count = 0;
            total = 0;
        }

        public int getRangeMid() {
            return start + (end - start) / 2;
        }

        public Node getLeft() {
            if (left == null) {
                left = new Node(start, getRangeMid(), x);
            }
            return left;
        }

        public Node getRight() {
            if (right == null) {
                right = new Node(getRangeMid(), end, x);
            }
            return right;
        }

        public long update(int i, int j, int val) {
            if (i >= j) {
                return 0;
            }
            if (start == i && end == j) {
                count += val;
            } else {
                getLeft().update(i, Math.min(getRangeMid(), j), val);
                getRight().update(Math.max(getRangeMid(), i), j, val);
            }

            if (count > 0) {
                total = x[end] - x[start];
            } else {
                total = getLeft().total + getRight().total;
            }
            return total;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] rectangles = new int[][]{{0,0,2,2},{1,0,2,3},{1,0,3,1}};
        int result = solution.rectangleArea(rectangles);
        System.out.println(result);
        Assert.assertEquals(6, result);

        rectangles = new int[][]{{0,0,1000000000,1000000000}};
        result = solution.rectangleArea(rectangles);
        System.out.println(result);
        Assert.assertEquals(49, result);
    }
}





