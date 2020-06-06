package com.potato.study.leetcode.p1388;


/**
 * 
 * @author liuzhao11
 * 
 * 	1388. Pizza With 3n Slices
 *  
 *
There is a pizza with 3n slices of varying size, you and your friends will take slices of pizza as follows:

You will pick any pizza slice.
Your friend Alice will pick next slice in anti clockwise direction of your pick.
Your friend Bob will pick next slice in clockwise direction of your pick.
Repeat until there are no more slices of pizzas.
Sizes of Pizza slices is represented by circular array slices in clockwise direction.

Return the maximum possible sum of slice sizes which you can have.



Example 1:



Input: slices = [1,2,3,4,5,6]
Output: 10
Explanation: Pick pizza slice of size 4, Alice and Bob will pick slices with size 3 and 5 respectively. Then Pick slices with size 6, finally Alice and Bob will pick slice of size 2 and 1 respectively. Total = 4 + 6.
Example 2:



Input: slices = [8,9,8,6,1,1]
Output: 16
Output: Pick pizza slice of size 8 in each turn. If you pick slice with size 9 your partners will pick slices of size 8.
Example 3:

Input: slices = [4,1,2,5,8,3,1,9,7]
Output: 21
Example 4:

Input: slices = [3,1,2]
Output: 3


Constraints:

1 <= slices.length <= 500
slices.length % 3 == 0
1 <= slices[i] <= 1000
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/pizza-with-3n-slices/solution/hua-jian-wei-qu-n3ge-bu-xiang-lin-shu-zi-de-zui-da/
 *
 *
 */
public class Solution {


    public int maxSizeSlices(int[] slices) {
        int[][] dp = new int[slices.length / 3][slices.length];
        int tmp = slices[0];
        slices[0] = 0;
        int v1 = getV(slices, dp);
        slices[0] = tmp;
        slices[slices.length - 1] = 0;
        int v2 = getV(slices, dp);
        return Math.max(v1, v2);
    }
    public int getV(int[] slices, int[][] dp) {
        int curMax = 0;
        for (int i = 0; i < slices.length; i++) {
            curMax = Math.max(curMax, slices[i]);
            dp[0][i] = slices[i];
        }
        for (int i = 1; i < dp.length; i++) {
            int pre = dp[i - 1][0];
            for (int j = 0; j < dp[0].length; j++) {
                if (j <= 1) dp[i][j] = slices[j];
                else {
                    pre = Math.max(pre, dp[i - 1][j - 2]);
                    dp[i][j] = pre + slices[j];
                }
                curMax = Math.max(dp[i][j], curMax);
            }
        }
        return curMax;
    }
}
