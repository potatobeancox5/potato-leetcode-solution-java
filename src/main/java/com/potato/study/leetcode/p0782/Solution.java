package com.potato.study.leetcode.p0782;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	782. Transform to Chessboard
 *  
 *         An N x N board contains only 0s and 1s. In each move, you can swap any 2 rows with each other, or any 2 columns with each other.

What is the minimum number of moves to transform the board into a "chessboard" - a board where no 0s and no 1s are 4-directionally adjacent? If the task is impossible, return -1.

Examples:
Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
Output: 2
Explanation:
One potential sequence of moves is shown below, from left to right:

0110     1010     1010
0110 --> 1010 --> 0101
1001     0101     1010
1001     0101     0101

The first move swaps the first and second column.
The second move swaps the second and third row.


Input: board = [[0, 1], [1, 0]]
Output: 0
Explanation:
Also note that the board with 0 in the top left corner,
01
10

is also a valid chessboard.

Input: board = [[1, 0], [1, 0]]
Output: -1
Explanation:
No matter what sequence of moves you make, you cannot end with a valid chessboard.
Note:

board will have the same number of rows and columns, a number in the range [2, 30].
board[i][j] will be only 0s or 1s.
 *         
 *         思路：
 *
 *         https://blog.csdn.net/magicbean2/article/details/79722329
 *
 *
 *         https://www.cnblogs.com/ruruozhenhao/p/10662760.html
 *
 *
 *
 *
 * 
 */
public class Solution {

    public int movesToChessboard(int[][] board) {

        // 1. 检查任意四个角 是不是偶数个1 个数 0 2 4 用异或 如果最终等于1 无法通过移动构成
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[i][0] ^ board[0][j] ^ board[0][0] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }
        // 2. 统计每行 每列 是不是满足 都是 列的一半的个数 个1 并记录 偶数index 不是 0 的个数 作为交换的依据
        int oneCountRow = 0;
        int oneCountColumn = 0;

        int needSwapRow = 0;
        int needSwapCol = 0;

        for (int i = 0; i < n; i++) {
            oneCountRow += board[0][i];
            oneCountColumn += board[i][0];
            if (board[i][0] != i % 2) {
                needSwapRow++;
            }
            if (board[0][i] != i % 2) {
                needSwapCol++;
            }
        }
        if (n / 2 > oneCountRow || oneCountRow > (n + 1) / 2) {
            return -1;
        }
        if (n / 2 > oneCountColumn || oneCountColumn > (n + 1) / 2) {
            return -1;
        }
        // 3. 如果N 是奇数 那么只有一种移动方式 否则 有两种移动形式 保证一致即可
        if (n % 2 == 1) {
            if (needSwapCol % 2 == 1) {
                needSwapCol = n - needSwapCol;
            }
            if (needSwapRow % 2 == 1) {
                needSwapRow = n - needSwapRow;
            }
        } else {
            needSwapCol = Math.min(n - needSwapCol, needSwapCol);
            needSwapRow = Math.min(n - needSwapRow, needSwapRow);
        }
        return (needSwapCol + needSwapRow) / 2;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();


        int[][] board = {{0,1,1,0},{0,1,1,0},{1,0,0,1}};
        int res = solution.movesToChessboard(board);
        System.out.println(res);
        Assert.assertEquals(2, res);


        int[][] board1 = {{0, 1}, {1, 0}};
        res = solution.movesToChessboard(board1);
        System.out.println(res);
        Assert.assertEquals(0, res);


        int[][] board2 = {{1, 0}, {1, 0}};
        res = solution.movesToChessboard(board2);
        System.out.println(res);
        Assert.assertEquals(-1, res);

    }
}
