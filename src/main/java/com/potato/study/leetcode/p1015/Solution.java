package com.potato.study.leetcode.p1015;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1015. Smallest Integer Divisible by K
 *  
 *         Given a positive integer K, you need find the smallest positive integer N such that N is divisible by K, and N only contains the digit 1.

Return the length of N.  If there is no such N, return -1.



Example 1:

Input: 1
Output: 1
Explanation: The smallest answer is N = 1, which has length 1.
Example 2:

Input: 2
Output: -1
Explanation: There is no such positive integer N divisible by 2.
Example 3:

Input: 3
Output: 3
Explanation: The smallest answer is N = 111, which has length 3.


Note:

1 <= K <= 10^5
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/smallest-integer-divisible-by-k/solution/qu-yu-by-mudawei/
 *          直接x10+1必然会溢出，考虑到 (Ax10+1)%K = (A%K x10+1)%K，遂采用取余的方法来替代原数直接乘。
            K为偶数或者末位为5的时候得不出1，遂剔除。
 *
 */
public class Solution {

    public int smallestRepunitDivByK(int k) {
        // K为偶数或者末位为5的时候得不出1
        if (k % 2 == 0||k % 5 == 0) {
            return -1;
        }
        int remainder = 0;
        int length = 1;
        while (true){
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                break;
            }
            length++;
        }
        return length;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int k = 1;
        int res = solution.smallestRepunitDivByK(k);
        System.out.println(res);
        Assert.assertEquals(1, res);
    }
}
