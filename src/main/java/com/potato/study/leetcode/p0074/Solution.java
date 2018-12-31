package com.potato.study.leetcode.p0074;

/**
 * 
 * @author liuzhao11
 * 
 *         
 *         74. Search a 2D Matrix
 *         
 *         
 *         Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 *         
 *         
 * 			
 *  思路：
 *  给定矩阵 矩阵经过了排序 左边小于右边 上边小于下边 找给定target
 *  从左下角开始寻找 
 *  当前值 大于target  向上寻找   如果下一个寻找位置发生了数组越界 则找不到元素 返回false
 *  当前值 小于target  向右寻找 
 *   
 *  
 *  
 *  
 * 
 * 
 */
public class Solution {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
//		从左下角开始寻找 
		int x = matrix.length - 1;//行
		int y = 0;//列
		while(x >=0 && y < matrix[0].length) {
			if(matrix[x][y] == target) {
				return true;
			} else if (matrix[x][y] > target) {
//		 *  当前值 大于target  向上寻找   如果下一个寻找位置发生了数组越界 则找不到元素 返回false
				x--;
			} else{ //		 *  当前值 小于target  向右寻找 
				y++;
			}
		}
		return false;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int target = 5;
		boolean isFound = solution.searchMatrix(matrix, target);
		System.out.println(isFound);
	}
}
