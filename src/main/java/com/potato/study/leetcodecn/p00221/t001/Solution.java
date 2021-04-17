package com.potato.study.leetcodecn.p00221.t001;

import com.potato.study.leetcode.util.ArrayUtil;
import org.junit.Assert;

/**
 * 221. 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

  

 示例 1：


 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 输出：4
 示例 2：


 输入：matrix = [["0","1"],["1","0"]]
 输出：1
 示例 3：

 输入：matrix = [["0"]]
 输出：0
  

 提示：

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 300
 matrix[i][j] 为 '0' 或 '1'

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximal-square
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dp ij 以点 ij 为右下端点 的正方形边长多少
     * dp ij 初始 dp 0 0 按照 matrix 是否为 1计算 同理处理 0行 0列
     * dp ij = 0 如果 matrix ij = '0'
     * dp ij = 1    如果
     * dp ij =
     *    max 以下
     *      dp i-1，j-1 如果 matrix ij = '1' 且 第 i行 j到 j - dp i-1，j-1 - 1位置都是1
     *      dp i，j-1 如果 matrix ij = '1' 且 第 j 列
     *      dp i-1，j 如果 matrix ij = '1' 且 第 i行 j到 j - dp i-1，j-1 - 1位置都是1
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxSide = 0;
        // 初始化 0 行和 0 列
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            }
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
            }
            maxSide = Math.max(maxSide, dp[0][i]);
        }
        // 从 第一行 和第一列 开始 遍历
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = this.maxSide(i, j, dp, matrix);
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        ArrayUtil.printMatrix(dp);
        return maxSide * maxSide;
    }

    /**
     *
     * @param i
     * @param j
     * @param dp
     * @return
     */
    private int maxSide(int i, int j, int[][] dp, char[][] matrix) {
        // i-1 和 j-1 组成
        boolean isSquare = true;
        int len = dp[i - 1][j - 1];
        for (int k = 0; k < len; k++) {
            if (matrix[i][j-1-k] == '0' || matrix[i-1-k][j] == '0') {
                isSquare = false;
                break;
            }
        }
        // 如果 当前位置 可以和之前位置 组成大的正方形
        if (isSquare) {
            dp[i][j] = dp[i-1][j-1] + 1;
        } else {
            dp[i][j] = 1;
        }
        dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
        dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
        return dp[i][j];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int max = solution.maximalSquare(matrix);
        System.out.println(max);
        Assert.assertEquals(4, max);

        matrix = new char[][] {
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };
        max = solution.maximalSquare(matrix);
        System.out.println(max);
        Assert.assertEquals(9, max);

        matrix = new char[][] {
                {'1','1','1','1'},
                {'1','1','1','1'},
                {'0','0','0','0'},
                {'1','1','1','1'},
                {'1','1','1','1'}
        };
        max = solution.maximalSquare(matrix);
        System.out.println(max);
        Assert.assertEquals(4, max);


        matrix = new char[][] {
                {'1','0','1','0'},
                {'1','0','1','1'},
                {'1','0','1','1'},
                {'1','1','1','1'}
        };
        max = solution.maximalSquare(matrix);
        System.out.println(max);
        Assert.assertEquals(4, max);


        matrix = new char[][] {
                {'0','1','1','0','0','1','0','1','0','1'},
                {'0','0','1','0','1','0','1','0','1','0'},
                {'1','0','0','0','0','1','0','1','1','0'},
                {'0','1','1','1','1','1','1','0','1','0'},
                {'0','0','1','1','1','1','1','1','1','0'},
                {'1','1','0','1','0','1','1','1','1','0'},
                {'0','0','0','1','1','0','0','0','1','0'},
                {'1','1','0','1','1','0','0','1','1','1'},
                {'0','1','0','1','1','0','1','0','1','1'}
        };
        max = solution.maximalSquare(matrix);
        System.out.println(max);
        Assert.assertEquals(4, max);
    }
}
