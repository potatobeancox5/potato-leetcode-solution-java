package com.potato.study.leetcode.p0059;

import com.potato.study.leetcode.util.ArrayUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 
 *         59. Spiral Matrix II
 *     
 *        Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * 
 * 
 *         思路：旋转数组 这次直接生成写好的的数组 n * n
 *         申请数组
 *         确定旋转次数 n / 2   q
 *          每次旋转先 i = q ，j = q  
 *          	j < n - 1 - q	j++
 *          	i < n - 1 - q	i++
 *         		j > q		 	j--
 *         		i > q    		i--
 *			n 为奇数 补充最中间的位置 圈数 圈数 
 */
public class Solution {
	
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int circleNum = n / 2;
		int step = 1;
		for(int q = 0 ; q < circleNum ; q++) {
			int i = q;
			int j = q;
			for(;j < n - 1 - q; j++) {
				result[i][j] = step++;
			}
			for(;i < n - 1 - q; i++) {
				result[i][j] = step++;
			}
			for(;j > q; j--) {
				result[i][j] = step++;
			} 
			for(;i > q; i--) {
				result[i][j] = step++;
			}
		}
		if(n % 2 == 1) {
			result[circleNum][circleNum] = step;
		}
		return result;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = solution.generateMatrix(8);
		ArrayUtil.printMatrix(matrix);
	}
}
