package com.potato.study.leetcode.p0520;

/**
 * 
 * @author liuzhao11
 * 
 *         520. Detect Capital
 * 
 *         Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.


Example 1:

Input: "USA"
Output: True


Example 2:

Input: "FlaG"
Output: False


Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.


 * 
 * 
 *         思路：
 *         题目含义：判断大写字母的使用是否合法
 *          
 */
public class Solution {

    public boolean detectCapitalUse(String word) {
        String upperWord = word.toUpperCase();
        String lovwerWord = word.toLowerCase();

        if (upperWord.equals(word) || lovwerWord.equals(word)) {
            return true;
        }
        if ('A' <= word.charAt(0) && word.charAt(0) <= 'Z' && word.substring(1).equals(lovwerWord.substring(1))) {
            return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//        String word = "USA" ;
//        String word = "FlaG" ;
        String word = "FlaG" ;
        boolean res = solution.detectCapitalUse(word);
        System.out.println(res);
	}

}
