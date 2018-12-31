package com.potato.study.leetcode.p0463;

/**
 * 
 * @author liuzhao11
 * 
 *         463. Island Perimeter
 * 
 *         You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:

 * 
 * 
 *         思路： 
 * 			遍历整个数组 对于每个节点 如果== 1 那么
 * 				寻找四个方向  存在相邻 记录相邻的count++  记录1节点数量counter++ 
 * 				
 */	
public class Solution {
	
	public int islandPerimeter(int[][] grid) {
		if(null == grid || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
        int countOne = 0;
        int countAdjacent = 0;
        for(int i = 0 ; i < grid.length ; i++) {
        	for(int j = 0 ; j < grid[0].length ; j++) {
        		if(grid[i][j] == 1) {
        			countOne++;
        			// 上
        			if(i > 0 && grid[i - 1][j] == 1) {
        				countAdjacent++; 
        			}
        			// 下
        			if(i < grid.length - 1 && grid[i + 1][j] == 1) {
        				countAdjacent++;
        			}
        			// 左
        			if(j > 0 && grid[i][j - 1] == 1) {
        				countAdjacent++;
        			}
        			// 右
        			if(j < grid[0].length - 1 && grid[i][j + 1] == 1) {
        				countAdjacent++;
        			}
        		}
        	}
        }
        return countOne * 4 - countAdjacent;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [][] grid = {{0,1,0,0},
				 {1,1,1,0},
				 {0,1,0,0},
				 {1,1,0,0}};
		int perimeter = solution.islandPerimeter(grid);
		System.out.println(perimeter);
	}
}
