package com.potato.study.leetcodecn.p01190.t001;


import org.junit.Assert;

/**
 * 1190. 反转每对括号间的子串
 *
 * 给出一个字符串 s（仅含有小写英文字母和括号）。

 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

 注意，您的结果中 不应 包含任何括号。

  

 示例 1：

 输入：s = "(abcd)"
 输出："dcba"
 示例 2：

 输入：s = "(u(love)i)"
 输出："iloveu"
 示例 3：

 输入：s = "(ed(et(oc))el)"
 输出："leetcode"
 示例 4：

 输入：s = "a(bcdefghijkl(mno)p)q"
 输出："apmnolkjihgfedcbq"
  

 提示：

 0 <= s.length <= 2000
 s 中只有小写英文字母和括号
 我们确保所有括号都是成对出现的

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     *
     * 递归解法吧
     * 找到左右两边第一个 （） 然后反转中间部分，拼接而成
     *
     * 需要改一下 找到 （） 一组之后 中间的进行 反转处理，然后接着弄之后的
     * @param s
     * @return
     */
    public String reverseParentheses(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int left = 0;
        int right = s.length() - 1;
        // 找到匹配的括号
        int status = 0;
        boolean hasFoundPosition = false;
        // 左边的括号
        while (left < s.length() && s.charAt(left) != '(') {
            left++;
        }
        for (int i = left; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('(' == ch) {
                status++;
            } else if (')' == ch) {
                status--;
            }
            // 遇到平衡位置
            if (status == 0) {
                right = i;
                hasFoundPosition = true;
                break;
            }
        }
        if (!hasFoundPosition) {
            return s;
        }
        // 找到了 反转的位置
        String leftStr = s.substring(0, left);
        String rightStr = s.substring(right + 1);
        String inner = reverseParentheses(s.substring(left + 1, right));
        StringBuilder builder = new StringBuilder(inner);
        // 组成新的字符串
        s = leftStr + builder.reverse().toString() + rightStr;
        return reverseParentheses(s);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "(abcd)";
        String s = solution.reverseParentheses(word);
        System.out.println(s);
        Assert.assertEquals("dcba", s);


        word = "(u(love)i)";
        s = solution.reverseParentheses(word);
        System.out.println(s);
        Assert.assertEquals("iloveu", s);


        word = "ta()usw((((a))))";
        s = solution.reverseParentheses(word);
        System.out.println(s);
        Assert.assertEquals("tauswa", s);
    }

}
