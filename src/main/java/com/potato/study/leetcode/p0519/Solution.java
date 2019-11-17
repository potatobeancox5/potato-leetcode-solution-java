package com.potato.study.leetcode.p0519;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         519. Random Flip Matrix
 * 
 *         You are given the number of rows n_rows and number of columns n_cols of a 2D binary matrix where all values are initially 0. Write a function flip which chooses a 0 value uniformly at random, changes it to 1, and then returns the position [row.id, col.id] of that value. Also, write a function reset which sets all values back to 0. Try to minimize the number of calls to system's Math.random() and optimize the time and space complexity.

Note:

1 <= n_rows, n_cols <= 10000
0 <= row.id < n_rows and 0 <= col.id < n_cols
flip will not be called when the matrix has no 0 values left.
the total number of calls to flip and reset will not exceed 1000.
Example 1:

Input:
["Solution","flip","flip","flip","flip"]
[[2,3],[],[],[],[]]
Output: [null,[0,1],[1,2],[1,0],[1,1]]
Example 2:

Input:
["Solution","flip","flip","reset","flip"]
[[1,2],[],[],[],[]]
Output: [null,[0,0],[0,1],null,[0,0]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has two arguments,
n_rows and n_cols. flip and reset have no arguments.
Arguments are always wrapped with a list, even if there aren't any.

 * 
 * 
 *         思路：
 *
 *         519. Random Flip Matrix

数据结构 翻数字
数字变成1

zreset 重置矩阵值

https://blog.csdn.net/fuxuemingzhu/article/details/83188258

https://leetcode.com/problems/random-flip-matrix/discuss/383920/Java-%3A-97-speed-and-66.67-memory-%3A-using-Szudzik's-Pairing-Function-and-HashSet
 *
 *          
 */
public class Solution {


    private Set<Integer> visitedSet;

    private Random random;

    private int rows;

    private int cols;

    public Solution(int rows, int cols) {
        visitedSet  = new HashSet<>();
        random = new Random();
        this.rows = rows;
        this.cols = cols;
    }

    public int[] flip() {
        while (true) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            if (visitedSet.add(hashCode(row, col))) {
                return new int[] {row, col};
            }
        }
    }

    public void reset() {
        visitedSet.clear();
    }

    /**
     * Szudzik's Pairing Function
     * @param row
     * @param col
     * @return
     */
    private int hashCode (int row, int col) {
        if (row < col) {
            return row + col * col;
        } else {
            return row * row + +row + col;
        }
    }
}
