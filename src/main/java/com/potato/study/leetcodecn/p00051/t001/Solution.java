package com.potato.study.leetcodecn.p00051.t001;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

  

 示例 1：


 输入：n = 4
 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 解释：如上图所示，4 皇后问题存在两个不同的解法。
 示例 2：

 输入：n = 1
 输出：[["Q"]]
  

 提示：

 1 <= n <= 9
 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-queens
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 初始化棋盘 复制 .
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        // 1.定义一个棋盘 初始化称 点
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessboard[i], '.');
        }
        // 2.定义 行 列 主对角线 i-j+len-1 次对角线 i+j 状态 2len-1个状态
        boolean[] line = new boolean[n];
        boolean[] column = new boolean[n];
        boolean[] mainDiagonal = new boolean[2 * n - 1];
        boolean[] negativeDiagonal = new boolean[2 * n - 1];
        // 3 dfs 棋盘 状态集 当前棋子数 总数要求数 结果集 当前从哪个位置开始确定 ij 初始化为00
        List<List<String>> result = new ArrayList<>();
        // 当前使用了多少个棋子
        int k = 0;
        // 当前开始遍历点的坐标（放置的点不能超过这个点，防重复）
        int i = 0;
        int j = 0;
        dfs(result, chessboard, n, k, i, j, line, column, mainDiagonal, negativeDiagonal);
        return result;
    }

    /**
     * dfs 生成 结果集合 没从从 ij 位置 开始遍历 寻找下一个 放置点
     * @param result
     * @param chessboard
     * @param n
     * @param k
     * @param i
     * @param j
     * @param line
     * @param column
     * @param mainDiagonal
     * @param negativeDiagonal
     */
    private void dfs(List<List<String>> result, char[][] chessboard, int n, int k, int i, int j,
                     boolean[] line, boolean[] column, boolean[] mainDiagonal, boolean[] negativeDiagonal) {
        // todo 当前棋子数 等于 总数 生成结果集合
        if (n == k) {
            result.add(generateList(chessboard));
            return;
        }
        // 寻找下一个 安放点
        for (int l = i; l < n; l++) {
            for (int m = 0; m < n; m++) {
                // 之前的点 就不考虑 放东西了，这样防重
                if (l == i && m < j) {
                    continue;
                }
                // if 状态 占用 continue  主对角线 i-j+len-1 次对角线 i+j
                if (line[l] || column[m] || mainDiagonal[l - m + n - 1] || negativeDiagonal[l + m]) {
                    continue;
                }
                // 设置棋盘位置 + 修改状态占位
                chessboard[l][m] = 'Q';
                line[l] = true;
                column[m] = true;
                mainDiagonal[l - m + n - 1] = true;
                negativeDiagonal[l + m] = true;
                // dfs 递归找
                dfs(result, chessboard, n, k + 1, l, m, line, column, mainDiagonal, negativeDiagonal);
                // 还原棋盘 + 还原状态
                chessboard[l][m] = '.';
                line[l] = false;
                column[m] = false;
                mainDiagonal[l - m + n - 1] = false;
                negativeDiagonal[l + m] = false;
            }
        }
    }

    /**
     * 转换
     * @param chessboard
     * @return
     */
    private List<String> generateList(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] arr : chessboard) {
            list.add(new String(arr));
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(2);
        System.out.println(lists);

        lists = solution.solveNQueens(1);
        System.out.println(lists);

        lists = solution.solveNQueens(4);
        System.out.println(lists);
    }

}
