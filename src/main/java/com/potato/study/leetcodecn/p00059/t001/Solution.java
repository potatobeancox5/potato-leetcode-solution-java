package com.potato.study.leetcodecn.p00059.t001;


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
        int value = 1;
        int[][] matrix = new int[n][n];
        int x = 0;
        int y = 0;
        while (value <= n * n) {
            for (int i = 0; i < n; i++) {
                y--;
                if (matrix[x][y] > 0) {
                    continue;
                }
                matrix[x][y + i] = value++;
            }
            for (int i = 0; i < n; i++) {
                if (matrix[x][y] > 0) {
                    continue;
                }
                matrix[x-i][y] = value++;
            }
            for (int i = 0; i < n; i++) {
                if (matrix[x][y] > 0) {
                    continue;
                }
            }
            for (int i = 0; i < n; i++) {
                if (matrix[x][y] > 0) {
                    continue;
                }
            }
        }
        return matrix;
    }


//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String s = "Hello World";
//        int res = solution.lengthOfLastWord(s);
//        System.out.println(res);
//        Assert.assertEquals(5, res);
//    }
}
