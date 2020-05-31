package com.potato.study.leetcode.p1052;


/**
 * 
 * @author liuzhao11
 * 
 * 	1052. Grumpy Bookstore Owner
 *  
 *        Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.



Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.


Note:

1 <= X <= customers.length == grumpy.length <= 20000
0 <= customers[i] <= 1000
0 <= grumpy[i] <= 1
 *         
 *
 *         题目含义：
 *          https://leetcode-cn.com/problems/grumpy-bookstore-owner/solution/qian-zhui-he-hua-dong-chuang-kou-by-liuchuan1992/
 *
 *
 */
public class Solution {


    //思路 先求出原本就满意的客户数  再利用滑动窗口求出X区间内 所有不满意的用户 两者相加就是最大满意数
    public int maxSatisfied(int[] customers, int[] grumpy, int xx) {

        int originCount = 0;
        int maxAngryCount = 0;
        //前缀和
        int[] sum = new int[grumpy.length + 1];

        for(int i = 0;i< grumpy.length;i++ ){
            if(grumpy[i] == 0){
                originCount += customers[i];
                sum[i+1] = sum[i];
            }else{
                sum[i+1] = sum[i] + customers[i];;
            }
        }
        //[i,i+X)
        for(int i = 0;i< grumpy.length - xx + 1;i++ ){
            maxAngryCount = Math.max(maxAngryCount,sum[i+xx] - sum[i]);
        }
        return originCount + maxAngryCount;
    }
}
