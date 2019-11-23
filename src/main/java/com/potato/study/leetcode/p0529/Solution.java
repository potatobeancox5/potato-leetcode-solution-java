package com.potato.study.leetcode.p0529;



/**
 * 
 * @author liuzhao11
 * 
 *         529. Minesweeper
 * 
 *        Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

If a mine ('M') is revealed, then the game is over - change it to 'X'.
If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.


Example 1:

Input:

[['E', 'E', 'E', 'E', 'E'],
['E', 'E', 'M', 'E', 'E'],
['E', 'E', 'E', 'E', 'E'],
['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

Output:

[['B', '1', 'E', '1', 'B'],
['B', '1', 'M', '1', 'B'],
['B', '1', '1', '1', 'B'],
['B', 'B', 'B', 'B', 'B']]

Explanation:

Example 2:

Input:

[['B', '1', 'E', '1', 'B'],
['B', '1', 'M', '1', 'B'],
['B', '1', '1', '1', 'B'],
['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

Output:

[['B', '1', 'E', '1', 'B'],
['B', '1', 'X', '1', 'B'],
['B', '1', '1', '1', 'B'],
['B', 'B', 'B', 'B', 'B']]

Explanation:



Note:

The range of the input matrix's height and width is [1,50].
The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
The input board won't be a stage when game is over (some mines have been revealed).
For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 * 
 * 
 *         思路：
 *
 *          529. Minesweeper

给我一个雷盘

输入

https://leetcode.com/problems/minesweeper/discuss/427810/Java-DFS-beats-100

dfs 盘 横坐标 纵坐标

当前位置是雷 改了这个位置 返回
当前位置是e
找当前位置的八个方向是否有雷
如果有 计数器加一
找完计数为0改成b 不是改成数字
 *
 *
 *
 *
 *
 *
 *          
 */
public class Solution {

    public char[][] updateBoard(char[][] board, int[] click) {
        dfsUpdateTheBoard(board, click[0], click[1]);
        return board;
    }

    /**
         *
         * @param board 雷区
         * @param i     横坐标
         * @param j     纵坐标
         */
    private void dfsUpdateTheBoard(char[][] board, int i, int j) {
        // check i j
        if (i<0 || i >= board.length || j < 0 || j>=board[0].length) {
            return;
        }

        // 当前位置是雷 改了这个位置 返回
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        } else if (board[i][j] == 'E') {
            // 当前位置是e
            int mCount = 0;
            // 找当前位置的八个方向是否有雷
            if (i < board.length-1 && board[i+1][j] == 'M') {
                mCount++;
            }
            if (i > 0 && board[i-1][j] == 'M') {
                mCount++;
            }
            if (j < board[0].length -1 && board[i][j+1] == 'M') {
                mCount++;
            }
            if (j > 0 && board[i][j-1] == 'M') {
                mCount++;
            }
            if (i <board.length-1 && j < board[0].length -1 && board[i+1][j+1] == 'M') {
                mCount++;
            }
            if (i <board.length-1 && j > 0 && board[i+1][j-1] == 'M') {
                mCount++;
            }
            if (i > 0 && j < board[0].length -1 && board[i-1][j+1] == 'M') {
                mCount++;
            }
            if (i > 0 && j > 0 && board[i-1][j-1] == 'M') {
                mCount++;
            }
            // 找完计数为0改成b 不是改成数字
            if (mCount == 0) {
                board[i][j] = 'B';
            } else {
                board[i][j] = (char)('0' + mCount);
            }

            // 如果当前位置周边没有雷，停止遍历，否则往四周蔓延
            if (0 == mCount) {
                dfsUpdateTheBoard(board, i + 1, j);
                dfsUpdateTheBoard(board, i - 1, j);
                dfsUpdateTheBoard(board, i, j + 1);
                dfsUpdateTheBoard(board, i, j - 1);
                dfsUpdateTheBoard(board, i + 1, j + 1);
                dfsUpdateTheBoard(board, i + 1, j - 1);
                dfsUpdateTheBoard(board, i - 1, j + 1);
                dfsUpdateTheBoard(board, i - 1, j - 1);
            }
        }
    }

	
	public static void main(String[] args) {

//
//        int n = 2;
//        int res = solution.countArrangement(n);
//        System.out.println(res);
//        Assert.assertEquals(2, res);

    }
}
