package com.potato.study.leetcode.p0991;


/**
 * 
 * @author liuzhao11
 * 
 * 	  991. Broken Calculator
 *  
 *         On a broken calculator that has a number showing on its display, we can perform two operations:

Double: Multiply the number on the display by 2, or;
Decrement: Subtract 1 from the number on the display.
Initially, the calculator is displaying the number X.

Return the minimum number of operations needed to display the number Y.



Example 1:

Input: X = 2, Y = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
Example 2:

Input: X = 5, Y = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
Example 3:

Input: X = 3, Y = 10
Output: 3
Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
Example 4:

Input: X = 1024, Y = 1
Output: 1023
Explanation: Use decrement operations 1023 times.


Note:

1 <= X <= 10^9
1 <= Y <= 10^9
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/broken-calculator/solution/wu-xu-ni-xiang-zheng-xiang-ji-suan-jian-ji-zheng-m/
 *
 */
public class Solution {

    public int brokenCalc(int xx, int yy) {
        if (yy <= xx) {
            return xx - yy;
        }
        int cnt1 = 0;
        while (xx < yy) {
            xx *= 2;
            cnt1 ++;
        }
        if (xx == yy) {
            return cnt1;
        }
        int r = xx - yy;
        int cnt2 = 0;
        for (int i = cnt1; i >= 0; i --) {
            int t = (int)Math.pow(2, i);
            int coeff = r / t;
            r = r % t;
            cnt2 += coeff;
            if (r == 0) {
                break;
            }
        }
        return cnt1 + cnt2;
    }

}
