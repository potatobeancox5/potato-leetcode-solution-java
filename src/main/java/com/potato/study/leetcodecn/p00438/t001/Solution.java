package com.potato.study.leetcodecn.p00438.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

 说明：

 字母异位词指字母相同，但排列不同的字符串。
 不考虑答案输出的顺序。
 示例 1:

 输入:
 s: "cbaebabacd" p: "abc"

 输出:
 [0, 6]

 解释:
 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
  示例 2:

 输入:
 s: "abab" p: "ab"

 输出:
 [0, 1, 2]

 解释:
 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 计数 滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (null == s || null == p) {
            return list;
        }
        int len = p.length();
        int[] count = getCount(p);
        for (int i = 0; i < s.length(); i++) {
            if (i + len > s.length()) {
                continue;
            }
            String substring = s.substring(i, i + len);
            int[] countSub = getCount(substring);
            if (isSame(count, countSub)) {
                list.add(i);
            }
        }
        return list;
    }

    private int[] getCount(String word) {
        int[] count = new int[26];
        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }
        return count;
    }

    private boolean isSame(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = solution.findAnagrams(s, p);
        System.out.println(anagrams);
    }

}
