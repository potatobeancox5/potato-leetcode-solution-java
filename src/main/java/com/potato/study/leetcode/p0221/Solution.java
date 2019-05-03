package com.potato.study.leetcode.p0221;

/**
 * 
 * @author liuzhao11
 * 
 *      221. Maximal Square
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 * *
 *
 * 题目含义：
 *  给定一个 矩阵 ，求其中1的方形最大部分的面积
 * 思路：
 *  https://blog.csdn.net/u012501459/article/details/46553139
 *  定义 sideLen[i][j] 为 i j 作为右下角的正方形的边长
 *  这样可以得到状态转移方程
 *
 *  过程中记录最大边长
 *  如果 ij 点为1的话
 *      sideLen[i][j] = min {sideLen[i-1][j], sideLen[i][j-1], sideLen[i-1][j-1]} + 1
 *  否则 sideLen[i][j] = 0;
 *  ps 第一行第一列的边长直接为 sideLen[i][j] = ij点处的值
 *
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        // 处理异常
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxSideLen = 0;
        int[][] sideLen = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 第一行第一列
                if (i == 0 || j == 0) {
                    sideLen[i][j] = (matrix[i][j] == '1' ? 1 : 0);
                } else if (matrix[i][j] == '1'){
                    sideLen[i][j] = Math.min(Math.min(sideLen[i-1][j], sideLen[i][j-1]),
                            sideLen[i-1][j-1]) + 1;
                } else {
                    sideLen[i][j] = 0;
                }
                // 设置最大值
                if (maxSideLen < sideLen[i][j]) {
                    maxSideLen = sideLen[i][j];
                }
            }
        }
        return maxSideLen * maxSideLen;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {};
        int area = solution.maximalSquare(matrix);
        System.out.println("area:" + area);
    }
}
