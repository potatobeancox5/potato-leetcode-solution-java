package com.potato.study.leetcode.p1072;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1072. Flip Columns For Maximum Number of Equal Rows
 *  
 *       Given a matrix consisting of 0s and 1s, we may choose any number of columns in the matrix and flip every cell in that column.  Flipping a cell changes the value of that cell from 0 to 1 or from 1 to 0.

Return the maximum number of rows that have all values equal after some number of flips.



Example 1:

Input: [[0,1],[1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.
Example 2:

Input: [[0,1],[1,0]]
Output: 2
Explanation: After flipping values in the first column, both rows have equal values.
Example 3:

Input: [[0,0,0],[0,0,1],[1,1,0]]
Output: 2
Explanation: After flipping values in the first two columns, the last two rows have equal values.


Note:

1 <= matrix.length <= 300
1 <= matrix[i].length <= 300
All matrix[i].length's are equal
matrix[i][j] is 0 or 1
 *         
 *
 *
 *
 *         思路：
 *         https://www.cnblogs.com/keepAC/p/11623860.html
 *
 *         https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows/solution/xun-zhao-ju-you-xiang-tong-de-te-zheng-de-xing-de-/
 *
 *
 *
 */
public class Solution {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // 判断 matrix 是否为空 返回 0
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 使用map 记录 异或相同的数字 出现的次数 每行 过程中记录最多次数
        Map<String, Integer> countMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder builder = new StringBuilder();
            if (matrix[i][0] == 1) {
                for (int j = 0; j < matrix[i].length; j++) {
                    builder.append(matrix[i][j] ^ 1);
                }
            } else {
                // matrix[i][0] == 0
                for (int j = 0; j < matrix[i].length; j++) {
                    builder.append(matrix[i][j]);
                }
            }
            Integer count = countMap.getOrDefault(builder.toString(), 0);
            count++;
            countMap.put(builder.toString(), count);
            max = Math.max(max, count);
        }
        return max;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] matrix = new int[][] {{0,1},{1,1}};
        int num = solution.maxEqualRowsAfterFlips(matrix);
        System.out.println(num);
        Assert.assertEquals(1, num);


        matrix = new int[][] {{0,1},{1,0}};
        num = solution.maxEqualRowsAfterFlips(matrix);
        System.out.println(num);
        Assert.assertEquals(2, num);

        matrix = new int[][] {{0,0,0},{0,0,1},{1,1,0}};
        num = solution.maxEqualRowsAfterFlips(matrix);
        System.out.println(num);
        Assert.assertEquals(2, num);
    }
}
