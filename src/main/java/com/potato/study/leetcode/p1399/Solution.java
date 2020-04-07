package com.potato.study.leetcode.p1399;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1399. Count Largest Group
 *  
 *
Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.

Return how many groups have the largest size.



Example 1:

Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
Example 2:

Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.
Example 3:

Input: n = 15
Output: 6
Example 4:

Input: n = 24
Output: 5


Constraints:

1 <= n <= 10^4
 *         
 *         思路：
 *         https://leetcode.com/problems/count-largest-group/discuss/566560/Java-solution-easy-to-understand
 *
 *
 *
 */
public class Solution {


    public int countLargestGroup(int n) {
        int[] count = new int[37];

        for (int i = 1; i <= n; i++) {
            count[getBitSum(i)]++;
        }
        // get max
        int max = 0;
        int res = 0;
        for (int c : count) {
            if (c > max) {
                max = c;
                res = 1;
            } else if (c == max) {
                res++;
            }
        }
        return res;
    }

    private int getBitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 13;
        int res = solution.countLargestGroup(n);
        System.out.println(res);
        Assert.assertEquals(4, res);

        n = 2;
        res = solution.countLargestGroup(n);
        System.out.println(res);
        Assert.assertEquals(2, res);

        n = 15;
        res = solution.countLargestGroup(n);
        System.out.println(res);
        Assert.assertEquals(6, res);

        n = 24;
        res = solution.countLargestGroup(n);
        System.out.println(res);
        Assert.assertEquals(5, res);
    }
}
