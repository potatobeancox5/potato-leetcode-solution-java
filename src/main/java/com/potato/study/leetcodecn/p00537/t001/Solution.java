package com.potato.study.leetcodecn.p00537.t001;


import org.junit.Assert;

/**
 * 537. 复数乘法
 *
 * 给定两个表示复数的字符串。

 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。

 示例 1:

 输入: "1+1i", "1+1i"
 输出: "0+2i"
 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 示例 2:

 输入: "1+-1i", "1+-1i"
 输出: "0+-2i"
 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 注意:

 输入字符串不包含额外的空格。
 输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/complex-number-multiplication
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. ab 按照 + 分割
     * 2. a = a1 + b1i , b = a2 + b2i 分别提取 a1 a2 b1 b2
     * 3. 计算 a1a2 - b1b2 和 a1b2 + a2b1
     * 4. 组成新的结果
     * @param a
     * @param b
     * @return
     */
    public String complexNumberMultiply(String a, String b) {
        String[] split1 = a.split("\\+");
        String[] split2 = b.split("\\+");
        int a1 = Integer.parseInt(split1[0]);
        int b1 = Integer.parseInt(split1[1].substring(0, split1[1].length() - 1));
        int a2 = Integer.parseInt(split2[0]);
        int b2 = Integer.parseInt(split2[1].substring(0, split2[1].length() - 1));

        int real = a1 * a2 - b1 * b2;
        int imaginary = a1 * b2 + a2 * b1;

        StringBuilder builder = new StringBuilder();
        builder.append(real).append("+").append(imaginary).append("i");
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "1+1i";
        String b = "1+1i";
        String s = solution.complexNumberMultiply(a, b);
        System.out.println(s);
        Assert.assertEquals("0+2i", s);

        a = "1+-1i";
        b = "1+-1i";
        s = solution.complexNumberMultiply(a, b);
        System.out.println(s);
        Assert.assertEquals("0+-2i", s);
    }

}
