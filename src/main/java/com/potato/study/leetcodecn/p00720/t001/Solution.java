package com.potato.study.leetcodecn.p00720.t001;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 720. 词典中最长的单词
 *
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。

 若无答案，则返回空字符串。

  

 示例 1：

 输入：
 words = ["w","wo","wor","worl", "world"]
 输出："world"
 解释：
 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 示例 2：

 输入：
 words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 输出："apple"
 解释：
 "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
  

 提示：

 所有输入的字符串都只包含小写字母。
 words数组长度范围为[1,1000]。
 words[i]的长度范围为[1,30]。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        // 用set 存储所有单词
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        // 依次比较前缀 是否在set 中 都在的话 就是所求
        String maxLenWord = "";
        for (String word : words) {
            if (word.length() == 1) {
                if (maxLenWord.length() < word.length()) {
                    maxLenWord = word;
                }
                continue;
            }
            boolean isValid = true;
            for (int i = 1; i < word.length(); i++) {
                if (!set.contains(word.substring(0, i))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                if (maxLenWord.length() < word.length()) {
                    maxLenWord = word;
                } else if (maxLenWord.length() == word.length() && maxLenWord.compareTo(word) > 0) {
                    // 字典序
                    maxLenWord = word;
                }
            }
        }
        return maxLenWord;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str = new String[] {
                "w","wo","wor","worl", "world"
        };
        String s = solution.longestWord(str);
        System.out.println(s);
        Assert.assertEquals(s, "world");

        str = new String[] {
                "m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"
        };
        s = solution.longestWord(str);
        System.out.println(s);
        Assert.assertEquals(s, "latte");
    }
}
