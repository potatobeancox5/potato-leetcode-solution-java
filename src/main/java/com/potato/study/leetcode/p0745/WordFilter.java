package com.potato.study.leetcode.p0745;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	745. Prefix and Suffix Search
 *  
 *         Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:

Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1


Note:

words has length in range [1, 15000].
For each test case, up to words.length queries WordFilter.f may be made.
words[i] has length in range [1, 10].
prefix, suffix have lengths in range [0, 10].
words[i] and prefix, suffix queries consist of lowercase letters only.
 *
 * 思路：
 *
 *
 *      https://segmentfault.com/a/1190000016973949
 *
 *      设计一个数据结果 能够对齐进行前缀后缀的查找并 返回 权重 权重就是 index
 *
 *      使用一个map 存储word 2 index
 *
 *      遍历 map 找到prefix 是否相同 再找 sufix 找到最大的index
 */
public class WordFilter {


    private Map<String, Integer> indexMap;

    public WordFilter(String[] words) {
        indexMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            indexMap.put(words[i], i);
        }
    }

    public int f(String prefix, String suffix) {
        if (null == prefix || null == suffix) {
            return -1;
        }
        int minLen = Math.max(prefix.length(), suffix.length());
        int max = -1;
        // 从后向前遍历 使用 长度进行剪zhi
        for (String word : indexMap.keySet()) {
            if (word.length() < minLen) {
                continue;
            }

            int suffixIndex = word.length() - suffix.length();

            if (word.startsWith(prefix) && suffix.equals(word.substring(suffixIndex))) {
                max = Math.max(max, indexMap.get(word));
            }
        }
        return max;
    }


    // TLE
//    private String[] words;
//
//    public WordFilter(String[] words) {
//        this.words = words;
//    }
//
//    public int f(String prefix, String suffix) {
//        if (null == prefix || null == suffix) {
//            return -1;
//        }
//        int minLen = Math.max(prefix.length(), suffix.length());
//        // 从后向前遍历 使用 长度进行剪zhi
//        for (int i = words.length - 1; i >= 0 ; i--) {
//            String word = words[i];
//            if (word.length() < minLen) {
//                continue;
//            }
//
//            int suffixIndex = word.length() - suffix.length();
//
//            if (word.startsWith(prefix) && suffix.equals(word.substring(suffixIndex))) {
//                return i;
//            }
//        }
//        return -1;
//    }
	

	
	public static void main(String[] args) {

        String[] words = {"apple"};
        WordFilter wordFilter = new WordFilter(words);

        int index = wordFilter.f("a", "e");
        System.out.println(index);
        Assert.assertEquals(0, index);

        index = wordFilter.f("b", "");
        System.out.println(index);
        Assert.assertEquals(-1, index);

    }
}
