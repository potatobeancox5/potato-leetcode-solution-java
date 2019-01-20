package com.potato.study.leetcode.p0832;

import com.potato.study.leetcode.util.ArrayUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 	832. Flipping an Image
 *  
 *         Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Notes:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
 *         
 *         思路：
 *          1.先按照垂直方向反转
 *          2.将数据倒置
 * 
 */
public class Solution {

    public int[][] flipAndInvertImage(int[][] matrix) {
        int leftRow = 0;
        int rightRow = matrix[0].length - 1;
        // 反转
        while (leftRow < rightRow) {
            for (int i =0 ; i < matrix.length ; i++) {
                int tmp = matrix[i][leftRow];
                matrix[i][leftRow] = matrix[i][rightRow];
                matrix[i][rightRow] = tmp;
            }
            leftRow++;
            rightRow--;
        }
        // 倒置 使用异或
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] ^= 1;
            }
        }
        return matrix;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] grid = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] result = solution.flipAndInvertImage(grid);
        ArrayUtil.printMatrix(result);
    }
}
