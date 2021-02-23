package com.potato.study.leetcodecn.p00059.t001;


import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

 示例:

 输入: 3
 输出:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 按照顺时针写
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] direction = new int[][] {
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        boolean[][] visited = new boolean[n][n];
        int index = 0;
        int p = 1;
        int i = 0;
        int j = 0;
        int[][] result = new int[n][n];
        while (p <= n * n) {
            visited[i][j] = true;
            result[i][j] = p;
            p++;
            // 判断 是不是已经触及了边界
            int nextI = i + direction[index][0];
            int nextJ = j + direction[index][1];
            if (nextI < 0 || nextI >= n
                    || nextJ < 0 || nextJ >= n
                    || visited[nextI][nextJ]) {
                index = (index + 1) % direction.length;
            }
            i = i + direction[index][0];
            j = j + direction[index][1];
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.generateMatrix(3);
        System.out.println(Arrays.deepToString(res));
    }
}
