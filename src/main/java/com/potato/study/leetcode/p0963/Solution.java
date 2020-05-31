package com.potato.study.leetcode.p0963;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	963. Minimum Area Rectangle II
 *  
 *       Given a set of points in the xy-plane, determine the minimum area of any rectangle formed from these points, with sides not necessarily parallel to the x and y axes.

If there isn't any rectangle, return 0.



Example 1:



Input: [[1,2],[2,1],[1,0],[0,1]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.
Example 2:



Input: [[0,1],[2,1],[1,1],[1,0],[2,0]]
Output: 1.00000
Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.
Example 3:



Input: [[0,3],[1,2],[3,1],[1,3],[2,1]]
Output: 0
Explanation: There is no possible rectangle to form from these points.
Example 4:



Input: [[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [2,1],[2,3],[3,3],[3,1], with an area of 2.


Note:

1 <= points.length <= 50
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
All points are distinct.
Answers within 10^-5 of the actual value will be accepted as correct.
 *         
 *         题目含义：
 *           https://leetcode-cn.com/problems/minimum-area-rectangle-ii/solution/zui-xiao-mian-ji-ju-xing-ii-by-leetcode/
 *
 * 
 */
public class Solution {

    public double minAreaFreeRect(int[][] points) {
        int N = points.length;

        Point[] aaa = new Point[N];
        Set<Point> pointSet = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            aaa[i] = new Point(points[i][0], points[i][1]);
            pointSet.add(aaa[i]);
        }

        double ans = Double.MAX_VALUE;
        for (int i = 0; i < N; ++i) {
            Point p1 = aaa[i];
            for (int j = 0; j < N; ++j) if (j != i) {
                Point p2 = aaa[j];
                for (int k = j+1; k < N; ++k) if (k != i) {
                    Point p3 = aaa[k];
                    Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);

                    if (pointSet.contains(p4)) {
                        int dot = ((p2.x - p1.x) * (p3.x - p1.x) +
                                (p2.y - p1.y) * (p3.y - p1.y));
                        if (dot == 0) {
                            double area = p1.distance(p2) * p1.distance(p3);
                            if (area < ans) {
                                ans = area;
                            }
                        }
                    }
                }
            }
        }
        return ans < Double.MAX_VALUE ? ans : 0;
    }

}
