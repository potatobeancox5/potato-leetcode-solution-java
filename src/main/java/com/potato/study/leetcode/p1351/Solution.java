package com.potato.study.leetcode.p1351;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1351. Count Negative Numbers in a Sorted Matrix
 *  
 *  Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.

Return the number of negative numbers in grid.



Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 *         
 *         思路：
 *          直接遍历数
 *
 *
 *
 */
public class Solution {

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int steps = solution.countNegatives(grid);
        System.out.println(steps);
        Assert.assertEquals(8, steps);

        grid = new int[][]{{3,2},{1,0}};
        steps = solution.countNegatives(grid);
        System.out.println(steps);
        Assert.assertEquals(0, steps);

        grid = new int[][]{{1,-1},{-1,-1}};
        steps = solution.countNegatives(grid);
        System.out.println(steps);
        Assert.assertEquals(3, steps);

        grid = new int[][]{{-1}};
        steps = solution.countNegatives(grid);
        System.out.println(steps);
        Assert.assertEquals(1, steps);
    }
}
