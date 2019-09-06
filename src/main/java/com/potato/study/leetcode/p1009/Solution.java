package com.potato.study.leetcode.p1009;


import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	1009. Complement of Base 10 Integer
 *  
 *         Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.

The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.

For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.



Example 1:

Input: 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
Example 2:

Input: 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
Example 3:

Input: 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 *         
 *         思路：
 *         https://baike.baidu.com/item/%E5%8D%81%E8%BF%9B%E5%88%B6%E8%BD%AC%E4%BA%8C%E8%BF%9B%E5%88%B6/393189?fr=aladdin
 *
 *

 *
 */
public class Solution {

    /**
     * stack存数字 然后进行转换
     * @param n
     * @return
     */
    public int bitwiseComplement(int n) {
        if (0 == n) {
            return 1;
        }
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.add(((n & 1) == 1) ? 0 : 1);
            n /= 2;
        }
        int target = 0;
        while (!stack.isEmpty()) {
            target = target * 2 + stack.pop();
        }
        return target;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 10;
        int res = solution.bitwiseComplement(n);
        System.out.println(res);
    }
}
