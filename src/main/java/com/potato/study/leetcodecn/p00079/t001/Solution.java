package com.potato.study.leetcodecn.p00079.t001;


import org.junit.Assert;

/**
 * 79. 单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

  

 示例:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 给定 word = "ABCCED", 返回 true
 给定 word = "SEE", 返回 true
 给定 word = "ABCB", 返回 false
  

 提示：

 board 和 word 中只包含大写和小写英文字母。
 1 <= board.length <= 200
 1 <= board[i].length <= 200
 1 <= word.length <= 10^3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-search
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 深度优先搜索
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int index = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        // 从每个位置开始dfs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfsJudgeExist(board, word, i, j, index, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判定 word 是够在矩阵中存在
     * @param board
     * @param word
     * @param i         当前查找的位置
     * @param j
     * @param index     遍历到的单词的index 本次要遍历的单词
     * @param visited   是否已经访问过 矩阵记录
     * @return
     */
    private boolean dfsJudgeExist(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        int[][] diection = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 终止条件
        if (index == word.length()) {
            return true;
        }
        // 如果 ij 不合法 返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        // visit i j
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        // 从 4个方向 dfs 遍历 接下来的单词 任意 一个成功就可以返回了
        for (int k = 0; k < 4; k++) {
            int nextI = i + diection[k][0];
            int nextJ = j + diection[k][1];
            boolean res = dfsJudgeExist(board, word, nextI, nextJ, index + 1, visited);
            if (res) {
                return true;
            }
        }
        // 这个点废了 回滚吧
        visited[i][j] = false;
        // 都不成功 返回 false
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean res = solution.exist(board, word);
        System.out.println(res);
        Assert.assertEquals(true, res);

        board = new char[][]{
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        word = "AAB";
        res = solution.exist(board, word);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
