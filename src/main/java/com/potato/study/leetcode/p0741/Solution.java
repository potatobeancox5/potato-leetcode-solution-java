package com.potato.study.leetcode.p0741;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	741. Cherry Pickup
 *  
 *         n a N x N grid representing a field of cherries, each cell is one of three possible integers.



0 means the cell is empty, so you can pass through;
1 means the cell contains a cherry, that you can pick up and pass through;
-1 means the cell contains a thorn that blocks your way.


Your task is to collect maximum number of cherries possible by following the rules below:



Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.




Example 1:

Input: grid =
[[0, 1, -1],
[1, 0, -1],
[1, 1,  1]]
Output: 5
Explanation:
The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
Then, the player went left, up, up, left to return home, picking up one more cherry.
The total number of cherries picked up is 5, and this is the maximum possible.


Note:

grid is an N by N 2D array, with 1 <= N <= 50.
Each grid[i][j] is an integer in the set {-1, 0, 1}.
It is guaranteed that grid[0][0] and grid[N-1][N-1] are not -1.
 *
 * 思路：
 *
 *
 *  给定一个矩阵 2维 从 0，0 开始走到 n-1， m-1 问最多能摘到多少个樱桃
 *  摘完之后必须能回去 左边或者 上 移动 要不
 *
 *  https://blog.csdn.net/luke2834/article/details/79365645
 *
 *  dp 解决问题 相当于  2个人同时从 0，0 走到 n，m 求最大值
 *
 *  dp i j 代表 某一个时刻t x1 走到i， t-i ； x2 走到j t-j的最大樱桃数字
 *
 *  那么 遍历 t 0 - m + n
 *
 *  https://blog.csdn.net/xdhc304/article/details/79557075
 *
 */
public class Solution {

    public int cherryPickup(int[][] grid) {
        // 遍历1 - 2n - 2
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int[] row: dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        dp[0][0] = grid[0][0];

        // 控制 dp 迭代次数
        for (int t = 1; t < 2 * n - 1; t++) {
            // 初始化 dpTmp 为最小值
            int[][] dpTmp = new int[n][n];
            for (int[] row: dpTmp) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }

            // 遍历 i from 0 - k -i ,j
            for (int i = Math.max(0, t - n + 1); i <= Math.min(n-1, t); i++) {
                for (int j = Math.max(0, t - n + 1); j <= Math.min(n-1, t); j++) {
                    // 如果有刺 continue
                    if (grid[i][t-i] == -1 || grid[j][t-j] == -1) {
                        continue;
                    }
                    // 当前格子里的樱桃数量
                    int val = grid[i][t-i];
                    if (i != j) {
                        val += grid[j][t-j];
                    }
                    // 状态转移
                    for (int k = i-1; k <=i; k++) {
                        for (int l = j-1; l <=j ; l++) {
                            if (k >= 0 && l >= 0) {
                                dpTmp[i][j] = Math.max(dpTmp[i][j], val + dp[k][l]);
                            }
                        }
                    }
                }
            }
            dp = dpTmp;
        }
        return Math.max(0, dp[n-1][n-1]);
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1,  1}};
        int num = solution.cherryPickup(grid);
		System.out.println(num);
        Assert.assertEquals(5, num);
    }
}
