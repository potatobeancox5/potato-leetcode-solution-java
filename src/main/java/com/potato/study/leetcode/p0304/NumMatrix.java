package com.potato.study.leetcode.p0304;

/**
 * 
 * @author liuzhao11
 * 
 *         304. Range Sum Query 2D - Immutable
 * 
 *         Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * 
 *         题目含义：
 *
 *
 *         思路：
 *         维护一个数组
 *         存储 00 - ij 的计算结果 初始化的时候生成
 *         每次调用使用这个矩阵进行计算
 *         https://www.cnblogs.com/grandyang/p/4958789.html
 */
public class NumMatrix {

    private int[][] plusReasultMatrix;

    private boolean isBlank = false;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            isBlank = true;
            return;
        }
        plusReasultMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j ==0) {
                    plusReasultMatrix[i][j] = matrix[i][j];
                } else if (i == 0) { // j!=0
                    plusReasultMatrix[i][j] = plusReasultMatrix[i][j-1] + matrix[i][j];
                } else if (j == 0) {
                    plusReasultMatrix[i][j] = plusReasultMatrix[i-1][j] + matrix[i][j];
                } else { // 都不是 利用方块相加的原理 记得减去重叠的面积
                    plusReasultMatrix[i][j] = plusReasultMatrix[i][j-1] + plusReasultMatrix[i-1][j]
                            - plusReasultMatrix[i-1][j-1]+ matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (isBlank) {
            return 0;
        }
        int result = plusReasultMatrix[row2][col2];
        if (row1 != 0) {
            result -= plusReasultMatrix[row1 - 1][col2];
        }
        if (col1 != 0) {
            result -= plusReasultMatrix[row2][col1 - 1];
        }
        if (row1 != 0 && col1 != 0) {
            result += plusReasultMatrix[row1 - 1][col1 - 1];
        }
        return result;
    }





	/**
	 * Your NumArray object will be instantiated and called as such: NumArray
	 * obj = new NumArray(nums); int param_1 = obj.sumRange(i,j);
	 */
	public static void main(String[] args) { // command+ option + l 格式化代码

        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
//        int result = numMatrix.sumRegion(2,1,4,3);
//        int result = numMatrix.sumRegion(1,1,2,2);
        int result = numMatrix.sumRegion(1,2,2,4);
        System.out.println(result);
    }
}
