package com.potato.study.leetcode.p0676;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         676. Implement Magic Dictionary
 * 
 *         Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
Note:
You may assume that all the inputs are consist of lowercase letters a-z.
For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.
 *
 *         思路：
 *
 *         构造一种数据结构 单词表和 给定单词 问 是否可以 word 只该变一个字母就能早word中找到
 *          https://www.cnblogs.com/lightwindy/p/9808248.html
 *
 *
 *          使用一个map
 *              map key 是 每个单词去掉某一个字母之后拼装成的单词
 *              value 是 list 存储 删除的位置 和 该位置的字母
 *
 *              https://www.cnblogs.com/lightwindy/p/9808248.html
 *
 */
public class MagicDictionary {

    private Map<String, List<int[]>> dictonary = new HashMap<>();

    /** Initialize your data structure here. */
    public MagicDictionary() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + word.substring(i+1);
                int[] indexAndChar = new int[2];
                indexAndChar[0] = i;
                indexAndChar[1] = word.charAt(i) - 'a';
                List<int[]> indexAndCharList = dictonary.getOrDefault(key, new ArrayList<>());
                indexAndCharList.add(indexAndChar);

                dictonary.put(key, indexAndCharList);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        // 1. 遍历 每个 字母 去掉 从list 里去出来结果 比较list 每个结果
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i+1);
            List<int[]> indexAndCharList = dictonary.getOrDefault(key, new ArrayList<>());
            for (int[] indexAndChar : indexAndCharList) {
                if (indexAndChar[0] == i && indexAndChar[1] != (word.charAt(i) - 'a')) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary dictionary = new MagicDictionary();
        String[] words = {"hello", "leetcode"};

        dictionary.buildDict(words);

        boolean search = dictionary.search("hello");
        System.out.println(search);
        Assert.assertEquals(false, search);

        search = dictionary.search("hhllo");
        System.out.println(search);
        Assert.assertEquals(true, search);

        search = dictionary.search("hell");
        System.out.println(search);
        Assert.assertEquals(false, search);

        search = dictionary.search("leetcoded");
        System.out.println(search);
        Assert.assertEquals(false, search);
    }
}
