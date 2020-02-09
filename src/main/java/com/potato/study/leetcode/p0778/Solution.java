package com.potato.study.leetcode.p0778;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	778. Swim in Rising Water
 *  
 *         On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
Note:

2 <= N <= 50.
grid[i][j] is a permutation of [0, ..., N*N - 1].
 *         
 *         思路：
 *
 *          https://www.cnblogs.com/ctrlzhang/p/8419318.html
 *
 *          bfs
 *
 *
 * 
 */
public class Solution {

    public int swimInWater(int[][] grid) {
        // 0 定义四个方向
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        // 1 定义优先队列 优先处理 海拔比较小的点 int[] index 0 -> x ; 1 -> y ; 2-> 花费时间
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        // 2 初始条件放入队列
        visited[0][0] = true;
        priorityQueue.add(new int[]{0, 0, grid[0][0]});
        // 3 while 队列 非空 出队 判断是否抵达终点 没有的话 将四个方向的值 放入队列
        while (!priorityQueue.isEmpty()) {
            int[] info = priorityQueue.poll();
            // 判断是否抵达终点
            if (info[0] == n - 1 && info[1] == m - 1) {
                return info[2];
            }
            for (int[] dirction : directions) {
                int x = dirction[0] + info[0];
                int y = dirction[1] + info[1];
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                if (visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                // val = max （tDay， 本身的值）
                priorityQueue.add(new int[]{x, y, Math.max(grid[x][y], info[2])});
            }
        }
        return -1;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] grid = {{0,2},{1,3}};
        int steps = solution.swimInWater(grid);
        System.out.println(steps);
        Assert.assertEquals(3, steps);


        int[][] grid1 = {{0,1,2,3,4}, {24,23,22,21,5}, {12,13,14,15,16}, {11,17,18,19,20}, {10,9,8,7,6}};
        steps = solution.swimInWater(grid1);
        System.out.println(steps);
        Assert.assertEquals(16, steps);

    }
}
