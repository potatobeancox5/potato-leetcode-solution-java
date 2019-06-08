package com.potato.study.leetcode.p0507;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *        507. Perfect Number
 * 
 *         We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)

 * 
 *         题目含义：
 *
 *         思路：
 *
 *
 *          
 */
public class Solution {


    public boolean checkPerfectNumber(int num) {

        if (num  == 1 || num == 0) {
            return false;
        }

        // 找到因数
        int until = (int) Math.sqrt(num);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= until; i++) {
            if (num / i * i == num) {
                list.add(i);
            }
        }
        // 求和
        int sum = 0;
        for (int n : list) {
            sum += n;
            if (n != 1) {
                sum += (num / n);
            }
        }
        System.out.println(sum);
        return num == sum;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int num = 28;

        boolean b = solution.checkPerfectNumber(num);
        System.out.println(b);

    }
}
