package com.potato.study.leetcode.p0887;

import org.junit.Assert;

/**
 * @author liuzhao11
 *
 *
 * 887. Super Egg Drop
 *
 *
 * You are given K eggs, and you have access to a building with N floors from 1 to N.

Each egg is identical in function, and if an egg breaks, you cannot drop it again.

You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.

Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N).

Your goal is to know with certainty what the value of F is.

What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?



Example 1:

Input: K = 1, N = 2
Output: 2
Explanation:
Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
If it didn't break, then we know with certainty F = 2.
Hence, we needed 2 moves in the worst case to know what F is with certainty.
Example 2:

Input: K = 2, N = 6
Output: 3
Example 3:

Input: K = 3, N = 14
Output: 4


Note:

1 <= K <= 100
1 <= N <= 10000

 *
 *
 * 题目含义：
 *
 * 思路：
 * https://leetcode-cn.com/problems/super-egg-drop/solution/ji-dan-diao-luo-by-leetcode-solution-2/
 *
 * 数学法
 *
 */
public class Solution {

    public int superEggDrop(int k, int n) {
        // 一层楼 0 ,1
        if (n == 1) {
            return 1;
        }
        int[][] f = new int[n + 1][k + 1];
        // 初始化
        for (int i = 1; i <= k; i++) {
            f[1][i] = 1;
        }
        int res = -1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k ; j++) {
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][k] >= n) {
                res = i;
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

        int k = 1;
        int n = 2;
        int res = solution.superEggDrop(k, n);
        System.out.println(res);
        Assert.assertEquals(2, res);
    }
}
