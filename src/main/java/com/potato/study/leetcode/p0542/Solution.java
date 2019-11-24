package com.potato.study.leetcode.p0542;

import com.potato.study.leetcode.util.ArrayUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 *         542. 01 Matrix
 * 
 *         Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.



Example 1:

Input:
[[0,0,0],
[0,1,0],
[0,0,0]]

Output:
[[0,0,0],
[0,1,0],
[0,0,0]]
Example 2:

Input:
[[0,0,0],
[0,1,0],
[1,1,1]]

Output:
[[0,0,0],
[0,1,0],
[1,2,1]]


Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 * 
 * 
 *         思路：
 *
 *         542. 01 Matrix

https://blog.csdn.net/u014593748/article/details/65937524

bfs 广度优先

队列缓存带访问的点
每次出队 都访问之前 没访问过的点

申请结果集 res fill -1

遍历当前数组
如果为0 入队 res ij 为0

whiel queue 非空
出队 ，
val 是当前ij的距离
对于临接  val +1 入对列
 *       
 *          
 */
public class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        // 队列缓存等待访问的点
        Queue<int[]> queue = new LinkedList<>();
        // distance 是一个距离
        int[][] distance = new int[matrix.length][matrix[0].length];
        // 遍历当前数组 如果为0 入队
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] nextNode = queue.remove();
            int x = nextNode[0];
            int y = nextNode[1];
            int curVal = distance[x][y];
            // 上
            if (x > 0 &&  distance[x-1][y] == -1) {
                distance[x-1][y] = curVal + 1;
                queue.add(new int[]{x-1, y});
            }
            // 下
            if (x < distance.length -1 && distance[x+1][y] == -1) {
                distance[x+1][y] = curVal + 1;
                queue.add(new int[]{x+1, y});
            }
            // 左
            if (y > 0 && distance[x][y-1] == -1) {
                distance[x][y-1] = curVal + 1;
                queue.add(new int[]{x, y-1});
            }
            // 右
            if (y < distance[0].length - 1 && distance[x][y+1] == -1) {
                distance[x][y+1] = curVal + 1;
                queue.add(new int[]{x, y + 1});
            }
        }
        return distance;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] matrix = {};
        int[][] newStr = solution.updateMatrix(matrix);
        ArrayUtil.printMatrix(newStr);
	}
}
