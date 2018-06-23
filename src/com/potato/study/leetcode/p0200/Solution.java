package com.potato.study.leetcode.p0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 *         200. Number of Islands
 * 
 *         Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 * 
 *         思路：  四面都是0的时候 算是小岛 或者 挨着陆地其他挨着0 算是小岛
 *         bfs 进行搜索
 *         从前只后依次开始进行bfs 开一个数组boolean[][] visited
 *         计数器 count 遇到 1 开始进行搜索 分别判断4个方向并将其加入queue中 每次遇到没有visited 和
 *         grid i j = 1 的 计数器++ 
 * 
 */
public class Solution {
	
	public int numIslands(char[][] grid) {
		if(null == grid || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // from 0,0 to len -1 ,len -1 find island
        for(int i = 0 ; i < grid.length ; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				 if(grid[i][j] == '1' && !visited[i][j]) {
					 count++;
					 visited[i][j] = true;
					 Queue<Integer> queue = new LinkedList<>();
					 queue.add(i * grid[0].length + j);
					 while(!queue.isEmpty()) {
						 int pos = queue.poll();
						 int x = pos / grid[0].length;
						 int y = pos % grid[0].length;
						 if(x - 1 >= 0 && grid[x - 1][y] == '1' && !visited[x - 1][y]) {//up
							 queue.add((x-1) * grid[0].length + y);
							 visited[x-1][y] = true;
						 }
						 if(x + 1 < grid.length && grid[x + 1][y] == '1' && !visited[x + 1][y]) {//down
							 queue.add((x+1) * grid[0].length + y);
							 visited[x+1][y] = true;
						 }
						 if (y - 1 >= 0 && grid[x][y - 1] == '1' && !visited[x][y - 1]) {//left
							 queue.add(x * grid[0].length + y - 1);
							 visited[x][y-1] = true;
						 }
						 if (y + 1 < grid[0].length && grid[x][y + 1] == '1' && !visited[x][y + 1]) {// right
							 queue.add(x * grid[0].length + y + 1);
							 visited[x][y+1] = true;
						 }
					 }
				 }
			}
        }
        return count;
    }
	

    
    public static void main(String[] args) {
		Solution solution = new Solution();
//		char[][] grid = {{'1','1','1','1','0'},
//				{'1','1','0','1','0'},
//				{'1','1','0','0','0'},
//				{'0','0','0','0','0'}};
		char[][] grid = {{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}};
		
		int num = solution.numIslands(grid);
		System.out.println(num);
	}
}
