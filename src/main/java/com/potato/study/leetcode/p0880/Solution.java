package com.potato.study.leetcode.p0880;

import org.junit.Assert;

/**
 * @author liuzhao11
 *
 * 880. Decoded String at Index
 *
 *
 * An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:

If the character read is a letter, that letter is written onto the tape.
If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.



Example 1:

Input: S = "leet2code3", K = 10
Output: "o"
Explanation:
The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".
Example 2:

Input: S = "ha22", K = 5
Output: "h"
Explanation:
The decoded string is "hahahaha".  The 5th letter is "h".
Example 3:

Input: S = "a2345678999999999999999", K = 1
Output: "a"
Explanation:
The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".


Note:

2 <= S.length <= 100
S will only contain lowercase letters and digits 2 through 9.
S starts with a letter.
1 <= K <= 10^9
The decoded string is guaranteed to have less than 2^63 letters.
 *
 *
 * 题目含义：
 *  如果是数字则将当前 重复n-1次, 求 第k个字母是啥
 *
 * 思路：
 *  计算当前字符串长度
 *  然后从 暂停为止往前遍历字符串 如果是数字  计算 扩大倍数之前字符串长度，求 K 位置是字符串的那个位置
 *
 *  https://leetcode.com/problems/decoded-string-at-index/discuss/530523/Java-0ms-(faster-than-100)
 *
 */
public class Solution {

    public String decodeAtIndex(String s, int k) {
        // 计算当前字符串长度 until >= k
        long virtualWordLength = 0;
        int index = 0;

        while (virtualWordLength < k) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                int num = ch - '0';

                if (k <= virtualWordLength * num) {
                    int x = 1;
                    while (k > virtualWordLength * (x + 1)) {
                        x++;
                    }
                    return decodeAtIndex(s.substring(0, index + 1),
                            k - (int)virtualWordLength * x);
                }
                virtualWordLength *= num;

            } else {
                virtualWordLength++;
                if (virtualWordLength == k) {
                    return Character.toString(ch);
                }
            }


            index++;
        }
        return "";
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "leet2code3";
        int k = 10;
        String result = solution.decodeAtIndex(s, k);
        System.out.println(result);
        Assert.assertEquals("o", result);

        s = "ha22";
        k = 5;
        result = solution.decodeAtIndex(s, k);
        System.out.println(result);
        Assert.assertEquals("h", result);

        s = "a2345678999999999999999";
        k = 1;
        result = solution.decodeAtIndex(s, k);
        System.out.println(result);
        Assert.assertEquals("a", result);
    }
}
