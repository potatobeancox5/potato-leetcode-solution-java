package com.potato.study.leetcode.p0890;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhao11
 * <p>
 * 890. Find and Replace Pattern
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern.

You may return the answer in any order.



Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.


Note:

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20
 * 题目含义：
 *
 * 思路：每次都建立一个双射 然后判定是不是满足双射条件
 *
 */
public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) { // 遍历每个单词
            Map<Character, Character> words2Pattern = new HashMap<>();
            Map<Character, Character> pattern2Word = new HashMap<>();
            if (word.length() != pattern.length()) {
                continue;
            }
            boolean isQualified = true;
            for (int i = 0; i < word.length(); i++) {
                char ch1 = word.charAt(i);
                char ch2 = pattern.charAt(i);
                if (words2Pattern.containsKey(ch1) && pattern2Word.containsKey(ch2)) {
                    if (words2Pattern.get(ch1).charValue() != ch2 || pattern2Word.get(ch2).charValue() != ch1) {
                        isQualified = false;
                        break;
                    }
                } else if (!words2Pattern.containsKey(ch1) && !pattern2Word.containsKey(ch2)) {
                    words2Pattern.put(ch1, ch2);
                    pattern2Word.put(ch2, ch1);
                } else {
                    isQualified = false;
                    break;
                }
            }
            // 能够完整的同过双射校验就可以进入返回列表了
            if (isQualified) {
                result.add(word);
            }
        }
        return result;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";
        List<String> andReplacePattern = solution.findAndReplacePattern(words, pattern);
        System.out.println(andReplacePattern);
    }
}
