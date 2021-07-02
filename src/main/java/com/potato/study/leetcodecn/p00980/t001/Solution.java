package com.potato.study.leetcodecn.p00980.t001;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

/**
 * 980. 不同路径 III
 *
 * 在二维网格 grid 上，有 4 种类型的方格：
 *
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
 *
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * 输出：2
 * 解释：我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * 示例 2：
 *
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * 输出：4
 * 解释：我们有以下四条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * 示例 3：
 *
 * 输入：[[0,1],[2,0]]
 * 输出：0
 * 解释：
 * 没有一条路能完全穿过每一个空的方格一次。
 * 请注意，起始和结束方格可以位于网格中的任意位置。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length * grid[0].length <= 20
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    private int pathNum = 0;
    /**
     * dfs
     * @param grid
     * @return
     */
    public int uniquePathsIII(int[][] grid) {
        // 先找下 有几个点必须被遍历，并确定 起点和终点
        int stepNum = 0;
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                    stepNum++;
                } else if (grid[i][j] == 0) {
                    stepNum++;
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[start[0]][start[1]] = true;
        // dfs 找每种可能
        countPath(stepNum, 0, start, end, grid, visited);
        return pathNum;
    }


    private int[][] direction = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    /**
     * 计算路径数量
     * @param stepNum
     * @param currentStep
     * @param start
     * @param end
     * @param grid
     * @param visited
     */
    private void countPath(int stepNum, int currentStep, int[] start, int[] end, int[][] grid,
            boolean[][] visited) {
        // start 已经到了 end 且 步数相等计数 否则 败走了
        if (start[0] == end[0] && start[1] == end[1]) {
            if (stepNum == currentStep) {
                this.pathNum++;
            }
            return;
        }
        if (stepNum < currentStep) {
            return;
        }
        // 往四个方向走
        for (int i = 0; i < direction.length; i++) {
            int[] newStart = new int[]{
                    direction[i][0] + start[0], direction[i][1] + start[1]
            };
            // 越过了边界
            if (newStart[0] < 0 || newStart[0] >= grid.length) {
                continue;
            }
            if (newStart[1] < 0 || newStart[1] >= grid[0].length) {
                continue;
            }
            // 不能访问
            if (grid[newStart[0]][newStart[1]] == -1) {
                continue;
            }
            // 访问过 直接跳过
            if (visited[newStart[0]][newStart[1]]) {
                continue;
            }
            visited[newStart[0]][newStart[1]] = true;
            countPath(stepNum, currentStep + 1, newStart, end, grid,visited);
            visited[newStart[0]][newStart[1]] = false;
        }
        return;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][] {
                {1,0,0,0},{0,0,0,0},{0,0,2,-1}
        };
        int i = solution.uniquePathsIII(grid);
        System.out.println(i);
        Assert.assertEquals(2, i);
    }


}
