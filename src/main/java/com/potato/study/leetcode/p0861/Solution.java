package com.potato.study.leetcode.p0861;

/**
 * 
 * @author liuzhao11
 * 
 * 	861. Score After Flipping Matrix
 *  
 *         We have a two dimensional matrix A where each value is 0 or 1.

A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score.



Example 1:

Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39


Note:

1 <= A.length <= 20
1 <= A[0].length <= 20
A[i][j] is 0 or 1.
 *         
 *
 *         题目含义：
 *             https://blog.csdn.net/qq_38959715/article/details/80931992

 *         思路：
 *              行最佳解是行最先的位置为1
                列的最佳解是 列中1最多的时候
 *
 *
 *
 */
public class Solution {

    public int matrixScore(int[][] matrix) {
        // 判断当前每一行是不是都是最佳解
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1) {
                continue;
            } else {
                revertLine(matrix, i);
            }
        }
        // 判断当前列经过转换之后是否能够达成最佳 能得话 旋转 否则保持不变
        for (int i = 1; i < matrix[0].length ; i++) {
            int countBefore = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    countBefore++;
                }
            }
            int countAfter = 0;
            this.revertRow(matrix, i);
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    countAfter++;
                }
            }
            if (countBefore > countAfter) {
                this.revertRow(matrix, i);
            }
        }
        return sumForLine(matrix);
    }

    /**
     * 每行为二进制数求和求和
     * @param matrix
     * @return
     */
    private int sumForLine(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = matrix[0].length - 1; j >= 0 ; j--) {
                int tmp = matrix[i][matrix[0].length - 1 - j];
                tmp = tmp << j;
                sum += tmp;
            }
        }
        return sum;
    }

    /**
     * 旋转一行
     * @param matrix
     */
    private void revertLine(int[][] matrix, int line) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[line][i] ^= 1;
        }
    }

    /**
     * 旋转一列
     * @param matrix
     */
    private void revertRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][row] ^= 1;
        }
    }




	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] matrix = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int result = solution.matrixScore(matrix);
        System.out.println(result);
    }
}
