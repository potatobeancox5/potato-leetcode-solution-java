package com.potato.study.leetcodecn.p00073.t002;


import com.potato.study.leetcode.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

 示例 1:

 输入:
 [
   [1,1,1],
   [1,0,1],
   [1,1,1]
 ]
 输出:
 [
   [1,0,1],
   [0,0,0],
   [1,0,1]
 ]
 示例 2:

 输入:
 [
   [0,1,2,0],
   [3,4,5,2],
   [1,3,1,5]
 ]
 输出:
 [
   [0,0,0,0],
   [0,4,5,0],
   [0,3,1,0]
 ]
 进阶:

 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 你能想出一个常数空间的解决方案吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * O 1 算法
     * 第一遍 记录如果遇到 0 标记每行第一个位置为 -555555 这样 （额外标记出第一列是不是为0）
     * 第二遍 每行 + 每列的第一个位置 如果都是 -555555 说明 改行 和改列为 0
     *
     * https://leetcode-cn.com/problems/set-matrix-zeroes/solution/ju-zhen-zhi-ling-by-leetcode/
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int firstColum = 0;
        // 第一遍 记录如果遇到 0 标记每行第一个位置为 -55555 这样 （额外标记出第一列是不是为0）
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = -555555;
                    matrix[0][j] = -555555;
                    if (j == 0) {
                        firstColum = -555555;
                    }
                }
            }
        }
        // 第二遍 每行 + 每列的第一个位置 如果都是 -555555 说明 改行 和改列为 0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] ==  -555555 || matrix[0][j] ==  -555555) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理第一行和第一列
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == -555555) {
                matrix[i][0] = 0;
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == -555555) {
                matrix[0][i] = 0;
            }
        }
        if (matrix[0][0] == -555555) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        // 处理第一列
        if (-555555 == firstColum) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][] {
                {1,1,1},{1,0,1},{1,1,1}
        };
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));


        matrix = new int[][] {
                {0,1,2,0},{3,4,5,2},{1,3,1,5}
        };
        solution.setZeroes(matrix);
        // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        System.out.println(Arrays.deepToString(matrix));
    }
}
