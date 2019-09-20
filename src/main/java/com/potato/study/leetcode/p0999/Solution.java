package com.potato.study.leetcode.p0999;


/**
 * 
 * @author liuzhao11
 * 
 * 	999. Available Captures for Rook
 *  
 *         On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.

The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.

Return the number of pawns the rook can capture in one move.



Example 1:



Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation:
In this example the rook is able to capture all the pawns.
Example 2:



Input: [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 0
Explanation:
Bishops are blocking the rook to capture any pawn.
Example 3:



Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation:
The rook can capture the pawns at positions b5, d6 and f5.


Note:

board.length == board[i].length == 8
board[i][j] is either 'R', '.', 'B', or 'p'
There is exactly one cell with board[i][j] == 'R'
 *         
 *         思路：
 *         找到R 然后往上下左右找是否有p 知道遇到p 遇到B 遇到边位置
 *

 *
 */
public class Solution {

    public int numRookCaptures(char[][] board) {
        // 找到起始的位置
        int x = 0;
        int y = 0;
        f :
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break f;
                }
            }
        }
        // 分别向四个方向找
        int sum = 0;
        // 下
        for (int i = x + 1; i < board.length; i++) {
            if (board[i][y] == 'B') {
                break;
            } else if (board[i][y] == 'p') {
                sum++;
                break;
            }
        }
        // 上
        for (int i = x - 1; i >= 0 ; i--) {
            if (board[i][y] == 'B') {
                break;
            } else if (board[i][y] == 'p') {
                sum++;
                break;
            }
        }
        // 右
        for (int i = y + 1; i < board[0].length; i++) {
            if (board[x][i] == 'B') {
                break;
            } else if (board[x][i] == 'p') {
                sum++;
                break;
            }
        }
        // 左
        for (int i = y - 1; i >= 0 ; i--) {
            if (board[x][i] == 'B') {
                break;
            } else if (board[x][i] == 'p') {
                sum++;
                break;
            }
        }
        return sum;
    }
	
	public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();

    }
}
