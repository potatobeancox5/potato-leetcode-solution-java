package com.potato.study.leetcode.p0867;

import com.potato.study.leetcode.util.ArrayUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 	867. Transpose Matrix
 *  
 *         Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.



Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]


Note:

1 <= A.length <= 1000
1 <= A[0].length <= 1000
 *         
 *
 *         题目含义：
 *

 *         思路：
 *              求矩阵的转zhi
申请一个新的数组，按照行列对应的形式进行赋值

 *
 *
 *
 */
public class Solution {

    public int[][] transpose(int[][] matrix) {
        int[][] tran = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                tran[j][i] = matrix[i][j];
            }
        }
        return tran;
    }




	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = {};
        int[][] transpose = solution.transpose(matrix);
        ArrayUtil.printMatrix(transpose);
    }
}
