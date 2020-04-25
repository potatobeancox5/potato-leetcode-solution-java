package com.potato.study.leetcode.p1074;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1074. Number of Submatrices That Sum to Target
 *  
 *      Given a matrix, and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.



Example 1:

Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.
Example 2:

Input: matrix = [[1,-1],[-1,1]], target = 0
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.


Note:

1 <= matrix.length <= 300
1 <= matrix[0].length <= 300
-1000 <= matrix[i] <= 1000
-10^8 <= target <= 10^8
 *         
 *
 *
 *
 *         思路：
 *         https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/solution/java-prefixsum-by-don-vito-corleone/
 *
 *
 *
 */
public class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // 求sum 行
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j-1];
            }
        }
        int res = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int cur = 0;
                for (int k = 0; k < matrix.length; k ++) {
                    cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    res += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] matrix = new int[][] {{0,1,0},{1,1,1},{0,1,0}};
        int target = 0;
        int num = solution.numSubmatrixSumTarget(matrix, target);
        System.out.println(num);
        Assert.assertEquals(4, num);
    }
}
