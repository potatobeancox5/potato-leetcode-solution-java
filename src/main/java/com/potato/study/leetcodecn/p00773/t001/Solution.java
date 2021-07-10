package com.potato.study.leetcodecn.p00773.t001;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;

/**
 * 773. 滑动谜题
 *
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 *
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 *
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 *
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * 示例：
 *
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * 提示：
 *
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 最小移动 bfs map 记录是否出现过
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        Queue<String> queue = new LinkedList<>();
        String initStatus = getStatus(board);
        queue.add(initStatus);
        int count = 0;
        String finalStatus = "123450";
        Set<String> visited = new HashSet<>();
        int[][] direction = new int[][] {
                {-1, 0}, {1, 0}, {0, 1}, {0, -1}
        };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 一下个位置
                String status = queue.poll();
                // 增加之后的状态 插入
                if (finalStatus.equals(status)){
                    return count;
                }
                visited.add(status);
                // 下一个 位置迭代
                int zeroIndex1 = -1;
                int zeroIndex2 = -1;
                kkk:
                for (int j = 0; j < board.length; j++) {
                    for (int k = 0; k < board[0].length; k++) {
                        if (board[j][k] == 0) {
                            zeroIndex1 = j;
                            zeroIndex2 = k;
                            break kkk;
                        }
                    }
                }
                for (int j = 0; j < 4; j++) {
                    int[][] clone = getFromStatus(status);
                    int nextIndex1 = zeroIndex1 + direction[j][0];
                    int nextIndex2 = zeroIndex2 + direction[j][1];
                    if (nextIndex1 < 0 || nextIndex1 >= board.length) {
                        continue;
                    }
                    if (nextIndex2 < 0 || nextIndex2 >= board[0].length) {
                        continue;
                    }
                    int tmp = clone[zeroIndex1][zeroIndex2];
                    clone[zeroIndex1][zeroIndex2] = clone[nextIndex1][nextIndex2];
                    clone[nextIndex1][nextIndex2] = tmp;
                    String nextStatus = getStatus(clone);
                    if (visited.contains(nextStatus)) {
                        continue;
                    }
                    queue.add(nextStatus);
                }
            }
            count++;
        }
        return -1;
    }

    /**
     * 获取 当前状态
     * @param board
     * @return
     */
    private String getStatus(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                builder.append(board[i][j]);
            }
        }
        return builder.toString();
    }

    /**
     *
     * @return
     */
    private int[][] getFromStatus(String status) {
        int[][] res = new int[2][3];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = (status.charAt(index) - '0');
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = new int[][] {
                {1,2,3},
                {4,0,5}
        };
        int i = solution.slidingPuzzle(board);
        System.out.println(i);
        Assert.assertEquals(1, i);


        board = new int[][] {
                {1,2,3},
                {5,4,0}
        };
        i = solution.slidingPuzzle(board);
        System.out.println(i);
        Assert.assertEquals(-1, i);

        // [[4,1,2],[5,0,3]]
        board = new int[][] {
                {4,1,2},
                {5,0,3}
        };
        i = solution.slidingPuzzle(board);
        System.out.println(i);
        Assert.assertEquals(5, i);
    }

}
