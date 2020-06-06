package com.potato.study.leetcode.p1422;


/**
 * 
 * @author liuzhao11
 * 
 * 	1422. Maximum Score After Splitting a String
 *  
 *
Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.



Example 1:

Input: s = "011101"
Output: 5
Explanation:
All possible ways of splitting s into two non-empty substrings are:
left = "0" and right = "11101", score = 1 + 4 = 5
left = "01" and right = "1101", score = 1 + 3 = 4
left = "011" and right = "101", score = 1 + 2 = 3
left = "0111" and right = "01", score = 1 + 1 = 2
left = "01110" and right = "1", score = 2 + 1 = 3
Example 2:

Input: s = "00111"
Output: 5
Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
Example 3:

Input: s = "1111"
Output: 3


Constraints:

2 <= s.length <= 500
The string s consists of characters '0' and '1' only.
 *         
 *         思路：
 *
 *         https://leetcode-cn.com/problems/maximum-score-after-splitting-a-string/solution/java-xian-xing-sao-miao-on-by-pnq/
 *
 *
 */
public class Solution {


    public int maxScore(String s) {
        int res = 0, cnt1 = 0, cnt0 = 0;        //cnt1统计右边1的个数，同理cnt0左边0的个数
        for(int i = 0; i < s.length(); i++){
            cnt1 += s.charAt(i)-'0';            //先统计1的个数
        }                                       //由于左右区域的数至少为1，所以i不能等于len-1
        for(int i = 0; i < s.length()-1; i++){  //点i分为左右两个区域
            if(s.charAt(i) == '0') {
                cnt0++;      //遇到01就统计，动态更新左右区域01个数
            } else {
                cnt1--;
            }
            res = Math.max(res, cnt0+cnt1);
        }
        return res;
    }
}
