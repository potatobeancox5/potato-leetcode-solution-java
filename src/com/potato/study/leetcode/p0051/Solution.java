package com.potato.study.leetcode.p0051;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 * 
 * 
 *          
 *          思路：n 皇后问题 
 *          横排只能有一个皇后 纵向上只能有一个皇后 
 *          两个斜向上只能有一个皇后
 *           
 * 
 * 
 * 
 */
public class Solution {
	
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        //初始化结果集
        char[][] checkerboard = new char[n][n];
        for(int i = 0 ; i < n ; i++) {
        	for(int j = 0 ; j < n ; j++) {
        		checkerboard[i][j] = '.';
        	}
        }
        // 将每个位置天上queen 并判断是否合适 若八个皇后都放到位置上时， 记录结果
        completeSolve(result, 0, checkerboard);
        return result;
    }
	
	/**
	 * 
	 * @param result 			最终记录的结果
	 * @param queenNum			皇后数量 即代表当前皇后数量 也代表当前遍历到的行数
	 * @param checkerboard		当前棋盘
	 */
	private void completeSolve(List<List<String>> result, int queenNum, char[][] checkerboard) {
		if(queenNum == checkerboard.length) {
			List<String> solution = new ArrayList<>();
			for(int i = 0 ; i < checkerboard.length ; i++) {
				String line = new String(checkerboard[i]);
				solution.add(line);
			}
			result.add(solution);
			return;
		} else if(queenNum < checkerboard.length){ // 理论上 只能有小于queenNum < checkerboard.length 情况
			for(int i = 0 ; i < checkerboard.length ; i++) {
				if(isValided(checkerboard, queenNum, i)) { 
					checkerboard[queenNum][i] = 'Q';
    				completeSolve(result, queenNum + 1, checkerboard);
    				checkerboard[queenNum][i] = '.';
				}
			}
		}
	}
	
	private boolean isValided(char[][] checkerboard, int i, int j) {
		// 横向
		for(int k = 0 ; k < checkerboard.length ;k++) {
			if(checkerboard[i][k] == 'Q' && k != j) {
				return false;
			}
		}
		// 纵向
		for(int k = 0 ; k < checkerboard.length ;k++) {
			if(checkerboard[k][j] == 'Q' && k != i) {
				return false;
			}
		}
		// 正斜向
		int p = i;
		int q = j;
		while(p >=0 && q >=0) { // 往左上走
			if(checkerboard[p][q] == 'Q' && p != i && q != j) {
				return false;
			}
			p--;
			q--;
		}
		p = i;
		q = j;
		while(p < checkerboard.length && q < checkerboard.length) { // 往右下走
			if(checkerboard[p][q] == 'Q' && p != i && q != j) {
				return false;
			}
			p++;
			q++;
		}
		// 反斜向
		p = i;
		q = j;
		while(p >=0 && q < checkerboard.length) { // 往右上走
			if(checkerboard[p][q] == 'Q' && p != i && q != j) {
				return false;
			}
			p--;
			q++;
		}
		p = i;
		q = j;
		while(p < checkerboard.length && q >= 0) { // 往左下走
			if(checkerboard[p][q] == 'Q' && p != i && q != j) {
				return false;
			}
			p++;
			q--;
		}
		return true;
	}
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 4;
		List<List<String>> result = solution.solveNQueens(n);
		System.out.println(result);
	}
}
