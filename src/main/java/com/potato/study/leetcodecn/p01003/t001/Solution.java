package com.potato.study.leetcodecn.p01003.t001;

import org.junit.Assert;

/**
 * 1003. 检查替换后的词是否有效
 *
 * 给你一个字符串 s ，请你判断它是否 有效 。
 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：

 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。注意，tleft 和 tright 可能为 空 。
 如果字符串 s 有效，则返回 true；否则，返回 false。

  

 示例 1：

 输入：s = "aabcbc"
 输出：true
 解释：
 "" -> "abc" -> "aabcbc"
 因此，"aabcbc" 有效。
 示例 2：

 输入：s = "abcabcababcc"
 输出：true
 解释：
 "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 因此，"abcabcababcc" 有效。
 示例 3：

 输入：s = "abccba"
 输出：false
 解释：执行操作无法得到 "abccba" 。
 示例 4：

 输入：s = "cababc"
 输出：false
 解释：执行操作无法得到 "cababc" 。
  

 提示：

 1 <= s.length <= 2 * 104
 s 由字母 'a'、'b' 和 'c' 组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历stringbuilder 每次见到abc 直接删除
     * 然后整理新字符串

     * 最后看会不会某一轮一次都没删除
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean noDelete = false;
        StringBuilder builder = new StringBuilder(s);
        while (!noDelete && builder.length() > 0) {
            // 开始遍历
            StringBuilder tmp = new StringBuilder();
            boolean hasDelete = false;
            for (int i = 0; i < builder.length(); i++) {
                if (i < 2) {
                    tmp.append(builder.charAt(i));
                    continue;
                }
                if (builder.charAt(i) == 'c' && builder.charAt(i-1) == 'b' && builder.charAt(i-2) == 'a') {
                    tmp.deleteCharAt(tmp.length()-1);
                    tmp.deleteCharAt(tmp.length()-1);
                    hasDelete = true;
                } else {
                    tmp.append(builder.charAt(i));
                }
            }
            builder = tmp;
            noDelete = !hasDelete;
        }
        return builder.length() == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aabcbc";
        boolean valid = solution.isValid(s);
        System.out.println(valid);
        Assert.assertEquals(true, valid);

        s = "abcabcababcc";
        valid = solution.isValid(s);
        System.out.println(valid);
        Assert.assertEquals(true, valid);

        s = "aa";
        valid = solution.isValid(s);
        System.out.println(valid);
        Assert.assertEquals(false, valid);
    }
}
