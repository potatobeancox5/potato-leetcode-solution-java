package com.potato.study.leetcode.p0807;

/**
 * 
 * @author liuzhao11
 * 
 * 	807. Max Increase to Keep City Skyline
 *  
 *         In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well.

At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.

What is the maximum total sum that the height of the buildings can be increased?

Example:
Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
Output: 35
Explanation:
The grid is:
[ [3, 0, 8, 4],
[2, 4, 5, 7],
[9, 2, 6, 3],
[0, 3, 1, 0] ]

The skyline viewed from top or bottom is: [9, 4, 8, 7]
The skyline viewed from left or right is: [8, 7, 9, 3]

The grid after increasing the height of buildings without affecting skylines is:

gridNew = [ [8, 4, 8, 7],
[7, 4, 7, 7],
[9, 4, 8, 7],
[3, 3, 3, 3] ]

Notes:

1 < grid.length = grid[0].length <= 50.
All heights grid[i][j] are in the range [0, 100].
All buildings in grid[i][j] occupy the entire grid cell: that is, they are a 1 x 1 x grid[i][j] rectangular prism.
 *         
 *         思路：
 *          找到【x,y】 中最小的值就是x行 y列最小值就是可以增加的值，如果当前值与天际线值相同，那这里不能再增长了
 * 
 */
public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // 先找到每行最大值
        int[] lineMax = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int max = grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                if (max < grid[i][j]) {
                    max = grid[i][j];
                }
            }
            lineMax[i] = max;
        }
        // 再找到每列的最大值
        int[] rowMax = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int max = grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                if (max < grid[j][i]) {
                    max = grid[j][i];
                }
            }
            rowMax[i] = max;
        }
        // 计算最终能增大多少
        int increasedNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != lineMax[i] && grid[i][j] != rowMax[j]) {
                    increasedNum += (min(lineMax[i], rowMax[j]) - grid[i][j]);
                }
            }
        }
        return increasedNum;
    }

    private int min (int a, int b) {
        return a < b ? a : b;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        int result = solution.maxIncreaseKeepingSkyline(grid);
        System.out.println(result);
    }
}
