package com.potato.study.leetcode.p0883;

/**
 * @author liuzhao11
 * <p>
 * 883. Projection Area of 3D Shapes
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

Now we view the projection of these cubes onto the xy, yz, and zx planes.

A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.

Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

Return the total area of all three projections.



Example 1:

Input: [[2]]
Output: 5
Example 2:

Input: [[1,2],[3,4]]
Output: 17
Explanation:
Here are the three projections ("shadows") of the shape made with each axis-aligned plane.

Example 3:

Input: [[1,0],[0,2]]
Output: 8
Example 4:

Input: [[1,1,1],[1,0,1],[1,1,1]]
Output: 14
Example 5:

Input: [[2,2,2],[2,1,2],[2,2,2]]
Output: 21


Note:

1 <= grid.length = grid[0].length <= 50
0 <= grid[i][j] <= 50
 *
 *
 * 题目含义：
 *
 * 思路：
 * 先看有多少个点 就是z视角
对于 每一个x
遍历y 找到z最大 累加

对于 每一个y
遍历x 找到z最大 累加

 *
 */
public class Solution {

    public int projectionArea(int[][] grid) {
        // z视角面积
        int areaZ = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    areaZ++;
                }
            }
        }
        // x 视角面积
        int areaX = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = grid[i][0];
            for (int j = 0; j < grid[0].length; j++) {
                if (max < grid[i][j]) {
                    max = grid[i][j];
                }
            }
            areaX += max;
        }
        // y 视角 面积
        int areaY = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = grid[0][i];
            for (int j = 0; j < grid.length; j++) {
                if (max < grid[j][i]) {
                    max = grid[j][i];
                }
            }
            areaY += max;
        }
        return areaX + areaY + areaZ;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
//        int[][] grid = {{1,2}, {3,4}};
        int[][] grid = {{1,0}, {0,2}};
        int result = solution.projectionArea(grid);
        System.out.println(result);
    }
}
