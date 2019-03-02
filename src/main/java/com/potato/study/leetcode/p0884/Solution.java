package com.potato.study.leetcode.p0884;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhao11
 * <p>
 * 884. Uncommon Words from Two Sentences
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words.

You may return the list in any order.



Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]


Note:

0 <= A.length <= 200
0 <= B.length <= 200
A and B both contain only spaces and lowercase letters.
 *
 *
 * 题目含义：
 *
 * 思路：
 *  直接map计算次数 1的单词 输出
 *
 */
public class Solution {

    public String[] uncommonFromSentences(String a, String b) {
        Map<String, Integer> map = new HashMap<>();
        generateMap(a, map);
        generateMap(b, map);
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            if (en.getValue() == 1) {
                list.add(en.getKey());
            }
        }

        String[] strings = new String[list.size()];
        list.toArray(strings);
        return strings;
    }

    private void generateMap(String b, Map<String, Integer> map) {
        if (null != b && !"".equals(b)) {
            String[] split = b.split(" ");
            for (String s : split) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
        }
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
		String a = "this apple is sweet";
		String b = "this apple is sour";
        String[] strings = solution.uncommonFromSentences(a, b);
        System.out.println(Arrays.toString(strings));
    }
}
