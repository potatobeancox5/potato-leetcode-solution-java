package com.potato.study.leetcode.p0052;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 
 * 52. N-Queens II
 * Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 *          
 *          思路：n皇后问题
 *          这次只返回解的个数
 *           
 * 
 * 
 * 
 */
public class Solution {
	
	public int totalNQueens(int n) {
        //初始化结果集
        char[][] checkerboard = new char[n][n];
        for(int i = 0 ; i < n ; i++) {
        	for(int j = 0 ; j < n ; j++) {
        		checkerboard[i][j] = '.';
        	}
        }
        // 将每个位置天上queen 并判断是否合适 若八个皇后都放到位置上时， 记录结果
        int result = completeSolve(0, checkerboard);
        return result;
    }
	
	/**
	 * 
	 * @param result 			最终记录的结果
	 * @param queenNum			皇后数量 即代表当前皇后数量 也代表当前遍历到的行数
	 * @param checkerboard		当前棋盘
	 */
	private int completeSolve(int queenNum, char[][] checkerboard) {
		if(queenNum == checkerboard.length) {
			return 1;
		} else if(queenNum < checkerboard.length){ // 理论上 只能有小于queenNum < checkerboard.length 情况
			int count = 0;
			for(int i = 0 ; i < checkerboard.length ; i++) {
				if(isValided(checkerboard, queenNum, i)) { 
					checkerboard[queenNum][i] = 'Q';
					count += completeSolve(queenNum + 1, checkerboard);
    				checkerboard[queenNum][i] = '.';
				}
			}
			return count;
		}
		return 0;
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
		int num = solution.totalNQueens(4);
		System.out.println(num);
	}
}
