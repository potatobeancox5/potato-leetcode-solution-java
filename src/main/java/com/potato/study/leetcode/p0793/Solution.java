package com.potato.study.leetcode.p0793;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	793. Preimage Size of Factorial Zeroes Function
 *  
 *         Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.)

For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has 2 zeroes at the end. Given K, find how many non-negative integers x have the property that f(x) = K.

Example 1:
Input: K = 0
Output: 5
Explanation: 0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.

Example 2:
Input: K = 5
Output: 0
Explanation: There is no x such that x! ends in K = 5 zeroes.
Note:

K will be an integer in the range [0, 10^9].
 *         
 *
 *         题目含义：
 *
 *         思路：
 *         https://cloud.tencent.com/developer/article/1434329
 *         二分法查找 满足k的个数
 *
 *
 * 
 */
public class Solution {

    public int preimageSizeFZF(int k) {
        return (int)(count(k) - count(k-1));
    }

    /**
     *
     * @param k
     * @return
     */
    private long count(int k) {
        if (k == -1) {
            return 0;
        }
        long left = 0;
        long right = Long.MAX_VALUE;

        while (left < right) {
            long mid = (left + right + 1) / 2;
            long cnt = 0;
            // 求5的个数 从而找到 k个5的结束点
            for (long i = mid / 5; i > 0 ; i /= 5) {
                cnt += i;
            }

            if (cnt <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }


	

	public static void main(String[] args) {
		Solution solution = new Solution();

        int k = 0;
        int res = solution.preimageSizeFZF(k);
        System.out.println(res);
        Assert.assertEquals(5, res);


        k = 5;
        res = solution.preimageSizeFZF(k);
        System.out.println(res);
        Assert.assertEquals(0, res);
    }
}
