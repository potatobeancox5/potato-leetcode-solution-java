package com.potato.study.leetcode.p1189;


/**
 * 
 * @author liuzhao11
 * 
 * 	1189. Maximum Number of Balloons
 *  
 *
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.



Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0


Constraints:

1 <= text.length <= 10^4
text consists of lower case English letters only.
 *         
 *         思路：
 *
 *         给一个张字符串 问能组成多少个 balloon
 *
 *
 *
 *
 *

 *
 */
public class Solution {

    public int maxNumberOfBalloons(String text) {
        // 统计单词 只统计 balloon 数量
        int[] count = new int[5];
        for (char ch: text.toCharArray()) {
            if (ch == 'b') {
                // b
                count[0]++;
            } else if (ch == 'a') {
                // a
                count[1]++;
            } else if (ch == 'l') {
                // l
                count[2]++;
            } else if (ch == 'o') {
                // o
                count[3]++;
            } else if (ch == 'n') {
                // n
                count[4]++;
            }
        }

        // 求最少能组成多少哥
        int maxNum = Math.min(Math.min(count[0], count[1]), count[4]);
        maxNum = Math.min(Math.min(maxNum, count[2] / 2), count[3] / 2);
        return maxNum;
    }
	
	public static void main(String[] args) {

    }
}
