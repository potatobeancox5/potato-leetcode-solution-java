package com.potato.study.leetcodecn.p00661.t001;

import java.util.Arrays;

/**
 * 661. 图片平滑器
 *
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。

 示例 1:

 输入:
 [[1,1,1],
 [1,0,1],
 [1,1,1]]
 输出:
 [[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
 解释:
 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 注意:

 给定矩阵中的整数范围为 [0, 255]。
 矩阵的长和宽的范围均为 [1, 150]。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/image-smoother
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param m
     * @return
     */
    public int[][] imageSmoother(int[][] m) {
        if (m == null) {
            return new int[0][0];
        }
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                res[i][j] = m[i][j];
                int n = 1;
                if (i > 0 && j > 0) {
                    res[i][j] += m[i - 1][j - 1];
                    n++;
                }
                if (i < m.length - 1 && j < m[0].length - 1) {
                    res[i][j] += m[i + 1][j + 1];
                    n++;
                }
                if (i > 0 && j < m[0].length - 1) {
                    res[i][j] += m[i - 1][j + 1];
                    n++;
                }
                if (i < m.length - 1 && j > 0) {
                    res[i][j] += m[i + 1][j - 1];
                    n++;
                }
                if (i > 0) {
                    res[i][j] += m[i - 1][j];
                    n++;
                }
                if (i < m.length - 1) {
                    res[i][j] += m[i + 1][j];
                    n++;
                }
                if (j > 0){
                    res[i][j] += m[i][j - 1];
                    n++;
                }
                if (j < m[0].length - 1) {
                    res[i][j] += m[i][j + 1];
                    n++;
                }
                res[i][j] /= n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[][] ints = solution.imageSmoother(m);
//        System.out.println(Arrays.deepToString(ints));
    }
}
