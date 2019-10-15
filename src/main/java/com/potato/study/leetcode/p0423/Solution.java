package com.potato.study.leetcode.p0423;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         423. Reconstruct Original Digits from English
 * 
 *         Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"



        思路：
423. Reconstruct Original Digits from English

https://blog.csdn.net/qq_32511479/article/details/78554428
// zero one two three four five six seven eight nine ten
// z 0
// e 0 1 3 3 5 7 7 8 9
// r 0 3 4
// o 0 1 2 4
// n 1 7 9 9
// t 2 3 8
// w 2
// h 3 8
// f 4 5
// u 4
// i 5 6 8 9
// v 5 7
// s 6 7
// x 6
// g 8


计算每个数字包含的字母数

对于02468可以直接使用一个字母定位
1 o个数减去 024
3 h个数减去8个数
5 f个数 减去 4数量
7s个数 减去6个数
9 i个数减568个数
 * 
 * 
 *
 *
 * 
 */
public class Solution {

    public String originalDigits(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int zero = count['z' - 'a'];
        int two = count['w' - 'a'];
        int four = count['u' - 'a'];
        int six = count['x' - 'a'];
        int eight = count['g' - 'a'];

        int one = count['o' - 'a'] - zero - two - four;
        int three = count['h' - 'a'] - eight;
        int five = count['f' - 'a'] - four;
        int seven = count['s' - 'a'] - six;
        int nine = count['i' - 'a'] - five - six - eight;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zero; i++) {
            sb.append('0');
        }
        for (int i = 0; i < one; i++) {
            sb.append('1');
        }
        for (int i = 0; i < two; i++) {
            sb.append('2');
        }
        for (int i = 0; i < three; i++) {
            sb.append('3');
        }
        for (int i = 0; i < four; i++) {
            sb.append('4');
        }
        for (int i = 0; i < five; i++) {
            sb.append('5');
        }
        for (int i = 0; i < six; i++) {
            sb.append('6');
        }
        for (int i = 0; i < seven; i++) {
            sb.append('7');
        }
        for (int i = 0; i < eight; i++) {
            sb.append('8');
        }
        for (int i = 0; i < nine; i++) {
            sb.append('9');
        }
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String board = "owoztneoer";
        String count = solution.originalDigits(board);
        System.out.println(count);
        Assert.assertEquals("012", count);


        board = "fviefuro";
        count = solution.originalDigits(board);
        System.out.println(count);
        Assert.assertEquals("45", count);

    }
}
