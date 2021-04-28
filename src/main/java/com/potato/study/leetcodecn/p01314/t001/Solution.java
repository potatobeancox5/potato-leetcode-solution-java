package com.potato.study.leetcodecn.p01314.t001;


import com.potato.study.leetcode.util.ArrayUtil;
import com.potato.study.leetcode.util.LeetcodeInputUtils;

import java.util.Arrays;

/**
 * 1314. 矩阵区域和
 *
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 

 i - K <= r <= i + K, j - K <= c <= j + K 
 (r, c) 在矩阵内。
  

 示例 1：

 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 输出：[[12,21,16],[27,45,33],[24,39,28]]
 示例 2：

 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 输出：[[45,45,45],[45,45,45],[45,45,45]]
  

 提示：

 m == mat.length
 n == mat[i].length
 1 <= m, n, K <= 100
 1 <= mat[i][j] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/matrix-block-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 先算每一个的前缀和，然后逐行叠加
     *
     * @param mat
     * @param k
     * @return
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        // 先算每一个的前缀和
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                // 每行的前缀和
                if (j == 0) {
                    continue;
                }
                mat[i][j] += mat[i][j-1];
            }
        }
        // 上下行相加
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0) {
                    continue;
                }
                mat[i][j] += mat[i-1][j];
            }
        }
        // 求完了和 然后求一下对应每个位置的结果
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                // 计算开始位置和终结位置
                int leftI = i - k;
                if (leftI < 0) {
                    leftI = 0;
                }
                int leftJ = j - k;
                if (leftJ < 0) {
                    leftJ = 0;
                }
                int rightI = i + k;
                if (rightI >= mat.length) {
                    rightI = mat.length - 1;
                }
                int rightJ = j + k;
                if (rightJ >= mat[0].length) {
                    rightJ = mat[0].length - 1;
                }
                // 通过矩形面积计得出结果
                if (leftI > 0 && leftJ > 0) {
                    res[i][j] = mat[rightI][rightJ] + mat[leftI-1][leftJ-1] - mat[leftI-1][rightJ] - mat[rightI][leftJ-1];
                } else if (leftI > 0) {
                    res[i][j] = mat[rightI][rightJ] - mat[leftI-1][rightJ];
                } else if (leftJ > 0) {
                    res[i][j] = mat[rightI][rightJ] - mat[rightI][leftJ-1];
                } else {
                    res[i][j] = mat[rightI][rightJ];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,2,3};
        int[][] mat = LeetcodeInputUtils.inputString2IntArrayTwoDimensional("[[1,2,3],[4,5,6],[7,8,9]]");
        int k = 1;
        int[][] res = solution.matrixBlockSum(mat, k);
        // [[12,21,16],[27,45,33],[24,39,28]]
        ArrayUtil.printMatrix(res);
    }
}
