package com.potato.study.leetcode.p0860;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	860. Lemonade Change
 *  
 *         We have a two dimensional matrix A where each value is 0 or 1.

At a lemonade stand, each lemonade costs $5.

Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).

Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.

Return true if and only if you can provide every customer with correct change.



Example 1:

Input: [5,5,5,10,20]
Output: true
Explanation:
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
Example 2:

Input: [5,5,10]
Output: true
Example 3:

Input: [10,10]
Output: false
Example 4:

Input: [5,5,10,10,20]
Output: false
Explanation:
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can't give change of $15 back because we only have two $10 bills.
Since not every customer received correct change, the answer is false.


Note:

0 <= bills.length <= 10000
bills[i] will be either 5, 10, or 20.
 *         
 *
 *         题目含义：
 *          https://leetcode-cn.com/problems/lemonade-change/solution/ning-meng-shui-zhao-ling-by-leetcode/

 *         思路：
 *           计数器 计算当前每种纸币有多少个
 *
 *
 *
 */
public class Solution {

    public boolean lemonadeChange(int[] bills) {
        int[] count = new int[3];

        for (int i = 0; i < bills.length; i++) {
            int price = bills[i];
            if (price == 5) {
                count[0]++;
            } else if (price == 10) {
                count[1]++;
                if (count[0] == 0) {
                    return false;
                }
                count[0]--;
            } else {
                // 20
                count[2]++;
                if (count[1] > 0 && count[0] > 0) {
                    count[1]--;
                    count[0]--;
                } else if (count[0] > 2) {
                    count[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }




	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] bills = new int[]{5,5,5,10,20};
        boolean result = solution.lemonadeChange(bills);
        System.out.println(result);
        Assert.assertEquals(true, result);
    }
}
