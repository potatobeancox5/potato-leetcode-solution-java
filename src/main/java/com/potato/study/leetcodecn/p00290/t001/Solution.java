package com.potato.study.leetcodecn.p00290.t001;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

 示例1:

 输入: pattern = "abba", str = "dog cat cat dog"
 输出: true
 示例 2:

 输入:pattern = "abba", str = "dog cat cat fish"
 输出: false
 示例 3:

 输入: pattern = "aaaa", str = "dog cat cat dog"
 输出: false
 示例 4:

 输入: pattern = "abba", str = "dog dog dog dog"
 输出: false
 说明:
 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-pattern
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用一个 map 对一下 单词对应字母，然后
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        if (null == s && null == pattern) {
            return true;
        }
        if ("".equals(s) && "".equals(pattern)) {
            return true;
        }
        String[] split = s.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (map.containsKey(split[i])) {
                // compare
                if (pattern.charAt(i) != map.get(split[i])) {
                    return false;
                }
            } else {
                // 多个 string 对应同一个 字母 识别 字母已经有了 但是 word 还没有
                if (!map.isEmpty() && map.values().contains(pattern.charAt(i))) {
                    return false;
                }
                map.put(split[i], pattern.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String pattern = "abba";
        String s = "dog cat cat dog";
        boolean result = solution.wordPattern(pattern, s);
        System.out.println(result);
        Assert.assertEquals(true, result);
    }
}
