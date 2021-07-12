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
        String initStatus = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                initStatus += board[i][j];
            }
        }
        queue.add(initStatus);
        int count = 0;
        String finalStatus = "123450";
        // 存放遍历过得字符串
        Set<String> visited = new HashSet<>();
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
                String[] nextPuzzle = getNextPuzzle(status);
                if (null == nextPuzzle) {
                    continue;
                }
                for (String next : nextPuzzle) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    queue.add(next);
                }
            }
            count++;
        }
        return -1;
    }

    private int[][] swap = new int[][] {
            {1,3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1,3,5},
            {2,4}
    };

    private String[] getNextPuzzle(String status) {
        // 找到 status 中0 的位置
        int index = status.indexOf('0');
        // 按照zero的位置 找到需要进行交换的两个字符串
        int[] nextSwapIndex = swap[index];
        String[] result = new String[nextSwapIndex.length];
        int i = 0;
        for (int swapIndex : nextSwapIndex) {
            char[] chars = status.toCharArray();
            char tmp = chars[index];
            chars[index] = chars[swapIndex];
            chars[swapIndex] = tmp;
            result[i++] = new String(chars);
        }
        // 可交换生成新的记过
        return result ;
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
