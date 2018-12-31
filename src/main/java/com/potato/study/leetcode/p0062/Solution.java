package com.potato.study.leetcode.p0062;

/**
 * 
 * @author liuzhao11
 * 
 *         62. Unique Paths
 * 
 *         A robot is located at the top-left corner of a m x n grid (marked
 *         'Start' in the diagram below).
 * 
 *         The robot can only move either down or right at any point in time.
 *         The robot is trying to reach the bottom-right corner of the grid
 *         (marked 'Finish' in the diagram below).
 * 
 *         How many possible unique paths are there?
 * 
 * 
 *         Above is a 3 x 7 grid. How many possible unique paths are there?
 * 
 *         Note: m and n will be at most 100.
 * 
 * 		思路：dp[i][j] 走到i，j 有多少种可能  
 * 		dp[i][j] = dp[i-1][j] + dp[i][j-1];
 * 	
 * 		压缩状态量：
 * 		dp[k] = dp[k] + dp[k-1];
 * 
 * 		最终的种类数 就是 dp[n]
 * 		
 * 
 */
public class Solution {
	
	public int uniquePaths(int m, int n) {
        int [] dp = new int[n];
        if(m <= 1 || n <= 1 ) {
        	return 1;
        }
        for(int i = 0 ; i < n ; i++) {
        	dp[i] = 1;
        }
        for(int i = 1 ; i < m ; i++) { // 控制行
        	for(int j = 1 ; j < n ; j++) { // 控制列
        		dp[j] = dp[j] + dp[j -1];
        	}
        }
        return dp[n-1];
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int pathNum = solution.uniquePaths(3, 3);
		System.out.println(pathNum);
	}
}
