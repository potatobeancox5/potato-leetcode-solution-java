package com.potato.study.leetcodecn.p00304.t001;

import org.junit.Assert;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入:
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出:
 * [null, 8, 11, 12]
 *
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * -105 <= matrix[i][j] <= 105
 * 0 <= row1 <= row2 < m
 * 0 <= col1 <= col2 < n
 * 最多调用 104 次 sumRegion 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class NumMatrix {

    private long[][] sumMatrix;

    /**
     * 直接计算 和
     * @param matrix
     */
    public NumMatrix(int[][] matrix) {
        long[][] sumMatrix = new long[matrix.length + 1][matrix[0].length + 1];
        // 按行求和
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                sumMatrix[i][j] = sumMatrix[i][j-1] + matrix[i-1][j-1];
            }
        }
        // 每个点 叠加上面的值
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                sumMatrix[i][j] += sumMatrix[i-1][j];
            }
        }
        // 存下和
        this.sumMatrix = sumMatrix;
    }

    /**
     * sumMatrix row2 + 1 col2 + 1  + row1 col1
     * 减去 row2+1， col1
     * 减去 row1 ， col2+1
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        long result = sumMatrix[row2+1][col2+1] + sumMatrix[row1][col1]
                - sumMatrix[row2+1][col1] - sumMatrix[row1][col2+1];
        return (int) result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        int row1 = 2;
        int col1 = 1;
        int row2 = 4;
        int col2 = 3;
        int i = numMatrix.sumRegion(row1, col1, row2, col2);
        System.out.println(i);
        Assert.assertEquals(8, i);
    }
}
