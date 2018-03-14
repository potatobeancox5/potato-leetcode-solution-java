package com.potato.study.leetcode.p0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 49. Group Anagrams
 *         
 *          Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 *          
 *          思路：建立一个map<String, List<String>> key为 字符串的字符数组经过排序生成的String 利用String
 *         	hashCode 函数是通过String 的字面生成的特点 建立一个map 
 *         	map value 存着每一个字符串的真实值，最终 遍历map 将value转成list
 * 
 * 
 * 
 */
public class Solution {
	
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		if(null == strs || strs.length == 0) {
			return result;
		}
		for (String word : strs) {
			char[] arr = word.toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);
			if(map.containsKey(key)) {
				map.get(key).add(word);
			} else {
				List<String> current = new ArrayList<>();
				current.add(word);
				map.put(key, current);
			}
		}
		// 遍历map 生成list
		for ( List<String> list : map.values()) {
			result.add(list);
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> list = solution.groupAnagrams(strs);
		System.out.println(list);
	}
}
