package com.potato.study.leetcode.p0204;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         204. Count Primes
 * 
 *        Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 *
 *         题目需求：
 *          查一下 1 - n 之间素数的个数
 *
 *         思路：
 *
 * 
 */
public class Solution {

    private List<Integer> primesList = new ArrayList<>();

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) { // 当前数字是不是素数
            if (isPrimes(i)) {
                count++;
                this.primesList.add(i);
                // 记录下来素数的值
            }
        }
        return count;
    }

    /**
     * 判定n 是不是素数
     * 判定方法 2- 根号 n 之间的数 是不是能被能n 整除
     * @param n
     * @return
     */
    private boolean isPrimes(int n) {
        // 利用之前的素数集合进行判断
        for (int prime : primesList) {
            if (prime * prime > n) {
                break;
            }
            if(n / prime * prime == n) {
                return false;
            }
        }
        return true;
    }



    
    public static void main(String[] args) {
		Solution solution = new Solution();
        int count = solution.countPrimes(499979);
        System.out.println(count);
    }
}
