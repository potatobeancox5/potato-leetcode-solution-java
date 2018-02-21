package com.potato.study.leetcode.p0329;


/**
 * 
 * @author Administrator
 *
 *         329. Longest Increasing Path in a Matrix
 *         
 *          
 *         Given an integer matrix,
 *         find the length of the longest increasing path.
 * 
 *         From each cell, you can either move to four directions: left, right,
 *         up or down. You may NOT move diagonally or move outside of the
 *         boundary (i.e. wrap-around is not allowed).
 * 
 *         Example 1:
 * 
 *         nums = [ [9,9,4], [6,6,8], [2,1,1] ] Return 4 The longest increasing
 *         path is [1, 2, 6, 9].
 * 
 *         Example 2:
 * 
 *         nums = [ [3,4,5], [3,2,6], [2,2,1] ] Return 4 The longest increasing
 *         path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 *         Credits: Special thanks to @dietpepsi for adding this problem and
 *         creating all test cases.
 *         
 *         
 *         
 *         思路： 
 *         题意给定一个二维数组 寻找该数组的最长增长路径  并计算路径长度
 *         以矩阵中的每个元素为起点进行dfs搜索 查找每个顶点的最大增长路径
 *         使用 dp[i][j] 记录以ij 为起点的最长路径 作为优化
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {
	public int longestIncreasingPath(int[][] matrix) {
		// 判断是否存在 matrix
		if(null == matrix || matrix.length == 0) {
			return 0;
		}
		if(null == matrix[0] || matrix[0].length == 0) {
			return 0;
		}
		// 创建dp数组 并进行赋值 为-1 表示 还没有查到该节点
		int lineNum = matrix.length; // 行
		int rowNum = matrix[0].length; //列
		int[][] dp = new int[lineNum][rowNum];
		int maxLength = 0;
		for(int i = 0; i < lineNum ; i++) {
			for(int j = 0 ; j < rowNum ; j++) {
				dp[i][j] = -1;
			}
		}
		for(int i = 0; i < lineNum ; i++) {
			for(int j = 0 ; j < rowNum ; j++) {
				int currentLen = findLongestIncreasing(matrix,i,j, dp);
				maxLength = (maxLength > currentLen? maxLength : currentLen);
			}
		}
		// 算啥 起点
		return maxLength + 1;
	}
	
	/**
	 * 控制上下左右
	 */
	private int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
	
	/**
	 * 查找以i j 为起点的数组矩阵中 最长增长路径的长度
	 * 深度优先搜索的思想 来实现
	 * @param matrix	带查找的路径
	 * @param line		横坐标
	 * @param row		纵坐标
	 * @param result	查找的结果
	 * @return			当前i j 为开始位置的矩阵中最长增长路径的长度
	 */
	private int findLongestIncreasing(int[][] matrix, int line, int row, int[][] result) {
		// result 既 保存当前访问长度 
		// 该节点是否之前访问过通过题目中递增关系 来保证 不用记录
		
		// 先查之前结果
		if(result[line][row] != -1) {
			return result[line][row];
		}
		int maxLength = 0;
		// 上下左右的顺序 进行深度优先搜索 使用数组对 来保证前后左右
		for (int[] direction : directions) {
			//控制index 在边界范围内
			if(line + direction[0] >= matrix.length || line + direction[0] < 0
					|| row + direction[1] >= matrix[0].length || row + direction[1] < 0) {
				continue;
			}
			
			if(matrix[line][row] < matrix[line + direction[0]][row + direction[1]]) { 
				// 严格递增
				int current = 1 + findLongestIncreasing(matrix, line + direction[0], row + direction[1],result);
				if(current > maxLength) {
					maxLength = current;
				}
			}
		}
		//给 result[line][row] 赋值
		result[line][row] = maxLength;
		return maxLength;
	}

	public static void main(String[] args) {
		int [][] matrix = {
		                   {9,9,4},
		                   {6,6,8},
		                   {2,1,1}
		}; // 4
//		int [][] matrix = {
//                {3,4,5},
//                {3,2,6},
//                {2,2,1}
//		}; // 3
		Solution solution = new Solution();
		int len = solution.longestIncreasingPath(matrix);
		System.out.println(len);
	}
}
