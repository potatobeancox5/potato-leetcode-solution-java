package com.potato.study.leetcodecn.p00085.t001;


import org.junit.Assert;

import java.util.Stack;

/**
 * 85. 最大矩形
 *
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

  

 示例 1：


 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 输出：6
 解释：最大矩形如上图所示。
 示例 2：

 输入：matrix = []
 输出：0
 示例 3：

 输入：matrix = [["0"]]
 输出：0
 示例 4：

 输入：matrix = [["1"]]
 输出：1
 示例 5：

 输入：matrix = [["0","0"]]
 输出：0
  

 提示：

 rows == matrix.length
 cols == matrix[0].length
 0 <= row, cols <= 200
 matrix[i][j] 为 '0' 或 '1'

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximal-rectangle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 相当于 对 84 进行了推广 相当于 从每个位置网上看 找到最大的矩形
     * 那么 我们固定 行为例
     * 1. 从该行的某个位置开始网上计算 非0 的个数，并计数至 改位置
     * 2. 对于这行的数据 相当于 求这个行上最大的矩形是啥 也就是 每次都固定找到 j 位置对应左右两边第一个小于j位置的index
     * 使用一个 栈存 目前位置 左边的小位置
     * 3. left -> right 如果当前位置 大于stack peek 那么 left i 就是peek位置 入栈 否则 当前位置小于等与 stack
     * 一直出栈找到第一个元素或者-1
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            // 往上计数
            int[] height = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                int tmp = 0;
                for (int k = i; k >= 0; k--) {
                    // 到了 0 说明已经到头了
                    if (matrix[k][j] == '0') {
                        break;
                    }
                    tmp++;
                }
                height[j] = tmp;
            }
            Stack<Integer> indexStack = new Stack<>();
            int[] left = new int[matrix[0].length];
            for (int k = 0; k < height.length; k++) {
                if (indexStack.isEmpty()) {
                    left[k] = -1;
                    indexStack.push(k);
                } else if (height[indexStack.peek()] < height[k]) {
                    left[k] = indexStack.peek();
                    indexStack.push(k);
                } else {
                    // 一直出栈到合适的位置
                    while (!indexStack.isEmpty()
                            && height[indexStack.peek()] >= height[k]) {
                        indexStack.pop();
                    }
                    if (indexStack.isEmpty()) {
                        left[k] = -1;
                    } else {
                        left[k] = indexStack.peek();
                    }
                    indexStack.push(k);
                }
            }
            indexStack.clear();
            int[] right = new int[matrix[0].length];
            for (int k = height.length - 1; k >= 0; k--) {
                if (indexStack.isEmpty()) {
                    right[k] = right.length;
                    indexStack.push(k);
                } else if (height[indexStack.peek()] < height[k]) {
                    right[k] = indexStack.peek();
                    indexStack.push(k);
                } else {
                    // 一直出栈到合适的位置
                    while (!indexStack.isEmpty()
                            && height[indexStack.peek()] >= height[k]) {
                        indexStack.pop();
                    }
                    if (indexStack.isEmpty()) {
                        right[k] = right.length;
                    } else {
                        right[k] = indexStack.peek();
                    }
                    indexStack.push(k);
                }
            }
            // 遍历左右求出最大值
            for (int k = 0; k < height.length; k++) {
                // 使用 len - -1 - 1
                int area = height[k] * (right[k] - left[k] - 1);
                maxArea = Math.max(maxArea, area);
            }

        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}

        };
        int maxArea = solution.maximalRectangle(matrix);
        System.out.println(maxArea);
        Assert.assertEquals(6, maxArea);


        matrix = new char[][] {{'0'}};
        maxArea = solution.maximalRectangle(matrix);
        System.out.println(maxArea);
        Assert.assertEquals(0, maxArea);


        matrix = new char[][] {{'1'}};
        maxArea = solution.maximalRectangle(matrix);
        System.out.println(maxArea);
        Assert.assertEquals(1, maxArea);

    }
}
