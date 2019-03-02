package com.potato.study.leetcode.p0893;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhao11
 * <p>
 * 893. Groups of Special-Equivalent Strings
 *
 * You are given an array A of strings.

Two strings S and T are special-equivalent if after any number of moves, S == T.

A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].

Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.

Return the number of groups of special-equivalent strings from A.



Example 1:

Input: ["a","b","c","a","c","c"]
Output: 3
Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
Example 2:

Input: ["aa","bb","ab","ba"]
Output: 4
Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
Example 3:

Input: ["abc","acb","bac","bca","cab","cba"]
Output: 3
Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
Example 4:

Input: ["abcd","cdab","adcb","cbad"]
Output: 1
Explanation: 1 group ["abcd","cdab","adcb","cbad"]
 * 题目含义：
 *
 * 思路：
 * https://blog.csdn.net/yanglingwell/article/details/82080913
利用hashmap equal提供的比较值功能，分别统计奇数位置和偶数位置字符出现频次，相等证明是同一个map
Map<Integer, Integer> map = new HashMap<>();
map.put(1,1);
map.put(2,2);

Map<Integer, Integer> map1 = new HashMap<>();
map1.put(1,1);
map1.put(2,2);

Set<Map<Integer, Integer>> set = new HashSet<>();
set.add(map);
set.add(map1);

System.out.println(set.size());
 */
public class Solution {

    public int numSpecialEquivGroups(String[] arr) {
        Set<Map<Integer, Map<Character, Integer>>> keySet = new HashSet<>();
        for (String s : arr) {
            Map<Character, Integer> oddMap = new HashMap<>();
            Map<Character, Integer> evenMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (i % 2 ==0) {
                    if (!evenMap.containsKey(ch)) {
                        evenMap.put(ch, 1);
                    } else {
                        evenMap.put(ch, evenMap.get(ch) + 1);
                    }
                } else {
                    if (!oddMap.containsKey(ch)) {
                        oddMap.put(ch, 1);
                    } else {
                        oddMap.put(ch, oddMap.get(ch) + 1);
                    }
                }
            }
            Map<Integer, Map<Character, Integer>> keyMap = new HashMap<>();
            keyMap.put(1, oddMap);
            keyMap.put(0, evenMap);
            keySet.add(keyMap);
        }
        return keySet.size();
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
//		String[] arr = {"a","b","c","a","c","c"};
//		String[] arr = {"aa","bb","ab","ba"};
//		String[] arr = {"abc","acb","bac","bca","cab","cba"};
		String[] arr = {"ababaa","aaabaa"};
        int num = solution.numSpecialEquivGroups(arr);
        System.out.println(num);
    }
}
