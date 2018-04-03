package com.potato.study.leetcode.p0079;

/**
 * 
 * @author liuzhao11
 * 
 * 79. Word Search
 * 
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 *   
 *  思路：
 *  深度优先搜索
 *  
 *  
 *   
 */
public class Solution {
	
	public boolean exist(char[][] board, String word) {
		if(null == board || board.length == 0 || board[0].length == 0) {
			return false;
		}
        //以每一个节点作为开始节点进行搜索
		boolean[][] isVisited = new boolean[board.length][board[0].length];
		for(int i = 0 ; i < board.length ; i++) {
			for(int j = 0 ; j < board[0].length ; j++) {
				boolean result = findWordDFS(board, word, 0, isVisited, i ,j);
				if(result) {
					return true;
				}
			}
		}
		return false;
    }
	
	
	/**
	 * 
	 * @param board 	字典板子
	 * @param word		查找的单词
	 * @param index		当前匹配的单词字母的index
	 * @param isVisited	是否访问数组
	 * @param x			当前访问位置
	 * @param y			当前访问位置
	 * @return			返回匹配结果
	 */
	private boolean findWordDFS(char[][] board, String word, int index, 
			boolean [][]isVisited ,int x , int y) {
		if(index >= word.length()) {
			return true;
		}
		if(x < 0 || x >= board.length) {
			return false;
		}
		if(y < 0 || y >= board[0].length) {
			return false;
		}
		if(isVisited[x][y]) {
			return false;
		}
		if(board[x][y] != word.charAt(index)) {
			return false;
		} else {//board[x][y] != word.charAt(index)
			isVisited[x][y] = true;
			boolean tmpResult = findWordDFS(board, word, index + 1, isVisited, x - 1 , y)
					||findWordDFS(board, word, index + 1, isVisited, x + 1 ,y)
					||findWordDFS(board, word, index + 1, isVisited, x, y - 1)
					||findWordDFS(board, word, index + 1, isVisited, x, y + 1);
			if(tmpResult) {
				return true;
			}
			isVisited[x][y] = false;//重置 x y
			return false;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
//		char[][] board = { {'a'}};
		String word = "ABCCED";
//		String word = "SEE";
//		String word = "ABCB";
//		String word = "a";
		boolean result = solution.exist(board, word);
		System.out.println(result);
	}
}
