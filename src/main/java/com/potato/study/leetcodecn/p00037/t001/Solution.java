package com.potato.study.leetcodecn.p00037.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. 解数独
 *
 * 编写一个程序，通过填充空格来解决数独问题。

 一个数独的解法需遵循如下规则：

 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 空白格用 '.' 表示。



 一个数独。



 答案被标成红色。

 提示：

 给定的数独序列只包含数字 1-9 和字符 '.' 。
 你可以假设给定的数独只有唯一解。
 给定数独永远是 9x9 形式的。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sudoku-solver
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 是否已经解决了
     */
    private boolean isSolved;
    /**
     * 行状态 board.len 行 每行 9个位置 代表9个数字的使用
     */
    private boolean[][] lineStatus;
    /**
     * 列状态
     */
    private boolean[][] columnStatus;


    /**
     * 块区域状态
     */
    private boolean[][][] blockedStatus;
    /**
     * 过程中 使用的位置记录
     */
    private List<int[]> position;

    /**
     * 1. 找到需要遍历的点 放入一个队列中 坐标形式
     * 2. 找点同时 初始化 行列的状态矩阵 其中每行 每列 每个方块都有9个位置，每个位置为true 为已经有值了，
     * 3. dfs 如果当前 队列已经空了，说明已经安排妥当了 直接返回
     *    否则选择一个 点 ，然后从 1 - 9选一个值 放上去，然后用新状态往下找 （ 递归 dfs）
     * 4. dfs 过程中 记录 一个 valid 状态 一旦达到状态 直接返回即可
     * @param board
     */
    public void solveSudoku(char[][] board) {
        // 数组和状态的初始化
        this.isSolved = false;
        this.lineStatus = new boolean[board.length][9];
        this.columnStatus = new boolean[board[0].length][9];
        this.blockedStatus = new boolean[3][3][9];
        this.position = new ArrayList<>();
        // 执行 初始化逻辑
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ('.' == board[i][j]) {
                    position.add(new int[]{i, j});
                } else {
                    // 设置占用状态
                    int index = board[i][j] - '1';
                    lineStatus[i][index] = true;
                    columnStatus[j][index] = true;
                    blockedStatus[i/3][j/3][index] = true;
                }
            }
        }
        if (position.isEmpty()) {
            isSolved = true;
            return;
        }
        //  dfs 如果当前 队列已经空了，说明已经安排妥当了 直接返回
        dfs(board, 0);
    }

    /**
     *
     * @param board 当前时刻的结果
     * @param index 当前访问的坐标值
     */
    private void dfs(char[][] board, int index) {
        // 当前已经没有可以填充的位置了 或者已经 isSolved 直接返回
        if (isSolved || position.size() <= index) {
            isSolved = true;
            return;
        }
        int i = position.get(index)[0];
        int j = position.get(index)[1];
        // 从 1 - 9 对当前 position index 选值填入
        for (int k = 1; !isSolved && k <= 9; k++) {
            // 三个状态均不能出现才可以使用
            if (lineStatus[i][k-1] || columnStatus[j][k-1] || blockedStatus[i/3][j/3][k-1]) {
                continue;
            }
            // 修改状态和 board 值 继续dfs
            board[i][j] = (char)('0' + k);
            lineStatus[i][k-1] = true;
            columnStatus[j][k-1] = true;
            blockedStatus[i/3][j/3][k-1] = true;
            dfs(board, index + 1);
            // 已经解决了 就这么地吧 直接返回
            if (isSolved) {
                break;
            }
            // 之前选的不太行，重新选
            board[i][j] = '.';
            lineStatus[i][k-1] = false;
            columnStatus[j][k-1] = false;
            blockedStatus[i/3][j/3][k-1] = false;
        }
    }

    // 测试用例有问题 我擦
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        char[][] board = new char[][] {
//                {'.','.','.','.','5','.','.','1','.'},
//                {'.','4','.','3','.','.','.','.','.'},
//                {'.','.','.','.','.','3','.','.','1'},
//                {'8','.','.','.','.','.','.','2','.'},
//                {'.','.','2','.','7','.','.','.','.'},
//                {'.','1','5','.','.','.','.','.','.'},
//                {'.','.','.','.','.','2','.','.','.'},
//                {'.','2','.','9','.','.','.','.','.'},
//                {'.','.','4','.','.','.','.','.','.'}
//
//        };
//        solution.solveSudoku(board);
//        System.out.println(Arrays.deepToString(board));
//
//    }

}
