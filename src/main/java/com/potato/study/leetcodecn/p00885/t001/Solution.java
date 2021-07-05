package com.potato.study.leetcodecn.p00885.t001;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.potato.study.leetcode.util.ArrayUtil;
import com.potato.study.leetcode.util.LeetcodeUtils;

/**
 * 885. 螺旋矩阵 III
 *
 * 在 R 行 C 列的矩阵上，我们从 (r0, c0) 面朝东面开始

 这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。

 现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。

 每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。

 最终，我们到过网格的所有 R * C 个空间。

 按照访问顺序返回表示网格位置的坐标列表。

  

 示例 1：

 输入：R = 1, C = 4, r0 = 0, c0 = 0
 输出：[[0,0],[0,1],[0,2],[0,3]]


  

 示例 2：

 输入：R = 5, C = 6, r0 = 1, c0 = 4
 输出：[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]


  

 提示：

 1 <= R <= 100
 1 <= C <= 100
 0 <= r0 < R
 0 <= c0 < C

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/spiral-matrix-iii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 885
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // rStart cStart 开始 使用 direct数组控制方向 东南西北
        int[][] direction = new int[][] {
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        // 使用 stepLen 控制每次走的长度 （没两个方向换一次）
        int stepLen = 1;
        // 走了多少步
        int stepCount = 0;
        // 对于生成的 坐标 如果不在里边的话 是 就直接continue 吧
        int[][] result = new int[rows * cols][2];
        int x = rStart;
        int y = cStart;
        result[stepCount] = new int[] {x, y};
        stepCount++;
        int turnTime = 0;
        for (int i = 0; i < rows * cols; i++) {
            // 方向
            for (int directionIndex = 0; directionIndex < direction.length; directionIndex++) {
                // 这个方向走几步
                turnTime++;
                for (int j = 0; j < stepLen; j++) {
                    x += direction[directionIndex][0];
                    y += direction[directionIndex][1];
                    // 判断坐标是否合法
                    if (0 <= x && x < rows && 0 <= y && y < cols) {
                        result[stepCount] = new int[] {x, y};
                        stepCount++;
                    }
                }
                // stepLen 转移
                if (turnTime % 2 == 0) {
                    stepLen++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int rows = 1;
        int cols = 4;
        int rStart = 0;
        int cStart = 0;
//        [[0,0],[0,1],[0,2],[0,3]]
        int[][] ints = solution.spiralMatrixIII(rows, cols, rStart, cStart);
        ArrayUtil.printMatrix(ints);

        rows = 5;
        cols = 6;
        rStart = 1;
        cStart = 4;
        // [[0,0],[0,1],[0,2],[0,3]]
        ints = solution.spiralMatrixIII(rows, cols, rStart, cStart);
        ArrayUtil.printMatrix(ints);
    }
}
