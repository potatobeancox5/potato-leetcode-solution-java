package com.potato.study.leetcode.p0980;


/**
 * 
 * @author liuzhao11
 * 
 * 	980. Unique Paths III
 *  
 *         On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:

Input: [[0,1],[2,0]]
Output: 0
Explanation:
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.


Note:

1 <= grid.length * grid[0].length <= 20
 *         
 *         思路：
 *         https://www.cnblogs.com/strengthen/p/10295241.html
 *         dfs visit数组记录访问情况
 *         visit[i][j] = 0 表示没访问 visit[i][j] = 1 表示访问了
 *
 */
public class Solution {

    public int uniquePathsIII(int[][] grid) {
        // 找到开始位置
        int startIndexX = 0;
        int startIndexY = 0;
        // 找到需要通过的节点数目
        int currentTotalPathNum = 0;
        int targetNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startIndexX = i;
                    startIndexY = j;
                } else if (grid[i][j] == 0) {
                    targetNum++;
                }
            }
        }

        int[][] visit = new int[grid.length][grid[0].length];

        int pathNum = dfs(startIndexX, startIndexY, grid, visit, currentTotalPathNum, targetNum);

        return pathNum;
    }


    /**
     * 深度优先遍历图 找到路径个数
     * @param startX        开始遍历的位置x
     * @param startY        开始遍历的位置y
     * @param grid          地图
     * @param visit         已经遍历的数组
     * @param currentTotalPathNum   当前已经遍历了多少个路径
     * @param targetNum             要遍历多少个位置
     * @return
     */
    private int dfs(int startX, int startY, int[][] grid, int[][] visit,
                    int currentTotalPathNum, int targetNum) {
        if (startX < 0 || startX >= grid.length || startY < 0 || startY >= grid[0].length) {
            return 0;
        }
        int pathNum = 0;
        // 判断当前节点 是否是结束节点
        if (2 == grid[startX][startY]) {
            if (currentTotalPathNum == targetNum) { // 已经走过了所有的路径了
                return 1;
            } else {
                return 0;
            }
        } else if (-1 == grid[startX][startY]) {
            return 0;
        } else if (0 == visit[startX][startY]){
            if (0 == grid[startX][startY]) {
                currentTotalPathNum += 1;
            }
            visit[startX][startY] = 1;
            // 四个方向分别走一走吧
            int up = dfs(startX - 1, startY, grid, visit, currentTotalPathNum, targetNum);
            int down = dfs(startX + 1, startY, grid, visit, currentTotalPathNum, targetNum);
            int left = dfs(startX, startY - 1, grid, visit, currentTotalPathNum, targetNum);
            int right = dfs(startX, startY + 1, grid, visit, currentTotalPathNum, targetNum);
            visit[startX][startY] = 0;
            return up + down + left + right;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};// 2
//		int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};// 4
		int[][] grid = {{0,1},{2,0}};// 0
        int pathNum = solution.uniquePathsIII(grid);
        System.out.println(pathNum);
    }
}
