package com.potato.study.leetcodecn.p00387.t001;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

  

 示例：

 s = "leetcode"
 返回 0

 s = "loveleetcode"
 返回 2
  

 提示：你可以假定该字符串只包含小写字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 找到 第一个 不重复的字符
     * 从后往前 如果历史字符 set 里没有这个 字母，记下index 并 放入set
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = countMap.getOrDefault(c, 0);
            count++;
            countMap.put(c, count);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = countMap.get(c);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
}
