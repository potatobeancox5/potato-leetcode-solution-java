package com.potato.study.leetcode.p0048;

import com.potato.study.leetcode.util.ArrayUtil;

/**
 * 
 * @author liuzhao11
 * 
 *       48. Rotate Image
 *       
 *       You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
]
 *         思路：
 *         先按正对角线交换
 *         然后按照垂直中轴线交换
 *         
 * 
 * 
 */
public class Solution {
	
	public void rotate(int[][] matrix) {
        if(null == matrix || matrix.length == 0) {
        	return;
        }
        rotateDiagonal(matrix);
        rotateVertical(matrix);
    }
	
	/**
	 * 按照正对角线 进行交换
	 * @param matrix
	 */
	private void rotateDiagonal(int[][] matrix) {
		for(int i = 0 ; i < matrix.length; i++) {
			for(int j = 0 ; j < i ; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
	
	/**
	 * 按照垂向进行交换
	 * @param matrix
	 */
	private void rotateVertical(int[][] matrix) {
		for(int i = 0 ; i < matrix.length ; i++) { // 控制行
			for(int j = 0 ; j < matrix.length / 2 ; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - j - 1];
				matrix[i][matrix.length - j - 1] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = 
			{
		  {1,2,3},
		  {4,5,6},
		  {7,8,9}
		  };
		solution.rotate(matrix);
		ArrayUtil.printMatrix(matrix);
	}
}
