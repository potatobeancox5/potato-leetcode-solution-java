package com.potato.study.leetcode.p0803;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	803. Bricks Falling When Hit
 *  
 *         We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.

We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.

Return an array representing the number of bricks that will drop after each erasure in sequence.

Example 1:
Input:
grid = [[1,0,0,0],[1,1,1,0]]
hits = [[1,0]]
Output: [2]
Explanation:
If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
Example 2:
Input:
grid = [[1,0,0,0],[1,1,0,0]]
hits = [[1,1],[1,0]]
Output: [0,0]
Explanation:
When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause no bricks dropping.  Note that the erased brick (1, 0) will not be counted as a dropped brick.


Note:

The number of rows and columns in the grid will be in the range [1, 200].
The number of erasures will not exceed the area of the grid.
It is guaranteed that each erasure will be different from any other erasure, and located inside the grid.
An erasure may refer to a location with no brick - if it does, no bricks drop.
 *         
 *
 *        题目含义：
 *
 *          砖块保持与top 相连 且与该节点相连的点是不会掉下来的
 *          依次删除给定位置的点，返回一个数组，每个位置代表删除每个砖块后会脱落的点个数
 *
 *        思路：
 *          union -find
 *
 *          https://www.cnblogs.com/lightwindy/p/9576770.html
 *
 *
 *
 *
 * 
 */
public class Solution {
    // 方向
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {

        // 0 依次将 hits 点 从 grid里去掉 --
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]]--;
        }
        // 1 从每个位置 top 开始 dfs 设置 grid 设置规则 dfs 犯规坠落砖块个数
        for (int i = 0; i < grid[0].length; i++) {
            dfs(0, i, grid);
        }
        // 2 遍历 每个hit点  设置git点为1 如果当前hit 是1 且 isConnected 返回从 dfs开始遍历节点数目 - 1（hit点）
        int[] deleteCount = new int[hits.length];
        for (int i = hits.length - 1; i >= 0 ; i--) {
            int x = hits[i][0];
            int y = hits[i][1];

            grid[x][y]++;

            if (grid[x][y] == 1 && isConnected(x, y, grid)) {
                deleteCount[i] = dfs(x, y, grid) - 1;
            }

        }
        // 3 返回数组
        return deleteCount;

    }

    /**
     * 从 ij 开始进行dfs 并设置访问状态
     *
     * g[i][j] != 1 返回 g[i][j] = 2; 依次往四个方向dfs 2 代表访问过
     * @param i
     * @param j
     * @param grid
     * @return ij 一共链接了多少个块
     */
    private int dfs(int i, int j, int[][] grid) {
        // i j  valid
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 + dfs(i-1, j, grid) + dfs(i+1, j, grid) + dfs(i, j-1, grid) + dfs(i, j+1, grid);
    }

    /**
     * isConnected 逻辑 判断 i j 点开始 四个方向的邻接 是否都是2 2有两个作用 1 标记 已经访问过的点，非hit点  g[r][c] == 2
     * @param i
     * @param j
     * @param grid
     * @return
     */
    private boolean isConnected(int i, int j, int[][] grid) {
        if (i == 0) {
            return true;
        }
        for (int k = 0; k < direction.length; k++) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length
                    && grid[x][y] == 2) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1,0,0,0},{1,1,1,0}};
        int[][] hits = new int[][]{{1, 0}};
        int[] result = solution.hitBricks(grid, hits);
        System.out.println(Arrays.toString(result)); // 2

        grid = new int[][]{{1,0,0,0},{1,1,0,0}};
        hits = new int[][]{{1,1}, {1, 0}};
        result = solution.hitBricks(grid, hits);
        System.out.println(Arrays.toString(result)); // 0 0
    }
}
