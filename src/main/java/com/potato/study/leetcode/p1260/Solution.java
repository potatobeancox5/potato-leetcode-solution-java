package com.potato.study.leetcode.p1260;



import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1260. Shift 2D Grid
 *  
 *
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.



Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
Example 2:


Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]


Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100
 *         
 *         思路：
 *
 *          二叉树规则
 *              treeNode.left.val == 2 * x + 1
 *              treeNode.right.val == 2 * x + 2
 *
https://leetcode.com/articles/shift-2d-grid/
 *
 */
public class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        for (; k > 0 ; k--) {
            // 第一个点
            int pre = grid[grid.length - 1][grid[0].length - 1];
            // 每次从 0 0开始移动了
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int tmp = grid[i][j];
                    grid[i][j] = pre;
                    pre = tmp;
                }
            }
        }

        // 将生成 的 grid 转换到数组中
        List<List<Integer>> result = new ArrayList<>();
        for (int[] line : grid) {
            List<Integer> list = new ArrayList<>();
            for (int ele : line) {
                list.add(ele);
            }
            result.add(list);
        }
        return result;
    }
}
