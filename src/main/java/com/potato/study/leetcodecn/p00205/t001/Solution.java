package com.potato.study.leetcodecn.p00205.t001;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。

 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

  

 示例 1:

 输入：s = "egg", t = "add"
 输出：true
 示例 2：

 输入：s = "foo", t = "bar"
 输出：false
 示例 3：

 输入：s = "paper", t = "title"
 输出：true
  

 提示：

 可以假设 s 和 t 长度相同。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/isomorphic-strings
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 判定 字符串 是够同构 使用一个 map
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (null == s && null == t) {
            return true;
        }
        if ("".equals(s) && "".equals(t)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                // 判定反向映射
                if (!map.isEmpty() && map.values().contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "egg";
        String t = "add";
        boolean res = solution.isIsomorphic(s, t);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
