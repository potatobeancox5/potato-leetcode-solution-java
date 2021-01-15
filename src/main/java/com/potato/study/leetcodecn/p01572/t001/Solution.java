package com.potato.study.leetcodecn.p01572.t001;

/**
 * 1572. 矩阵对角线元素的和
 *
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。

 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。

  

 示例  1：



 输入：mat = [[1,2,3],
             [4,5,6],
             [7,8,9]]
 输出：25
 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 请注意，元素 mat[1][1] = 5 只会被计算一次。
 示例  2：

 输入：mat = [[1,1,1,1],
             [1,1,1,1],
             [1,1,1,1],
             [1,1,1,1]]
 输出：8
 示例 3：

 输入：mat = [[5]]
 输出：5
  

 提示：

 n == mat.length == mat[i].length
 1 <= n <= 100
 1 <= mat[i][j] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/matrix-diagonal-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 对角线的和 减去重复计算的数字
     * @param mat
     * @return
     */
    public int diagonalSum(int[][] mat) {
        // 判断是不是奇数
        int deduceVal = 0;
        int n = mat.length;
        if ((n & 1) == 1) {
            int index = n / 2;
            deduceVal = mat[index][index];
        }
        // 计算 正对角线 计算 fu 对角线
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - 1 - i];
        }
        sum -= deduceVal;
        return sum;
    }
}
