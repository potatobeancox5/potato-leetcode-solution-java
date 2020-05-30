package com.potato.study.leetcode.p1091;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1091. Shortest Path in Binary Matrix
 *  
 *       In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.



Example 1:

Input: [[0,1],[1,0]]


Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]


Output: 4



Note:

1 <= grid.length == grid[0].length <= 100
grid[r][c] is 0 or 1
 *         
 *
 *
 *
 *         思路：
 *          https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/solution/1091java-bfszhi-jie-da-bai-98-xiang-jie-by-ustcyyw/
 *
 */
public class Solution {

    private static int[][] directions = {{0,1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private int row, col;

    public int shortestPathBinaryMatrix(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        Queue<int[]> pos = new LinkedList<>();
        grid[0][0] = 1; // 直接用grid[i][j]记录从起点到这个点的最短路径长。按照题意 起点也有长度1
        pos.add(new int[]{0,0});
        while(!pos.isEmpty() && grid[row - 1][col - 1] == 0){ // 求最短路径 使用BFS
            int[] xy = pos.remove();
            int preLength = grid[xy[0]][xy[1]]; // 当前点的路径长度
            for(int i = 0; i < 8; i++){
                int newX = xy[0] + directions[i][0];
                int newY = xy[1] + directions[i][1];
                if(inGrid(newX, newY) && grid[newX][newY] == 0){
                    pos.add(new int[]{newX, newY});
                    grid[newX][newY] = preLength + 1; // 下一个点的路径长度要+1
                }
            }
        }
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1]; // 如果最后终点的值还是0，说明没有到达
    }

    private boolean inGrid(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
    }
}
