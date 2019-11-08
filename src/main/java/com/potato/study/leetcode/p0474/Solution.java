package com.potato.study.leetcode.p0474;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         474. Ones and Zeroes
 * 
 *        In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:

The given numbers of 0s and 1s will both not exceed 100
The size of given string array won't exceed 600.


Example 1:

Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”


Example 2:

Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

 *         思路：
 *          474. Ones and Zeroes

https://www.cnblogs.com/grandyang/p/6188893.html

https://www.cnblogs.com/grandyang/p/6188893.html

dp i j 代表 i个0 j个1 最大能包含字符串数
对于每个单词 ones zeros
dp ij 等于  max dpij  dp i-zeros j-zeros



for e word
统计 零和一的数量
for i m 到  zeros    i减减
for j n到  ones j 减减
if  i大于等于ones 且j大于等于zeros
dpij 等于 max dpij dpi-ones j-zeros +1


end fore

返回dp m n
 * 
 */
public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        // dp ij 等于  max dpij  dp i-zeros j-zeros
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            // 统计 零和一的数量
            int zeroCount = 0;
            int oneCount = 0;
            for (char ch : str.toCharArray()) {
                if ('1' == ch) {
                    oneCount++;
                } else if ('0' == ch) {
                    zeroCount++;
                }
            }
            for (int i = m; i >= zeroCount ; i--) {
                for (int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int res = solution.findMaxForm(strs, m, n);
        System.out.println(res);
        Assert.assertEquals(4, res);


        String[] strs1 = {"10", "0", "1"};
        m = 1;
        n = 1;
        res = solution.findMaxForm(strs1, m, n);
        System.out.println(res);
        Assert.assertEquals(2, res);
    }
}
