package com.potato.study.leetcode.p0419;

/**
 * 
 * @author liuzhao11
 * 
 *         419. Battleships in a Board
 * 
 *         Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 * 
 * 
 *         思路：
 *         https://www.jianshu.com/p/f1977785ddaf
利用题目中给的限定条件 同一个飞船内部处于同一行或者同一列中
直接遍历二维数组 判定当前点上左没有点 说明是新的飞船 count +1
 * 
 */
public class Solution {

    public int countBattleships(char[][] board) {
        if (null == board) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if (i == 0 && j == 0) {
                        count++;
                    } else if (i == 0) {
                        if (board[i][j - 1] != 'X') {
                            count++;
                        }
                    } else if (j == 0) {
                        if (board[i - 1][j] != 'X') {
                            count++;
                        }
                    } else {
                        if (board[i][j - 1] != 'X' && board[i - 1][j] != 'X') {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        char[][] board = null;
        int count = solution.countBattleships(board);
        System.out.println(count);

    }
}
