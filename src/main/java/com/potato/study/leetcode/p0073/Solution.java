package com.potato.study.leetcode.p0073;

import com.potato.study.leetcode.util.ArrayUtil;

/**
 * 
 * @author liuzhao11
 *
 * 73. Set Matrix Zeroes
 * 
 *         Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 * 			
 *  思路：
 *  题目不许开辟多余的空间，则直接在原来的数组上进行修改
 *  使用第一行和第一列作为标记 
 *  另外开辟两个标记 分别记录第一行或者第一列是不是为0
 *  先遍历第一行 、第一列 如果存在0则break并置标记为是0
 *  然后按行遍历，如果遇到0则置所在行 列的第一个元素为0
 *  最后遍历一遍中间生成的数组，分别将第一个元素为0的行和列的其他元素都置为0
 *  最后根据之前记录的第一行和第一列的状态，置换即可
 *  
 *  
 *  
 * 
 * 
 */
public class Solution {

	public void setZeroes(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
        //对第一行 第一列判断
        boolean isFirstLineZero = false;//行
        boolean isFirstRowZero = false;    ///列    
        for(int i = 0 ; i < matrix.length ; i++) {
        	if(matrix[i][0] == 0) {
        		isFirstRowZero = true;
        		break;
        	}
        }
        for(int i = 0 ; i < matrix[0].length ; i++) {
        	if(matrix[0][i] == 0) {
        		isFirstLineZero = true;
        		break;
        	}
        }
        // 对第2-n行 2-n列进行遍历
        for(int i = 1 ; i < matrix.length ; i++) {
        	for (int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
        }
        // 按照第一行修改结果
        for(int i = 1 ; i < matrix[0].length ; i++) {
        	if(matrix[0][i] == 0) {
        		//全置为0
        		for(int j = 1 ; j < matrix.length ; j++ ) {
        			matrix[j][i] = 0;
        		}
        	}
        }
        // 按照第一列修改结果
        for(int i = 1 ; i < matrix.length ; i++) {
        	if(matrix[i][0] == 0) {
        		// 全置为0
        		for(int j = 1 ; j < matrix[0].length ; j++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        // 修改第一行 第一列的结果
        if(isFirstLineZero) {
        	for(int i = 0 ; i < matrix[0].length ; i++) {
            	matrix[0][i] = 0;
            }
        }
        if(isFirstRowZero) {
        	for(int i = 0 ; i < matrix.length ; i++) {
            	matrix[i][0] = 0;
            }
        }
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int [][] matrix = {{1,2,3},{0,4,5},{6,3,5}};
		solution.setZeroes(matrix);
		ArrayUtil.printMatrix(matrix);
	}
}
