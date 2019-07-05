package com.potato.study.leetcode.p0438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *   Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 			
 *     思路：
 *      使用map统计 次数，然后使用map .equels
 *     

 * 	
 */	
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> resultList = new ArrayList<>();

        int pLen = p.length();

        int sSize = 0;

        // 统计 p
        Map<Character, Integer> countPMap = new HashMap<>();
        Map<Character, Integer> countSMap = new HashMap<>();
        for (Character ch : p.toCharArray()) {
            if (countPMap.containsKey(ch)) {
                countPMap.put(ch, countPMap.get(ch) + 1);
            } else {
                countPMap.put(ch, 1);
            }
        }

        for (int i = 0; i < s.length() ; i++) {

            char ch = s.charAt(i);

            if (sSize < pLen) {
                if (countSMap.containsKey(ch)) {
                    countSMap.put(ch, countSMap.get(ch) + 1);
                } else {
                    countSMap.put(ch, 1);
                }
                sSize++;
            } else {
                if (countSMap.containsKey(ch)) {
                    countSMap.put(ch, countSMap.get(ch) + 1);
                } else {
                    countSMap.put(ch, 1);
                }
                // 同时删除
                char key = s.charAt(i - pLen);
                Integer num = countSMap.get(key);
                num--;
                if (num == 0) {
                    countSMap.remove(key);
                } else {
                    countSMap.put(key, num);
                }
            }

            // same
            if (countPMap.equals(countSMap)) {
                resultList.add(i - pLen + 1);
            }
        }
        return resultList;
    }
	
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "abab";
		String p = "ab";

//        String s = "cbaebabacd";
//        String p = "abc";


        List<Integer> list = solution.findAnagrams(s, p);
		System.out.println(list);
	}
}
