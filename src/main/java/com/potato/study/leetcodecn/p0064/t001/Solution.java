package com.potato.study.leetcodecn.p0064.t001;


import org.junit.Assert;

/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

 说明：每次只能向下或者向右移动一步。

 示例:

 输入:
 [
   [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-path-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * 前提条件：
     *  每次只能向下或者向右移动一步。
     *
     * val ij = min {i-1 j  ,i j-1, }
     * 边界条件 需要判断
     * @param grid
     * @return
     *
     */
    public int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int minPath = Integer.MAX_VALUE;
                if (i == 0 && j == 0) {
                    res[i][j] = grid[0][0];
                    continue;
                }
                if (i > 0) {
                    minPath = Math.min(res[i-1][j] + grid[i][j], minPath);
                }
                if (j > 0) {
                    minPath = Math.min(res[i][j-1] + grid[i][j], minPath);
                }
                res[i][j] = minPath;
            }
        }
        return res[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        int res = solution.minPathSum(grid);
        System.out.println(res);
        Assert.assertEquals(res, 7);
    }
}
