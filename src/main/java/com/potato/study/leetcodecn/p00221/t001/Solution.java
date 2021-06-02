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
     * dp ij 代表 以ij为右下角点的最长的边长
     * 如果 matrix ij 位置是 0 那么 这个点的dp 是0
     * 如果 matrix ij 位置是 1 那么 matrix 位置
     * dp ij = min {dp i-1,j, dp ij-1, dp i-1, j-1} + 1
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                    dp[i][j] += 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
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
