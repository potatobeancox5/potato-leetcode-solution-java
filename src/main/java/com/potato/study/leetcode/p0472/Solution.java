package com.potato.study.leetcode.p0472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         472. Concatenated Words
 * 
 *        Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
"dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.

 *         思路：
 *
 *         题意： 定义了一个 Concatenated word
 *         472. Concatenated Words

https://www.jianshu.com/p/9f8fb430920f

set 存当前word可能的前缀
word 按长度排序
for word
每次将word canForm
word 加入 prefixset



canForm word   prefixset
判断当前 word 是否可以由prefix组成
dp i 表示 从 头到第i个字母 是否可以被set单词组成  dpi  = dp j  j小于i && 从j 到 i 不包含j 组成单词是否在set中
dp 0 为真
for i 1 len
for j   0 i-1
if dpj为true 且 j到i在set中 dp i =true
 * 
 */
public class Solution {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        List<String> resultList = new ArrayList<>();
        Set<String> prefixSet = new HashSet<>();
        for (String word : words) {
            if (canForm(word, prefixSet)) {
                resultList.add(word);
            }
            prefixSet.add(word);
        }
        return resultList;
    }

    /**
     * word 是否由于 prefixSet 组成
     * @param word
     * @param prefixSet
     * @return
     */
    private boolean canForm(String word, Set<String> prefixSet) {
        if (prefixSet.isEmpty()) {
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && prefixSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> allConcatenatedWordsInADict = solution.findAllConcatenatedWordsInADict(words);
        System.out.println(allConcatenatedWordsInADict);

    }
}
