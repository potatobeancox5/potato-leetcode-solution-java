package com.potato.study.leetcodecn.p01329.t001;


import com.potato.study.leetcode.util.ArrayUtil;
import com.potato.study.leetcode.util.LeetcodeInputUtils;
import com.potato.study.leetcode.util.LeetcodeUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1329. 将矩阵按对角线排序
 *
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。

 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。

  

 示例 1：



 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 示例 2：

 输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
 输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
  

 提示：

 m == mat.length
 n == mat[i].length
 1 <= m, n <= 100
 1 <= mat[i][j] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sort-the-matrix-diagonally
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 从 00 - 0x 开始遍历 mat 每次 往下 xy 均 ++ 直到 遇到了 边界 停止，
     *      将生成的list 进行排序
     *      排序之后 重新放回原来的位置
     * 2. 从 10 - x0 开始 同样的步骤
     * @param mat
     * @return
     */
    public int[][] diagonalSort(int[][] mat) {
        // 1. 从 00 - 0x 开始遍历 mat 每次 往下 xy 均 ++ 直到 遇到了 边界 停止，
        for (int i = 0; i < mat[0].length; i++) {
            int x = 0;
            int y = i;
            List<Integer> list = new ArrayList<>();
            while (x < mat.length && y < mat[0].length) {
                list.add(mat[x][y]);
                x++;
                y++;
            }
            // 进行排序
            Collections.sort(list);
            x = 0;
            y = i;
            int index = 0;
            sortAndSetDiagonal(mat, x, y, list, index);

        }
        // 2. 从 10 - x0 开始 同样的步骤
        for (int i = 1; i < mat.length; i++) {
            int x = i;
            int y = 0;
            List<Integer> list = new ArrayList<>();
            while (x < mat.length && y < mat[0].length) {
                list.add(mat[x][y]);
                x++;
                y++;
            }
            // 进行排序
            Collections.sort(list);
            x = i;
            y = 0;
            int index = 0;
            sortAndSetDiagonal(mat, x, y, list, index);

        }
        return mat;
    }

    private void sortAndSetDiagonal(int[][] mat, int x, int y, List<Integer> list, int index) {
        while (x < mat.length && y < mat[0].length && index < list.size()) {
            mat[x][y] = list.get(index);
            index++;
            x++;
            y++;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "[[3,3,1,1],[2,2,1,2],[1,1,1,2]]";
        int[][] array = LeetcodeInputUtils.inputString2IntArrayTwoDimensional(input);
        int[][] res = solution.diagonalSort(array);
        // [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
        ArrayUtil.printMatrix(res);
    }
}
