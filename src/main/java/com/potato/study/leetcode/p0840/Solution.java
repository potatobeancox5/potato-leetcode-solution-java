package com.potato.study.leetcode.p0840;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	840. Magic Squares In Grid
 *  
 *         A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).



Example 1:

Input: [[4,3,8,4],
[9,5,1,9],
[2,7,6,2]]
Output: 1
Explanation:
The following subgrid is a 3 x 3 magic square:
438
951
276

while this one is not:
384
519
762

In total, there is only one magic square inside the given grid.
Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
0 <= grid[i][j] <= 15
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/magic-squares-in-grid/solution/ju-zhen-zhong-de-huan-fang-by-leetcode/
 *
 * 
 */
public class Solution {

    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (isMagic(grid[i][j], grid[i][j+1], grid[i][j+2],
                        grid[i+1][j], grid[i+1][j+1], grid[i+1][j+2],
                        grid[i+2][j], grid[i+2][j+1], grid[i+2][j+2])) {

                    count++;
                }
            }
        }
        return count;
    }

    public boolean isMagic(int... vals) {
        int[] count = new int[16];
        for (int v: vals) {
            count[v]++;
        }
        for (int v = 1; v <= 9; ++v) {
            if (count[v] != 1)
                return false;
        }
        boolean res = (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
        return res;
    }



	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] grid = new int[][]{{4,3,8,4}, {9,5,1,9}, {2,7,6,2}};

        int res = solution.numMagicSquaresInside(grid);
        System.out.println(res);
        Assert.assertEquals(1, res);
    }
}
