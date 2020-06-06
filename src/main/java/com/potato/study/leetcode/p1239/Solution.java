package com.potato.study.leetcode.p1239;


import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1239. Maximum Length of a Concatenated String with Unique Characters
 *  
 *      Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.



Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26


Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.
 *         
 *
 *
 *         思路：
 *          https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/solution/java-dfssou-suo-shi-yong-wei-yan-ma-jie-jue-by-kei/

 *
 */
public class Solution {

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0){
            return 0;
        }
        return maxLengthDFS(arr, 0, 0);
    }

    //此处函数的目的是为了返回串联字符的最大长度
    public int maxLengthDFS(List<String> arr, int start, int bitMask) {
        if (start == arr.size()) {
            return 0;
        }

        int ans = 0;
        for (int i = start; i < arr.size(); i++) {
            int bit = getBitMask(arr.get(i));
            if (bit == 0 || (bitMask & bit) != 0) {
                continue;
            }
            //一。当前子字符位掩码不为0（为0的话证明子字符里面有重复字符）
            //二。当前子字符位掩码与前面字符的位掩码与运算结果为0（如果结果不为0，那么说明与之前的字符串有重复）
            //满足上述两个条件才进入一下层递归。
            ans = Math.max(ans, maxLengthDFS(arr, i + 1, bitMask | bit) + arr.get(i).length());
        }
        return ans;
    }

    public int getBitMask(String s) {
        int bitMask = 0;
        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');
            if ((bit & bitMask) != 0) {
                return 0;
            }
            bitMask |= bit;
        }
        return bitMask;
    }
}
