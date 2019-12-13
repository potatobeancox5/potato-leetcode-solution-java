package com.potato.study.leetcode.p0664;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         664. Strange Printer
 * 
 *         There is a strange printer with the following two special requirements:

The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.

Example 1:
Input: "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".
Example 2:
Input: "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
Hint: Length of the given string will not exceed 100.
 *
 *
 *
 *         思路：
 *
 *
 *         https://www.cnblogs.com/ruruozhenhao/p/10517462.html
 *
 *         https://www.cnblogs.com/lychnis/p/9247920.html
 *
 */
public class Solution {

    // dp i j 从i打印到j 需要的最少次数
    // 每次
    private int[][] dp;


    public int strangePrinter(String s) {
        dp = new int[s.length()][s.length()];
        int res = dfs(s.toCharArray(), 0, s.length()-1);
        return res;

    }


    /**
     * dfs 找 ij 最小次数
     * @param s
     * @param i
     * @param j
     * @return
     */
    private int dfs(char[] s, int i, int j) {
        if (i > j) {
            return 0;
        }
        // 之前已经找到了
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        // 默认最小 i - j-1  + 1种可能
        int res = dfs(s, i, j-1) + 1;

        // from i to j 找到一个位置 k与j相等 就可以一起打印
        for (int k = i; k < j; k++) {
            if (s[k] == s[j]) {
                res = Math.min(res, dfs(s, i, k) + dfs(s, k+1, j-1));
            }
        }

        dp[i][j] = res;
        return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "aaabbb";
        int turns = solution.strangePrinter(s);
        System.out.println(turns);
        Assert.assertEquals(2, turns);

        s = "aba";
        turns = solution.strangePrinter(s);
        System.out.println(turns);
        Assert.assertEquals(2, turns);
    }
}
