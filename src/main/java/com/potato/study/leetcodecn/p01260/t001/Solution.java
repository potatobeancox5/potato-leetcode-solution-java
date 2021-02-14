package com.potato.study.leetcodecn.p01260.t001;


import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 *
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

 每次「迁移」操作将会引发下述活动：

 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 请你返回 k 次迁移操作后最终得到的 二维网格。

  

 示例 1：



 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 输出：[[9,1,2],[3,4,5],[6,7,8]]
 示例 2：



 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 示例 3：

 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 输出：[[1,2,3],[4,5,6],[7,8,9]]
  

 提示：

 1 <= grid.length <= 50
 1 <= grid[i].length <= 50
 -1000 <= grid[i][j] <= 1000
 0 <= k <= 100


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shift-2d-grid
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param grid
     * @param k
     * @return
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int i = 0; i < k; i++) {
            grid = shift(grid);
        }
        // build result
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
            for (int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
        }
        return res;
    }

    /**
     * 按照规则 生成一个新的 grid
     * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
     * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
     * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
     * 请你返回 k 次迁移操作后最终得到的 二维网格。
     * @param grid
     * @return
     */
    private int[][] shift(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] target = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n -1) {
                    target[i][j + 1] = grid[i][j];
                }
            }
            if (i != m - 1) {
                target[i+1][0] = grid[i][n-1];
            }
        }
        target[0][0] = grid[m-1][n-1];
        return target;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[][] grid = new ;
//        int k;
//        List<List<Integer>> list = solution.shiftGrid(grid, k);
//        System.out.println(list);
    }
}
