package com.potato.study.leetcode.p0879;

import org.junit.Assert;

/**
 * @author liuzhao11
 *
 *
 *
 * 879. Profitable Schemes
 *
 *
 * There are G people in a gang, and a list of various crimes they could commit.

The i-th crime generates a profit[i] and requires group[i] gang members to participate.

If a gang member participates in one crime, that member can't participate in another crime.

Let's call a profitable scheme any subset of these crimes that generates at least P profit, and the total number of gang members participating in that subset of crimes is at most G.

How many schemes can be chosen?  Since the answer may be very large, return it modulo 10^9 + 7.



Example 1:

Input: G = 5, P = 3, group = [2,2], profit = [2,3]
Output: 2
Explanation:
To make a profit of at least 3, the gang could either commit crimes 0 and 1, or just crime 1.
In total, there are 2 schemes.
Example 2:

Input: G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
Output: 7
Explanation:
To make a profit of at least 5, the gang could commit any crimes, as long as they commit one.
There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).


Note:

1 <= G <= 100
0 <= P <= 100
1 <= group[i] <= 100
0 <= profit[i] <= 100
1 <= group.length = profit.length <= 100
 *
 * 思路：
 *      https://leetcode-cn.com/problems/profitable-schemes/solution/java-er-wei-dp-by-yin-di-an-ren-ppoai6hjux/
 *      思路同背包问题，使用二维数组保存之前状态，第一维是利润，第二维是人数
需要注意的问题是当：利润大于P时就使用 P 来表示 >=P的利润
 *
 */
public class Solution {

    private int mod = (int)1e9 + 7;

    /**
     *
     * @param g     成员数
     * @param p     目标利润
     * @param group     利润 i 需要的人数
     * @param profit    具体利润1
     * @return
     */
    public int profitableSchemes(int g, int p, int[] group, int[] profit) {

        // 第一维是利润，第二维是人数
        int[][] dp = new int[p+1][g+1];
        // 利润为0
        dp[0][0] = 1;
        //
        for(int i = 0; i < group.length; i++){
            int person = group[i];
            int money = profit[i];
            //
            for(int j = p ; j >= 0 ; j--){
                for(int k = g - person ; k >= 0 ; k--){
                    //利润>=P时，使用P来代替
                    int x = j + money >= p ? p : j + money;
                    dp[x][k + person] = ( dp[x][k + person] + dp[j][k])%mod;
                }
            }
        }


        long res = 0;
        // 0 - g 中 能获得p的种类数
        for (int i = 0; i <= g; i++) {
            res += dp[p][i];
            res %= mod;
        }
        return (int) (res % mod);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int g = 5;
        int p = 3;
        int[] group = new int[]{2, 2};
        int[] profit = new int[]{2, 3};
        int head = solution.profitableSchemes(g, p, group, profit);
        System.out.println(head);
        Assert.assertEquals(2, head);
    }
}
