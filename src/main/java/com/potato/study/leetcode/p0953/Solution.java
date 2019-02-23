package com.potato.study.leetcode.p0953;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	953. Verifying an Alien Dictionary
 *  
 *       In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.



Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).


Note:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are english lowercase letters.
 *         
 *         题目含义：
 *
 *         思路：
 *         建立 字母数字 index map 然后逐个比较是不是符合map的标准
 *         一次比较前一个和后一个是不是升序
 *
 *
 *
 * 
 */
public class Solution {

    public boolean isAlienSorted(String[] words, String order) {

        // 构建顺序map
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.toCharArray().length; i++) {
            orderMap.put(order.charAt(i), i);
        }
        // 控制循环选择i he i+ 1 进行比较
        boolean isSorted = true;
        for (int i = 0; i < words.length - 1; i++) {
            // 比较相邻的两个 字符串
            String pre = words[i];
            String after = words[i + 1];
            // 判断前缀情况
            if (after.startsWith(pre) && after.length() >= pre.length()) {
                continue;
            } else if (pre.startsWith(after) && pre.length() >= after.length()) {
                return false;
            }
            // 不是前缀关系 那么一定会出现 两个字母不一致找到就好了
            for (int j = 0; j < pre.length(); j++) {
                if (orderMap.get(pre.charAt(j)) > orderMap.get(after.charAt(j))) {
                    return false;
                } else if (orderMap.get(pre.charAt(j)) == orderMap.get(after.charAt(j))) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return isSorted;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
//		String[] words = {"hello","leetcode"};
//		String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        boolean alienSorted = solution.isAlienSorted(words, order);
        System.out.println(alienSorted);
    }
}
