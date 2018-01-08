package com.potato.study.leetcode.p0064;

/**
 * 
 * @author liuzhao11
 * 
 *         64. Minimum Path Sum
 * 
 * 
 *         Given a m x n grid filled with non-negative numbers, find a path from
 *         top left to bottom right which minimizes the sum of all numbers along
 *         its path.
 * 
 *         Note: You can only move either down or right at any point in time.
 * 
 *         Example 1: [[1,3,1], [1,5,1], [4,2,1]] Given the above grid map,
 *         return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * 
 *         思路：
 * 			dp方程
 * 			dp[i][j] = min{dp[i-1][j], dp[i][j-1]} + grid[i][j];
 * 			dp[i][j] 走到 i j 的最小距离
 * 			dp[0][j] = 叠加
 * 			dp[i][0] = 叠加
 * 		状态量压缩
 * 		dpLine[n]  n为列数量
 * 			dpLine[i] = min{dpLine[i-1] , dpLine[i]} + grid[i][j]
 * 
 */
public class Solution {
	
	public int minPathSum(int[][] grid) {
        if(null == grid || grid.length == 0) {
        		return 0;
        }
        if(grid[0].length == 0) { //1行0列
        		return 0;
        }
        // 设置第一行数据
        int length = grid[0].length;
        int[] dpLine = new int[length];
        dpLine[0] = grid[0][0];
        for(int i = 1 ; i < length ; i++) {
        		dpLine[i] = dpLine[i-1] + grid[0][i];
        }
        for(int i = 1 ; i < grid.length ; i++) {
        		for(int j = 0 ; j < length ; j++) {
        			if(j == 0) {
        				dpLine[j] += grid[i][j];
        			} else {
        				dpLine[j] = min(dpLine[j],dpLine[j-1]) + grid[i][j];
        			}
        		}
        }
        return dpLine[length - 1];
    }

	private int min(int a , int b) {
		return a > b ? b : a;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
//		int[][] grid = { { 1}};
//		int[][] grid = { { }};
		int[][] grid = {};
		int path = solution.minPathSum(grid);
		System.out.println(path);
		
	}
}
