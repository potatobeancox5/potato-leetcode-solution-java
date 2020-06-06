package com.potato.study.leetcode.p1269;


/**
 * 
 * @author liuzhao11
 * 
 * 	1269. Number of Ways to Stay in the Same Place After Some Steps
 *  
 *
You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 1 position to the right in the array or stay in the same place  (The pointer should not be placed outside the array at any time).

Given two integers steps and arrLen, return the number of ways such that your pointer still at index 0 after exactly steps steps.

Since the answer may be too large, return it modulo 10^9 + 7.



Example 1:

Input: steps = 3, arrLen = 2
Output: 4
Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
Right, Left, Stay
Stay, Right, Left
Right, Stay, Left
Stay, Stay, Stay
Example 2:

Input: steps = 2, arrLen = 4
Output: 2
Explanation: There are 2 differents ways to stay at index 0 after 2 steps
Right, Left
Stay, Stay
Example 3:

Input: steps = 4, arrLen = 2
Output: 8


Constraints:

1 <= steps <= 500
1 <= arrLen <= 10^6
 *         
 *         思路：
 *https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/solution/javaban-ben-dpjie-fa-by-huo-yan-yan-yi-3/
 *
 *
 */
/**
 s: steps
 l：经过s步，停留的坐标
 p[s][l]: 经过s步，停留在坐标l的总方案数
 arrLen: 数组长度

 动态规划解法三要素：
 1、最优子结构
 指针可以向左、向右、停在原地，所有最后一步可以前面的基础上往这三个方向前进，即子结构为：
 p[s-1][l], p[s-1][l-1] , p[s-1][l+1]   PS: 原地、向右、向左
 2、状态转移方程
 p[s][l] = p[s-1][l] + p[s-1][l-1] + p[s-1][l+1]
 3、边界条件
 p[0][0] = 1;
 p[s][l] = 0 if s < l

 问题求解：
 p[s][0]
 arrLen


 注意点：
 1、 中间结果数组，注意边界条件p[s][l] = 0 if s < l  ，所以只需要定义int[steps+1][steps+1] 而不需要是int[steps+1][arrLen]，不然会超出内存限制；
 2、 结果是返回模 10^9 + 7 后的结果，p[s][l] = p[s-1][l] + p[s-1][l-1] + p[s-1][l+1]  状态方程是两两相加就要求mod，而不是三个求和之后再求mod，之前结果总有用例不过
 就是因为三个求和之后再求的mod。
 */
public class Solution {

    private static int MOD = 1_000_000_007;

    public int numWays(int steps, int arrLen) {

        int p[][] = new int[steps+1][steps+1];

        p[0][0] = 1;
        for (int s=1; s<=steps; s++) {
            for (int l=0; l < Math.min(steps+1, arrLen); l++) {
                if (s == l) {
                    p[s][l] = 1;
                    break;
                }
                if (s < l) {
                    break;
                }
                p[s][l] = p[s-1][l];
                if (l-1 > -1) {
                    p[s][l] += p[s-1][l-1];
                    p[s][l] %= MOD;
                }
                if (l+1 < arrLen) {
                    p[s][l] += p[s-1][l+1];
                    p[s][l] %= MOD;
                }
            }
        }
        return p[steps][0];
    }
}
