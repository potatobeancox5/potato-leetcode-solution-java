package com.potato.study.leetcodecn.p00316.t001;

import org.junit.Assert;

/**
 * 316. 去除重复字母
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

  

 示例 1：

 输入：s = "bcabc"
 输出："abc"
 示例 2：

 输入：s = "cbacdcbc"
 输出："acdb"
  

 提示：

 1 <= s.length <= 104
 s 由小写英文字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 有个要求就是按照字典顺序
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        boolean[] appear = new boolean[26];
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            // 没有出现重复 直接插入
            if (!appear[ch - 'a']) {
                appear[ch - 'a'] = true;
                builder.append(ch);
            } else {
                // 出现了重复 找到之前的位置 如果 之后的位置存在比他小的 那么删除 这个元素 往最后加上他
                int index = -1;
                for (int i = 0; i < builder.length(); i++) {
                    if (builder.charAt(i) == ch) {
                        index = i;
                        break;
                    }
                }

                for (int i = index + 1; i < builder.length(); i++) {
                    // 相等
                    if (builder.charAt(i) < ch) {
                        builder.deleteCharAt(index);
                        builder.append(ch);

                    }
                    // 不满足直接返回只比较一个位置
                    break;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "bcabc";
        String s = solution.removeDuplicateLetters(input);
        System.out.println(s);
        Assert.assertEquals("abc", s);


        input = "cbacdcbc";
        s = solution.removeDuplicateLetters(input);
        System.out.println(s);
        Assert.assertEquals("acdb", s);
    }
}
