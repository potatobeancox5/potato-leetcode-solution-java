package com.potato.study.leetcode.p0149;

import com.potato.study.leetcode.domain.Point;

/**
 * 
 * @author liuzhao11
 * 
 *      149. Max Points on a Line
 *         
 *          
 *   Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6

 *
 *         题目需求：
 *          找到一条直线上 最多经过多少个点
 *         思路：
 *          先选择两个点
 *          在确认一个点 利用行列式判断三点是否共线
 *          贡献行列式判断
 *          x1 * y2 + x2 * y3 + x3 * y1 - x3 * y2 - x2 * y1 - x1 * y3 == 0
 *          每次更换之前选择两个点的时候 判断最大值
 *
 */
public class Solution {

    public int maxPoints(Point[] points) {

        int num = points.length;
        int max = 0;
        for (int i = 0; i < num; i++) {
            // 记录重合点 重合点 但算 重合点如果多与 共线点个数 就用重合点个数作为最大值
            int dup = 1;
            for (int j = i + 1; j < num; j++) {
                // 当前 共线点计数器
                int sameLineNum = 0;

                long x1 = points[i].x;
                long y1 = points[i].y;
                long x2 = points[j].x;
                long y2 = points[j].y;
                // 选择第三个点
                if (x1 == x2 && y1 == y2) { // 重合点 计数
                    dup++;
                    continue;
                }
                // 选择第三个点 判断是否共线
                for (int k = 0; k < num; k++) {
                    long x3 = points[k].x;
                    long y3 = points[k].y;
                    long result = x1 * y2 + x2 * y3 + x3 * y1 - x3 * y2 - x2 * y1 - x1 * y3;
                    if (result == 0) {
                        sameLineNum++;
                    }
                }
                // 最大值 记录
                max = Math.max(sameLineNum, max);
            }
            max = Math.max(dup, max);
        }
        return max;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		Point[] points = new Point[3];
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 65536);
        Point point3 = new Point(65536, 0);
        points[0] = point1;
        points[1] = point2;
        points[2] = point3;
        int num = solution.maxPoints(points);
        System.out.println(num);

    }
}
