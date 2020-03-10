package com.potato.study.leetcode.p0794;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	794. Valid Tic-Tac-Toe State
 *  
 *         A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares (" ").
The first player always places "X" characters, while the second player always places "O" characters.
"X" and "O" characters are always placed into empty squares, never filled ones.
The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Example 1:
Input: board = ["O  ", "   ", "   "]
Output: false
Explanation: The first player always plays "X".

Example 2:
Input: board = ["XOX", " X ", "   "]
Output: false
Explanation: Players take turns making moves.

Example 3:
Input: board = ["XXX", "   ", "OOO"]
Output: false

Example 4:
Input: board = ["XOX", "O O", "XOX"]
Output: true
Note:

board is a length-3 array of strings, where each string board[i] has length 3.
Each board[i][j] is a character in the set {" ", "X", "O"}.
 *         
 *
 *         题目含义：
 *         判断一个 二维数组是否满足上述给定规则
 *
 *
 *         思路：
 *         https://www.cnblogs.com/grandyang/p/9223105.html
 *
 *         row i 每行有多少个X
 *         col i 每一列有多少个O
 *
 *
 *
 * 
 */
public class Solution {

    public boolean validTicTacToe(String[] board) {
        // 统计每一行 每一列 对角线和反对角线有多少个o 并记录turn （最终 0 / 1） X first\
        int turn = 0;
        int[] row = new int[3];
        int[] col = new int[3];

        // 对角线和反对角线
        int dia = 0;
        int diaO = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    turn++;
                    row[i]++;
                    col[j]++;
                    if (i == j) {
                        dia++;
                    }
                    if (i + j == 2) {
                        diaO++;
                    }
                } else if (board[i].charAt(j) == 'O'){
                    turn--;
                    row[i]--;
                    col[j]--;
                    if (i == j) {
                        dia--;
                    }
                    if (i + j == 2) {
                        diaO--;
                    }
                }
            }
        }
        // 判断胜利状态
        boolean isXWin = (row[0] == 3 || row[1] == 3 || row[2] == 3
                || col[0] == 3 || col[1] == 3 || col[2] == 3
                || dia == 3|| diaO == 3);
        boolean isOWin = (row[0] == -3 || row[1] == -3 || row[2] == -3
                || col[0] == -3 || col[1] == -3 || col[2] == -3
                || dia == -3 || diaO == -3);
        // 根据胜利状态判断结果
        if (isXWin && turn != 1) {
            return false;
        }
        if (isOWin && turn != 0) {
            return false;
        }
        if (isOWin && isXWin) {
            return false;
        }
        if (turn != 1 && turn != 0) {
            return false;
        }
        return true;
    }




	

	public static void main(String[] args) {
		Solution solution = new Solution();

        String[] board = new String[]{"O  ", "   ", "   "};
        boolean res = solution.validTicTacToe(board);
        System.out.println(res);
        Assert.assertEquals(false, res);


        board = new String[]{"XOX", " X ", "   "};
        res = solution.validTicTacToe(board);
        System.out.println(res);
        Assert.assertEquals(false, res);


        board = new String[]{"XXX", "   ", "OOO"};
        res = solution.validTicTacToe(board);
        System.out.println(res);
        Assert.assertEquals(false, res);

        board = new String[]{"XOX", "O O", "XOX"};
        res = solution.validTicTacToe(board);
        System.out.println(res);
        Assert.assertEquals(true, res);


        board = new String[]{"XO ", "XO ", "XO "};
        res = solution.validTicTacToe(board);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
