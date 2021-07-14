package com.potato.study.leetcodecn.p01162.t001;


import com.potato.study.leetcode.domain.TreeNode;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. 地图分析
 *
 * 你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。

 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。

 如果网格上只有陆地或者海洋，请返回 -1。

  

 示例 1：



 输入：[[1,0,1],[0,0,0],[1,0,1]]
 输出：2
 解释：
 海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
 示例 2：



 输入：[[1,0,0],[0,0,0],[0,0,0]]
 输出：4
 解释：
 海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
  

 提示：

 1 <= grid.length == grid[0].length <= 100
 grid[i][j] 不是 0 就是 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 1162
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        // 遍历 找到 陆地 单元格 然后将相邻的海域 记录 visit 最终返回层数
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        if (queue.isEmpty()) {
            return -1;
        } else if (queue.size() == grid.length * grid[0].length) {
            return -1;
        }

        int distance = 0;
        int[][] direction = new int[][] {
                {1, 0},{-1, 0},{0, 1},{0, -1}
        };
        while (!queue.isEmpty()) {
            int layerLength = queue.size();
            for (int i = 0; i < layerLength; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < direction.length; j++) {
                    int x = poll[0] + direction[j][0];
                    int y = poll[1] + direction[j][1];
                    if (x < 0 || x >= grid.length) {
                        continue;
                    }
                    if (y < 0 || y >= grid[0].length) {
                        continue;
                    }
                    if (visit[x][y]) {
                        continue;
                    }
                    queue.add(new int[] {x, y});
                    visit[x][y] = true;
                }
            }
            distance++;
        }
        return distance - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][] {
                {1,0,1},{0,0,0},{1,0,1}
        };
        int max = solution.maxDistance(grid);
        System.out.println(max);
        Assert.assertEquals(2, max);
    }



}
