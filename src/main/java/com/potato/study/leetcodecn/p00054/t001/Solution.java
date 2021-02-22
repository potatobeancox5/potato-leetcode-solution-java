package com.potato.study.leetcodecn.p00054.t001;


import com.potato.study.leetcode.util.LeetcodeInputUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

  

 示例 1：


 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[1,2,3,6,9,8,7,4,5]
 示例 2：


 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
  

 提示：

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 10
 -100 <= matrix[i][j] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/spiral-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用状态矩阵
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // 四个方向
        int[][] directions = new int[][] {
                {0, 1},{1,0},{0, -1},{-1, 0}
        };
        List<Integer> result = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        // 状态矩阵 记录 是够已经被遍历过 每次遇到 已经遍历过的点或者 便捷 就使用下一个方向遍历
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (result.size() < matrix.length * matrix[0].length) {
            // 访问当前节点
            visit[i][j] = true;
            result.add(matrix[i][j]);
            int temp1 = i + directions[index][0];
            int temp2 = j + directions[index][1];
            if (temp1 < 0 || temp1 >= matrix.length
                    || temp2 < 0 || temp2 >= matrix[0].length
                    || visit[temp1][temp2] == true) {
                // 判断是够达到便捷或者 到了访问过的店
                index++;
                index %= directions.length;
            }
            i += directions[index][0];
            j += directions[index][1];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = LeetcodeInputUtils.inputString2IntArrayTwoDimensional(
                "[[1,2,3,4],[5,6,7,8],[9,10,11,12]]"
        );
        List<Integer> res = solution.spiralOrder(matrix);
        System.out.println(res);
//        Assert.assertEquals(6, res);
    }
}
