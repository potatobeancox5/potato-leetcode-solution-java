package com.potato.study.leetcode.p0829;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	829. Consecutive Numbers Sum
 *  
 *         Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

Example 1:

Input: 5
Output: 2
Explanation: 5 = 5 = 2 + 3
Example 2:

Input: 9
Output: 3
Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
Example 3:

Input: 15
Output: 4
Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
Note: 1 <= N <= 10 ^ 9.
 *         
 *         思路：
 *         https://www.cnblogs.com/grandyang/p/11595236.html
 *
 *         有了k的范围就可以开始遍历了，首先数字N本身也是符合题意的，可以看作是长度为1的等差数列，则 res 可以初始化为1，然后i从2遍历到 sqrt(2N)，对于每个i值，只要 (N - i(i-1)/2) 能整除i，就表示存在长度为i的等差数列和为N，结果 res 自增1，这样就可以求出所有符合题意的等差数列的个数，参见代码如下：
 *
 *         就是求等差 看有几组等差
 *
 * 
 */
public class Solution {

    public int consecutiveNumbersSum(int n) {
        // 数字自身就是一个解
        int count = 1;
        for (int i = 2; i < Math.sqrt(n * 2) ; i++) {
            if ( (n - i * (i-1) / 2) % i == 0) {
                count++;
            }
        }
        return count;
    }



	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 5;
        int res = solution.consecutiveNumbersSum(n);
        System.out.println(res);
        Assert.assertEquals(2, res);

        n = 9;
        res = solution.consecutiveNumbersSum(n);
        System.out.println(res);
        Assert.assertEquals(3, res);


        n = 15;
        res = solution.consecutiveNumbersSum(n);
        System.out.println(res);
        Assert.assertEquals(4, res);
    }
}
