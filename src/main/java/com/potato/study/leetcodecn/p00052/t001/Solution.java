package com.potato.study.leetcodecn.p00052.t001;


import org.junit.Assert;

/**
 * 52. N皇后 II
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。

  

 示例 1：


 输入：n = 4
 输出：2
 解释：如上图所示，4 皇后问题存在两个不同的解法。
 示例 2：

 输入：n = 1
 输出：1
  

 提示：

 1 <= n <= 9
 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-queens-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * n 皇后计数器
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        // 不用初始化 棋盘 直接 生成 状态矩阵 正对角线 i - j + n - 1 负对角线 i+ j
        boolean[] line = new boolean[n];
        boolean[] column = new boolean[n];
        boolean[] main = new boolean[2 * n - 1];
        boolean[] negtive = new boolean[2 * n - 1];
        // in dfs n k-当前遍历到多少Q， i， j 从哪个点开始遍历，4个状态矩阵
        return dfs(n, 0, 0, 0, line, column, main, negtive);
    }


    /**
     *
     * @param n
     * @param k
     * @param startLine
     * @param startColumn
     * @param line          行状态
     * @param column        列状态
     * @param main          正对角线  i - j + n - 1 作为下标
     * @param negtive       负对角线  i + j
     * @return
     */
    private int dfs(int n, int k, int startLine, int startColumn,
                         boolean[] line, boolean[] column, boolean[] main, boolean[] negtive) {
        // 是否可以返回
        if (n == k) {
            return 1;
        }
        // 取点设置 并dfs
        int count = 0;
        for (int i = startLine; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 遍历过了 走吧
                if (i == startLine && j < startColumn) {
                    continue;
                }
                // 放这会被杀死
                if (line[i] || column[j] || main[i - j + n - 1] || negtive[i + j]) {
                    continue;
                }
                // 设置状态
                line[i] = true;
                column[j] = true;
                main[i - j + n - 1] = true;
                negtive[i + j] = true;
                // dfs
                count += dfs(n, k + 1, i, j,line, column, main, negtive);
                // 回滚状态
                line[i] = false;
                column[j] = false;
                main[i - j + n - 1] = false;
                negtive[i + j] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.totalNQueens(2);
        System.out.println(res);
        Assert.assertEquals(0, res);

        res = solution.totalNQueens(1);
        System.out.println(res);
        Assert.assertEquals(1, res);

        res = solution.totalNQueens(4);
        System.out.println(res);
        Assert.assertEquals(2, res);
    }

}
