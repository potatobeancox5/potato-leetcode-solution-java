package com.potato.study.leetcode.p0063;

/**
 * 
 * @author liuzhao11
 * 
 *         63. Unique Paths II
 * 
 *         Follow up for "Unique Paths":
 * 
 *         Now consider if some obstacles are added to the grids. How many
 *         unique paths would there be?
 * 
 *         An obstacle and empty space is marked as 1 and 0 respectively in the
 *         grid.
 * 
 *         For example, There is one obstacle in the middle of a 3x3 grid as
 *         illustrated below.
 * 
 *         [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
 * 
 *         Note: m and n will be at most 100.
 * 
 * 
 *         思路：dp[i][j] 表示到 i j 的种类数 
 *         	如果 当前位置不是障碍物的话
 * 				dp[i][j] = dp[i-1][j] + dp[i][j-1];
 * 			否则
 * 				dp[i][j] = 0;
 * 			压缩状态量
 * 				dpLine[j] = dp[j-1] + dp[j](i ，j 位置不是障碍物) 
 * 			
 * 
 */
public class Solution {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (null == obstacleGrid || obstacleGrid.length == 0) {
			return 0;
		}
		if(obstacleGrid[0].length == 0) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] dpLine = new int[n];
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(i == 0) { //设置第一行
					if(j == 0) {
						dpLine[j] = obstacleGrid[i][j] == 1 ? 0 : 1;
					} else {
						dpLine[j] = obstacleGrid[i][j] == 1 ? 0 : dpLine[j-1];
					}
				} else { // 从第二行开始
					if(j == 0) {
						dpLine[j] = obstacleGrid[i][j] == 1 ? 0 : dpLine[j];
					} else {
						dpLine[j] = obstacleGrid[i][j] == 1 ? 0 : dpLine[j] + dpLine[j-1];
					}
				}
			}
		}
		return dpLine[n-1];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int [][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		int kinds = solution.uniquePathsWithObstacles(obstacleGrid);
		System.out.println(kinds);
	}
}
