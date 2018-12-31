package com.potato.study.leetcode.p0130;

import java.util.LinkedList;
import java.util.Queue;

import com.potato.study.leetcode.util.ArrayUtil;

/**
 * 
 * @author liuzhao11
 * 
 *       130. Surrounded Regions
 *         
 *    Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.    
 *        
 *         
 *         思路：将x包围的o转换成x
 *         如果o挨着边缘 那么不对o进行转换
 *         https://blog.csdn.net/ChilseaSai/article/details/50375111
 *         
 *         工作主要是找出： 
1. 最外圈的 O 
2. 与最外圈的 O 相连的 O 
3. 将上述找到的元素替换为某种标识符，代码中使用“#” 
4. 最后按先行后列的顺序遍历矩形，找到没有被替换为 O 的元素，它们就是被 X 完全包围的需要被替换为 X 的元素；同时，标记为 # 的元素是没有被 X 包围的元素，此时将它们变回原来的 O
 *         
 *        	分别从边的每一个点开始进行bfs
 *        
 * 
 */
public class Solution {
	
	
	/**
	 * bfs
	 * @param board
	 */
	public void solve(char[][] board) {
		if(null == board || board.length == 0 || board[0].length == 0) {
			return;
		}
        // deal first and last line
		for(int i = 0 ; i < board[0].length ; i++) {
			bfs(board,0, i);
			bfs(board,board.length - 1, i);
		}
		// deal first and last column
		for(int i = 0 ; i < board.length ; i++) {
			bfs(board, i, 0);
			bfs(board, i, board[0].length - 1);
		}
		// replace all the # to O  and all the o to x
		for(int i = 0 ; i < board.length ; i++) {
			for(int j = 0 ; j < board[0].length ; j++) {
				if(board[i][j] == '#') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
		
    }
	
	/**
	 * 如果o确定没有被包围 那么改成x
	 * @param board
	 * @param x	 横坐标
	 * @param y  纵坐标
	 */
	private void bfs(char[][] board,int x,int y) {
		//判断当前位置 是不是o
		if(board[x][y] != 'O') {
			return;
		}
		board[x][y] = '#';
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x * board[0].length + y);
		while(!queue.isEmpty()) {
			// poll
			int xy = queue.poll();
			x = xy / board[0].length;
			y = xy % board[0].length;
			// if up down left right is o ,push and edit it to #
			if(x - 1 >= 0 && board[x - 1][y] == 'O') { 
				board[x - 1][y] = '#';
				queue.add((x - 1) * board[0].length + y);
			}
			if(x + 1 < board.length && board[x + 1][y] == 'O') {
				board[x + 1][y] = '#';
				queue.add((x + 1) * board[0].length + y);
			}
			if(y - 1 >= 0 && board[x][y - 1] == 'O') {
				board[x][y - 1] = '#';
				queue.add(x * board[0].length + y - 1);
			}
			if(y + 1 < board[0].length && board[x][y + 1] == 'O') {
				board[x][y + 1] = '#';
				queue.add(x * board[0].length + y + 1);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = {{'X', 'O', 'X', 'X'},
				{'O', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'O'},
				{'O', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'O'},
				{'O', 'X', 'O', 'X'}};
		solution.solve(board);
		ArrayUtil.printMatrix(board);
	}
}
