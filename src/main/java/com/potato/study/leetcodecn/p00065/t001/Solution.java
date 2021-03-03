package com.potato.study.leetcodecn.p00065.t001;


import org.junit.Assert;

/**
 * 65. 有效数字
 *
 * 有效数字（按顺序）可以分成以下几个部分：

 一个 小数 或者 整数
 （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 小数（按顺序）可以分成以下几个部分：

 （可选）一个符号字符（'+' 或 '-'）
 下述格式之一：
 至少一位数字，后面跟着一个点 '.'
 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 一个点 '.' ，后面跟着至少一位数字
 整数（按顺序）可以分成以下几个部分：

 （可选）一个符号字符（'+' 或 '-'）
 至少一位数字
 部分有效数字列举如下：

 ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 部分无效数字列举如下：

 ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。

  

 示例 1：

 输入：s = "0"
 输出：true
 示例 2：

 输入：s = "e"
 输出：false
 示例 3：

 输入：s = "."
 输出：false
 示例 4：

 输入：s = ".1"
 输出：true
  

 提示：

 1 <= s.length <= 20
 s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1 一个 小数 或者 整数
     * 2 （可选）一个 'e' 或 'E' ，后面跟着一个 整数
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (null == s) {
            return false;
        }
        if (s.contains("E") || s.contains("e")) {
            s = s.toLowerCase();
            // 如果有多个e
            int eCount = 0;
            for (char ch : s.toCharArray()) {
                if (ch == 'e') {
                    eCount++;
                }
            }
            if (eCount > 1) {
                return false;
            }
            String[] split = s.split("e");
            if (split.length != 2) {
                return false;
            }
            // 一个 小数 或者 整数 e 整数
            return (isValidDecimal(split[0]) || isValidInteger(split[0])) && isValidInteger(split[1]);
        } else {
            return isValidDecimal(s) || isValidInteger(s);
        }
    }

    /**
     * 是否有效整数
     * （可选）一个符号字符（'+' 或 '-'）
     * 至少一位数字
     * @param s
     * @return
     */
    private boolean isValidInteger(String s) {
        if (s.length() < 1) {
            return false;
        }
        // 符号位置
        int numIndex = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            numIndex++;
        }
        String numStr = s.substring(numIndex);
        // 至少一个数字
        if (numStr.length() < 1) {
            return false;
        }
        // 如果已0 开始 就不行了
        if (numStr.equals("0")) {
            return true;
        }
        for (int i = 0; i < numStr.length(); i++) {
            // 整数中出现了不是数字的 就返回非法
            if (!Character.isDigit(numStr.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否有效的小数
     * （可选）一个符号字符（'+' 或 '-'）
     下述格式之一：
     至少一位数字，后面跟着一个点 '.'
     至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     一个点 '.' ，后面跟着至少一位数字

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/valid-number
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    private boolean isValidDecimal(String s) {
        // 没有点就尴尬了
        if (!s.contains(".")) {
            return false;
        }
        // 符号位置
        int numIndex = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            numIndex++;
        }
        // 生成数字传
        String numStr = s.substring(numIndex);
        if (numStr.startsWith(".")) {
            return atLeastADigit(numStr.substring(1));
        } else if (numStr.endsWith(".")) {
            return atLeastADigit(numStr.substring(0, numStr.length() - 1));
        }
        String[] split = numStr.split("\\.");
        if (split.length != 2) {
            return false;
        }
        return atLeastADigit(split[0]) && atLeastADigit(split[1]);
    }

    /**
     * 是否至少一个数字
     * @param num
     * @return
     */
    private boolean atLeastADigit(String num) {
        if (num.length() == 0) {
            return false;
        }
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "0";
        boolean res = solution.isNumber(s);
        System.out.println(res);
        Assert.assertEquals(res, true);


        s = ".1";
        res = solution.isNumber(s);
        System.out.println(res);
        Assert.assertEquals(res, true);


        s = "01";
        res = solution.isNumber(s);
        System.out.println(res);
        Assert.assertEquals(res, true);


        s = "0..";
        res = solution.isNumber(s);
        System.out.println(res);
        Assert.assertEquals(res, false);

        s = "3.";
        res = solution.isNumber(s);
        System.out.println(res);
        Assert.assertEquals(res, true);


        s = "-3.";
        res = solution.isNumber(s);
        System.out.println(res);
        Assert.assertEquals(res, true);

        s = "-03";
        res = solution.isNumber(s);
        System.out.println(res);
        Assert.assertEquals(res, true);

        s = "7e69e";
        res = solution.isNumber(s);
        System.out.println(res);
        Assert.assertEquals(res, false);
    }
}
