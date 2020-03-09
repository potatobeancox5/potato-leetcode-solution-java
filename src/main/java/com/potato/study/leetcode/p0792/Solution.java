package com.potato.study.leetcode.p0792;

import org.junit.Assert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	792. Number of Matching Subsequences
 *  
 *         Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
Note:

All words in words and S will only consists of lowercase letters.
The length of S will be in the range of [1, 50000].
The length of words will be in the range of [1, 5000].
The length of words[i] will be in the range of [1, 50].
 *         
 *
 *         题目含义：
 *
 *         思路：
 *         https://blog.csdn.net/u014688145/article/details/79454874
 *
 *         使用一个map key 是当前问匹配单词的首字母 value 是当前为匹配单词 list
 *
 *         1. 将 words -》 map
 *
 *         2. 遍历s的每一个字母，从map 中取出 当前字母对应的list 对其进行遍历
 *
 *         3. 如果 list 中单词 len = 1 计数器++ 否则 subString 1 ， 并将其放到 word 1 对应的list 中
 *
 *         4. 返回数量
 *
 *
 * 
 */
public class Solution {

    public int numMatchingSubseq(String s, String[] words) {

        //    1. 将 words -》 map
        Map<Character, List<String>> firstChWordListMap = new HashMap<>();
        for (String word : words) {
            char first = word.charAt(0);
            List<String> list = firstChWordListMap.getOrDefault(word.charAt(0), new LinkedList<>());
            list.add(word);
            firstChWordListMap.put(first, list);

        }
        //    2. 遍历s的每一个字母，从map 中取出 当前字母对应的list 对其进行遍历
        int matchCount = 0;
        for (char ch : s.toCharArray()) {
            //    3. 如果 list 中单词 len = 1 计数器++ 否则 subString 1 ， 并将其放到 word 1 对应的list 中
            List<String> wordList = firstChWordListMap.get(ch);

            if (wordList == null || wordList.size() == 0) {
                continue;
            }

            int n = wordList.size();
            for (int i = 0; i < n; i++) {
                String word = wordList.remove(0);
                if (word.length() == 1) {
                    matchCount++;
                } else {
                    List<String> list = firstChWordListMap.getOrDefault(word.charAt(1), new LinkedList<>());
                    list.add(word.substring(1));
                    firstChWordListMap.put(word.charAt(1), list);
                }
            }

        }
        //    4. 返回数量
        return matchCount;
    }


	

	public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};

        int res = solution.numMatchingSubseq(s, words);
        System.out.println(res);
        Assert.assertEquals(res, 3);
    }
}
