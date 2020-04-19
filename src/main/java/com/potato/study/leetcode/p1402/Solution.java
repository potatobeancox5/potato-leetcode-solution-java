package com.potato.study.leetcode.p1402;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1402. Reducing Dishes
 *  
 *
A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.

Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level  i.e.  time[i]*satisfaction[i]

Return the maximum sum of Like-time coefficient that the chef can obtain after dishes preparation.

Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.



Example 1:

Input: satisfaction = [-1,-8,0,5,-9]
Output: 14
Explanation: After Removing the second and last dish, the maximum total Like-time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14). Each dish is prepared in one unit of time.
Example 2:

Input: satisfaction = [4,3,2]
Output: 20
Explanation: Dishes can be prepared in any order, (2*1 + 3*2 + 4*3 = 20)
Example 3:

Input: satisfaction = [-1,-4,-5]
Output: 0
Explanation: People don't like the dishes. No dish is prepared.
Example 4:

Input: satisfaction = [-2,5,-1,0,3,-3]
Output: 35


Constraints:

n == satisfaction.length
1 <= n <= 500
-10^3 <= satisfaction[i] <= 10^3
 *         
 *         思路：
 *
 *          https://leetcode.com/problems/reducing-dishes/discuss/582594/My-java-sol
 *
 *
 *
 */
public class Solution {

    private int max;

    public int maxSatisfaction(int[] satisfaction) {
        max = Integer.MIN_VALUE;
        // satisfaction 按照 小 -》 大排序
        Arrays.sort(satisfaction);
        // 遍历 satisfaction findMax i satisfaction
        for (int i = 0; i < satisfaction.length; i++) {
            findMax(i, satisfaction);
        }
        return max > 0 ? max : 0;
    }

    private void findMax(int i, int[] satisfaction) {
        // 当前开始做 一直到最后 能获得的sum 值是多少
        int sum = 0;
        int count = 1;
        for (int j = i; j < satisfaction.length; j++) {
            sum += count * satisfaction[j];
            count++;
        }
        max = Math.max(max, sum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] satisfaction = new int[]{-1,-8,0,5,-9};
        int res = solution.maxSatisfaction(satisfaction);
        System.out.println(res);
        Assert.assertEquals(14, res);

        satisfaction = new int[]{4,3,2};
        res = solution.maxSatisfaction(satisfaction);
        System.out.println(res);
        Assert.assertEquals(20, res);

        satisfaction = new int[]{-1,-4,-5};
        res = solution.maxSatisfaction(satisfaction);
        System.out.println(res);
        Assert.assertEquals(0, res);

        satisfaction = new int[]{-2,5,-1,0,3,-3};
        res = solution.maxSatisfaction(satisfaction);
        System.out.println(res);
        Assert.assertEquals(35, res);
    }
}
