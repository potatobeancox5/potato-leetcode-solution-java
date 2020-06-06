package com.potato.study.leetcode.p1263;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	1263. Minimum Moves to Move a Box to Their Target Location
 *  
 *
Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.



Example 1:

Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
Example 2:

Input: nums = [4]
Output: 0
Explanation: Since 4 is not divisible by 3, do not pick any number.
Example 3:

Input: nums = [1,2,3,4,4]
Output: 12
Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).


Constraints:

1 <= nums.length <= 4 * 10^4
1 <= nums[i] <= 10^4
 *         
 *         思路：
 *      https://leetcode-cn.com/problems/minimum-moves-to-move-a-box-to-their-target-location/solution/java-bfsdfs-by-jackie-tien/
 *
 */
public class Solution {

    private static final int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int minPushBox(char[][] grid) {
        int targetX = -1;
        int targetY = -1;
        int startX = -1;
        int startY = -1;
        int peopleX = -1;
        int peopleY = -1;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][][] visited = new boolean[n][m][4];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'T') {
                    targetX = i;
                    targetY = j;
                } else if (grid[i][j] == 'B') {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 'S') {
                    peopleX = i;
                    peopleY = j;
                }
            }
        }

        grid[startX][startY] = '#';
        for (int i = 0; i < directions.length;  i++) {
            int[] direction = directions[i];
            int x = startX + direction[0];
            int y = startY + direction[1];
            if (canReach(grid, n, m, peopleX, peopleY, x, y)) {
                queue.add(new Point(startX, startY, x, y));
                visited[startX][startY][i] = true;
            }
        }
        grid[startX][startY] = 'B';
        int step = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Point point = queue.poll();
                if (point.x == targetX && point.y == targetY) {
                    return step;
                }
                grid[point.x][point.y] = '#';
                // up
                if (point.x - 1 >= 0 && grid[point.x - 1][point.y] != '#' && !visited[point.x - 1][point.y][2]
                        && canReach(grid, n, m, point.peopleX, point.peopleY, point.x + 1, point.y)) {
                    queue.add(new Point(point.x - 1, point.y, point.x, point.y));
                    visited[point.x - 1][point.y][2] = true;
                }
                // down
                if (point.x + 1 < n && grid[point.x + 1][point.y] != '#' && !visited[point.x + 1][point.y][3]
                        && canReach(grid, n, m, point.peopleX, point.peopleY, point.x - 1, point.y)) {
                    queue.add(new Point(point.x + 1, point.y, point.x, point.y));
                    visited[point.x + 1][point.y][3] = true;
                }
                // left
                if (point.y - 1 >= 0 && grid[point.x][point.y - 1] != '#' && !visited[point.x][point.y - 1][1]
                        && canReach(grid, n, m, point.peopleX, point.peopleY, point.x, point.y + 1)) {
                    queue.add(new Point(point.x, point.y - 1, point.x, point.y));
                    visited[point.x][point.y - 1][1] = true;
                }
                // right
                if (point.y + 1 < m && grid[point.x][point.y + 1] != '#' && !visited[point.x][point.y + 1][0]
                        && canReach(grid, n, m, point.peopleX, point.peopleY, point.x, point.y - 1)) {
                    queue.add(new Point(point.x, point.y + 1, point.x, point.y));
                    visited[point.x][point.y + 1][0] = true;
                }
                grid[point.x][point.y] = '.';
            }

            step++;
        }
        return -1;
    }

    private boolean canReach(char[][] grid, int n, int m, int startX, int startY, int targetX,
                             int targetY) {
        if (targetX < 0 || targetX >= n || targetY < 0 || targetY >= m) {
            return false;
        }
        boolean[][] visited = new boolean[n][m];
        visited[startX][startY] = true;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(startX, startY));
        while (!stack.isEmpty()) {
            Point point = stack.pop();
            if (point.x == targetX && point.y == targetY) {
                return true;
            }
            for (int[] direction : directions) {
                int x = point.x + direction[0];
                int y = point.y + direction[1];
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != '#' && !visited[x][y]) {
                    visited[x][y] = true;
                    stack.add(new Point(x, y));
                }
            }
        }
        return false;
    }


    private static class Point {

        int x;
        int y;
        int peopleX;
        int peopleY;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int peopleX, int peopleY) {
            this.x = x;
            this.y = y;
            this.peopleX = peopleX;
            this.peopleY = peopleY;
        }
    }

}
