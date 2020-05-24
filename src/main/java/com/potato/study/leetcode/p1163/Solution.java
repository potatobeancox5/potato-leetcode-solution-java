package com.potato.study.leetcode.p1163;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1163. Last Substring in Lexicographical Order
 *  
 *
Given a string s, return the last substring of s in lexicographical order.



Example 1:

Input: "abab"
Output: "bab"
Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
Example 2:

Input: "leetcode"
Output: "tcode"


Note:

1 <= s.length <= 4 * 10^5
s contains only lowercase English letters.
 *         
 *         思路：
 *          给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 *          https://leetcode-cn.com/problems/last-substring-in-lexicographical-order/solution/java8ms-by-guyul/
 *
 */
public class Solution {


    public String lastSubstring(String s) {

        char[] str = s.toCharArray();
        int index = str.length-1;
        int max = 0;

        for(int i=str.length-1;i>=0;i--) {
            if(str[i]-'a'>max){
                index = i;
                max = str[i]-'a';
            } else if(str[i]-'a'==max) {
                if(i-1 >= 0 && str[i] == str[i-1]) {
                    continue;
                }
                int temp = index;
                index = i;
                max = str[i]-'a';
                for(int j = i,k = temp;j < str.length && k < str.length; j++,k++){
                    if(str[k]-'a'==str[j]-'a') {
                        continue;
                    }
                    if(str[k]-'a'>str[j]-'a'){
                        index = temp;
                        max = str[index]-'a';
                        break;
                    } else if(str[k]-'a'<str[j]-'a'){
                        break;
                    }
                }
            }
        }

        return s.substring(index);
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "abab";
        String res = solution.lastSubstring(s);
        System.out.println(res);
        Assert.assertEquals("bab", res);
    }
}
