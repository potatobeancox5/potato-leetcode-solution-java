package com.potato.study.leetcode.p0812;

/**
 * 
 * @author liuzhao11
 * 
 * 	812. Largest Triangle Area
 *  
 *        You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.

Example:
Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2
Explanation:
The five points are show in the figure below. The red triangle is the largest.


Notes:

3 <= points.length <= 50.
No points will be duplicated.
-50 <= points[i][j] <= 50.
Answers within 10^-6 of the true value will be accepted as correct.
 *         
 *         思路：
 *          最大的三角形区域面积
 *
 *
 *          812. Largest Triangle Area

https://blog.csdn.net/xdhc304/article/details/79947106

思路及公式
https://blog.csdn.net/xiabenshu/article/details/88810759i
 * 
 */
public class Solution {

    public double largestTriangleArea(int[][] points) {
        int n = points.length;

        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < j + 1; k++) {
                    max = Math.max(max, getArea(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }

    private double getArea(int[] p, int[] q, int[] r) {
        return 0.5 * Math.abs(p[0]*q[1] + q[0]*r[1] + r[0]*p[1] -p[1]*q[0] - q[1]*r[0] - r[1]*p[0]);
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] points = new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}};
        double list = solution.largestTriangleArea(points);
        System.out.println(list); // 2
    }
}
