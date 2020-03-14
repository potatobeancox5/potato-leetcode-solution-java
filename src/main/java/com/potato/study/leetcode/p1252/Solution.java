package com.potato.study.leetcode.p1252;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1252. Cells with Odd Values in a Matrix
 *  
 *
Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.

Return the number of cells with odd values in the matrix after applying the increment to all indices.



Example 1:


Input: n = 2, m = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
Example 2:


Input: n = 2, m = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.


Constraints:

1 <= n <= 50
1 <= m <= 50
1 <= indices.length <= 100
0 <= indices[i][0] < n
0 <= indices[i][1] < m
 *         
 *         思路：
 *          给定左边 分别对行列 增加1
 *
 *

 *
 */
public class Solution {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];
        for (int[] indice : indices) {
            int line = indice[0];
            int column = indice[1];
            for (int i = 0; i < m; i++) {
                arr[line][i]++;
            }
            for (int i = 0; i < n; i++) {
                arr[i][column]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 2;
        int m = 3;
        int[][] indices = new int[][]{{0,1}, {1,1}};
        int res = solution.oddCells(n, m, indices);
        System.out.println(res);
        Assert.assertEquals(6, res);


    }
}
