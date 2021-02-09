package com.potato.study.leetcodecn.p00139.t001;

import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.List;

/**
 * 139. 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

 说明：

 拆分时可以重复使用字典中的单词。
 你可以假设字典中没有重复的单词。
 示例 1：

 输入: s = "leetcode", wordDict = ["leet", "code"]
 输出: true
 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 示例 2：

 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 输出: true
 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
      注意你可以重复使用字典中的单词。
 示例 3：

 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-break
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * bool match[i] 从 0到i 位置 是否都能匹配上
     * match 每个位置 i fore wordDict 如果 x - i 可以与 word 匹配 那么 可以判定是不是第一个单词
     * 是的话 true 不是的话 遗传 之前位置 的状态
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] match = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() > i + 1) {
                    continue;
                }
                // 判定是否匹配
                String source = s.substring(i + 1 - word.length(), i + 1);
                if (!source.equals(word)) {
                    continue;
                }
                if (0 == i + 1 - word.length()) {
                    // 匹配的上 判定 是不是从 0 开始的
                    match[i] = true;
                } else {
                    // 不是从零开始的 那就是之前的状态
                    match[i] = match[i - word.length()];
                }
                // 找到 true 就不找了
                if (match[i]) {
                    break;
                }
            }
        }
        return match[s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = Lists.newArrayList("leet", "code");
        boolean res = solution.wordBreak(s, wordDict);
        System.out.println(res);
        Assert.assertEquals(true, res);

        s = "applepenapple";
        wordDict = Lists.newArrayList("apple", "pen");
        res = solution.wordBreak(s, wordDict);
        System.out.println(res);
        Assert.assertEquals(true, res);

        s = "catsandog";
        wordDict = Lists.newArrayList("cats", "dog", "sand", "and", "cat");
        res = solution.wordBreak(s, wordDict);
        System.out.println(res);
        Assert.assertEquals(false, res);

        s = "dogs";
        wordDict = Lists.newArrayList("dog","s","gs");
        res = solution.wordBreak(s, wordDict);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
