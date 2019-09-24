package com.potato.study.leetcode.p0335;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         335. Self Crossing
 * 
 *         You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise.

Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.



Example 1:

┌───┐
│   │
└───┼──>
│

Input: [2,1,1,2]
Output: true
Example 2:

┌──────┐
│      │
│
│
└────────────>

Input: [1,2,3,4]
Output: false
Example 3:

┌───┐
│   │
└───┼>

Input: [1,1,1,1]
Output: true
 * 
 *         思路：
 *
 *          335. Self Crossing
顺序遍历结点

每次判断 xy 坐标是否有0
判断本次 走完之后是否遇到0 或者走之前就是0

记录之前位置
走一步
走之后结果是否00 是的话返回
判断之前快找是与当前点 是否在轴上 另一个节点出现符号变化
https://blog.csdn.net/zshouyi/article/details/77351334

另一个接发
https://blog.csdn.net/sbitswc/article/details/50935196



https://blog.csdn.net/m0_37518259/article/details/100564564

思路
如果size 小于4 返回f
否则三种闭环方式
1 x0 》=x2 且 x3》》=x1
2 x1==x3 0+4 》=2
3 x(2) > x(0) &&

x(3) > x(1) &&

x(4) <= x(2) &&

x(4) >= x(2)-x(0) &&

x(5) >= x(3)-x(1)
 *
 *
 *
 * 
 */
public class Solution {

    public boolean isSelfCrossing(int[] x) {
        if (null == x || x.length < 4) {
            return false;
        }
        // 大于四的时候有三种情况
        for(int i = 3; i < x.length ; i++) {
            if (x[i-3] >= x[i-1] && x[i] >= x[i -2]) {
                return true;
            }
            if (i > 3 && x[i-3] == x[i-1] && x[i-4]+ x[i] >= x[i-2]) {
                // 只有5个线段以上
                return true;
            }
            if (i > 4 && x[i] >= x[i-2] - x[i-4] && x[i-1] >= x[i-3] - x[i-5]
                    && x[i-1] <= x[i-3] && x[i-2] > x[i-4]) {
                // 6个 线段以上
                return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
        Solution solution = new Solution();
        int[] x = {2,1,1,2};// false
        boolean res = solution.isSelfCrossing(x);
        Assert.assertEquals(true, res);
        System.out.println(res);



        int[] x1 = {1,2,3,4};// false
        res = solution.isSelfCrossing(x1);
        Assert.assertEquals(false, res);
        System.out.println(res);

        int[] x2 = {1,1,1,1};// false
        res = solution.isSelfCrossing(x2);
        Assert.assertEquals(true, res);
        System.out.println(res);
	}
}
