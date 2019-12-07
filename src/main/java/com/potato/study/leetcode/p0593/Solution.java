package com.potato.study.leetcode.p0593;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         593. Valid Square
 * 
 *         Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True


Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.
 * 
 *
 *         思路：
 *
 *
https://www.jianshu.com/p/45e23e385c54

正方形 满足 4个边相等 2个对角线相等

依次计算任意两点的距离

遍历距离 统计个数 插入map 并找到max 和common

若map key 不等于2 false

若map key 大的max那个 val 不等于2 false

若nap key 小的那个common 不等于4 false

max平方== common平方2倍
 *
 *
 *
 *       
 *          
 */
public class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        long maxDis = Integer.MIN_VALUE;
        long minDis = Integer.MAX_VALUE;

        int[][] point = new int[][]{p1, p2, p3, p4};

        Map<Long, Integer> countMap = new HashMap<>();

        for (int i = 0; i < point.length; i++) {
            for (int j = i+1; j < point.length; j++) {
                long dis = this.distance(point[i], point[j]);
                Integer count = countMap.get(dis);
                if (count == null) {
                    countMap.put(dis, 1);
                } else {
                    countMap.put(dis, count + 1);
                }
                // 最大值和最小值 的判定
                if (maxDis < dis) {
                    maxDis = dis;
                }
                if (minDis > dis) {
                    minDis = dis;
                }
            }
        }
        // 最后判定
        if (countMap.keySet().size() != 2) {
            return false;
        }
        if (countMap.get(maxDis) != 2) {
            return false;
        }
        if (countMap.get(minDis) != 4) {
            return false;
        }
        return true;
    }

    private long distance(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] p1 = {0,0};
        int[] p2 = {1,1};
        int[] p3 = {1,0};
        int[] p4 = {0,1};
        boolean res = solution.validSquare(p1, p2, p3, p4);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
