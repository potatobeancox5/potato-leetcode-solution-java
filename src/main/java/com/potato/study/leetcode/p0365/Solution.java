package com.potato.study.leetcode.p0365;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *        365. Water and Jug Problem
 * 
 *    You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.

If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs completely with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
Example 1: (From the famous "Die Hard" example)

Input: x = 3, y = 5, z = 4
Output: True
Example 2:

Input: x = 2, y = 6, z = 5
Output: False
 *         
 *         思路：
 *         365. Water and Jug Problem
 *
 *
 *         jugs 水罐 坛子
 *         litres 升
 *         infinite 无尽的 无穷的
飞鼠定理
z = ax + by
问有没有ab 满足
https://baike.baidu.com/item/裴蜀定理/5186593?fr=aladdin&ivk_sa=1022817p

如果 z是ab的最大公约数 那么等式成立

https://blog.csdn.net/mine_song/article/details/70051091

如果z 比xy的和大 返回false
求出gcd of xy
判断 z 是不是gcd的n倍


https://blog.csdn.net/weixin_41183791/article/details/79610183
 辗转相除法
 *        
 */
public class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
        // 只有一个x 一个y 最大就是他们的和
        if (z > x + y) {
            return false;
        }
        if (y == 0) {
            return z <= x;
        }
        // 求出 xy 的最大公约数
        int gcd = this.gcd(x, y);
        // 判断z是不是xy公约数的n倍
        if (z / gcd * gcd == z) {
            return true;
        }
        return false;
    }


    /**
     * 返回两个数字的最大公约数
     * @param x
     * @param y
     * @return
     */
    private int gcd (int x, int y) {
        int mod = x % y;
        while (mod != 0) {
            x = y;
            y = mod;
            mod = x % y;
        }
        return y;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int x = 3;
		int y = 5;
		int z = 4;
		boolean res = solution.canMeasureWater(x, y, z);
		System.out.println(res);
        Assert.assertEquals(true, res);

        x = 2;
        y = 6;
        z = 5;
        res = solution.canMeasureWater(x, y, z);
        System.out.println(res);
        Assert.assertEquals(false, res);
	}
}
