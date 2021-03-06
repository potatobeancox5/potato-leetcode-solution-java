package com.potato.study.leetcode.p0858;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	858. Mirror Reflection
 *  
 *         There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.

The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.

Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)



Example 1:

Input: p = 2, q = 1
Output: 2
Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.



Note:

1 <= p <= 1000
0 <= q <= p
 *         
 *
 *         题目含义：
 *         从左下角 射出一束光 问最后 会被哪个接收器接收
 *
 *         思路：
 *
 *         https://leetcode-cn.com/problems/mirror-reflection/solution/jing-mian-fan-she-by-leetcode/
 *
 *
 *
 */
public class Solution {


    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        p /= g;
        p %= 2;
        q /= g;
        q %= 2;
        if (p == 1 && q == 1) {
            return 1;
        }
        return p == 1 ? 0 : 2;
    }

    /**
     * 最大公约数 辗转相除发
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        int p = 2;
        int q = 1;
        int result = solution.mirrorReflection(p, q);
        System.out.println(result);
        Assert.assertEquals(2, result);

    }
}
