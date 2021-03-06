package com.potato.study.leetcodecn.p00063.t001;


import org.junit.Assert;

/**
 * 63. 不同路径 II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？



 网格中的障碍物和空位置分别用 1 和 0 来表示。

 说明：m 和 n 的值均不超过 100。

 示例 1:

 输入:
 [
   [0,0,0],
   [0,1,0],
   [0,0,0]
 ]
 输出: 2
 解释:
 3x3 网格的正中间有一个障碍物。
 从左上角到右下角一共有 2 条不同的路径：
 1. 向右 -> 向右 -> 向下 -> 向下
 2. 向下 -> 向下 -> 向右 -> 向右

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-paths-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 求sum 时如果遇到障碍物 那么这个方向上就不能计算了
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    if (i == 0 && j == 0){
                        res[i][j] = 1;
                    } else if (i == 0) {
                        res[i][j] = res[i][j-1];
                    } else if (j == 0) {
                        res[i][j] = res[i-1][j];
                    } else {
                        res[i][j] = res[i-1][j] + res[i][j-1];
                    }
                }
            }
        }
        return res[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacleGrid = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        int res = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
        Assert.assertEquals(res, 2);

//        obstacleGrid = new int[][] {};
//        res = solution.uniquePathsWithObstacles(obstacleGrid);
//        System.out.println(res);
//        Assert.assertEquals(res, 28);

    }
}
