package com.potato.study.leetcode.p1284;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix
 *  
 *
Given a m x n binary matrix mat. In one step, you can choose one cell and flip it and all the four neighbours of it if they exist (Flip is changing 1 to 0 and 0 to 1). A pair of cells are called neighboors if they share one edge.

Return the minimum number of steps required to convert mat to a zero matrix or -1 if you cannot.

Binary matrix is a matrix with all cells equal to 0 or 1 only.

Zero matrix is a matrix with all cells equal to 0.



Example 1:


Input: mat = [[0,0],[0,1]]
Output: 3
Explanation: One possible solution is to flip (1, 0) then (0, 1) and finally (1, 1) as shown.
Example 2:

Input: mat = [[0]]
Output: 0
Explanation: Given matrix is a zero matrix. We don't need to change it.
Example 3:

Input: mat = [[1,1,1],[1,0,1],[0,0,0]]
Output: 6
Example 4:

Input: mat = [[1,0,0],[1,0,0]]
Output: -1
Explanation: Given matrix can't be a zero matrix


Constraints:

m == mat.length
n == mat[0].length
1 <= m <= 3
1 <= n <= 3
mat[i][j] is 0 or 1.
 *         
 *         思路：
 *          变成 全0 矩阵
 *
 *          https://leetcode.com/problems/
 *          minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/discuss/446304/Java-DFS
 *
 *
 *
 *
 */
public class Solution {

    // 记录当前 位置的访问状态
    private boolean[][] visited;

    public int minFlips(int[][] mat) {
        this.visited = new boolean[mat.length][mat[0].length];
        long step = generateZeroMatrix(mat);
        if (step == Integer.MAX_VALUE) {
            return -1;
        }
        return (int)step;
    }

    /**
     *
     * @param mat
     * @return
     */
    private long generateZeroMatrix(int[][] mat) {
        // 终止条件
        if (checkIsZero(mat)) {
            return 0;
        }
        long minStep = Integer.MAX_VALUE;
        // 遍历二维数组 访问了就过 没访问
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                // 未访问过 修改相关位置 修改状态 递归进行 generateZeroMatrix
                changeMatrixStatus(mat, i, j);
                visited[i][j] = true;
                // 记录最小值
                minStep = Math.min(minStep, generateZeroMatrix(mat)  + 1);
                // 回滚状态 + 回滚 mat
                changeMatrixStatus(mat, i, j);
                visited[i][j] = false;
            }
        }
        // 最终返回 min
        return minStep;
    }

    /**
     * 修改 mat ij位置的值  1 -> 0 ; 0 -> 1
     * @param mat
     * @param i
     * @param j
     */
    private void changeMatrixStatus(int[][] mat, int i, int j) {
        mat[i][j] ^= 1;
        int n = mat.length;
        int m = mat[0].length;
        if (i-1>= 0) {
            mat[i-1][j] ^= 1;
        }
        if (i+1<n) {
            mat[i+1][j] ^= 1;
        }

        if (j-1>=0) {
            mat[i][j-1] ^= 1;
        }
        if (j+1<m) {
            mat[i][j+1] ^= 1;
        }
    }


    /**
     * 检验 矩阵是否是 0 矩阵
     * @param matrix
     * @return
     */
    private boolean checkIsZero (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat = new int[][]{{0,0}, {0,1}};
        int res = solution.minFlips(mat);
        System.out.println(res);
        Assert.assertEquals(3, res);

        mat = new int[][]{{0}};
        res = solution.minFlips(mat);
        System.out.println(res);
        Assert.assertEquals(0, res);

        mat = new int[][]{{1,1,1}, {1,0,1}, {0,0,0}};
        res = solution.minFlips(mat);
        System.out.println(res);
        Assert.assertEquals(6, res);

        mat = new int[][]{{1,0,0}, {1,0,0}};
        res = solution.minFlips(mat);
        System.out.println(res);
        Assert.assertEquals(-1, res);
    }
}
