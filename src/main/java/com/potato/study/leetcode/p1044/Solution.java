package com.potato.study.leetcode.p1044;


import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1044. Longest Duplicate Substring
 *  
 *        Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)



Example 1:

Input: "banana"
Output: "ana"
Example 2:

Input: "abcd"
Output: ""


Note:

2 <= S.length <= 10^5
S consists of lowercase English letters.
 *         
 *
 *         题目含义：
 *          最长的重复 子字符串
 *          https://leetcode-cn.com/problems/longest-duplicate-substring/solution/zui-chang-zhong-fu-zi-chuan-by-leetcode/
 *
 *          选取子串 并使用 编码 进行识别是否出现超过2次
 *
 *
 */
public class Solution {


    private int search(int ll, int a, long modulus, int n, int[] nums) {
        long h = 0;
        for (int i = 0; i < ll; ++i) {
            h = (h * a + nums[i]) % modulus;
        }
        // 存储已经 出现过的单词
        Set<Long> seen = new HashSet<>();
        seen.add(h);
        // const value to be used often : a**ll % modulus
        long aL = 1;
        for (int i = 1; i <= ll; ++i) {
            aL = (aL * a) % modulus;
        }

        for (int start = 1; start < n - ll + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + ll - 1]) % modulus;
            if (seen.contains(h)) {
                return start;
            }
            seen.add(h);
        }
        return -1;
    }

    public String longestDupSubstring(String s) {
        int n = s.length();
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = (int)s.charAt(i) - (int)'a';
        }
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 32);

        // binary search, L = repeating string length
        int left = 1;
        int right = n;
        int ll;
        while (left != right) {
            ll = left + (right - left) / 2;
            if (search(ll, a, modulus, n, nums) != -1) {
                left = ll + 1;
            } else {
                right = ll;
            }
        }

        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? s.substring(start, start + left - 1) : "";
    }


	public static void main(String[] args) {
		Solution solution = new Solution();


        String s = "banana";
        String res = solution.longestDupSubstring(s);
        System.out.println(res);
        Assert.assertEquals("ana", res);
    }
}
