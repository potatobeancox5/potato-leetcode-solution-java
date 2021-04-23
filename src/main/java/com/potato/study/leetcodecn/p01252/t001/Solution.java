package com.potato.study.leetcodecn.p01252.t001;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 1252. 奇数值单元格的数目
 *
 * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。

 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。

 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。

 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。

  

 示例 1：



 输入：n = 2, m = 3, indices = [[0,1],[1,1]]
 输出：6
 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 示例 2：



 输入：n = 2, m = 2, indices = [[1,1],[0,0]]
 输出：0
 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
  

 提示：

 1 <= n <= 50
 1 <= m <= 50
 1 <= indices.length <= 100
 0 <= indices[i][0] < n
 0 <= indices[i][1] < m

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public int oddCells(int n, int m, int[][] indices) {
        // 1 生命矩阵
        int[][] cell = new int[n][m];
        // 2 遍历 indices 依次 给 indices 0 行和 indices 1 列 ++
        for (int i = 0; i < indices.length; i++) {
            if (indices[i][0] >= n) {
                continue;
            }
            if (indices[i][1] >= m) {
                continue;
            }
            // 给 indices 0 行和 indices 1 列 ++
            for (int j = 0; j < m; j++) {
                cell[indices[i][0]][j]++;
            }
            for (int j = 0; j < n; j++) {
                cell[j][indices[i][1]]++;
            }
        }
        // 3 遍历矩阵计数
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cell[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        int m = 3;
        int[][] indices = new int[][] {
                {0,1},
                {1,1}
        };
        int oddCount = solution.oddCells(n, m, indices);
        System.out.println(oddCount);
        Assert.assertEquals(6, oddCount);
    }
}
