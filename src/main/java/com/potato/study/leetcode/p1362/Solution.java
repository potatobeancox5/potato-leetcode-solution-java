package com.potato.study.leetcode.p1362;


/**
 * 
 * @author liuzhao11
 * 
 * 	1362. Closest Divisors
 *  
 *
Given an integer num, find the closest two integers in absolute difference whose product equals num + 1 or num + 2.

Return the two integers in any order.



Example 1:

Input: num = 8
Output: [3,3]
Explanation: For num + 1 = 9, the closest divisors are 3 & 3, for num + 2 = 10, the closest divisors are 2 & 5, hence 3 & 3 is chosen.
Example 2:

Input: num = 123
Output: [5,25]
Example 3:

Input: num = 999
Output: [40,25]


Constraints:

1 <= num <= 10^9
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/closest-divisors/solution/jun-zhi-bu-deng-shi-si-xiang-xian-zhao-gen-hao-shu/
 */
public class Solution {

    public int[] closestDivisors(int num) {
        int sum1 = num + 1;
        int sum2 = num + 2;
        int[] res1 = getDivisors(sum1);
        int[] res2 = getDivisors(sum2);
        return Math.abs(res1[0] - res1[1]) < Math.abs(res2[0] - res2[1]) ? res1:res2;
    }

    private int[] getDivisors(int sum){
        int num1 = (int) Math.sqrt(sum);
        while (true){
            if (sum % num1 == 0){
                int num2 = sum / num1;
                return new int[]{num1,num2};
            }else {
                num1--;
            }
        }
    }

}
