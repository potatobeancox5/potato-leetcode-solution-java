package com.potato.study.leetcode.p0892;

import org.junit.Assert;

/**
 * @author liuzhao11
 *
 * 892. Surface Area of 3D Shapes
 *
 * On a N * N grid, we place some 1 * 1 * 1 cubes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

Return the total surface area of the resulting shapes.



Example 1:

Input: [[2]]
Output: 10
Example 2:

Input: [[1,2],[3,4]]
Output: 34
Example 3:

Input: [[1,0],[0,2]]
Output: 16
Example 4:

Input: [[1,1,1],[1,0,1],[1,1,1]]
Output: 32
Example 5:

Input: [[2,2,2],[2,1,2],[2,2,2]]
Output: 46


Note:

1 <= N <= 50
0 <= grid[i][j] <= 50

 * 题目含义：
 *      三维物体的表面积
 *
 * 思路：
 *      grid ij 坐标 和高度 求表面积
 *
 *      每个结点计算与周围结点重合点的面积 减去
 *      https://www.cnblogs.com/grandyang/p/10928332.html
 *
 */
public class Solution {

    public int surfaceArea(int[][] grid) {
        int n = grid.length;

        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 计算 当前增加的面积
                if (grid[i][j] > 0) {
                    area += (2 + 4 * grid[i][j]);
                }
                // i i-1 接触面要删除2次
                if (i > 0) {
                    area -= Math.min(grid[i][j], grid[i-1][j]) * 2;
                }
                // j j-1 接触面要删除2次
                if (j > 0) {
                    area -= Math.min(grid[i][j], grid[i][j-1]) * 2;
                }
            }
        }
        return area;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] grid = new int[][]{{2}};
        int area = solution.surfaceArea(grid);
        System.out.println(area);
        Assert.assertEquals(10, area);

        grid = new int[][]{{1,2}, {3,4}};
        area = solution.surfaceArea(grid);
        System.out.println(area);
        Assert.assertEquals(34, area);

        grid = new int[][]{{1,0}, {0,2}};
        area = solution.surfaceArea(grid);
        System.out.println(area);
        Assert.assertEquals(16, area);

        grid = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        area = solution.surfaceArea(grid);
        System.out.println(area);
        Assert.assertEquals(32, area);

        grid = new int[][]{{2,2,2},{2,1,2},{2,2,2}};
        area = solution.surfaceArea(grid);
        System.out.println(area);
        Assert.assertEquals(46, area);
    }
}
