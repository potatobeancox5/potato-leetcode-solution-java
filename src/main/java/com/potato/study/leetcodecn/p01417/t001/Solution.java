package com.potato.study.leetcodecn.p01417.t001;

import org.junit.Assert;

/**
 * 1417. 重新格式化字符串
 *
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。

 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。

 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。

  

 示例 1：

 输入：s = "a0b1c2"
 输出："0a1b2c"
 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 示例 2：

 输入：s = "leetcode"
 输出：""
 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 示例 3：

 输入：s = "1229857369"
 输出：""
 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 示例 4：

 输入：s = "covid2019"
 输出："c2o0v1i9d"
 示例 5：

 输入：s = "ab123"
 输出："1a2b3"
  

 提示：

 1 <= s.length <= 500
 s 仅由小写英文字母和/或数字组成。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reformat-the-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 重新生成一个字符串 要求 其中 字母和数字是相间隔的
     * 先统计下字母和数字的个数，判断是否可以达成目标，
     * 可以的话
     * 遍历s 对于每个位置i 如果是字母，填入字母所在位置，如果是数字填入数字所在位置
     *
     * @param s
     * @return
     */
    public String reformat(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int charNum = 0;
        int numNum = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                charNum++;
            } else {
                numNum++;
            }
        }
        // 判断是否可以达成目标
        if (Math.abs(charNum - numNum) > 1) {
            // 超过了 2个字母的差距 无法安置
            return "";
        }
        int charStartIndex;
        int numStartIndex;
        if (charNum > numNum) {
            charStartIndex = 0;
            numStartIndex = 1;
        } else {
            numStartIndex = 0;
            charStartIndex = 1;
        }
        char[] chArr = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                chArr[charStartIndex] = ch;
                charStartIndex += 2;
            } else {
                chArr[numStartIndex] = ch;
                numStartIndex += 2;
            }
        }
        return new String(chArr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String reformat = solution.reformat("a0b1c2");
        System.out.println(reformat);
        Assert.assertEquals("0a1b2c", reformat);


        reformat = solution.reformat("leetcode");
        System.out.println(reformat);
        Assert.assertEquals("", reformat);
    }
}
