package com.potato.study.leetcode.p1368;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1368. Minimum Cost to Make at Least One Valid Path in a Grid
 *  
 *
Given a m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:
1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
Notice that there could be some invalid signs on the cells of the grid which points outside the grid.

You will initially start at the upper left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path doesn't have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.



Example 1:


Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
Output: 3
Explanation: You will start at point (0, 0).
The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
The total cost = 3.
Example 2:


Input: grid = [[1,1,3],[3,2,2],[1,1,4]]
Output: 0
Explanation: You can follow the path from (0, 0) to (2, 2).
Example 3:


Input: grid = [[1,2],[4,3]]
Output: 1
Example 4:

Input: grid = [[2,2,2],[2,2,2]]
Output: 3
Example 5:

Input: grid = [[4]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/solution/zhi-jie-bfsqiu-jie-java-by-z_zhaojun/
 *
 *
 *
 */
public class Solution {

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //由(0, 0)到其他网格的最小花费，为-1则表示待计算
        int dst[][] = new int[n][m];
        //用来保存待扩展的四个方向在纵轴和横轴上的增量，右-左-下-上
        int d[][] = {{}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < n; i++) {
            Arrays.fill(dst[i], -1);
        }
        //用来执行bfs的队列
        Queue<int[]> queue = new LinkedList<>();
        //int数组三个参数：纵轴、横轴、当前cost
        queue.offer(new int[] {0, 0, 0});
        while (!queue.isEmpty()) {
            int x = queue.size();
            for (int i = 0; i < x; i++) {
                int q[] = queue.poll();
                if (q[0] == n - 1 && q[1] == m - 1) {
                    continue;
                }
                int val = grid[q[0]][q[1]];
                for (int j = 1; j <= 4; j++) {
                    int r = q[0] + d[j][0];
                    int c = q[1] + d[j][1];
                    if (r >= 0 && c >= 0 && r < n && c < m) {
                        int add = j == val ? 0 : 1;
                        if (dst[r][c] == -1 || dst[r][c] > q[2] + add) {
                            dst[r][c] = q[2] + add;
                            queue.offer(new int[] {r, c, dst[r][c]});
                        }
                    }
                }
            }
        }
        return Math.max(0, dst[n - 1][m - 1]);
    }

}
