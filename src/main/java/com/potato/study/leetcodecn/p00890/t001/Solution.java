package com.potato.study.leetcodecn.p00890.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

/**
 * 890. 查找和替换模式
 *
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 *
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 *
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 *
 * 返回 words 中与给定模式匹配的单词列表。
 *
 * 你可以按任何顺序返回答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-and-replace-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     *
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String commonPattern = getCommonPattern(pattern);
        List<String> result = new ArrayList<>();
        for (String word : words) {
            String wordPattern = getCommonPattern(word);
            if (commonPattern.equals(wordPattern)) {
                result.add(word);
            }
        }
        return result;
    }

    /**
     * 生成 common pattern
     * 规则 使用 map记录 出现 char 和 他的index
     * @param pattern
     * @return
     */
    private String getCommonPattern(String pattern) {
        StringBuilder builder = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            Integer index = map.get(ch);
            if (index == null) {
                index = map.size();
                map.put(ch, index);
            }
            builder.append(index).append("_");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[] {
                "abc","deq","mee","aqq","dkd","ccc"
        };
        String pattern = "abb";
        List<String> list = solution.findAndReplacePattern(words,pattern);
        System.out.println(list);
    }
}
