package com.potato.study.leetcode.p1297;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1297. Maximum Number of Occurrences of a Substring
 *  
 *
Given a string s, return the maximum number of ocurrences of any substring under the following rules:

The number of unique characters in the substring must be less than or equal to maxLetters.
The substring size must be between minSize and maxSize inclusive.


Example 1:

Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
Output: 2
Explanation: Substring "aab" has 2 ocurrences in the original string.
It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
Example 2:

Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
Output: 2
Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
Example 3:

Input: s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
Output: 3
Example 4:

Input: s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
Output: 0


Constraints:

1 <= s.length <= 10^5
1 <= maxLetters <= 26
1 <= minSize <= maxSize <= min(26, s.length)
s only contains lowercase English letters.
 *         
 *         思路：
 *
 *
 *          每个盒子礼拜 关联着好多其他资源 计算 最多能获得多少资源
 *
 *          https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring/solution/java-hashmap-by-npe_tle/
 *
 *

 *
 */
public class Solution {

    private boolean isMatch(String str, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
            if (set.size() > maxLetters) {
                return false;
            }
        }

        return set.size() <= maxLetters;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int len = s.length();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (i + minSize > len) {
                break;
            }

            String sub = s.substring(i, i + minSize);
            if (isMatch(sub, maxLetters)) {
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }

        int ansMax = 0;
        for (String str: countMap.keySet()) {
            int count = countMap.get(str);
            if (count > ansMax) {
                ansMax = count;
            }
        }

        return ansMax;
    }
}
