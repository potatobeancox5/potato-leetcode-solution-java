package com.potato.study.leetcode.p0058;

/**
 * 
 * @author liuzhao11
 * 
 * 
 *         58. Length of Last Word
 *     
 *         Given a string s consists of upper/lower-case
 *         alphabets and empty space characters ' ', return the length of last
 *         word in the string.
 * 
 *         If the last word does not exist, return 0.
 * 
 *         Note: A word is defined as a character sequence consists of non-space
 *         characters only.
 * 
 *         Example:
 * 
 *         Input: "Hello World" Output: 5
 * 
 * 
 *         思路：
 *         找到一句话中 最后一个单词的长度
 *         去掉收尾的空格 并返回数组 
 *         从后向前遍历数组 并技术 遇到第一个" "时 或者到头时 输出数量
 * 
 */
public class Solution {
	
	public int lengthOfLastWord(String s) {
		char[] arr = s.trim().toCharArray();
		int count = 0;
		for(int i = arr.length - 1 ; i >=0 ; i--) {
			if(' ' == arr[i]) {
				return count;
			} 
			count++;
		}
		return count;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
		int num = solution.lengthOfLastWord("hello world");
		System.out.println(num);
		
	}
}
