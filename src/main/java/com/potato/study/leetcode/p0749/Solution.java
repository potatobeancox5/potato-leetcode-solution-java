package com.potato.study.leetcode.p0749;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	749. Contain Virus
 *  
 *         A virus is spreading rapidly, and your task is to quarantine the infected area by installing walls.

The world is modeled as a 2-D array of cells, where 0 represents uninfected cells, and 1 represents cells contaminated with the virus. A wall (and only one wall) can be installed between any two 4-directionally adjacent cells, on the shared boundary.

Every night, the virus spreads to all neighboring cells in all four directions unless blocked by a wall. Resources are limited. Each day, you can install walls around only one region -- the affected area (continuous block of infected cells) that threatens the most uninfected cells the following night. There will never be a tie.

Can you save the day? If so, what is the number of walls required? If not, and the world becomes fully infected, return the number of walls used.

Example 1:
Input: grid =
[[0,1,0,0,0,0,0,1],
[0,1,0,0,0,0,0,1],
[0,0,0,0,0,0,0,1],
[0,0,0,0,0,0,0,0]]
Output: 10
Explanation:
There are 2 contaminated regions.
On the first day, add 5 walls to quarantine the viral region on the left. The board after the virus spreads is:

[[0,1,0,0,0,0,1,1],
[0,1,0,0,0,0,1,1],
[0,0,0,0,0,0,1,1],
[0,0,0,0,0,0,0,1]]

On the second day, add 5 walls to quarantine the viral region on the right. The virus is fully contained.
Example 2:
Input: grid =
[[1,1,1],
[1,0,1],
[1,1,1]]
Output: 4
Explanation: Even though there is only one cell saved, there are 4 walls built.
Notice that walls are only built on the shared boundary of two different cells.
Example 3:
Input: grid =
[[1,1,1,0,0,0,0,0,0],
[1,0,1,0,1,1,1,1,1],
[1,1,1,0,0,0,0,0,0]]
Output: 13
Explanation: The region on the left only builds two new walls.
Note:
The number of rows and columns of grid will each be in the range [1, 50].
Each grid[i][j] will be either 0 or 1.
Throughout the described process, there is always a contiguous viral region that will infect strictly more uncontaminated squares in the next round.


 *
 *
 *
 *  思路：
 *      要求建立防火墙 建立策略 是每天找到临街边最多的进行建立，最终计算需要建立多少个防火墙 才能阻止病毒
 *      https://leetcode.com/problems/contain-virus/discuss/341527/Simple-Java-DFS
 *  解答：
 *
 *  // 1. 遍历找出被感染的区域 max 边
 *
 *  // 2. 将max 隔离
 *
 *  // 3. 更改数组状态 再继续找
 *
 */
public class Solution {

    /**
     * 矩阵的长或者宽
     */
    private int m;
    private int n;

    /**
     * 查看的方向
     */
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    /**
     * 是够访问 矩阵
     */
    private boolean [][] visited;

    /**
     *  感染去 内部为1的区域
     */
    List<Set<Integer>> region;
    /**
     * 记录邻接感染区域具体信息 用来甄别 哪个是最危险的区域
     */
    List<Set<Integer>> frontier;

    /**
     * 记录当前区域的边长
     */
    List<Integer> perimeter;


    public int containVirus(int[][] grid) {
        // 行
        m = grid.length;
        // 列
        n = grid[0].length;

        int result = 0;
        // while true
        while (true) {

            visited = new boolean[m][n];
            region = new ArrayList<>();
            frontier = new ArrayList<>();
            perimeter = new ArrayList<>();

            // 0 从 0，0 开始查找 每个 1区域 并记录 他们的周长 这个过程之后 知道哪些区域是1的区域 并且知道他们的周长 每次找到 1 的时候 申请一个新的区域
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 找到没有访问过的疫区
                    if (!visited[i][j] && grid[i][j] == 1) {
                        frontier.add(new HashSet<>());
                        region.add(new HashSet<>());
                        perimeter.add(0);
                        // 找到各个点
                        dfs(grid, i, j);
                    }
                }
            }
            if (region.size() == 0) {
                return result;
            }
            // region 记录当前区域里的点 形式 x * n + y
            // 1 找到上述区域 邻接最多的1区域  修改总结果
            int maxAreaIndex = 0;
            for (int i = 1; i < frontier.size(); i++) {
                if (frontier.get(i).size() > frontier.get(maxAreaIndex).size()) {
                    maxAreaIndex = i;
                }
            }
            result += perimeter.get(maxAreaIndex);
            // 2 遍历区域 如果是隔离区域 区域值不变 否则 邻接的点 扩散
            for (int i = 0; i < region.size(); i++) {
                if (maxAreaIndex == i) {
                    for (int coo : region.get(i)) {
                        // 安全点
                        grid[coo / n][coo % n] = -1;
                    }

                } else {
                    // 扩散
                    for (int coo : region.get(i)) {
                        int r = coo / n;
                        int c = coo % n;
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dx[k], nc = c + dy[k];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n
                                    && grid[nr][nc] == 0)
                                grid[nr][nc] = 1;
                        }
                    }
                }
            }

        }
    }


    /**
     * dfs 从 x y 查找 grid
     * @param grid
     * @param x
     * @param y
     */
    private void dfs (int[][] grid, int x, int y) {
        // 0. 获取当前的区域 将当前
        int regionCount = region.size();
        // 1. 改点记录信息
        region.get(regionCount - 1).add(x * n + y);
        visited[x][y] = true;
        // 往4个方向找
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            // 边界
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            // 临界点是不是 1
            if (!visited[nx][ny] && grid[nx][ny] == 1) {
                dfs(grid, nx, ny);
            } else if (grid[nx][ny] == 0) {
                frontier.get(regionCount-1).add(nx * n + ny);
                perimeter.set(regionCount-1, perimeter.get(regionCount-1)+1);
            }
        }
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] grid = {};

		int count = solution.containVirus(grid);
		System.out.println(count);
        Assert.assertEquals(10, count);
    }
}
