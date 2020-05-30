package com.potato.study.leetcode.p0926;

/**
 * 
 * @author liuzhao11
 * 
 * 	926. Flip String to Monotone Increasing
 *  
 *       A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.)

We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.

Return the minimum number of flips to make S monotone increasing.



Example 1:

Input: "00110"
Output: 1
Explanation: We flip the last digit to get 00111.
Example 2:

Input: "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.
Example 3:

Input: "00011000"
Output: 2
Explanation: We flip to get 00000000.


Note:

1 <= S.length <= 20000
S only consists of '0' and '1' characters.
 *         
 *         题目含义：
 *
 *
 *         思路：
 *          https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/solution/jiang-zi-fu-chuan-fan-zhuan-dao-dan-diao-di-zeng-b/
 *
 * 
 */
public class Solution {


    public int minFlipsMonoIncr(String str) {
        int len = str.length();
        int[] arr = new int[len + 1];
        for (int i = 0; i < len; ++i)
            arr[i+1] = arr[i] + (str.charAt(i) == '1' ? 1 : 0);

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= len; ++j) {
            ans = Math.min(ans, arr[j] + len-j-(arr[len]-arr[j]));
        }

        return ans;
    }
}
