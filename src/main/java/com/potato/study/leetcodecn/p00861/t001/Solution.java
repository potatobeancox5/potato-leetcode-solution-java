package com.potato.study.leetcodecn.p00861.t001;

import com.google.common.collect.Lists;
import com.potato.study.leetcode.util.ArrayUtil;
import com.potato.study.leetcode.util.LeetcodeInputUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 861. 翻转矩阵后的得分
 *
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。

 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。

 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。

 返回尽可能高的分数。

  

 示例：

 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 输出：39
 解释：
 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
  

 提示：

 1 <= A.length <= 20
 1 <= A[0].length <= 20
 A[i][j] 是 0 或 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 先按照 行为单位，如果第一个数字为0 按照行翻转
     * 2. 再按照第二列开始 如果 0的个数少于1的个数 那么对这列进行翻转
     * 3. 最终计算和
     * @param arr
     * @return
     */
    public int matrixScore(int[][] arr) {
        // 1. 先按照 行为单位，如果第一个数字为0 按照行翻转
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 0) {
                revertLine(arr, i);
            }
        }
        // 2. 再按照第二列开始 如果 0的个数少于1的个数 那么对这列进行翻转
        for (int i = 0; i < arr[0].length; i++) {
            int zeroCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount > arr.length - zeroCount) {
                revertColumn(arr, i);
            }
        }
        // 3. 最终计算和
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += getNum(arr[i]);
        }
//        ArrayUtil.printMatrix(arr);
        return (int)res;
    }


    /**
     *
     * @param arr       数字缓存
     * @param lineIndex 待翻转的行号
     */
    private void revertLine(int[][] arr, int lineIndex) {
        for (int i = 0; i < arr[lineIndex].length; i++) {
            if (arr[lineIndex][i] == 0) {
                arr[lineIndex][i] = 1;
            } else {
                arr[lineIndex][i] = 0;
            }
        }
    }

    /**
     *
     * @param arr         数字缓存
     * @param columnIndex 待翻转的列号
     */
    private void revertColumn(int[][] arr, int columnIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][columnIndex] == 0) {
                arr[i][columnIndex] = 1;
            } else {
                arr[i][columnIndex] = 0;
            }
        }
    }

    /**
     * 将 二进制 数组 转换成 数字
     * @param bitNum
     * @return
     */
    private long getNum(int[] bitNum) {
        long num = 0;
        for (int i = 0; i < bitNum.length; i++) {
            num *= 2;
            num += bitNum[i];
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String arrStr = "[[0,0,1,1],[1,0,1,0],[1,1,0,0]]";
        int[][] arr = LeetcodeInputUtils.inputString2IntArrayTwoDimensional(arrStr);
        int score = solution.matrixScore(arr);
        System.out.println(score);
        Assert.assertEquals(39, score);
    }
}
