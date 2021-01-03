package com.potato.study.leetcodecn.p00058.t001;


import org.junit.Assert;

/**
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

 如果不存在最后一个单词，请返回 0 。

 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

  

 示例:

 输入: "Hello World"
 输出: 5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/length-of-last-word
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int lastIndex = s.length() - 1;
        // 找到结束的字符串
        while (lastIndex >= 0) {
            if (!Character.isAlphabetic(s.charAt(lastIndex))) {
                lastIndex--;
            } else {
                break;
            }
        }
        // 从结束字符串开始 计算长度
        int length = 0;
        while (lastIndex >= 0 && Character.isAlphabetic(s.charAt(lastIndex))) {
            lastIndex--;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Hello World";
        int res = solution.lengthOfLastWord(s);
        System.out.println(res);
        Assert.assertEquals(5, res);
    }
}
