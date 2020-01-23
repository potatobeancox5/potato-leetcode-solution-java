package com.potato.study.leetcode.p0688;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         688. Knight Probability in Chessboard
 * 
 *         On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.



Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.



Example:

Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.


Note:

N will be between 1 and 25.
K will be between 0 and 100.
The knight always initially starts on the board.
 *
 *         思路：
 *
 *         https://www.cnblogs.com/Dylan-Java-NYC/p/7633409.html
 *
 *
 *
 *
 */
public class Solution {

    /**
     *
     * @param n 矩阵大小
     * @param k 移动步数
     * @param r 开始位置坐标 - 行
     * @param c 开始位置坐标 - 列
     * @return
     */
    public double knightProbability(int n, int k, int r, int c) {
        // 0. 初始化 8种走法
        int[][] step = {{1,2},{-1,-2},{1,-2},{-1,2},{2,1},{-2,-1},{-2,1},{2,-1}};
        // 1 控制走 k 步 初始化 dp1 记录种类个数 初始化 dp ij = 1
        double[][] dp = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }
        // 内部控制从某个点开始走，走到 某个点
        for (int stepIndex = 0; stepIndex < k; stepIndex++) {
            //  每次申请信息 可能性数组 保存可能性 dpTmp 当前步数 到达每个点的情况数量
            double[][] dpTmp = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 起始点都是ij 求每次的终点
                    for (int[] eachStep : step) {
                        int finalRowIndex = i + eachStep[0];
                        int finalColIndex = j + eachStep[1];
                        // 更新终点种类数
                        if (isIllegal(finalRowIndex, finalColIndex, n)) {
                            dpTmp[finalRowIndex][finalColIndex] += dp[i][j];
                        }
                    }
                }
            }
            // 更新原始dp
            dp = dpTmp;
        }
        return dp[r][c] / Math.pow(8, k);
    }

    /**
     * 判断当前坐标是否合法
     * @param row       行index
     * @param col       列index
     * @param length    限制
     * @return
     */
    private boolean isIllegal(int row, int col, int length) {
        if (row < 0 || row >= length) {
            return false;
        }
        if (col < 0 || col >= length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int k = 2;
        int r = 0;
        int c = 0;
        double v = solution.knightProbability(n, k, r, c);
        System.out.println(v); // 0.0625
    }

}
