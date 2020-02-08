package com.potato.study.leetcode.p0780;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	780. Reaching Points
 *  
 *         A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).

Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.

Examples:
Input: sx = 1, sy = 1, tx = 3, ty = 5
Output: True
Explanation:
One series of moves that transforms the starting point to the target is:
(1, 1) -> (1, 2)
(1, 2) -> (3, 2)
(3, 2) -> (3, 5)

Input: sx = 1, sy = 1, tx = 2, ty = 2
Output: False

Input: sx = 1, sy = 1, tx = 1, ty = 1
Output: True

Note:

sx, sy, tx, ty will all be integers in the range [1, 10^9].
 *         
 *         思路：
 *
 *         https://www.cnblogs.com/ruruozhenhao/p/10872636.html
 *
 *         推论 xy 大的那个 肯定是由小的那个 获得 那么 x = x % y 递归求tx ty
 *
 *
 * 
 */
public class Solution {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // 递归比较 知道 低于 sx sy
        while (tx >= sx && ty >= sy) {
            if (tx > ty) {
                tx %= ty;
            } else { // (tx <= ty)
                ty %= tx;
            }
        }
        if (tx > ty) {
            return tx == sx && ty == sy % sx;
        }
        //  判断是不是最终到了 sx xy
        return ty == sy && tx == sx % sy;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();


        int sx = 1;
        int sy = 1;
        int tx = 3;
        int ty = 5;
        boolean res = solution.reachingPoints(sx, sy, tx, ty);
        System.out.println(res);
        Assert.assertEquals(true, res);


        sx = 1;
        sy = 1;
        tx = 2;
        ty = 2;
        res = solution.reachingPoints(sx, sy, tx, ty);
        System.out.println(res);
        Assert.assertEquals(false, res);

        sx = 1;
        sy = 1;
        tx = 1;
        ty = 1;
        res = solution.reachingPoints(sx, sy, tx, ty);
        System.out.println(res);
        Assert.assertEquals(true, res);

    }
}
