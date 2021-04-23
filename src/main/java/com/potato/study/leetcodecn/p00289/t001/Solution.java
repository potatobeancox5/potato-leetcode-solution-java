package com.potato.study.leetcodecn.p00289.t001;


import org.junit.Assert;

/**
 * 289. 生命游戏
 *
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。

  

 示例 1：


 输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 示例 2：


 输入：board = [[1,1],[1,0]]
 输出：[[1,1],[1,1]]
  

 提示：

 m == board.length
 n == board[i].length
 1 <= m, n <= 25
 board[i][j] 为 0 或 1
  

 进阶：

 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/game-of-life
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     * 当前矩阵 01 使用 2345
     * 2 0-0
     * 3 0-1
     * 4 1-0
     * 5 1-1
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        // 遍历 board 根据周围状态 修改 当前数组 存储的值
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCount = getAroudLiveNum(board, i, j);
                boolean isLive = isLiveStatus(board[i][j]);
                if (isLive) {
                    // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                    if (liveCount < 2) {
                        // 1 -0
                        board[i][j] = 4;
                    } else if (liveCount > 3) {
                        // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                        board[i][j] = 4;
                    } else {
                        // 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                        board[i][j] = 5;
                    }
                } else {
                    // 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    if (liveCount == 3) {
                        // 0 -1
                        board[i][j] = 3;
                    } else {
                        board[i][j] = 2;
                    }
                }
            }
        }
        // 遍历 board 根据 2345 状态 修改最终的矩阵 最后的状态
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 1) {
                    board[i][j] %= 2;
                }
            }
        }
    }

    /**
     * 根据 状态判定当前是不是存活 根据之前的状态判断
     * @return
     */
    private boolean isLiveStatus(int status) {
        if (status == 1) {
            return true;
        }
        if (status >= 4) {
            return true;
        }
        return false;
    }

    /**
     * 返回 周围 存活的个数
     * @return
     */
    private int getAroudLiveNum(int[][] board, int i, int j) {
        int count = 0;
        int[][] direction = new int[][] {
                {-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        for (int k = 0; k < direction.length; k++) {
            int current1 = i + direction[k][0];
            int current2 = j + direction[k][1];
            // 坐标不对 直接continue
            if (current1 < 0 || current1 >= board.length) {
                continue;
            }
            if (current2 < 0 || current2 >= board[0].length) {
                continue;
            }
            if (board[current1][current2] == 1 || board[current1][current2] >= 4) {
                count++;
            }
        }
        return count;
    }


}
