package com.potato.study.leetcodecn.p01556.t001;

import org.junit.Assert;

/**
 * 1556. 千位分隔数
 *
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。

  

 示例 1：

 输入：n = 987
 输出："987"
 示例 2：

 输入：n = 1234
 输出："1.234"
 示例 3：

 输入：n = 123456789
 输出："123.456.789"
 示例 4：

 输入：n = 0
 输出："0"
  

 提示：

 0 <= n < 2^31

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/thousand-separator
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 千位分隔符
     * @param n
     * @return
     */
    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (n > 0) {
            if (index != 0 && index % 3 == 0) {
                builder.append(".");
            }
            int bit = n % 10;
            builder.append(bit);
            index++;
            n /= 10;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 987;
        String s = solution.thousandSeparator(n);
        System.out.println(s);
        Assert.assertEquals("987", s);


        n = 1234;
        s = solution.thousandSeparator(n);
        System.out.println(s);
        Assert.assertEquals("1.234", s);
    }
}
