package com.potato.study.leetcode.p1002;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1002. Find Common Characters
 *  
 *         Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.



Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]


Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter
 *         
 *         思路：
 *         set 弄三次 最后一个有的set 返回出List
 *

 *
 */
public class Solution {

    public List<String> commonChars(String[] a) {
        List<String> res = new ArrayList<>();
        if (null == a || a.length == 0) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> otherMap = new HashMap<>();

        for (char ch : a[0].toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 1; i < a.length; i++) {
            for (char ch : a[i].toCharArray()) {
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                    if (otherMap.containsKey(ch)) {
                        otherMap.put(ch, otherMap.get(ch) + 1);
                    } else {
                        otherMap.put(ch, 1);
                    }
                }
            }
            // 置换
            map = otherMap;
            otherMap = new HashMap<>();
        }
        for (Character sh : map.keySet()) {
            for (int i = 0 ; i < map.get(sh); i++) {
                res.add(sh.toString());
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String[] a = {"bella","label","roller"};
        List<String> list = solution.commonChars(a);
        System.out.println(list);
    }
}
