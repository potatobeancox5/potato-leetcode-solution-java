package com.potato.study.leetcode.p0994;


import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	  994. Rotting Oranges
 *  
 *         In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.


Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
 *         
 *         思路：
 *=
 *
 */
public class Solution {


    public int orangesRotting(int[][] grid) {
        // 有多少好橙子 坏橙子初始化到队列里边
        int goodNum = 0;
        Queue<int[]> badQueue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    goodNum++;
                } else if (grid[i][j] == 2) {
                    badQueue.add(new int[]{i, j});
                }
            }
        }
        int day = 0;
        if (goodNum == 0) {
            return day;
        }
        // bfs 按照天维度记性遍历队列 每次传染 将好橙子-- 当为0 时 返回day 初始day 0

        int[][] direction = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!badQueue.isEmpty()) {
            // 第一天遍历的点
            int size = badQueue.size();
            day++;
            for (int i = 0; i < size; i++) {
                int[] badPosition = badQueue.poll();
                // 传染
                for (int j = 0; j < direction.length; j++) {
                    int nextX = badPosition[0] + direction[j][0];
                    int nextY = badPosition[1] + direction[j][1];
                    // invalid pisiiton
                    if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                        continue;
                    }

                    if (grid[nextX][nextY] != 1) {
                        continue;
                    }
                    grid[nextX][nextY] = 2;

                    badQueue.add(new int[]{nextX, nextY});
                    goodNum--;
                    if (goodNum == 0) {
                        return day;
                    }
                }
            }

        }
        if (goodNum > 0) {
            day = -1;
        }
        return day;
    }


	public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        int day = solution.orangesRotting(grid);
        System.out.println(day);
        Assert.assertEquals(4, day);


        grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        day = solution.orangesRotting(grid);
        System.out.println(day);
        Assert.assertEquals(-1, day);

        grid = new int[][]{{0,2}};
        day = solution.orangesRotting(grid);
        System.out.println(day);
        Assert.assertEquals(0, day);
    }
}
