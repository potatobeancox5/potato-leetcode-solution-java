package com.potato.study.leetcode.p0984;


/**
 * 
 * @author liuzhao11
 * 
 * 	984. String Without AAA or BBB
 *  
 *        Given two integers A and B, return any string S such that:

S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
The substring 'aaa' does not occur in S;
The substring 'bbb' does not occur in S.


Example 1:

Input: A = 1, B = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.
Example 2:

Input: A = 4, B = 1
Output: "aabaa"


Note:

0 <= A <= 100
0 <= B <= 100
It is guaranteed such an S exists for the given A and B.
 *
 *
 *      题目思路：
 *      https://leetcode-cn.com/problems/string-without-aaa-or-bbb/solution/javatan-xin-suan-fa-by-wo-ye-lai-shi-shi-ba-2/
 *
 */
public class Solution {

    public String strWithout3a3b(int arrA, int arrB) {
        char[] res = new char[arrA + arrB];
        int n = Math.abs(arrA - arrB);
        char c = arrA > arrB ? 'a' : 'b';
        int aSubCount = arrA > arrB ? 2 : 1;
        int bSubCount = arrA <= arrB ? 2 : 1;
        char otherC = arrA <= arrB ? 'a' : 'b';
        int index = 0;
        for (int i = 0; arrA > 0 && arrB > 0 && i < n; i++) {
            res[index++] = c;
            res[index++] = c;
            res[index++] = otherC;
            arrA -= aSubCount;
            arrB -= bSubCount;
        }
        while (arrA > 0 && arrB > 0 && index < res.length) {
            res[index++] = c;
            res[index++] = otherC;
            arrA--;
            arrB--;
        }
        while (arrA-- > 0) {
            res[index++] = 'a';
        }
        while (arrB-- > 0) {
            res[index++] = 'b';
        }
        return new String(res);
    }


    public static void main(String[] args) {

    }

}
