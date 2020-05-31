package com.potato.study.leetcode.p0934;

/**
 * 
 * @author liuzhao11
 * 
 * 	934. Shortest Bridge
 *  
 *       In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)



Example 1:

Input: A = [[0,1],[1,0]]
Output: 1
Example 2:

Input: A = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1


Constraints:

2 <= A.length == A[0].length <= 100
A[i][j] == 0 or A[i][j] == 1
 *         
 *         题目含义：
 *
 *
 *         思路：
 *          https://leetcode-cn.com/problems/shortest-bridge/solution/zui-duan-de-qiao-by-leetcode/
 *
 * 
 */
public class Solution {
    private int[] ref = {1, -1, 0 ,0};
    public int shortestBridge(int[][] arr) {
        int y = arr.length;
        int x = arr[0].length;
        boolean found = false;
        boolean[][] isVisited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j, arr, isVisited);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        int count = 1;
        found = false;
        //BFS
        while (true){
            count++;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (arr[i][j] == count) {
                        found = add(count, i, j, arr, isVisited);
                    }
                    if (found) {
                        return --count;
                    }
                }
            }
        }
    }
    private boolean add(int count, int y, int x, int[][] a, boolean[][] isVisited) {
        for (int i = 0; i < 4; i++) {
            int y1 = y + ref[i];
            int x1 = x + ref[3-i];
            if (y1 < 0 || y1 >= a.length) {
                continue;
            }
            if (x1 < 0 || x1 >= a[0].length) {
                continue;
            }
            if (a[y1][x1] == 1 && !isVisited[y1][x1]) {
                return true;
            }
            if (a[y1][x1] == 0) {
                a[y1][x1] = count + 1;
            }
        }
        return false;
    }
    //DFS
    private void dfs(int y, int x, int[][] a, boolean[][] isVisited) {
        isVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int y1 = y + ref[i];
            int x1 = x + ref[3-i];
            if (y1 < 0 || y1 >= a.length) {
                continue;
            }
            if (x1 < 0 || x1 >= a[0].length) {
                continue;
            }
            if (a[y1][x1] == 1 && !isVisited[y1][x1]) {
                dfs(y1, x1, a, isVisited);
            }
            if (a[y1][x1] == 0) {
                a[y1][x1] = 2;
            }
        }
    }
}
