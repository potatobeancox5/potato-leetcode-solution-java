package com.potato.study.leetcode.p1219;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1219. Path with Maximum Gold
 *  
 *n a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position you can walk one step to the left, right, up or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.


Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
[5,8,7],
[0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
[2,0,6],
[3,4,5],
[0,3,0],
[9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.


Constraints:

1 <= grid.length, grid[i].length <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.
 *         
 *         思路：
 *
 *          http://www.manongjc.com/detail/13-tqjzaijggujqhll.html
 *
 *          https://leetcode.com/problems/path-with-maximum-gold/discuss/564191/Java-O(1)-space-DFS-Solution
 *
 *
 *
 */
public class Solution {

    public int getMaximumGold(int[][] grid) {
        int max = 0;
        // ij 每个位置开始 找到最大点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    max = Math.max(max, getMaxGold(grid, i, j));
                }
            }
        }
        return max;
    }

    /**
     * ij 为起点 最多能获取多少金子
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int getMaxGold(int[][] grid, int i, int j) {
        // 当前 节点 超了限制 或者已经遍历过
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= 0) {
            return 0;
        }
        // 标记 当前点
        int cur = grid[i][j];
        // 记录四个位置获得的金币
        grid[i][j] = -1 * grid[i][j];
        int[] sum = new int[4];
        sum[0] = getMaxGold(grid, i+1, j);
        sum[1] = getMaxGold(grid, i-1, j);
        sum[2] = getMaxGold(grid, i, j+1);
        sum[3] = getMaxGold(grid, i, j-1);
        // 当前节点的金币量 + 四个方向最多的金币
        grid[i][j] = -1 * grid[i][j];

        int max = sum[0];
        for (int k = 1; k < 4; k++) {
            max = Math.max(max, sum[k]);
        }
        return cur + max;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] grid = new int[][]{{0,6,0}, {5,8,7}, {0,9,0}};
        int res = solution.getMaximumGold(grid);
        System.out.println(res);
        Assert.assertEquals(24, res);


        grid = new int[][]{{1,0,7},{2,0,6},{3,4,5},{0,3,0}};
        res = solution.getMaximumGold(grid);
        System.out.println(res);
        Assert.assertEquals(28, res);

    }
}
