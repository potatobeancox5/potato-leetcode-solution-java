package com.potato.study.leetcode.p1324;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1324. Print Words Vertically
 *  
 *
Given a string s. Return all the words vertically in the same order in which they appear in s.
Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
Each word would be put on only one column and that in one column there will be only one word.



Example 1:

Input: s = "HOW ARE YOU"
Output: ["HAY","ORO","WEU"]
Explanation: Each word is printed vertically.
"HAY"
"ORO"
"WEU"
Example 2:

Input: s = "TO BE OR NOT TO BE"
Output: ["TBONTB","OEROOE","   T"]
Explanation: Trailing spaces is not allowed.
"TBONTB"
"OEROOE"
"   T"
Example 3:

Input: s = "CONTEST IS COMING"
Output: ["CIC","OSO","N M","T I","E N","S G","T"]


Constraints:

1 <= s.length <= 200
s contains only upper case English letters.
It's guaranteed that there is only one space between 2 words.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/print-words-vertically/solution/998-100-by-wei-yu-13/
 *
 *
 *

 *
 */
public class Solution {

    public List<String> printVertically(String s) {
        // 遍历 单词求 最长的单词长度 max
        int maxLen = 0;
        String[] words = s.split(" ");
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        List<String> res = new ArrayList<>();
        // 遍历 max 每个位置 如果长度没有超过单词 就添加字母 否则添加空格 开始使用 # 占位 防止trim
        for (int i = 0; i < maxLen; i++) {
            String vWord = "#";
            for (String word : words) {
                if (i > word.length() - 1) {
                    vWord += " ";
                } else {
                    vWord += word.charAt(i);
                }
            }
            vWord = vWord.trim();
            res.add(vWord.substring(1));
        }
        return res;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "HOW ARE YOU";
        List<String> words = solution.printVertically(s);
        System.out.println(words); // "HAY","ORO","WEU"

    }
}
