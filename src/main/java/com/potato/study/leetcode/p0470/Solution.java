package com.potato.study.leetcode.p0470;

/**
 * 
 * @author liuzhao11
 * 
 *         470. Implement Rand10() Using Rand7()
 * 
 *        Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.

Do NOT use system's Math.random().



Example 1:

Input: 1
Output: [7]
Example 2:

Input: 2
Output: [8,4]
Example 3:

Input: 3
Output: [8,1,10]


Note:

rand7 is predefined.
Each testcase has one argument: n, the number of times that rand10 is called.


Follow up:

What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?*

 *         思路：凑 40 然后对 10 取%
 *         470. Implement Rand10() Using Rand7()
https://www.jianshu.com/p/08910074f9bc
 *         
 * 
 */
public class Solution extends SolBase {
    public int rand10() {
        int val = 7 * (rand7() - 1) + rand7(); // 7 (0 - 6) + (1-7)
        while (val > 40) {
            val = 7 * (rand7() - 1) + rand7();
        }
        return val % 10 + 1;
    }
}

class SolBase{
    public int rand7() {
        return -1;
    }
}
