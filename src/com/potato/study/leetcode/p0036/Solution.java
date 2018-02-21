package com.potato.study.leetcode.p0036;

/**
 * 
 * @author liuzhao11
 * 
 *         36. Valid Sudoku
 *          Determine if a Sudoku is valid, according to: Sudoku
 *         Puzzles - The Rules.
 * 
 *         The Sudoku board could be partially filled, where empty cells are
 *         filled with the character '.'.
 * 
 * 
 *         A partially filled sudoku which is valid.
 * 
 *         Note: A valid Sudoku board (partially filled) is not necessarily
 *         solvable. Only the filled cells need to be validated.
 * 
 *         思路：
 *         验证给定的模板是否是合法的数独模板 即 横排 1-9 竖排 1-9 每个单元格 1-9
 * 			分成三个子方法进行验证 
 * 			横排 竖排  子格
 * 			每个子方法采用 count[9] 计数的形式
 * 
 * 
 */
public class Solution {
	
	
	public boolean isValidSudoku(char[][] board) {
		return isValidSudokuPart(board) && isValidSudokuLine(board) && isValidSudokuRow(board);
    }

	// 判断每列是否符合规则
	private boolean isValidSudokuRow(char[][] board) {
		for(int i=0;i<9;i++){
			int[] num = new int[9];
			for(int j=0;j<9;j++){
				if(board[j][i] == '.'){
					continue;
				}
				int index = board[j][i] - '1';
				if(index < 0 || index > 8){
					return false;
				}
				num[index]++;
			}
			for(int k=0;k<9;k++){
				if(num[k] > 1){
					//System.out.println(num[k]);
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 判断 每行是否是 合法的
	 * @param board
	 * @return
	 */
	private boolean isValidSudokuLine(char[][] board) {
		for(int i=0;i<9;i++){
			int[] num = new int[9];
			for(int j=0;j<9;j++){
				if(board[i][j] == '.'){
					continue;
				}
				int index = board[i][j] - '1';
				if(index < 0 || index > 8){
					return false;
				}
				num[index]++;
			}
			for(int k=0;k<9;k++){
				if(num[k]>1){
					return false;
				}
			}
		}
		return true;
	}
	//判断每个小格子是不是符合数独
	private boolean isValidSudokuPart(char[][] board) {
		//数字不能重复
		for(int l=0;l<3;l++){
			for(int k=0;k<3;k++){
				int[] num = new int[9];
				for(int i=0;i<3;i++){
					for(int j=0;j<3;j++){
						if(board[i+3*k][j+3*l] == '.'){
							continue;
						}
						int index = board[i+3*k][j+3*l] - '1';
						if(index < 0 || index > 8){
							return false;
						}
						num[index]++;
					}
				}
				//数字范围为1-9
				for(int i=0;i<9;i++){
					if(num[i]>1){
						return false;
					}
				}
			}			
		}
		return true;
	}

	
	
	
	public static void main(String[] args) {
//		Solution solution = new Solution();
//		
//		solution.isValidSudoku(board);
//		System.out.println();
	}
}
