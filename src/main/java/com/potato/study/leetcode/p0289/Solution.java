package com.potato.study.leetcode.p0289;

import com.potato.study.leetcode.util.ArrayUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 289. Game of Life
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input:
[
[0,1,0],
[0,0,1],
[1,1,1],
[0,0,0]
]
Output:
[
[0,0,0],
[1,0,1],
[0,1,1],
[0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 * 	题目含义：
 *      给定一种游戏规则，判断下一个board的状态数组，不能使用新建数组的办法
 * 	思路：
 *      利用原来的数组，生命几个新的状态
 *      0 当前已经死亡 未处理过
 *      1 当前还活着 未处理过
 *      2 从 0 - 0
 *      3 从 0 - 1
 *      4 从 1 - 0
 *      5 从 1 - 1
 *
 *      遍历一边数组，对于新数组根据给的值重新生成新数组
 *
 *
 *
 */
public class Solution {


    public void gameOfLife(int[][] board) {
        if (null ==board) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                makeNewBoardNode(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                } else if (board[i][j] == 4) {
                    board[i][j] = 0;
                } else if (board[i][j] == 5) {
                    board[i][j] = 1;
                }
            }
        }
    }

    /**
     * 根据游戏规则，判断这个位置的生死
     * @param board
     * @param i
     * @param j
     */
    private void makeNewBoardNode(int[][] board, int i, int j) {
        int liveNeighborNum = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k < 0 || k >= board.length) {
                    continue;
                }
                if (l < 0 || l >= board[0].length) {
                    continue;
                }
                if (k == i && l == j) {
                    continue;
                }
                // 真正计数
                if (board[k][l] == 1 || board[k][l] == 4 || board[k][l] == 5) {
                    liveNeighborNum++;
                }
            }
        }
        // 根据计数器设定这个值
        if (board[i][j] == 1 && liveNeighborNum < 2) {
            // 1 - 0;
            board[i][j] = 4;
        } else if (board[i][j] == 1 && liveNeighborNum > 3) {
            board[i][j] = 4;
        } else if (board[i][j] == 1 && (liveNeighborNum == 3 || liveNeighborNum == 2) ){
            board[i][j] = 5;
        } else if (board[i][j] == 0 && liveNeighborNum == 3) {
            board[i][j] = 3;
        }

    }


    public static void main(String[] args) {
    	Solution solution = new Solution();
        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
    	solution.gameOfLife(board);
        ArrayUtil.printMatrix(board);
    }
}
