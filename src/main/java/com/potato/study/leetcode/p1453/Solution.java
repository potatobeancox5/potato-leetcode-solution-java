package com.potato.study.leetcode.p1453;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1453. Maximum Number of Darts Inside of a Circular Dartboard
 *  
 *
You have a very large square wall and a circular dartboard placed on the wall. You have been challenged to throw darts into the board blindfolded. Darts thrown at the wall are represented as an array of points on a 2D plane.

Return the maximum number of points that are within or lie on any circular dartboard of radius r.



Example 1:



Input: points = [[-2,0],[2,0],[0,2],[0,-2]], r = 2
Output: 4
Explanation: Circle dartboard with center in (0,0) and radius = 2 contain all points.
Example 2:



Input: points = [[-3,0],[3,0],[2,6],[5,4],[0,9],[7,8]], r = 5
Output: 5
Explanation: Circle dartboard with center in (0,4) and radius = 5 contain all points except the point (7,8).
Example 3:

Input: points = [[-2,0],[2,0],[0,2],[0,-2]], r = 1
Output: 1
Example 4:

Input: points = [[1,2],[3,5],[1,-1],[2,3],[4,1],[1,3]], r = 2
Output: 4


Constraints:

1 <= points.length <= 100
points[i].length == 2
-10^4 <= points[i][0], points[i][1] <= 10^4
1 <= r <= 5000
 *         
 *
 *
 *
 * 思路：
 *      https://leetcode-cn.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/solution/javagao-zhong-shu-xue-ti-by-wo-ye-lai-shi-shi-ba/
 *
 *
 *
 */
public class Solution {


    public int numPoints(int[][] points, int r) {
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                double dis = getDistance(points[i], points[j]);
                if (i == j) {
                    continue;
                }
                if (dis > 2 * r && Math.abs(dis - r) >= 1e-6) {
                    continue;
                }
                double[] point = getCirclePoint(points[i], points[j], r);
                int temp = 0;
                for (int l = 0; l < points.length; l++) {
                    double distance = getDistance(point, points[l]);
                    if (distance <= r || Math.abs(distance - r) <= 1e-6) {
                        temp++;
                    }
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    private double[] getCirclePoint(int[] point1, int[] point2, int r) {
        double[] point = new double[2];
        double l = getDistance(point1, point2);
        double d = Math.sqrt(r * r - (l * l / 4));
        point[0] = (double) (point1[0] + point2[0]) / 2 - d * (point2[1] - point1[1]) / l;
        point[1] = (double) (point1[1] + point2[1]) / 2 + d * (point2[0] + -point1[0]) / l;
        return point;
    }

    private double getDistance(int[] point1, int[] point2) {
        double dx = point1[0] - point2[0];
        double dy = point1[1] - point2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    private double getDistance(double[] point1, int[] point2) {
        double dx = point1[0] - point2[0];
        double dy = point1[1] - point2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] points = new int[][]{{-2,0},{2,0},{0,2},{0,-2}};
        int r = 1;
        int res = solution.numPoints(points, r);
        System.out.println(res);
        Assert.assertEquals(1, res);


    }
}
