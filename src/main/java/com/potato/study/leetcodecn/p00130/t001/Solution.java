package com.potato.study.leetcodecn.p00130.t001;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 130. 被围绕的区域
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

 示例:

 X X X X
 X O O X
 X X O X
 X O X X
 运行你的函数后，矩阵变为：

 X X X X
 X X X X
 X X X X
 X O X X
 解释:

 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/surrounded-regions
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 从 4个 边开始 bfs 没有遍历过的点 ，这些点都是不用改变的 放到一个 set中
     * 2. 遍历 board 对于 不在 set 中 且 四 O的点 用 X替换
     * @param board
     */
    public void solve(char[][] board) {
        // 1. 从 4个 边开始 bfs 没有遍历过的点 ，这些点都是不用改变的 放到一个 set中
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<int[]> queue = new LinkedList<>();
        // 边界上 的 O
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
            }
            if (board[i][board[0].length - 1] == 'O') {
                queue.add(new int[]{i, board[0].length - 1});
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
            }
            if (board[board.length - 1][i] == 'O') {
                queue.add(new int[]{board.length - 1, i});
            }
        }

        // bfs 从边界往外延伸
        Set<String> noNeedFillSet = new HashSet<>();
        int[][] direction = new int[][] {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            visited[poll[0]][poll[1]] = true;
            noNeedFillSet.add(getKey(poll[0], poll[1]));
            // 四个方向
            for (int i = 0; i < 4; i++) {
                int nextI = poll[0] + direction[i][0];
                int nextJ = poll[1] + direction[i][1];
                // nextI nextJ 有效性
                if (nextI < 0 || nextI >= board.length || nextJ < 0 || nextJ >= board[0].length) {
                    continue;
                }
                if (visited[nextI][nextJ] || board[nextI][nextJ] == 'X'){
                    continue;
                }
                queue.add(new int[]{nextI, nextJ});
            }
        }
        // 2. 遍历 board 对于 不在 set 中 且 四 O的点 用 X替换
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 'X') {
                    continue;
                }

                if (!noNeedFillSet.contains(getKey(i, j))) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 生成 set的 key
     * @param i
     * @param j
     * @return
     */
    private String getKey(int i, int j) {
        return i + "_" + j;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));

        board = new char[][] {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

}
