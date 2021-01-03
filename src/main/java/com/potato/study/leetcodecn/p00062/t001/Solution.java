package com.potato.study.leetcodecn.p00062.t001;


import org.junit.Assert;

/**
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 问总共有多少条不同的路径？



 例如，上图是一个7 x 3 的网格。有多少可能的路径？

  

 示例 1:

 输入: m = 3, n = 2
 输出: 3
 解释:
 从左上角开始，总共有 3 条路径可以到达右下角。
 1. 向右 -> 向右 -> 向下
 2. 向右 -> 向下 -> 向右
 3. 向下 -> 向右 -> 向右
 示例 2:

 输入: m = 7, n = 3
 输出: 28
  

 提示：

 1 <= m, n <= 100
 题目数据保证答案小于等于 2 * 10 ^ 9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-paths
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * step i j 代表 到达 ij 位置 需要多少 走法
     * step i j = sum step i-1 j + step i j-1
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] step = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    step[i][j] = 1;
                } else {
                    step[i][j] = step[i-1][j] + step[i][j-1];
                }
            }
        }
        return step[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 3;
        int n = 2;
        int res = solution.uniquePaths(m, n);
        System.out.println(res);
        Assert.assertEquals(res, 3);

        m = 7;
        n = 3;
        res = solution.uniquePaths(m, n);
        System.out.println(res);
        Assert.assertEquals(res, 28);

    }
}
