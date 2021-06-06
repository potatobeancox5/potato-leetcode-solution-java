package com.potato.study.leetcodecn.p01859.t001;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;

/**
 * 1859. 将句子排序
 *
 * 一个 句子 指的是一个序列的单词用单个空格连接起来，且开头和结尾没有任何空格。每个单词都只包含小写或大写英文字母。
 *
 * 我们可以给一个句子添加 从 1 开始的单词位置索引 ，并且将句子中所有单词 打乱顺序 。
 *
 * 比方说，句子 "This is a sentence" 可以被打乱顺序得到 "sentence4 a3 is2 This1" 或者 "is2 sentence4 This1 a3" 。
 * 给你一个 打乱顺序 的句子 s ，它包含的单词不超过 9 个，请你重新构造并得到原本顺序的句子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "is2 sentence4 This1 a3"
 * 输出："This is a sentence"
 * 解释：将 s 中的单词按照初始位置排序，得到 "This1 is2 a3 sentence4" ，然后删除数字。
 * 示例 2：
 *
 * 输入：s = "Myself2 Me1 I4 and3"
 * 输出："Me Myself and I"
 * 解释：将 s 中的单词按照初始位置排序，得到 "Me1 Myself2 and3 I4" ，然后删除数字。
 *  
 *
 * 提示：
 *
 * 2 <= s.length <= 200
 * s 只包含小写和大写英文字母、空格以及从 1 到 9 的数字。
 * s 中单词数目为 1 到 9 个。
 * s 中的单词由单个空格分隔。
 * s 不包含任何前导或者后缀空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorting-the-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. s 按照 空格 split
     * 2. sort 按照 word 的最后一个数字进行排序
     * 3. 组装 单词 去掉最后一个 数字
     * @param s
     * @return
     */
    public String sortSentence(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        String[] split = s.split(" ");
        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.charAt(o1.length() - 1) - '0', o2.charAt(o2.length() - 1) - '0');
            }
        });
        StringBuilder builder = new StringBuilder();
        for (String word : split) {
            builder.append(word.substring(0, word.length() - 1)).append(" ");
        }
        // delete last blank
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "is2 sentence4 This1 a3";
        String s = solution.sortSentence(word);
        System.out.println(s);
        Assert.assertEquals("This is a sentence", s);
    }
}
