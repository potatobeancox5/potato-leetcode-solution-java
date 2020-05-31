package com.potato.study.leetcode.p0964;

/**
 * 
 * @author liuzhao11
 * 
 * 	964. Least Operators to Express Number
 *  
 *       Given a single positive integer x, we will write an expression of the form x (op1) x (op2) x (op3) x ... where each operator op1, op2, etc. is either addition, subtraction, multiplication, or division (+, -, *, or /).  For example, with x = 3, we might write 3 * 3 / 3 + 3 - 3 which is a value of 3.

When writing such an expression, we adhere to the following conventions:

The division operator (/) returns rational numbers.
There are no parentheses placed anywhere.
We use the usual order of operations: multiplication and division happens before addition and subtraction.
It's not allowed to use the unary negation operator (-).  For example, "x - x" is a valid expression as it only uses subtraction, but "-x + x" is not because it uses negation.
We would like to write an expression with the least number of operators such that the expression equals the given target.  Return the least number of operators used.



Example 1:

Input: x = 3, target = 19
Output: 5
Explanation: 3 * 3 + 3 * 3 + 3 / 3.  The expression contains 5 operations.
Example 2:

Input: x = 5, target = 501
Output: 8
Explanation: 5 * 5 * 5 * 5 - 5 * 5 * 5 + 5 / 5.  The expression contains 8 operations.
Example 3:

Input: x = 100, target = 100000000
Output: 3
Explanation: 100 * 100 * 100 * 100.  The expression contains 3 operations.


Note:

2 <= x <= 100
1 <= target <= 2 * 10^8
 *         
 *         题目含义：
 *          https://leetcode-cn.com/problems/least-operators-to-express-number/solution/yong-shi-ji-bai-100-by-gskfid/
 */
public class Solution {

    public int leastOpsExpressTarget(int x, int target) {
        int[] nums = new int[32];
        int len = 0;
        for (; target > 0; len++) {
            nums[len] = target%x;
            target = target/x;
        }
        //表示更高一位为转换为反向表示时需要增加的运算符数目
        int lastReverse = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = len-1; i >= 0 ; i--) {
            //个位时为加2
            int m = i==0?2:i;
            //正向表示（例如3*5*5*5表示为5*5*5+5*5*5）所需要的数目
            int forward = nums[i] * m;
            //反向表示（例如3*5*5*5表示为5*5*5*5-5*5*5-5*5*5-5*5*5）,反向表示需要考虑向高位进1
            int reverse = (x - nums[i])*m + Math.min(lastReverse - i - 1 , i + 1);
            //
            ans += Math.min(forward,reverse);
            //如果当前取得就是反向表示，那么后面再考虑高一位转换成反向表示需要增加的运算为0
            lastReverse = forward>=reverse?0:reverse-forward;
        }
        return ans;
    }


}
