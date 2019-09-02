package com.potato.study.leetcode.p0695;

/**
 * 
 * @author liuzhao11
 * 
 * 	695. Max Area of Island
 *  
 *        Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,1,1,0,1,0,0,0,0,0,0,0,0],
[0,1,0,0,1,1,0,0,1,0,1,0,0],
[0,1,0,0,1,1,0,0,1,1,1,0,0],
[0,0,0,0,0,0,0,0,0,0,1,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.

 *         题目解释：
 *          没走完一步将走过节点设置为0 这样就用再重复走了
 *
 *          https://www.cnblogs.com/jimmycheng/p/7715061.html
 *         
 *
 *
 * 
 */
public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int value = dfsFindArea(grid, i, j);
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }


    /**
     * 从ij 开始dfs计算面积
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int dfsFindArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        int count = 0;
        if (grid[i][j] == 0) {
            return count;
        }
        count++;
        grid[i][j] = 0;
//        System.out.println("i:" + i + ",j:" + j + ", count: " + count) ;
        count = count + dfsFindArea(grid, i - 1, j) + dfsFindArea(grid, i + 1, j)
                + dfsFindArea(grid, i, j - 1) + dfsFindArea(grid, i, j + 1);
//        grid[i][j] = 1;
        return count;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] grid = {{1,1,0},{1,1,0},{0,0,0}};
        int b = solution.maxAreaOfIsland(grid);
        System.out.println(b);
    }
}
