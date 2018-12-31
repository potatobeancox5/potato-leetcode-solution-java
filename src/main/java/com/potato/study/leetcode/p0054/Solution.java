package com.potato.study.leetcode.p0054;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         54. Spiral Matrix
 * 
 *        Given a matrix of m x n elements (m rows, n columns), 
 *        return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 * 
 * 
 *         思路： 螺旋输出数组
 *         如图：
 *         http://blog.csdn.net/zhangxiao93/article/details/49388395
 * 
 */
public class Solution {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		// 计算几圈 
		int n = matrix.length;// 横行
		int m = matrix[0].length; // 纵行
		int circleNum = (m > n ? n/2 : m/2);// 圈数为小的那个边
		for (int q = 0 ; q < circleNum ; q++) {
			// 每圈4个阶段
			int i = q;
			int j = q;
			for( ; j < m - 1 - q; j++ ) { // right
				result.add(matrix[i][j]);
			} // 结束时 j = m - q i=q
			for( ; i < n - 1 - q; i++) { // down
				result.add(matrix[i][j]);
			} // over i = n - q j = m - q
			for(;j > q; j--) { // left
				result.add(matrix[i][j]);
			} // over j = q i = n - q
			for(;i > q;i--) { // up
				result.add(matrix[i][j]);
			} // over i = q , j = q
		}
		// 最后是否需要补充一下  小的那个边是 奇数时 需要进行补充最后一步操作
		int min = m > n ? n : m;
		if(min % 2 == 1) {
			if(m > n) { // 水平向右
				for(int k = 0 ; k < m - n + 1 ; k++) {					
					result.add(matrix[circleNum][circleNum + k]);
				}
//				result.add(matrix[circleNum][circleNum + 1]);
			} else if (m < n) { // 数值向下
				for(int k = 0 ; k < n - m + 1 ; k++) {					
//					result.add(matrix[circleNum][circleNum + k]);
					result.add(matrix[circleNum + k][circleNum]);
				}
//				result.add(matrix[circleNum][circleNum]);
			} else { // m == n
				result.add(matrix[circleNum][circleNum]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int [][] matrix = { {1, 2, 3 },
//				{ 4, 5, 6 },
//				{ 7, 8, 9 }
//				};
		/*int [][] matrix = { {2, 5 },
				{ 8, 4 },
				{ 0,-1 }
				};*/
		int [][] matrix = { {2,3,4} };
		List<Integer> list = solution.spiralOrder(matrix);
		System.out.println(list);
	}
}
