package com.potato.study.leetcode.p1358;


/**
 * 
 * @author liuzhao11
 * 
 * 	1358. Number of Substrings Containing All Three Characters
 *  
 *  Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.



Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
Example 3:

Input: s = "abc"
Output: 1


Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/number-of-substrings-containing-all-three-characters/solution/si-kao-de-guo-cheng-bi-da-an-zhong-yao-xiang-xi-tu/
 *
 *
 *
 *
 */
public class Solution {

    public int numberOfSubstrings(String s) {
        int answer=0;
        //abc 的计数
        int[] count=new int[3];
        //窗口左沿
        int start=0;
        //窗口右沿
        for(int end=0;end<s.length();end++){
            char charAtEnd=s.charAt(end);
            count[charAtEnd-'a']++;
            while(count[0]>=1 && count[1]>=1 && count[2]>=1){
                answer+=s.length()-end;
                char charAtStart=s.charAt(start);
                count[charAtStart-'a']--;
                start++;
            }
        }
        return answer;
    }
}
