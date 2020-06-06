package com.potato.study.leetcode.p1463;


/**
 * 
 * @author liuzhao11
 * 
 * 	1463. Cherry Pickup II
 *  
 *
Given a rows x cols matrix grid representing a field of cherries. Each cell in grid represents the number of cherries that you can collect.

You have two robots that can collect cherries for you, Robot #1 is located at the top-left corner (0,0) , and Robot #2 is located at the top-right corner (0, cols-1) of the grid.

Return the maximum number of cherries collection using both robots  by following the rules below:

From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1).
When any robot is passing through a cell, It picks it up all cherries, and the cell becomes an empty cell (0).
When both robots stay on the same cell, only one of them takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in the grid.


Example 1:



Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
Example 2:



Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
Output: 28
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.
Example 3:

Input: grid = [[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]
Output: 22
Example 4:

Input: grid = [[1,1],[1,1]]
Output: 4


Constraints:

rows == grid.length
cols == grid[i].length
2 <= rows, cols <= 70
0 <= grid[i][j] <= 100
 *
 *
 *
 * 思路：
 *
 *  https://leetcode-cn.com/problems/cherry-pickup-ii/solution/java-dong-tai-gui-hua-12ms-cou-he-zhao-kan-ba-by-t/
 *
 *
 */
public class Solution {


    int[] move = new int[]{1, 0, -1};

    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][][] dp = new int[row][col][col];
        dp[0][0][col - 1] = grid[0][0] + grid[0][col - 1];

        for (int i = 1; i < row; i++) {
            int limit = Math.min(i, col - 1);   //这里处理稍微有点混乱... 就是 第一个机器人 如果在n行, 它无法运动超过 n列. 因为 最多就是每次向右下运动
//同理 第二个机器人 也有 运动范围
            for (int j = 0; j <= limit; j++) {
                for (int jj = col - limit - 1; jj < col; jj++) {
                    int max = 0;
                    for (int k : move) {        //枚举之前所有可以出现的情况
                        int j1 = j + k;
                        if (j1 >= 0 && j1 < col) {
                            for (int kk : move) {
                                int j2 = jj + kk;
                                if (j2 >= 0 && j2 < col) {
                                    max = Math.max(dp[i-1][j1][j2],max);
                                }
                            }
                        }
                    }
                    dp[i][j][jj] = max + grid[i][j] + grid[i][jj];
                    if (j == jj) {
                        dp[i][j][jj] -= grid[i][j];
                    }
                }
            }
        }
//最后挑出一个收益最大的方案
        int max = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(dp[row - 1][i][j], max);
            }
        }
        return max;
    }

}
