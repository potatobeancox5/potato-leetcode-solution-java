package com.potato.study.leetcode.p1254;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1254. Number of Closed Islands
 *  
 *
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.



Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation:
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
[1,0,0,0,0,0,1],
[1,0,1,1,1,0,1],
[1,0,1,0,1,0,1],
[1,0,1,1,1,0,1],
[1,0,0,0,0,0,1],
[1,1,1,1,1,1,1]]
Output: 2


Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1
 *         
 *         思路：dfs 求解
 *
 *          dfs 过的都设置成水域
 *          https://leetcode-cn.com/problems/number-of-closed-islands/solution/tong-yong-dao-yu-dfs-by-user8772-2/
 *
 *
 *

 *
 */
public class Solution {

    private int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int closedIsland(int[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果是陆地 找到
                if (grid[i][j]  == 0) {
                    count += dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 返回ij 所在的岛屿个数
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        int count = 1;
        if (grid[i][j] == 0) {
            grid[i][j] = 1;
            // 四周看看有多少个岛屿 相连接
            for (int[] dir : direction) {
                count = Math.min(count, dfs(grid, i + dir[0], j + dir[1]));
            }
        }

        return count;
    }

    public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] grid = new int[][]{{1,1,1,1,1,1,1}, {1,0,0,0,0,0,1}, {1,0,1,1,1,0,1}, {1,0,1,0,1,0,1}, {1,0,1,1,1,0,1},
                {1,0,0,0,0,0,1}, {1,1,1,1,1,1,1}};
        int res = solution.closedIsland(grid);
        System.out.println(res);
        Assert.assertEquals(2, res);


    }
}
