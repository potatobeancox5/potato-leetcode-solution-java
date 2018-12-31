package com.potato.study.leetcode.p0139;

import java.util.List;

import com.potato.study.leetcode.util.ListUtil;

/**
 * 
 * @author liuzhao11
 * 
 *        139. Word Break
 *         
 *         Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
  
 *         思路：
 *         canBreak【i️】 代表 从 0 - i （包括） 能被字母表中的组合进行表示
 *         
 *         canBreak【i️】  若 canBreak【j】 （j 《 i） 和j+ 1 i 的串在字母表中 = true
 *         					否则 = false
 * 			两层循环 i 0 - len - 1
 * 					j 0 - i - 1
 * 			计算
 * 				canBreak【i️】  若 canBreak【j】 （j 《 i） 和j+ 1 i 的串在字母表中 = true
 *         					否则 = false
 *         https://leetcode.com/problems/word-break/description/
 */
public class Solution {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
		for(int i = 1 ; i < s.length() + 1; i++) {
        		for (int j = 0; j < i ; j++) {
        			String lastPartWord = s.substring(j, i);
        			if(canBreak[j] && isInWordDict(lastPartWord, wordDict)) {
        				canBreak[i] = true;
        				break;
        			}
			}
        }
		return canBreak[s.length()];
    }
	
	private boolean isInWordDict(String word, List<String> wordDict) {
		if(wordDict == null || wordDict.size() == 0) {
			return false;
		}
		for (String w : wordDict) {
			if(w.equals(word)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String s = "leetcode";
//		String words = "[\"leet\",\"code\"]";
		String s = "applepenapple";
		String words = "[\"apple\", \"pen\"]";
		List<String> wordDict = ListUtil.stringToList(words);
		boolean res = solution.wordBreak(s, wordDict);
		System.out.println(res);
	}
}
