package com.potato.study.leetcodecn.p00030.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

  

 示例 1：

 输入：
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 输出：[0,9]
 解释：
 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 输出的顺序不重要, [9,0] 也是有效答案。
 示例 2：

 输入：
 s = "wordgoodgoodgoodbestword",
 words = ["word","good","best","word"]
 输出：[]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * 每个字母index 开始 找 每次 找 words 中单词的长度
     *
     * 使用一个 map 计数 单词是否出现，以及出现的次数，每个在map 中刨除单词
     *
     * 剪枝
     * 1. 如果 位置index 到末尾长度 小于 set 中还剩下单词个数，返回无法匹配
     * 2. 如果当前位置 不在 set 中 ，往后找一个位置
     * 3. 如果当前位置 在 set 中 深度优先搜索 往后找 找到了 生成结果 返回，
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (null == words) {
            return result;
        }
        // 制作次数map
        int wordLen = 0;
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            Integer count = wordCountMap.getOrDefault(word, 0);
            count++;
            wordCountMap.put(word, count);
            wordLen = word.length();
        }
        // 遍历数组 对于每个位置进行深度优先搜索
        for (int i = 0; i < s.length(); i++) {
            // 1. 如果 位置index 到末尾长度 小于 set 中还剩下单词个数，返回无法匹配
            if (s.length() - i < wordLen * words.length) {
                break;
            }
            // 2.  如果当前位置 不在 set 中 ，往后找一个位置 如果当前位置 在 set 中 深度优先搜索 往后找 找到了 生成结果 加入结果集
            if (canCompositeByWord(s, i, wordCountMap, wordLen)) {
                result.add(i);
            }
        }
        return result;
    }


    /**
     *
     * @param s             原始字符串
     * @param startIndex    匹配开始的位置
     * @param wordCountMap  待匹配的单词集合 + 出现次数
     * @param wordLen       每个单词的长度
     * @return
     */
    private boolean canCompositeByWord (String s, int startIndex, Map<String, Integer> wordCountMap, int wordLen) {
        // 单独弄一个 map 用来匹配
        wordCountMap = new HashMap<>(wordCountMap);
        int i = startIndex;
        while (i < s.length()) {
            // i 开始的一个单词 匹配一下
            String word = s.substring(i, i + wordLen);
            if (!wordCountMap.containsKey(word)) {
                return false;
            }
            Integer count = wordCountMap.get(word);
            count--;
            if (count == 0) {
                wordCountMap.remove(word);
            } else {
                wordCountMap.put(word, count);
            }
            // 如果此时已经完全匹配 返回 true
            if (wordCountMap.isEmpty()) {
                return true;
            }
            // i 移动
            i = i + wordLen;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "barfoothefoobarman";
        String[] words = new String[] {"foo","bar"};
        List<Integer> substring = solution.findSubstring(s, words);
        System.out.println(substring);

        s = "wordgoodgoodgoodbestword";
        words = new String[] {"word","good","best","word"};
        substring = solution.findSubstring(s, words);
        System.out.println(substring);
    }

}
