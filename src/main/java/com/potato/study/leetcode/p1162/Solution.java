package com.potato.study.leetcode.p1162;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1162. As Far from Land as Possible
 *  
 *
Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

If no land or water exists in the grid, return -1.



Example 1:



Input: [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation:
The cell (1, 1) is as far as possible from all the land with distance 2.
Example 2:



Input: [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation:
The cell (2, 2) is as far as possible from all the land with distance 4.


Note:

1 <= grid.length == grid[0].length <= 100
grid[i][j] is 0 or 1
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/li-qing-si-lu-wei-shi-yao-yong-bfs-ru-he-xie-bfs-d/
 *
 */
public class Solution {


    public int maxDistance(int[][] grid) {
        int len = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        // 将所有的陆地格子加入队列
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        // 如果我们的地图上只有陆地或者海洋，请返回 -1。
        if (queue.isEmpty() || queue.size() == len * len) {
            return -1;
        }

        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            // 这里一口气取出 n 个结点，以实现层序遍历
            for (int i = 0; i < n; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                // 遍历上方单元格
                if (r-1 >= 0 && grid[r-1][c] == 0) {
                    grid[r-1][c] = 2;
                    queue.add(new int[]{r-1, c});
                }
                // 遍历下方单元格
                if (r+1 < len && grid[r+1][c] == 0) {
                    grid[r+1][c] = 2;
                    queue.add(new int[]{r+1, c});
                }
                // 遍历左边单元格
                if (c-1 >= 0 && grid[r][c-1] == 0) {
                    grid[r][c-1] = 2;
                    queue.add(new int[]{r, c-1});
                }
                // 遍历右边单元格
                if (c+1 < len && grid[r][c+1] == 0) {
                    grid[r][c+1] = 2;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        return distance;
    }
}
