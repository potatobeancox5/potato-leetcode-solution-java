package com.potato.study.leetcode.p1222;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1222. Queens That Can Attack the King
 *  
 *
On an 8x8 chessboard, there can be multiple Black Queens and one White King.

Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king that represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.



Example 1:



Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
Output: [[0,1],[1,0],[3,3]]
Explanation:
The queen at [0,1] can attack the king cause they're in the same row.
The queen at [1,0] can attack the king cause they're in the same column.
The queen at [3,3] can attack the king cause they're in the same diagnal.
The queen at [0,4] can't attack the king cause it's blocked by the queen at [0,1].
The queen at [4,0] can't attack the king cause it's blocked by the queen at [1,0].
The queen at [2,4] can't attack the king cause it's not in the same row/column/diagnal as the king.
Example 2:



Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
Output: [[2,2],[3,4],[4,4]]
Example 3:



Input: queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
Output: [[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]


Constraints:

1 <= queens.length <= 63
queens[0].length == 2
0 <= queens[i][j] < 8
king.length == 2
0 <= king[0], king[1] < 8
At most one piece is allowed in a cell.
 *         
 *         思路：
 *          给出 king坐标 和一组 queen 坐标
 *          返回能供给到king 的 皇后的坐标
 *
 *          遍历 queen 横坐标相同 或者纵坐标相同 横纵坐标和相同 横纵坐标差相同
 *
 *          https://leetcode.com/problems/queens-that-can-attack-the-king/discuss/544614/Java-Solution-Easy-method-Runtime-0ms-100-space.
 *          从king位置 往四个方向找找到第一个 queen
 *
 *
 *

 *
 */
public class Solution {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        // 8 个 方向
        int [][] directions = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1},
                {1, 1},{-1, -1},{1, -1},{-1, 1}};

        // 设置 queen 是否有状态 0 <= queens[i][j] < 8
        boolean[][] hasQueue = new boolean[8][8];
        for (int[] queen : queens) {
            hasQueue[queen[0]][queen[1]] = true;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        // 从 king位置 向8个方向找到第一个 queen

        for (int i = 0; i < 8; i++) {
            int x = king[0];
            int y = king[1];

            int dx = directions[i][0];
            int dy = directions[i][1];
            while (0 <= x + dx && x + dx < 8 && 0 <= y + dy && y + dy < 8) {
                x += dx;
                y += dy;
                if (hasQueue[x][y]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    resultList.add(list);
                    break;
                }
            }
        }
        return resultList;
    }


	
	public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queens = new int[][]{{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        int[] king = new int[]{3,3};
        List<List<Integer>> res = solution.queensAttacktheKing(queens, king);
        System.out.println(res); // [[2,2],[3,4],[4,4]]
    }
}
