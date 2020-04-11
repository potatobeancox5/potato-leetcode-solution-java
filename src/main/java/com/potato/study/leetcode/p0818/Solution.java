package com.potato.study.leetcode.p0818;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	818. Race Car
 *  
 *        Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)

Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).

When you get an instruction "A", your car does the following: position += speed, speed *= 2.

When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 , otherwise speed = 1.  (Your position stays the same.)

For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.

Now for some target position, say the length of the shortest sequence of instructions to get there.

Example 1:
Input:
target = 3
Output: 2
Explanation:
The shortest instruction sequence is "AA".
Your position goes from 0->1->3.
Example 2:
Input:
target = 6
Output: 5
Explanation:
The shortest instruction sequence is "AAARA".
Your position goes from 0->1->3->7->7->6.


Note:

1 <= target <= 10000.
 *         
 *         思路：
 *         https://blog.csdn.net/magicbean2/article/details/80333734
 *
 *
 *
 * 
 */
public class Solution {


    public int racecar(int target) {
        int[] f = new int[1 + target];
        Arrays.fill(f, -1);
        f[0] = 0;

        return find(f, target);
    }

    private int find(int[] f, int i) {
        // has found
        if (f[i] >= 0) {
            return f[i];
        }
        f[i] = Integer.MAX_VALUE;

        int m = 1;
        for (; dist(m) < i ; m++) {
            for (int j = 0; j < m; j++) {
                f[i] = Math.min(f[i], m + 1 + j + 1 + find(f, i - (dist(m) - dist(j))));
            }
        }

        f[i] = Math.min(f[i], dist(m) == i ? m : m + 1 + find(f, dist(m) - i));

        return f[i];
    }

    private int dist(int m) {
        return (1 << m) - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int target = 3;
        int racecar = solution.racecar(target);
        System.out.println(racecar);
        Assert.assertEquals(2, racecar);

        target = 6;
        racecar = solution.racecar(target);
        System.out.println(racecar);
        Assert.assertEquals(5, racecar);
    }
}
