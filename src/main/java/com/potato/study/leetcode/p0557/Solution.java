package com.potato.study.leetcode.p0557;

/**
 * 
 * @author liuzhao11
 * 
 *         557. Reverse Words in a String III
 * 
 *         Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.


 * 
 * 
 *         思路：
 *          字符串内进行反转
 *       
 *          
 */
public class Solution {

    public String reverseWords(String s) {
        // 按照空格分割
        String[] split = s.split(" ");
        // 对每个单词反转
        StringBuilder sb = new StringBuilder();
        for (String word : split) {
            sb.append(this.reverseSingleWord(word)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String reverseSingleWord(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        return sb.reverse().toString();
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "Let's take LeetCode contest";
        String words = solution.reverseWords(s);
        System.out.println(words);

    }
}
