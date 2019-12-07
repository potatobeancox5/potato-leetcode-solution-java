package com.potato.study.leetcode.p0564;

import org.junit.Assert;

import java.util.Arrays;


/**
 * 
 * @author liuzhao11
 * 
 *         564. Find the Closest Palindrome
 * 
 *         Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.
 * 
 * 
 *         思路：
 *
 *         564. Find the Closest Palindrome

给一个字符串代表数字，求这个字符串相邻的最近的回文数字

https://blog.csdn.net/magicbean2/article/details/78889530
 *
 *  https://leetcode.com/problems/find-the-closest-palindrome/discuss/102390/Java-solution-with-full-explaination
 *       
 *          
 */
public class Solution {


    /**
     * 找到 大于n 最小的回文数
     * 找到 小于n 最大的回文数字
     * @param n
     * @return
     */
    public String nearestPalindromic(String n) {

        long cur = Long.parseLong(n);
        // 1. 找到 大于n 最小的回文数
        long biggerPalindromic = getTheBiggerPalindromic(cur + 1);
        // 2. 找到 小于n 最大的回文数字
        long smallerPalindromic = getTheSmallerPalindromic(cur - 1);
        // 3. 找到 差距最小的数字
        long smallDistance = Math.abs(cur - smallerPalindromic);
        long bigDistance = Math.abs(biggerPalindromic - cur);
        if (smallDistance <= bigDistance) {
            return String.valueOf(smallerPalindromic);
        } else {
            return String.valueOf(biggerPalindromic);
        }
    }

    /**
     * 获取给定 limit 大一点的回文数字
     * @param limit
     * @return
     */
    private Long getTheBiggerPalindromic(Long limit) {
        // 1. 根据 limit 构建一个回文数字，前面的位置都相同
        String orignalNum = String.valueOf(limit);
        char[] oriArr = orignalNum.toCharArray();
        int length = orignalNum.length();
        char[] target = Arrays.copyOf(oriArr, length);
        for (int i = 0; i < length / 2; i++) {
            target[length - 1 - i] = target[i];
        }
        // 2. 从最高位置开始比较，如果发现生成的回文数字 比limit开始大了 直接返回
        for (int i = 0; i < length; i++) {
            if (target[i] > oriArr[i]) {
                return Long.parseLong(String.valueOf(target));
            } else if (target[i] < oriArr[i]) {
                // 否则在某个位置 if 出现 小于 limit的情况 说明 需要从中间开始往两边每个位置 + 1试一试 如果超过了 9 还需要进位 没超过 break
                for (int j = (length-1) / 2; j >= 0; j--) {
                    target[j]++;
                    if (target[j] > '9') {
                        target[j] = '0';
                        continue;
                    } else {
                        break;
                    }
                }
                // 重新生成回文数字 修改 0 位置 到 len / 2 位置数字
                for (int j = 0; j < length / 2; j++) {
                    target[length - 1 - j] = target[j];
                }
                return Long.parseLong(String.valueOf(target));
            }
        }
        // 3. 返回走到这的数字
        return Long.parseLong(String.valueOf(target));
    }

    /**
     * 获取给定 limit 小一点的回文数字
     * @param limit
     * @return
     */
    private Long getTheSmallerPalindromic(Long limit) {
        // 1. 根据 limit 构建一个回文数字，前面的位置都相同
        String orignalNum = String.valueOf(limit);
        char[] oriArr = orignalNum.toCharArray();
        int length = orignalNum.length();
        char[] target = Arrays.copyOf(oriArr, length);
        for (int i = 0; i < length / 2; i++) {
            target[length - 1 - i] = target[i];
        }
        // 2. 从最高位置开始比较，如果发现生成的回文数字 比limit开始大了 直接返回
        for (int i = 0; i < length; i++) {
            if (target[i] < oriArr[i]) {
                return Long.parseLong(String.valueOf(target));
            } else if (target[i] > oriArr[i]) {
                // 否则在某个位置 if 出现 小于 limit的情况 说明 需要从中间开始往两边每个位置 + 1试一试 如果超过了 9 还需要进位 没超过 break
                for (int j = (length-1) / 2; j >= 0; j--) {
                    target[j]--;
                    if (target[j] < '0') {
                        target[j] = '9';
                        continue;
                    } else {
                        break;
                    }
                }

                // 需要减少一个位置了
                if (target[0] == '0') {
                    char[] a = new char[length - 1];
                    Arrays.fill(a, '9');
                    return Long.parseLong(String.valueOf(a));
                }

                // 重新生成回文数字 修改 0 位置 到 len / 2 位置数字
                for (int j = 0; j < length / 2; j++) {
                    target[length - 1 - j] = target[j];
                }
                return Long.parseLong(String.valueOf(target));
            }
        }
        // 3. 返回走到这的数字
        return Long.parseLong(String.valueOf(target));

    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        String n = "123";
        String res = solution.nearestPalindromic(n);
        System.out.println(res);
        Assert.assertEquals("121", res);

        n = "1";
        res = solution.nearestPalindromic(n);
        System.out.println(res);
        Assert.assertEquals("0", res);

        n = "11";
        res = solution.nearestPalindromic(n);
        System.out.println(res);
        Assert.assertEquals("9", res);

        n = "1283";
        res = solution.nearestPalindromic(n);
        System.out.println(res);
        Assert.assertEquals("1331", res);
    }
}
