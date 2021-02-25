package com.potato.study.leetcodecn.p00542.t001;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 *
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

 两个相邻元素间的距离为 1 。

  

 示例 1：

 输入：
 [[0,0,0],
 [0,1,0],
 [0,0,0]]

 输出：
 [[0,0,0],
  [0,1,0],
  [0,0,0]]
 示例 2：

 输入：
 [[0,0,0],
 [0,1,0],
 [1,1,1]]

 输出：
 [[0,0,0],
 [0,1,0],
 [1,2,1]]
  

 提示：

 给定矩阵的元素个数不超过 10000。
 给定矩阵中至少有一个元素是 0。
 矩阵中的元素只在四个方向上相邻: 上、下、左、右。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/01-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 遍历 matrix 将 0的点放入 queue 标记 已访问过
     * 2. queue 循环pop 出节点 对于 四个方向 没访问过的记录值 并入队
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (true) {

                    queue.add(null);
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][] {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        int[][] ints = solution.updateMatrix(matrix);
        System.out.println(Arrays.deepToString(ints));
    }
}
