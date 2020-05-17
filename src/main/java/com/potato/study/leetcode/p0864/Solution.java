package com.potato.study.leetcode.p0864;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	864. Shortest Path to Get All Keys
 *  
 *        We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.

We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.  We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.

For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.



Example 1:

Input: ["@.a.#","###.#","b.A.B"]
Output: 8
Example 2:

Input: ["@..aA","..B#.","....b"]
Output: 6


Note:

1 <= grid.length <= 30
1 <= grid[0].length <= 30
grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
The number of keys is in [1, 6].  Each key has a different letter and opens exactly one lock.
 *         
 *
 *         题目含义：
 *
 *          https://leetcode-cn.com/problems/shortest-path-to-get-all-keys/solution/java-bfszhuang-tai-ya-suo-by-gaaakki
 *
 *         思路：
 *
 *
 *
 *
 *
 *
 */
public class Solution {

    /**
     * 四个方向
     */
    private int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int[][][] dis; // ij 位置和中间状态
    private int row;
    private int column;

    public int shortestPathAllKeys(String[] grid) {
        row = grid.length;
        column = grid[0].length();
        // ij 位置 和目前带有钥匙的状态值
        dis = new int[row][column][1 << 6];
        // dis 初始值 设置成 row * column
        for(int[][] d: dis) {
            for(int[] dd: d) {
                Arrays.fill(dd, row * column);
            }
        }
        // bfs 用到的queue
        Queue<int[]> que = new LinkedList<>();
        int target = 0;
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < column; ++j) {
                if(grid[i].charAt(j) == '@') {
                    que.add(new int[]{i, j, 0, 0});
                    dis[i][j][0] = 0;
                } else if(Character.isLowerCase(grid[i].charAt(j))) {
                    // 是key 拿到钥匙
                    target |= 1 << (grid[i].charAt(j) - 'a');
                }
            }
        }

        while(!que.isEmpty()) {
            int[] cur = que.remove();
            int r = cur[0];
            int c = cur[1];
            int step = cur[2];
            int key = cur[3];
            if(key == target) {
                return step;
            }
            for(int k = 0; k < 4; ++k) {
                int nextr = r + dirs[k][0];
                int nextc = c + dirs[k][1];
                if(isValid(nextr, nextc)) {
                    char cc = grid[nextr].charAt(nextc);
                    if(Character.isLowerCase(cc)) {
                        int nextKey = key | (1 << (cc - 'a'));
                        if(step + 1 < dis[nextr][nextc][nextKey]) {
                            dis[nextr][nextc][nextKey] = step + 1;
                            que.add(new int[]{nextr, nextc, step + 1, nextKey});
                        }
                    } else if(cc == '.' || cc == '@' || (Character.isUpperCase(cc) && (key & 1 << (cc - 'A')) != 0)) {
                        if(step + 1 < dis[nextr][nextc][key]) {
                            dis[nextr][nextc][key] = step + 1;
                            que.add(new int[]{nextr, nextc, step + 1, key});
                        }
                    }
                }
            }
        }
        return -1;
    }


    /**
     * 判断左边是不是合法
     * @param r
     * @param c
     * @return
     */
    public boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < column;
    }






    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] grid = new String[] {"@.a.#","###.#","b.A.B"};
        int res = solution.shortestPathAllKeys(grid);
        System.out.println(res);
        Assert.assertEquals(res, 8);


        grid = new String[] {"@..aA","..B#.","....b"};
        res = solution.shortestPathAllKeys(grid);
        System.out.println(res);
        Assert.assertEquals(res, 6);
    }
}
