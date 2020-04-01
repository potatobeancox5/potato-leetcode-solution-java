package com.potato.study.leetcode.p0808;

/**
 * 
 * @author liuzhao11
 * 
 * 	808. Soup Servings
 *  
 *         There are two types of soup: type A and type B. Initially we have N ml of each type of soup. There are four kinds of operations:

Serve 100 ml of soup A and 0 ml of soup B
Serve 75 ml of soup A and 25 ml of soup B
Serve 50 ml of soup A and 50 ml of soup B
Serve 25 ml of soup A and 75 ml of soup B
When we serve some soup, we give it to someone and we no longer have it.  Each turn, we will choose from the four operations with equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as we can.  We stop once we no longer have some quantity of both types of soup.

Note that we do not have the operation where all 100 ml's of soup B are used first.

Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time.



Example:
Input: N = 50
Output: 0.625
Explanation:
If we choose the first two operations, A will become empty first. For the third operation, A and B will become empty at the same time. For the fourth operation, B will become empty first. So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.

Notes:

0 <= N <= 10^9.
Answers within 10^-6 of the true value will be accepted as correct.
 *         
 *         思路：
 *         https://blog.csdn.net/tiefanhe/article/details/80165420
 *
 * 
 */
public class Solution {

    // 递归剪枝
    double[][] cache = new double[200][200];

    public double soupServings(int n) {
        return n >= 5000 ? 1.0 : getProbability((n+24)/25, (n+24)/25);
    }

    /**
     * 返回 A为a ml， B为bml 情况下，A先空以及AB同时为空的概率之和。
     * @param a
     * @param b
     * @return
     */
    public double getProbability(int a, int b) {
        // ab 同时为 0 概率为 0.5
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        // a 为空 概率为 1
        if (a <= 0) {
            return 1;
        }
        // b 为空 概率为 0
        if (b <= 0) {
            return 0;
        }
        // 缓存
        if (cache[a][b] > 0) {
            return cache[a][b];
        }
        // 递归求概率 不到 a 没意义
        cache[a][b] = 0.25 * (getProbability(a - 4, b) + getProbability(a - 3, b - 1)
                + getProbability(a - 2, b - 2) + getProbability(a - 1, b - 3));

        return cache[a][b];
    }

	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 50;
        double result = solution.soupServings(n);
        System.out.println(result);// 0.625
    }
}
