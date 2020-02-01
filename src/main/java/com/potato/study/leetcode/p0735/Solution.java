package com.potato.study.leetcode.p0735;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	735. Asteroid Collision
 *  
 *         We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size,
and the sign represents its direction
(positive meaning right, negative meaning left).
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions.
If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode.
Two asteroids moving in the same direction will never meet.

Example 1:
Input:
asteroids = [5, 10, -5]
Output: [5, 10]
Explanation:
The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
Example 2:
Input:
asteroids = [8, -8]
Output: []
Explanation:
The 8 and -8 collide exploding each other.
Example 3:
Input:
asteroids = [10, 2, -5]
Output: [10]
Explanation:
The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
Example 4:
Input:
asteroids = [-2, -1, 1, 2]
Output: [-2, -1, 1, 2]
Explanation:
The -2 and -1 are moving left, while the 1 and 2 are moving right.
Asteroids moving the same direction never meet, so no asteroids will meet each other.
Note:

The length of asteroids will be at most 10000.
Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 *
 *
 *         思路：
 *          遍历 数组 使用 stack 记录 大于0 的数字 也就是向右行动的数字
 *
 *          一旦遇到 负数，那么 while stack 栈顶 与负数绝对值比较 判定 ，最终 弹出stack 返回array
 *
 *          https://www.jianshu.com/p/8b4dda794377
 *
 *
 *
 *
 *
 * 
 */
public class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        // 0 边界条件
        if (null == asteroids) {
            return new int[0];
        }
        // 1 遍历 数组 使用 stack 记录 大于0 的数字 也就是向右行动的数字
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            // 循环获取 可能呗干点的 asteroid
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                // 2 一旦遇到 负数，那么 while stack 栈顶 与负数绝对值比较 判定 ，
                // 最终 弹出stack 返回array 使用负的最小值 标志 是否已经全部爆炸
                int otherAsteroid = stack.pop();
                // 全爆炸
                if (otherAsteroid == -1 * asteroid) {
                    asteroid = Integer.MIN_VALUE;
                    break;
                } else if (otherAsteroid > -1 * asteroid) {
                    asteroid = otherAsteroid;
                }
            }

            // 留下么有爆炸的 星球
            if (Integer.MIN_VALUE != asteroid) {
                stack.push(asteroid);
            }
        }
        // 2 构造结果
        int[] res = new int[stack.size()];
        int index = res.length -1;
        while (!stack.isEmpty()) {
            res[index--] = stack.pop();
        }
        return res;
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] asteroids = {5, 10, -5};
        int[] arr = solution.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(arr));

        int[] asteroids1 = {8, -8};
        arr = solution.asteroidCollision(asteroids1);
        System.out.println(Arrays.toString(arr));
    }
}
