package com.potato.study.leetcode.p1221;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1221. Split a String in Balanced Strings
 *  
 *
Balanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.



Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
Example 4:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'


Constraints:

1 <= s.length <= 1000
s[i] = 'L' or 'R'
 *         
 *         思路：
 *
 *
 *

 *
 */
public class Solution {

    public int balancedStringSplit(String s) {
        // L 计数器
        int balance = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                count++;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "RLRRLLRLRL";
        int res = solution.balancedStringSplit(s);
        System.out.println(res);
        Assert.assertEquals(4, res);

        s = "RLLLLRRRLR";
        res = solution.balancedStringSplit(s);
        System.out.println(res);
        Assert.assertEquals(3, res);

        s = "LLLLRRRR";
        res = solution.balancedStringSplit(s);
        System.out.println(res);
        Assert.assertEquals(1, res);

        s = "RLRRRLLRLL";
        res = solution.balancedStringSplit(s);
        System.out.println(res);
        Assert.assertEquals(2, res);
    }
}
