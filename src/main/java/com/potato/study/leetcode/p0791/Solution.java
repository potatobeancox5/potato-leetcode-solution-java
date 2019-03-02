package com.potato.study.leetcode.p0791;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	791. Custom Sort String
 *  
 *         S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input:
S = "cba"
T = "abcd"
Output: "cbad"
Explanation:
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.


Note:

S has length at most 26, and no character is repeated in S.
T has length at most 200.
S and T consist of lowercase letters only.
 *         
 *
 *         题目含义：
 *
 *         思路：
 *              将t中char和出现次数 存到一个map中 最终按照s顺序扫一遍输出
 *              最后将没有扫到的输出
 *
 * 
 */
public class Solution {

    public String customSortString(String s, String t) {
        Map<Character, Integer> charTimesMap = new HashMap<>();
        for (char sh : t.toCharArray()) {
            if (charTimesMap.containsKey(sh)) {
                charTimesMap.put(sh, charTimesMap.get(sh) + 1);
            } else {
                charTimesMap.put(sh, 1);
            }
        }
        // 按照s顺序扫一遍输出
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (charTimesMap.containsKey(ch)) {
                for (int i = 0; i < charTimesMap.get(ch); i++) {
                    sb.append(ch);
                }
                charTimesMap.remove(ch);
            }
        }
        // 输出剩下的
        for (Map.Entry<Character, Integer> en: charTimesMap.entrySet()) {
            for (int i = 0; i < en.getValue(); i++) {
                sb.append(en.getKey());
            }
        }
        return sb.toString();
    }


	

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "cba";
		String t = "abcd";
        String str = solution.customSortString(s, t);
        System.out.println(str);
    }
}
