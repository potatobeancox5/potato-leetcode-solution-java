package com.potato.study.leetcode.p0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 30. Substring with Concatenation of All Words
 * 		
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).


 *         思路：
 *         开两个map 一个纪录应该出现字符串的次数 一个纪录已经出现的字符串次数 和 总的剩余次数
 *         然后对字符串s 的每个位置作为起点开始遍历  
 *         		由于每个字串长度都一致 每次比较一个串 并计数 当总剩余次数为0时 纪录当前i 
 *         										当某一个纪录超过限制时 i++
 *         										当该字符串不存在时 i++
 *         		
 *         
 * 
 */
public class Solution {
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if(s == null || words == null || words.length == 0) {
			return result;
		}
		Map<String, Integer> checkMap = buildMap(words);
		int wordLen = words[0].length();
		// 遍历s 查找合适位置
		for(int i = 0 ; i <= s.length() - wordLen * words.length; i++) { // 此处注意比较次数 尽量小
			Map<String, Integer> countMap = new HashMap<>(checkMap);
			int mapSize = words.length;
			for(int j = i ; j <= s.length() - wordLen; j+=wordLen) {
				String targetWord = s.substring(j, j + wordLen);
				if(countMap.containsKey(targetWord) && countMap.get(targetWord) > 0 ) {
					countMap.put(targetWord, countMap.get(targetWord) - 1);
					mapSize--;
				} else { // 不存在当前word 或者 当前字符串计数器已经减到0
					break;
				}
				if (mapSize == 0) { // 所有的word都已经匹配上了 纪录位置 继续比较					
					result.add(i);
					break;
				}
			}
		}
		return result;
    }
	
	/**
	 * 创建单词map
	 * @param words
	 * @return
	 */
	private Map<String, Integer> buildMap(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		if(null != words) {			
			for (String word : words) {
				if(map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);
				}
			}
		}
		return map;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","good"};
		List<Integer> result = solution.findSubstring(s, words);
		System.out.println(result);
	}

	
	
}
