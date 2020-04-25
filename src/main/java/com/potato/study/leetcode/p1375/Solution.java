package com.potato.study.leetcode.p1375;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1375. Bulb Switcher III
 *  
 *
There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are turned off.

At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.

Return the number of moments in which all turned on bulbs are blue.



Example 1:



Input: light = [2,1,3,5,4]
Output: 3
Explanation: All bulbs turned on, are blue at the moment 1, 2 and 4.
Example 2:

Input: light = [3,2,4,1,5]
Output: 2
Explanation: All bulbs turned on, are blue at the moment 3, and 4 (index-0).
Example 3:

Input: light = [4,1,2,3]
Output: 1
Explanation: All bulbs turned on, are blue at the moment 3 (index-0).
Bulb 4th changes to blue at the moment 3.
Example 4:

Input: light = [2,1,4,3,6,5]
Output: 3
Example 5:

Input: light = [1,2,3,4,5,6]
Output: 6


Constraints:

n == light.length
1 <= n <= 5 * 10^4
light is a permutation of  [1, 2, ..., n]
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/bulb-switcher-iii/solution/qi-shi-hen-jian-dan-bie-xiang-de-tai-fu-za-by-gith/
 *         index 求和 与 value sum 比较 相等 count++
 *
 *
 *
 *
 */
public class Solution {



    public int numTimesAllBlue(int[] light) {
        int count = 0;
        int sumValue = 0;
        int sumIndex = 0;
        for (int i = 0; i < light.length; i++) {
            sumIndex += (i+1);
            sumValue += light[i];
            if (sumIndex == sumValue) {
                count++;
            }
        }
        return count;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        int[] light = new int[]{2,1,3,5,4};
        int res = solution.numTimesAllBlue(light);
        System.out.println(res);
        Assert.assertEquals(3, res);


        light = new int[]{3,2,4,1,5};
        res = solution.numTimesAllBlue(light);
        System.out.println(res);
        Assert.assertEquals(2, res);

        light = new int[]{4,1,2,3};
        res = solution.numTimesAllBlue(light);
        System.out.println(res);
        Assert.assertEquals(1, res);

        light = new int[]{2,1,4,3,6,5};
        res = solution.numTimesAllBlue(light);
        System.out.println(res);
        Assert.assertEquals(3, res);

        light = new int[]{1,2,3,4,5,6};
        res = solution.numTimesAllBlue(light);
        System.out.println(res);
        Assert.assertEquals(6, res);
    }
}
