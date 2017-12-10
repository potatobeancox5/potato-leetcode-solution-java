package com.potato.study.leetcode.p0003;

import java.util.HashMap;
import java.util.Map;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11 3. Longest Substring Without Repeating Characters
 *
 *
 *         Given a string, find the length of the longest substring without
 *         repeating characters.
 * 
 *         Examples:
 * 
 *         Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 *         Given "bbbbb", the answer is "b", with the length of 1.
 * 
 *         Given "pwwkew", the answer is "wke", with the length of 3. Note that
 *         the answer must be a substring, "pwke" is a subsequence and not a
 *         substring.
 * 
 *         思路： 
 *         遍历一次字符串，并使用Map<char index> 记录下 字符和出现的最后一个位置，记录当前不重复的字串的起始位置start
 *         记录历史最长字符串长度 
 *         取出一个字符，判断是否在map中 
 *         	没在的话 字串长度+1 并将字符放入map中 
 *         	在的话 
 *         		若取出的index >= start（起始位置） 更新start，更新历史最大长度
 *         			更新map中的index 重新计算字串长度:index + 1 到 当前位置 
 *         		若取出的index < start (起始位置) 更新map中的index 字串长度++
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
		
		if(null == s || s.length() == 0) {
			return 0;
		}

		int startIndex = 0;//当前不重复字串起始位置
		int maxLength = 0;//最大不重复字串长度
		Map<Character, Integer> lastAppear = new HashMap<>();//字符出现的最后一个位置
		int currentLength = 0;//当前不重复字串长度
		for(int i = 0 ; i < s.length() ; i++) {
			char ch = s.charAt(i);
			if (!lastAppear.containsKey(ch)) {
				currentLength++;
				lastAppear.put(ch, i);
			} else {
				int lastAppearIndex = lastAppear.get(ch);
				if (lastAppearIndex >= startIndex) {
					startIndex = lastAppearIndex + 1;
					if (currentLength > maxLength) {
						maxLength = currentLength;
					}
					currentLength = i - lastAppearIndex;
					lastAppear.put(ch, i);
				} else {//取出的index < start (起始位置)
					currentLength++;
					lastAppear.put(ch, i);
				}
			}
		}
		//处理一直到最后一个字符都是不重复字串的情况
		if (currentLength > maxLength) {
			maxLength = currentLength;
		}
		return maxLength;
	}

	public static void main(String[] args) {
//		String str = "abcabcbb";
//		String str = "bbbbb";
		String str = "pwwkew";
		Solution solution = new Solution();
		int length = solution.lengthOfLongestSubstring(str);
		System.out.println("length = " + length);
	}
}
