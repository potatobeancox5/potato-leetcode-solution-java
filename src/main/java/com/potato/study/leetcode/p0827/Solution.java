package com.potato.study.leetcode.p0827;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	827. Making A Large Island
 *  
 *         In a 2D grid of 0s and 1s, we change at most one 0 to a 1.

After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).

Example 1:

Input: [[1, 0], [0, 1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: [[1, 1], [1, 0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: [[1, 1], [1, 1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.


Notes:

1 <= grid.length = grid[0].length <= 50.
0 <= grid[i][j] <= 1.
 *         
 *         思路：
 *          变更 matrix 其中的一个 0-1， 求形成的 1 区域 最大面积是多少
 *
 *          https://leetcode.com/problems/making-a-large-island/discuss/313787/Two-java-solutions
 *
 *          找到每个 非1 点使用一个 visited 开始遍历 计算总大小 然后返回 如果当前 0 - i0 - j 都是 1 直接计算面积
 * 
 */
public class Solution {

    // 四个方向
    private int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        // 标记是否 grid 全是1
        boolean isAllOne = true;
        // 遍历 grid  grid ij = 1 continue 如果当前点 是0 bfs queue 计数1 最终完成比较最大值
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                isAllOne = false;
                // bfs 存放节点的 queue
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                int currentOnes = 1;
                boolean[][] hasVisited = new boolean[grid.length][grid[0].length];
                while (!queue.isEmpty()) {
                    int[] position = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = position[0] + direction[k][0];
                        int y = position[1] + direction[k][1];
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                            continue;
                        }
                        if (hasVisited[x][y]) {
                            continue;
                        }
                        if (grid[x][y] == 1) {
                            hasVisited[x][y] = true;
                            currentOnes++;
                            queue.add(new int[]{x, y});
                        }
                    }
                }
                max = Math.max(max, currentOnes);
            }
        }
        if (isAllOne) {
            return grid.length * grid[0].length;
        }
        return max;
    }



	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        int res = solution.largestIsland(grid);
        System.out.println(res);
        Assert.assertEquals(3, res);

        grid = new int[][]{{1, 1}, {1, 0}};
        res = solution.largestIsland(grid);
        System.out.println(res);
        Assert.assertEquals(4, res);


        grid = new int[][]{{1, 1}, {1, 1}};
        res = solution.largestIsland(grid);
        System.out.println(res);
        Assert.assertEquals(4, res);
    }
}
