package com.potato.study.leetcode.p0661;

import com.potato.study.leetcode.util.ArrayUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         661. Image Smoother
 * 
 *         Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
[1,0,1],
[1,1,1]]
Output:
[[0, 0, 0],
[0, 0, 0],
[0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
The value in the given matrix is in the range of [0, 255].
The length and width of the given matrix are in the range of [1, 150].
 *
 *
 *
 *         思路：
 *
 *
 */
public class Solution {

    public int[][] imageSmoother(int[][] matrix) {

        int[][] retuenMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sum = matrix[i][j];
                int count = 1;
                // 上下左右
                if (i != 0) {
                    sum += matrix[i - 1][j];
                    count++;
                }
                if (i != matrix.length - 1) {
                    sum += matrix[i + 1][j];
                    count++;
                }
                if (j != 0) {
                    sum += matrix[i][j - 1];
                    count++;
                }
                if (j != matrix[0].length - 1) {
                    sum += matrix[i][j + 1];
                    count++;
                }
                // 斜向
                if (i != 0 && j != 0) {
                    sum += matrix[i -1][j - 1];
                    count++;
                }
                if (i != 0 && j != matrix[0].length - 1) {
                    sum += matrix[i -1][j + 1];
                    count++;
                }
                if (i != matrix.length - 1 && j != 0) {
                    sum += matrix[i +1][j - 1];
                    count++;
                }
                if (i != matrix.length - 1 && j != matrix[0].length - 1) {
                    sum += matrix[i +1][j + 1];
                    count++;
                }

                int ave = sum / count;
                retuenMatrix[i][j] = ave;
            }
        }
        return retuenMatrix;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] matrix =
                {{1,1,1},
                {1,0,1},
                {1,1,1}};
        int[][] result = solution.imageSmoother(matrix);
        ArrayUtil.printMatrix(result);
    }
}
