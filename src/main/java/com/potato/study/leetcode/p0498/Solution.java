package com.potato.study.leetcode.p0498;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         498. Diagonal Traverse
 * 
 *         Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.



Example:

Input:
[
[ 1, 2, 3 ],
[ 4, 5, 6 ],
[ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:



Note:

The total number of elements of the given matrix will not exceed 10,000.
 *
 *
 *         题目含义：
 *
 *         思路： 按照对接线维度输出
 *         https://segmentfault.com/a/1190000016130041?utm_medium=referral&utm_source=tuicool
 *
 *         首先从 00 开始 使用一个表示为代表现在的遍历方向 direction = true 向右上 false 左下
 *
 *         如果方向是 false 左下
 *              如果 碰到了左边 列 = 0
 *                  方向 true
 *                  往下走一个几点
 *              如果碰到了下边 行 == len -1
 *                  方向 true
 *                  往右走一个界定
 *              如果都没有的话 行++ j--
 *
 *
 *         如果方向是 true 右上
 * 
 */
public class Solution {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];

        boolean directionLeftDown = false;
        int i = 0;
        int j = 0;
        int index = 1;
        res[0] = matrix[0][0];
        while (i != matrix.length - 1 || j != matrix[0].length - 1) {
            if (directionLeftDown) {
                // 正在往左下走
                if (j == 0 && i < matrix.length - 1) {
                    // 碰到了左边
                    i++;
                    directionLeftDown = false;
                } else if (i == matrix.length - 1 && j < matrix[0].length - 1) {
                    // donw
                    j++;
                    directionLeftDown = false;
                } else if (j > 0 && i < matrix.length -1){
                    i++;
                    j--;
                }
            } else {
                // 正在往右上走
                if (i == 0 && j < matrix[0].length - 1) {
                    j++;
                    directionLeftDown = true;
                } else if (j == matrix[0].length - 1 && i < matrix.length - 1) {
                    // right most
                    i++;
                    directionLeftDown = true;
                } else if (i > 0 && j < matrix[0].length -1){
                    i--;
                    j++;
                }
            }
            res[index++] = matrix[i][j];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] res = solution.findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(res));
    }
}
