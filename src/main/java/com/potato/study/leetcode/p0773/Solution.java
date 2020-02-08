package com.potato.study.leetcode.p0773;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	773. Sliding Puzzle
 *  
 *         On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.

A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given a puzzle board, return the least number of moves required so that the state of the board is solved.

If it is impossible for the state of the board to be solved, return -1.

Examples:

Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.
Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.
Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
Input: board = [[3,2,4],[1,5,0]]
Output: 14
Note:

board will be a 2 x 3 array as described above.
board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 *         
 *         思路：只能移动 0 问能不能通过移动0 将数组变成 [1,2,3],[4,5,0] 形式
 *
 *
 *         https://www.jianshu.com/p/57309a11db1a
 *
 *         BFS
 *
 * 
 */
public class Solution {

    public int slidingPuzzle(int[][] board) {
        Set<Integer> visitedSet = new HashSet<>();
        // 0 使用 queue 存储 board 序列化成的code
        Queue<Integer> stateQueue = new LinkedList<>();
        int initState = getCode(board);
        if (initState == 123450) {
            return 0;
        }
        stateQueue.add(initState);
        visitedSet.add(initState);
        // 1 bfs 寻找是否能够 到达最终位置
        int step = 1;
        while (!stateQueue.isEmpty()) {
            int levelCount = stateQueue.size();
            for (int i = 0; i < levelCount; i++) {
                int currentState = stateQueue.remove();
                List<Integer> nextStateList = this.getNextStateListByCode(currentState);
                for (int nextState : nextStateList) {
                    if (!visitedSet.contains(nextState)) {
                        visitedSet.add(nextState);
                        stateQueue.add(nextState);

                        if (123450 == nextState) {
                            return step;
                        }
                    }
                }

            }
            // 每层遍历结束 step ++
            step++;
        }
        // 2 返回最终的结果
        return -1;
    }


    /**
     * 交换矩阵 中给定坐标的两个数字
     * @param board
     * @param x
     * @param y
     * @param nx
     * @param ny
     */
    private void swap(int[][] board, int x, int y, int nx, int ny) {
        int tmp = board[x][y];
        board[x][y] = board[nx][ny];
        board[nx][ny] = tmp;
    }


    /**
     * 将当前矩阵状态按照一个数字除数
     * @param board
     * @return
     */
    private int getCode(int[][] board) {
        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res = 10 * res;
                res += board[i][j];
            }
        }
        return res;
    }

    /**
     * 四个方向
     */
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    /**
     * 根据当前的code 求出走一步可能有多少中状态
     * @param code
     * @return
     */
    private List<Integer> getNextStateListByCode(int code) {
        // 0 通过code 生成矩阵 同时 找到 0位置
        int[][] matrix = this.getMatrixByCode(code);
        int zx = -1;
        int zy = -1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    zx = i;
                    zy = j;
                }
            }
        }
        // 1 遍历四个方向 对 0 点分别进行swap 并插入list
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            if (zx + directions[i][0] < 0 || zx + directions[i][0] > 1) {
                continue;
            }
            if (zy + directions[i][1] < 0 || zy + directions[i][1] > 2) {
                continue;
            }

            swap(matrix, zx, zy, zx + directions[i][0], zy + directions[i][1]);
            resList.add(this.getCode(matrix));
            swap(matrix, zx, zy, zx + directions[i][0], zy + directions[i][1]);
        }
        // 2 返回
        return resList;
    }

    /**
     * 将 code 解析成 数组状态
     * @param code
     * @return
     */
    private int[][] getMatrixByCode(int code) {
        int[][] board = new int[2][3];
        for (int i = 1; i >= 0 ; i--) {
            for (int j = 2; j >= 0 ; j--) {
                board[i][j] = code % 10;
                code /= 10;
            }
        }
        return board;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();


        int[][] board = {{1,2,3},{4,0,5}};
        int steps = solution.slidingPuzzle(board);
        System.out.println(steps);
        Assert.assertEquals(1, steps);

        int[][] board1 = {{1,2,3},{5,4,0}};
        steps = solution.slidingPuzzle(board1);
        System.out.println(steps);
        Assert.assertEquals(-1, steps);

        int[][] board2 = {{4,1,2},{5,0,3}};
        steps = solution.slidingPuzzle(board2);
        System.out.println(steps);
        Assert.assertEquals(5, steps);
    }
}
