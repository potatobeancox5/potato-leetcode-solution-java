package com.potato.study.leetcode.p0766;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	766. Toeplitz Matrix
 *  
 *         A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.


Example 1:

Input:
matrix = [
[1,2,3,4],
[5,1,2,3],
[9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:

Input:
matrix = [
[1,2],
[2,2]
]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.

Note:

matrix will be a 2D array of integers.
matrix will have a number of rows and columns in range [1, 20].
matrix[i][j] will be integers in range [0, 99].

Follow up:

What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
What if the matrix is so large that you can only load up a partial row into the memory at once?


 *   题目大意：
 *      对角线遍历矩阵 保证对角线元素相同
 *
 *   解题思路：
 *   https://blog.csdn.net/leafage_m/article/details/79157007
 *   记录一个map key 下一行期望的位置index value 这个位置应该多少值
 * 
 */
public class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {

        Map<Integer, Integer> nextExpectMap = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            Map<Integer, Integer> indexAndValue = new HashMap<>(nextExpectMap);
            nextExpectMap.clear();
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    nextExpectMap.put(j + 1, matrix[i][j]);
                } else {
                    if (indexAndValue.containsKey(j) && matrix[i][j] != indexAndValue.get(j)) {
                        return false;
                    }
                    nextExpectMap.put(j + 1, matrix[i][j]);
                }
            }
        }
        return true;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] matrix = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,21}};
        boolean toeplitzMatrix = solution.isToeplitzMatrix(matrix);
        System.out.println(toeplitzMatrix);
    }
}
