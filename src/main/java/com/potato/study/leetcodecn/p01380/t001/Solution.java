package com.potato.study.leetcodecn.p01380.t001;


import java.util.*;

/**
 * 1380. 矩阵中的幸运数
 *
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。

 幸运数是指矩阵中满足同时下列两个条件的元素：

 在同一行的所有元素中最小
 在同一列的所有元素中最大
  

 示例 1：

 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 输出：[15]
 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 示例 2：

 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 输出：[12]
 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 示例 3：

 输入：matrix = [[7,8],[1,2]]
 输出：[7]
  

 提示：

 m == mat.length
 n == mat[i].length
 1 <= n, m <= 50
 1 <= matrix[i][j] <= 10^5
 矩阵中的所有元素都是不同的

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     * 先按照行遍历 找到每一个行对应的最小值
     * 再遍历列 找到每一个列对应的最大值
     * 排序上面两个数组 找到交集
     * （因为数字不重复）
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> minOfLine = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            minOfLine.add(min);
        }
        Set<Integer> maxOfColumn = new HashSet<>();
        for (int i = 0; i < matrix[0].length; i++) {
            int max = matrix[0][i];
            for (int j = 1; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            maxOfColumn.add(max);
        }
        // 找到交集
        maxOfColumn.retainAll(minOfLine);
        return new ArrayList<>(maxOfColumn);
    }

}
