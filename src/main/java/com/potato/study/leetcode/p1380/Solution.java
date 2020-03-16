package com.potato.study.leetcode.p1380;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1380. Lucky Numbers in a Matrix
 *  
 *
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.



Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]


Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5.
All elements in the matrix are distinct.
 *         
 *         思路：
 *           找到一个数字 这个数字既是 行最小 列最大 先找到每行最小 再判断是不是列最大
 *
 *
 */
public class Solution {



    public List<Integer> luckyNumbers (int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minLineIndex = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < matrix[i][minLineIndex]) {
                    minLineIndex = j;
                }
            }
            // find if is the max
            int maxRowIndex = i;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][minLineIndex] > matrix[maxRowIndex][minLineIndex]) {
                    maxRowIndex = j;
                }
            }
            if (maxRowIndex == i) {
                res.add(matrix[maxRowIndex][minLineIndex]);
            }
        }

        return res;
    }

	public static void main(String[] args) {
    }
}
