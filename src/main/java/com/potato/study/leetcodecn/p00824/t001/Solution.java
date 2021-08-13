package com.potato.study.leetcodecn.p00824.t001;

import org.junit.Assert;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 824. 山羊拉丁文
 *
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。

 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。

 山羊拉丁文的规则如下：

 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 例如，单词"apple"变为"applema"。

 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 例如，单词"goat"变为"oatgma"。

 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 返回将 S 转换为山羊拉丁文后的句子。

 示例 1:

 输入: "I speak Goat Latin"
 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 示例 2:

 输入: "The quick brown fox jumped over the lazy dog"
 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 说明:

 S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
 1 <= S.length <= 150。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/goat-latin
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param sentence
     * @return
     */
    public String toGoatLatin(String sentence) {
        // 解析出来单词 直接空格分割
        String[] split = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        // 遍历每个单词 生成 山羊文
        for (int i = 0; i < split.length; i++) {
            String target = getGoatLatin(split[i], i);
            builder.append(target).append(" ");
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    /**
     * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
     * 例如，单词"apple"变为"applema"。
     *
     *
     * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
     * 例如，单词"goat"变为"oatgma"。
     *
     * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
     * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
     *
     * @param word
     * @return
     */
    private String getGoatLatin(String word, int index) {
        StringBuilder builder = new StringBuilder();
        char first = Character.toLowerCase(word.charAt(0));
        if (first == 'a' || first == 'e' || first == 'i'
                || first == 'o' || first == 'u') {
            builder.append(word)
                    .append("ma");
        } else {
            // 辅音开头
            builder.append(word.substring(1))
                    .append(word.charAt(0))
                    .append("ma");
        }
        for (int i = 0; i <= index; i++) {
            builder.append('a');
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "I speak Goat Latin";
        String s = solution.toGoatLatin(input);
        System.out.println(s);
        Assert.assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", s);
    }
}
