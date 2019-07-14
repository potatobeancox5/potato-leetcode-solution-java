package com.potato.study.leetcode.p0598;


/**
 * 
 * @author liuzhao11
 * 
 *         598. Range Addition II
 * 
 *        Given an m * n matrix M initialized with all 0's and several update operations.

Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

You need to count and return the number of maximum integers in the matrix after performing all the operations.

Example 1:
Input:
m = 3, n = 3
operations = [[2,2],[3,3]]
Output: 4
Explanation:
Initially, M =
[[0, 0, 0],
[0, 0, 0],
[0, 0, 0]]

After performing [2,2], M =
[[1, 1, 0],
[1, 1, 0],
[0, 0, 0]]

After performing [3,3], M =
[[2, 2, 1],
[2, 2, 1],
[1, 1, 1]]

So the maximum integer in M is 2, and there are four of it in M. So return 4.
Note:
The range of m and n is [1,40000].
The range of a is [1,m], and the range of b is [1,n].
The range of operations size won't exceed 10,000.
 * 
 * 
 *         思路：
 *          直接求m n 最小值 计算乘积
 *
 *       
 *          
 */
public class Solution {

    public int maxCount(int m, int n, int[][] ops) {
        // 设置值
        int minM = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;

        if (ops == null || ops.length == 0) {
            return m * n;
        }

        for (int i = 0; i < ops.length ; i++) {
            if (ops[i][0] < minM) {
                minM = ops[i][0];
            }
            if (ops[i][1] < minN) {
                minN = ops[i][1];
            }
        }
        return minM * minN;
    }

    public static void main(String[] args) {
		Solution solution = new Solution();
        int m = 3;
        int n = 3;
        int[][] ops = {{2,2}, {3,3}};
        int sum = solution.maxCount(m, n, ops);
        System.out.println(sum);
    }
}
