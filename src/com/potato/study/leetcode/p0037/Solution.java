package com.potato.study.leetcode.p0037;

/**
 * 
 * @author liuzhao11
 * 
 *         37. Sudoku Solver
 *         Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
 * 
 *         思路：
 *         解一个数独
 *         对于数独的右上角的点一次进行深度优先搜索上左下右的顺序
 *         对于每个点 如果有值 则继续查找 没有值的话 从1-9 依次填入 进行校验 暂时校验成功的继续搜索失败的 否则 抹掉值 填入新值
 *         
 * 
 * 
 */
public class Solution {
	
	public void solveSudoku(char[][] board) {
		isSolved(board);
    }
	
	private boolean isSolved(char[][] board) {
		
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				if(board[i][j] == '.') {
					for(int k = 1 ; k <= 9 ; k++) {
						board[i][j] = (char)('0' + k);
						if(isValid(board, i, j) && isSolved(board)) {
							return true;
						} 
						// 解决一个 会迭代 进去 出来说明没解决 需要回滚
						board[i][j] = '.';
					}
					// 九个位置都不行 返回不行
					return false;
				}
			}
		}
		//全部都是数字了
		return true;
	}
	
	private boolean isValid(char[][] board, int x, int y) {
		//行
		for(int i = 0 ; i < 9 ; i++) {
			if(i != y && board[x][y] == board[x][i]) {
				return false;
			}
		}
		//列
		for(int i = 0 ; i < 9 ; i++) {
			if(i != x && board[x][y] == board[i][y]) {
				return false;
			}
		}
		//小格子
		int xx = x / 3 * 3;
		int yy = y / 3 * 3;
		for(int i = xx ; i < xx + 3 ; i++) {
			for(int j = yy ; j < yy + 3 ; j++) {
				if(i != x && j != y && board[x][y] == board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
