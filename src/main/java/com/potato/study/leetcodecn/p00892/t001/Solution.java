package com.potato.study.leetcodecn.p00892.t001;

import java.util.List;

import org.junit.Assert;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 892. 三维形体的表面积
 *
 * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 *
 * 请你返回最终这些形体的总表面积。
 *
 * 注意：每个形体的底面也需要计入表面积中。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[2]]
 * 输出：10
 * 示例 2：
 *
 *
 * 输入：grid = [[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 *
 * 输入：grid = [[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 *
 * 输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *  
 *
 * 提示：
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 对于每个单元格 需要 比较前后左右 是否相邻
     * 1.如果没有相邻，那么表面积 + 高 （4个面）
     * 2.算上定和底面
     * 3.如果有相邻，减去爱得那个面
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                // 上下 两个面，走位4个面
                sum += 2;
                sum += 4 * grid[i][j];
                if (i >= 1 && grid[i-1][j] > 0) {
                    sum -= Math.min(grid[i][j], grid[i-1][j]);
                }
                if (j >= 1 && grid[i][j-1] > 0) {
                    sum -= Math.min(grid[i][j], grid[i][j-1]);
                }
                if (i < grid.length - 1 && grid[i+1][j] > 0) {
                    sum -= Math.min(grid[i][j], grid[i+1][j]);
                }
                if (j < grid[0].length - 1 && grid[i][j+1] > 0) {
                    sum -= Math.min(grid[i][j], grid[i][j+1]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {2}
        };
        int i = solution.surfaceArea(grid);
        System.out.println(i);
        Assert.assertEquals(10, i);
    }
}
