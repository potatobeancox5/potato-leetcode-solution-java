package com.potato.study.leetcode.p0390;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *       390. Elimination Game
 * 
 *     There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.

Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.

We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

Find the last number that remains starting with a list of length n.

Example:

Input:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

Output:
6
 *         
 *         思路：
 *         odd 次遍历 删掉奇数数字 相当于  1 2 3 4 5 6 7 8 9 操作剩下的进行偶数次遍历
 *
 *         
 */
public class Solution {

    public int lastRemaining(int n) {
        return this.getTheFinalNum(n, true);
    }

    /**
     *
     * @param m 目前操作的数字
     * @param isOdd 是否是技术次遍历
     * @return
     */
    private int getTheFinalNum (int m, boolean isOdd) {
        if (m == 1) {
            return 1;
        }
        // 大于2 的进行递归遍历
        if (isOdd) {
            return  2 * getTheFinalNum(m / 2, false);
        } else {
            // 偶数次遍历时 还要对m 的奇偶性 进行判别
            if (m % 2 == 0) {
//                m 是偶数 1,2,3,4 -> 1,3  = 2 * (1,2) - 1
                return 2 * getTheFinalNum(m / 2, true) - 1;
            } else {
                // m 是奇数 1,2,3,4,5 -> 2,4  2*(1,2)
                return 2 * getTheFinalNum(m / 2, true);
            }
        }
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 9;
		int res = solution.lastRemaining(n);
		System.out.println(res);
        Assert.assertEquals(6, res);

        n = 1;
        res = solution.lastRemaining(n);
        System.out.println(res);
        Assert.assertEquals(1, res);
    }
}

