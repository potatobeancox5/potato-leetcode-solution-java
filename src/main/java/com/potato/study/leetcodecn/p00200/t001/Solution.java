package com.potato.study.leetcodecn.p00200.t001;

import org.junit.Assert;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 200. 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

 此外，你可以假设该网格的四条边均被水包围。

  

 示例 1：

 输入：grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 输出：1
 示例 2：

 输入：grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 输出：3
  

 提示：

 m == grid.length
 n == grid[i].length
 1 <= m, n <= 300
 grid[i][j] 的值为 '0' 或 '1'

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-islands
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * bfs
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        boolean[][] hasVisited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (hasVisited[i][j]) {
                    continue;
                }
                hasVisited[i][j] = true;
                if (grid[i][j] == '0') {
                    continue;
                }
                count++;
                // bfs 找到周边的点
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    if (point[0] != 0
                            && !hasVisited[point[0]-1][point[1]]
                            && grid[point[0]-1][point[1]] == '1') {
                        queue.add(new int[]{point[0]-1, point[1]});
                        hasVisited[point[0]-1][point[1]] = true;
                    }
                    if (point[0] != grid.length - 1
                            && !hasVisited[point[0]+1][point[1]]
                            && grid[point[0]+1][point[1]] == '1') {
                        queue.add(new int[]{point[0]+1, point[1]});
                        hasVisited[point[0]+1][point[1]] = true;
                    }
                    if (point[1] != 0
                            && !hasVisited[point[0]][point[1]-1]
                            && grid[point[0]][point[1]-1] == '1') {
                        queue.add(new int[]{point[0], point[1]-1});
                        hasVisited[point[0]][point[1]-1] = true;
                    }
                    if (point[1] != grid[0].length - 1
                            && !hasVisited[point[0]][point[1]+1]
                            && grid[point[0]][point[1]+1] == '1') {
                        queue.add(new int[]{point[0], point[1]+1});
                        hasVisited[point[0]][point[1]+1] = true;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}

        };
        int count = solution.numIslands(grid);
        System.out.println(count);
        Assert.assertEquals(1, count);


        grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        count = solution.numIslands(grid);
        System.out.println(count);
        Assert.assertEquals(3, count);
    }
}
