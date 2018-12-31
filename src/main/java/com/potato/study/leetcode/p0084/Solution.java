package com.potato.study.leetcode.p0084;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *         84. Largest Rectangle in Histogram
 *         
 *          
 *         Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10
 * 
 *         思路：
 *         动态规划题目 超时
 *         首先动态规划化 找出 minHeight【i】【j】 = min （height【i】【j】 , minHeight[i-1][j] ,minHeight[i][j -1]）
 *         压缩状态量
 *         minHeight【j】 = min （height【j】  ,minHeight[i][j -1]）
 *         
 *         
 *         设area[i][j] 是从i 到 j 的最大面积
 *         area【i】【j】 = max （area【i-1】【j】 ， area【i】【j-1】 , min（i，j） * j - i + 1）；
 *         area【i】【i】 = heights[i]
 *         压缩状态量
 *          行循环时记录i 
 *          j记录列 每次从j=i 开始循环
 *         area【j】 = max （area【j】 ， area【j-1】 , min（i，j） * （j - i + 1）；
 *         
 * 		经典解法
 * https://www.cnblogs.com/ganganloveu/p/4148303.html
 * 		思路：
 * 		1  使用一个栈保存当前路径向后最大的height 
 * 			比如  2,1,5,6,2,3
 * 				全部进栈之后 栈内情况 栈底  1,1,2,2,2,3 stack
 * 			使用公式  stack[i] * (len - i) // 计算第一类的面积
 * 		2 第二类面积 是生成stack 时，遇到当前height 《 栈顶时 弹出栈顶 * 当前累计弹出数量的面积
 * 		3 在1 2 中 记录最大的面积
 * 
 */
public class Solution {

//	public int largestRectangleArea(int[] heights) {
//        int[] minHeight = new int[heights.length];
//        int[] area = new int[heights.length];
//        int largestRectangleArea = 0;
//        for(int i = 0 ; i < heights.length ; i++) {
//        	for (int j = i ; j < heights.length ; j++) {
//        		//当前  i 到 j 的最小的高度
//        		if(i == j) {
//        			minHeight[j] = heights[j];
//        			area[j] = heights[j];
//        		} else {
//        			minHeight[j] = minHeight[j - 1] > heights[j] ? heights[j] : minHeight[j - 1];
//        			area[j] = max(area[j] , area[j-1] , minHeight[j] * (j - i + 1));
//        		}
//        		if(area[j] > largestRectangleArea) {
//        			largestRectangleArea = area[j];
//        		}
//        	}
//        }
//        return largestRectangleArea;
//    }
	
	

//	/**
//	 * 返回 i j k 中 最大的那个
//	 * @param i
//	 * @param j
//	 * @param k
//	 * @return
//	 */
//	private int max(int i, int j, int k) {
//		if(i > j) {
//			return i > k ? i : k;
//		} else {
//			return j > k ? j : k;
//		}
//	}

	public int largestRectangleArea(int[] heights) {
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
//		int[] heights = {2,1,5,6,2,3};
		int[] heights = {2,1,2};
		int area = solution.largestRectangleArea(heights);
		System.out.println(area);
	}
}
