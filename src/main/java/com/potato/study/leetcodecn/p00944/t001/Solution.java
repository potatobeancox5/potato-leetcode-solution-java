package com.potato.study.leetcodecn.p00944.t001;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：

 值 0 代表空单元格；
 值 1 代表新鲜橘子；
 值 2 代表腐烂的橘子。
 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

  

 示例 1：



 输入：[[2,1,1],[1,1,0],[0,1,1]]
 输出：4
 示例 2：

 输入：[[2,1,1],[0,1,1],[1,0,1]]
 输出：-1
 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 示例 3：

 输入：[[0,2]]
 输出：0
 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
  

 提示：

 1 <= grid.length <= 10
 1 <= grid[0].length <= 10
 grid[i][j] 仅为 0、1 或 2

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/rotting-oranges
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 遍历 grid 找到 已经腐烂的橘子左边 入队
     * 2. queue 非空 len 出队 依次判断相邻位置 是不是可以烂的 入队 烂 每次 len 结束 分钟计数
     * 3. 判断下目前还有没有烂不了的橘子，有的话 返回 -1
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int minute = 0;
        // queue 非空 len 出队 依次判断相邻位置 是不是可以烂的 入队 烂 每次 len 结束 分钟计数
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] poll = queue.poll();
                // 4个方向判断 是不是能烂
                if (poll[0] > 0 && grid[poll[0] - 1][poll[1]] == 1) {
                    grid[poll[0] - 1][poll[1]] = 2;
                    queue.add(new int[]{poll[0] - 1, poll[1]});
                }
                if (poll[0] < grid.length - 1 && grid[poll[0] + 1][poll[1]] == 1) {
                    grid[poll[0] + 1][poll[1]] = 2;
                    queue.add(new int[]{poll[0] + 1, poll[1]});
                }
                if (poll[1] > 0 && grid[poll[0]][poll[1] - 1] == 1) {
                    grid[poll[0]][poll[1] - 1] = 2;
                    queue.add(new int[]{poll[0], poll[1] - 1});
                }
                if (poll[1] < grid[0].length - 1 &&  grid[poll[0]][poll[1] + 1] == 1) {
                    grid[poll[0]][poll[1] + 1] = 2;
                    queue.add(new int[]{poll[0], poll[1] + 1});
                }
            }
            // 如果本轮没有一个 新增 那本轮也就是mei烂
            if (!queue.isEmpty()) {
                minute++;
            }
        }
        // 判断下目前还有没有烂不了的橘子，有的话 返回 -1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minute;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][] {
                {2,1,1},{1,1,0},{0,1,1}

        };
        int min = solution.orangesRotting(grid);
        System.out.println(min);
        Assert.assertEquals(4, min);
    }
}
