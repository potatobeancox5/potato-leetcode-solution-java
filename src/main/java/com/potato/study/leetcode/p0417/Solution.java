package com.potato.study.leetcode.p0417;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         417. Pacific Atlantic Water Flow
 * 
 *         Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.


Example:

Given the following 5x5 matrix:

Pacific ~   ~   ~   ~   ~
~  1   2   2   3  (5) *
~  3   2   3  (4) (4) *
~  2   4  (5)  3   1  *
~ (6) (7)  1   4   5  *
~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * 
 *
 *         题目含义：
 *          左边缘和上边缘 是太平洋
 *          右边缘和下边缘 是大西洋
 *          矩阵中每个点代表 地势的高度 ，找到点既能到达太平洋 又能到达大西洋的点集合
 *          能抵达指的是 该点高度大于等于下一个点高度
 *
 *         思路：
 *         417. Pacific Atlantic Water Flow

https://blog.csdn.net/anhuibozhoushatu/article/details/85055159

思路 从边上每个点进行dfs 上面往下 下面往上
分别生成两个状态 visitp 和visota
遍历二维数组 两个状态都ok的 插入结果

dfs visit状态 x y  当前水位
判断xy 正确性

改变当前visit

四个方向
如果 下个方向没被访问过 且xt yt水位小于 xy的水位 遍历st yt

https://blog.csdn.net/anhuibozhoushatu/article/details/85055159
 *
 */
public class Solution {

    private int[][] direction = {{-1,0},{1, 0},{0,-1},{0,1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> res = new ArrayList<>();
        if (null == matrix || matrix.length == 0|| matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        boolean[][] visitPacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] visitAtlantic = new boolean[matrix.length][matrix[0].length];
        // 1. 从 上下 遍历
        for (int i = 0; i < matrix.length; i++) {
            dfsBuildVisit (visitPacific, direction, i, 0, matrix);
            dfsBuildVisit (visitAtlantic, direction, i, matrix[0].length - 1, matrix);
        }
        // 2. 从左右 遍历
        for (int i = 0; i < matrix[0].length; i++) {
            dfsBuildVisit (visitPacific, direction, 0, i, matrix);
            dfsBuildVisit (visitAtlantic, direction, matrix.length - 1, i,  matrix);
        }
        // 3. 遍历 visitPacific 和 visitAtlantic 判断交集并加入结果数组
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visitPacific[i][j] && visitAtlantic[i][j]) {
                    ArrayList<Integer> coordinate = new ArrayList<>(2);
                    coordinate.add(i);
                    coordinate.add(j);
                    res.add(coordinate);
                }
            }
        }
        return res;
    }


    /**
     * dfs 构建 到达判断结果数据
     * 1. 如果ij 能访问这个方法 说明已经经过上层判断 这个节点能reach目的地
     * 2. 依次判断 ij  的下一个几点是否满足到达条件 如果当前节点visit为false 那么继续往下找
     * @param canReached    是否可以到达目的地
     * @param direction     方向
     * @param currentLine             当前行号
     * @param currentRow             当前列号
     * @param matrix        地图矩阵
     */
    private void dfsBuildVisit (boolean[][] canReached, int[][] direction, int currentLine, int currentRow, int[][] matrix) {
        int lineNum = matrix.length;
        int rowNum = matrix[0].length;
        // 四个方向遍历
        canReached[currentLine][currentRow] = true;
        for (int index = 0; index < direction.length; index++) {
            int nextLine = currentLine + direction[index][0];
            int nextRow = currentRow + direction[index][1];

            if (0 <= nextLine && nextLine < lineNum && 0 <= nextRow && nextRow < rowNum) {
                // 下个位置是否已经遍历过
                if (canReached[nextLine][nextRow]) {
                    continue;
                }
                if (matrix[nextLine][nextRow] >= matrix[currentLine][currentRow]) {
                    dfsBuildVisit(canReached, direction, nextLine, nextRow, matrix);
                }
            }
        }
    }
	
	
	public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> res = solution.pacificAtlantic(matrix);
        System.out.println(res);


        int[][] matrix1 = {{1,2,3},{8,9,4},{7,6,5}};
        res = solution.pacificAtlantic(matrix1);
        System.out.println(res);
    }
}
