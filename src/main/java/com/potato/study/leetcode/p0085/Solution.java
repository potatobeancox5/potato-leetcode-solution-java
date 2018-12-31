package com.potato.study.leetcode.p0085;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *         85. Maximal Rectangle
 *         
 *          
 *       Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 * 
 *         思路：模拟84解法 
 *         首先对每行向上求该列的高度 
 *         对于求玩高度每行，使用84 计算 最大的长方形块 并 记录下历史最大		
 *         
 * 
 */
public class Solution {

	
	public int maximalRectangle(char[][] matrix) {
		if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[] height = new int[matrix[0].length];
		int max = 0;
		//对每一行 统计高度
		for(int i = 0 ; i < matrix.length ; i++) {
			for(int j = 0 ; j < matrix[0].length ; j++) {				
				if(matrix[i][j] == '1') {
					int count = 0;
					int tmp = i;
					while(tmp >= 0) {
						if(matrix[tmp][j] == '1') {
							count++;
							tmp--;
						} else {
							break;
						}
					}
					height[j] = count;
				} else { // 为0
					height[j] = 0;
				}
			}
			// 使用函数计算历史最大值
			int cur = largestRectangleArea(height);
			if(cur > max) {
				max = cur;
			}
		}
		return max;
    }

	private int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();// 栈内由栈底到栈顶为升序
		//生成栈
		int maxArea = 0;
		for(int i = 0 ; i < heights.length; i++) {
			if(stack.isEmpty()) {
				stack.push(heights[i]);
			} else {
				if(heights[i] >= stack.peek()) {
					stack.push(heights[i]);
				} else {					
					int popNum = 0;
					while(!stack.isEmpty() && heights[i] < stack.peek()) {
						int currentHeight = stack.pop();
						popNum++;
						int area = popNum * currentHeight;
						if(area > maxArea) {
							maxArea = area;
						}
					}
					//将pop的值 置换成当前的 height
					for(int kk = 0 ; kk <= popNum ; kk++) {						
						stack.push(heights[i]);
					}
				}
			}
		}
		int popNum = 0; 
		while(!stack.isEmpty()) {
			int currentHeight = stack.pop();
			popNum++;
			int area = popNum * currentHeight;
			if(area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}
	
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		char [][] matrix = {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
		};
		int max = solution.maximalRectangle(matrix);
		System.out.println(max);
	}
}
