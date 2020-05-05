package com.potato.study.leetcode.p1359;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1359. Count All Valid Pickup and Delivery Options
 *  
 *  Given n orders, each order consist in pickup and delivery services.

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).

Since the answer may be too large, return it modulo 10^9 + 7.



Example 1:

Input: n = 1
Output: 1
Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
Example 2:

Input: n = 2
Output: 6
Explanation: All possible orders:
(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
Example 3:

Input: n = 3
Output: 90


Constraints:

1 <= n <= 500
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/count-all-valid-pickup-and-delivery-options/solution/si-lu-bi-da-an-zhong-yao-tu-jie-by-orangex/
 *
 *         F[n]=F[n-1]*C(2,2n) =F[n-1]*n*(2*n-1)
 *
 *
 *
 *
 */
public class Solution {

    private int mod = 1000000007;

    public int countOrders(int n) {
        long last = 1;
        for(int i = 1;i <= n;i++){
            //组合 C(2,2*i)
            int c = i*(2*i-1);
            last = (last*c) % mod;
        }
        return (int)last;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 1;
        int res = solution.countOrders(n);
        System.out.println(res);
        Assert.assertEquals(1, res);


        n = 2;
        res = solution.countOrders(n);
        System.out.println(res);
        Assert.assertEquals(6, res);


        n = 3;
        res = solution.countOrders(n);
        System.out.println(res);
        Assert.assertEquals(90, res);
    }
}
