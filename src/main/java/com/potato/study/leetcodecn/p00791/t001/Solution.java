package com.potato.study.leetcodecn.p00791.t001;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 791. 自定义字符串排序
 *
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。

 S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。

 返回任意一种符合条件的字符串T。

 示例:
 输入:
 S = "cba"
 T = "abcd"
 输出: "cbad"
 解释:
 S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 注意:

 S的最大长度为26，其中没有重复的字符。
 T的最大长度为200。
 S和T只包含小写字符。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/custom-sort-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 统计 str 中的字母出现次数
     * @param order
     * @param str
     * @return
     */
    public String customSortString(String order, String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            Integer count = countMap.getOrDefault(ch, 0);
            count++;
            countMap.put(ch, count);
        }
        // 遍历 order 每次都从 map 中获取单词
        StringBuilder builder = new StringBuilder();
        for (char ch : order.toCharArray()) {
            Integer count = countMap.remove(ch);
            if (count == null) {
                continue;
            }
            for (int i = 0; i < count; i++) {
                builder.append(ch);
            }
        }
        // 哪些没有用到的字符
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                builder.append(entry.getKey());
            }
        }
        return builder.toString();
    }
}
