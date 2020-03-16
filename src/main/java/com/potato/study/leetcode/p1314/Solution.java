package com.potato.study.leetcode.p1314;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1314. Matrix Block Sum
 *  
 *
Given a m * n matrix mat and an integer K, return a matrix answer
where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K,
and (r, c) is a valid position in the matrix.


Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]
Example 2:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n, K <= 100
1 <= mat[i][j] <= 100
 *         
 *         思路：
 *
 *         res ij 是 i - K <= r <= i + K, j - K <= c <= j + K 的和
 *
 *         https://www.cnblogs.com/wentiliangkaihua/p/12196298.html
 *
 *          rangeSum 存储 从 0 0 开始计算的面积
 *
 *
 *          最终通过
 *          计算面积
 *          rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
 *
 *
 *

 *
 */
public class Solution {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] rangeSum = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rangeSum[i+1][j+1] = rangeSum[i+1][j] + rangeSum[i][j+1] - rangeSum[i][j] + mat[i][j];
            }
        }

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i-k, 0);
                int c1 = Math.max(j-k, 0);
                int r2 = Math.min(i+k+1, m);
                int c2 = Math.min(j+k+1, n);

                res[i][j] = rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
            }
        }
        return res;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int k= 1;
        int[][] matrix = solution.matrixBlockSum(mat, k);
        // [[12,21,16],[27,45,33],[24,39,28]]
        System.out.println(Arrays.deepToString(matrix));


        mat = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        k= 2;
        matrix = solution.matrixBlockSum(mat, k);
        // [[45,45,45],[45,45,45],[45,45,45]]
        System.out.println(Arrays.deepToString(matrix));

    }
}
