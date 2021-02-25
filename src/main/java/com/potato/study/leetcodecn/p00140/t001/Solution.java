package com.potato.study.leetcodecn.p00140.t001;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 140. 单词拆分 II
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

 说明：

 分隔时可以重复使用字典中的单词。
 你可以假设字典中没有重复的单词。
 示例 1：

 输入:
 s = "catsanddog"
 wordDict = ["cat", "cats", "and", "sand", "dog"]
 输出:
 [
   "cats and dog",
   "cat sand dog"
 ]
 示例 2：

 输入:
 s = "pineapplepenapple"
 wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 输出:
 [
   "pine apple pen apple",
   "pineapple pen apple",
   "pine applepen apple"
 ]
 解释: 注意你可以重复使用字典中的单词。
 示例 3：

 输入:
 s = "catsandog"
 wordDict = ["cats", "dog", "sand", "and", "cat"]
 输出:
 []

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-break-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 其实也是 动态规划 方法和 139 类似 只是 记录结果的矩阵由bool型 变成String 类型
     * List<List<String> result i 记录 从 0 到 i 能被 wordDict 中串构造出来的 可能结果
     *
     * result i =  wordDict 中每个单词 word i- word.len  result[i- word.len] 并集
     *
     * 返回 result.get(s.len -1 )
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] result = new List[s.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                // 超出了 0-i的长度
                if (i + 1 < word.length()) {
                    continue;
                }
                String target = s.substring(i + 1 - word.length(), i + 1);
                // 对不上
                if (!target.equals(word)) {
                    continue;
                }
                if (i + 1 - word.length() == 0) {
                    // 对上了 看是否是第一个 或者是并
                    result[i].add(new String(word));
                } else {
                    // 不是第一个对上的单词 要看 之前有没有结果，没有也不行
                    if (result[i - word.length()].size() == 0) {
                        continue;
                    }
                    // 获取到之前的结果 生成新的结果 合并入目前的集合
                    for (String temp : result[i - word.length()]) {
                        result[i].add(temp + " " + target);
                    }
                }
            }
        }
        return result[s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "catsanddog";
        List<String> wordDict = Lists.newArrayList("cat", "cats", "and", "sand", "dog");
        List<String> list = solution.wordBreak(s, wordDict);
        System.out.println(list);


        s = "pineapplepenapple";
        wordDict = Lists.newArrayList("apple", "pen", "applepen", "pine", "pineapple");
        list = solution.wordBreak(s, wordDict);
        System.out.println(list);
    }
}
