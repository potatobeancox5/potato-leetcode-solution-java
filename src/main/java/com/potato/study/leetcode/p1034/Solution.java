package com.potato.study.leetcode.p1034;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1034. Coloring A Border
 *  
 *        Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.

Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.

The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).

Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.



Example 1:

Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
Output: [[3, 3], [3, 2]]
Example 2:

Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
Output: [[1, 3, 3], [2, 3, 3]]
Example 3:

Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]


Note:

1 <= grid.length <= 50
1 <= grid[0].length <= 50
1 <= grid[i][j] <= 1000
0 <= r0 < grid.length
0 <= c0 < grid[0].length
1 <= color <= 1000
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/coloring-a-border/solution/tong-yong-dao-yu-bfs-by-user8772/
 *
 *
 */
public class Solution {

    private int[][] dirArr = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int tColor = grid[r0][c0];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        visited[r0][c0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pArr = queue.poll();
                int r = pArr[0], c = pArr[1];
                for (int[] dir : dirArr) {
                    int nR = r + dir[0], nC = c + dir[1];
                    if (inArea(grid, nR, nC)) {
                        if (visited[nR][nC]) {
                            continue;
                        }
                        if (grid[nR][nC] == tColor) {
                            queue.add(new int[]{nR, nC});
                            visited[nR][nC] = true;
                        } else {
                            grid[r][c] = color;
                        }
                    } else {
                        grid[r][c] = color;
                    }
                }
            }
        }
        return grid;
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

}
