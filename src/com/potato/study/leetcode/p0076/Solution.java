package com.potato.study.leetcode.p0076;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *  76. Minimum Window Substring
 *  
 *  Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.++
 *        
 *  思路：利用hash结构统计t中字母的个数
 *  两个指针 start = 0 end = 0 计数器count = t。length
 *  while count 》 0 切 end 《  s.lengh
 *  	如果end处字符是hash中字符 
 *  		hash value 》0 时  找到t中的一个字符
 *  			count--; hash value--
 *  		hash value <= 0 时  表示找到了多余的字符
 *  			hash value --
 *  		
 *  	如果end处字符不是hash中字符
 *  		 向后移动一个位置
 *  	end++
 *  如果遍历一遍之后
 *  end >= s.length 表示没有合适的字符串 返回 “”
 *  这样确定的start 和 end 中移动包含所有的字符串
 *  while start 《=  end 时
 *  	如果start处字符是hash中字符 
 *  		hash value 《 0 时 hash value++
 *  		若 hash value 》= 0 时 此时的start 到 end中的字符串是所求  返回
 *  	如果start处字符不是hash中字符
 *  		start++ 向后移动一个位置
 *   	start++
 *   没有找到合适的串 返回“” 
 *   
 */
public class Solution {

	public String minWindow(String s, String t) {
		if(s == null || s.length() == 0) {
			return "";
		}
		if(t == null || t.length() == 0) {
			return "";
		}
//		两个指针 start = 0 end = 0 计数器count = t。length
		int start = 0;
		int end = 0;
		//创建最开始的hashmap
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			if(map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
			} else {
				map.put(t.charAt(i), 1);
			}
		}
		int count = t.length();
//	 *  while count 》 0 切 end 《  s.lengh
		while (count > 0 && end < s.length()) {
//	 *  	如果end处字符是hash中字符 
			if(map.containsKey(s.charAt(end))) {
				if(map.get(s.charAt(end)) > 0) {
					count--;
				}
				map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
			} 	
			end++;
		}
		if(count > 0) {
			return "";
		}
		int minStart = start;
		int minEnd = end;
		int minWindowLength = minEnd - minStart;
//	 *  这样确定的start 和 end 的初始位置
		while (start <= end) { // end < s.length() &&
			// * 如果start处字符是hash中字符
			if (map.containsKey(s.charAt(start))) {
				if (map.get(s.charAt(start)) < 0) {
					// * hash value 《 0 时 hash value++
					map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
					start++;
				} else if (map.get(s.charAt(start)) == 0) {
					// * 若 hash value 》= 0 时 此时的start 到 end中的字符串可能是所求 返回
					if (end - start < minWindowLength) {
						minEnd = end;
						minStart = start;
						minWindowLength = end - start;
					}
					break;
				} // 当前windows缺字符没有意义
			} else {
				start++;
			}

		}
		
		while (end < s.length()) {
			while(end < s.length() && !map.containsKey(s.charAt(end))) {
				end++;
			}
			if(end < s.length() && map.containsKey(s.charAt(end))) {
				map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
				end++;
			}
			while(start <= end) { //end < s.length() &&
//	 *  	如果start处字符是hash中字符 
				if(map.containsKey(s.charAt(start))) {				
					if(map.get(s.charAt(start)) < 0) {
//	 *  		hash value 《 0 时 hash value++		
						map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
						start++;
					} else if(map.get(s.charAt(start)) == 0){
//	 *  		若 hash value 》= 0 时 此时的start 到 end中的字符串可能是所求  返回	
						if(end - start < minWindowLength) {
							minEnd = end;
							minStart = start;
							minWindowLength = end - start;
						}
						break;
					} //当前windows缺字符没有意义
				} else {
					start++;
				}
				
			}
		}
		//移动start 进行最后一次查找
		while (start <= end) { // end < s.length() &&
			// * 如果start处字符是hash中字符
			if (map.containsKey(s.charAt(start))) {
				if (map.get(s.charAt(start)) < 0) {
					// * hash value 《 0 时 hash value++
					map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
					start++;
				} else if (map.get(s.charAt(start)) == 0) {
					// * 若 hash value 》= 0 时 此时的start 到 end中的字符串可能是所求 返回
					if (end - start < minWindowLength) {
						minEnd = end;
						minStart = start;
						minWindowLength = end - start;
					}
					break;
				} // 当前windows缺字符没有意义
			} else {
				start++;
			}

		}
//	 *   没有找到合适的串 返回“” 
		return s.substring(minStart,minEnd);
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "ba";
		String t = "b";
		String window = solution.minWindow(s, t);
		System.out.println(window);
	}
}
