package com.potato.study.leetcodecn.p00043.t001;

import org.junit.Assert;

/**
 * 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

 示例 1:

 输入: num1 = "2", num2 = "3"
 输出: "6"
 示例 2:

 输入: num1 = "123", num2 = "456"
 输出: "56088"
 说明：

 num1 和 num2 的长度小于110。
 num1 和 num2 只包含数字 0-9。
 num1 和 num2 均不以零开头，除非是数字 0 本身。
 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/multiply-strings
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 先个位乘法再算加法
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num2) || "0".equals(num1)) {
            return "0";
        }
        // 遍历 num2 的每个 位置 求基础
        int index = num2.length() - 1;
        int zeroCount = 0;
        String result = "0";
        while (index >= 0) {
            char num2Char = num2.charAt(index);
            String target = this.multiplyBy(num1, num2Char, zeroCount);
            result = plus(result, target);
            index--;
            zeroCount++;
        }
        return result;
    }


    /**
     * num1 * num2 进位并在末尾补上0
     * @param num1Str
     * @param ch2    ch2 只能有一个数字
     * @param zeroCount
     * @return
     */
    private String multiplyBy(String num1Str, char ch2, int zeroCount) {
        if ('0' == ch2){
            return "0";
        }
        int index = num1Str.length() - 1;
        long process = 0;
        long num2 = (ch2 - '0');
        StringBuilder builder = new StringBuilder();
        while (index >= 0) {
            char cc = num1Str.charAt(index);
            long num1 = cc - '0';
            long res = num1 * num2 + process;
            if (res >= 10) {
                process = res / 10;
                res %= 10;
            } else {
                process = 0;
            }
            builder.insert(0, res);
            index--;
        }
        if (process > 0) {
            builder.insert(0, process);
        }
        // 填充 0
        for (int i = 0; i < zeroCount; i++) {
            builder.append(0);
        }
        return builder.toString();
    }

    /**
     * 求和
     * @param num1
     * @param num2
     * @return
     */
    private String plus(String num1, String num2) {
        boolean process = false;
        StringBuilder builder = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        while (index1 >= 0 && index2 >= 0) {
            long n1 = num1.charAt(index1) - '0';
            long n2 = num2.charAt(index2) - '0';
            long tmp = n1 + n2;
            if (process) {
                tmp++;
            }
            if (tmp > 9) {
                tmp %= 10;
                process = true;
            } else {
                process = false;
            }
            builder.insert(0, tmp);
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            long n1 = num1.charAt(index1) - '0';
            long tmp = n1;
            if (process) {
                tmp++;
            }
            if (tmp > 9) {
                tmp %= 10;
                process = true;
            } else {
                process = false;
            }
            builder.insert(0, tmp);
            index1--;
        }
        while (index2 >= 0) {
            long n2 = num2.charAt(index2) - '0';
            long tmp = n2;
            if (process) {
                tmp++;
            }
            if (tmp > 9) {
                tmp %= 10;
                process = true;
            } else {
                process = false;
            }
            builder.insert(0, tmp);
            index2--;
        }
        if (process) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String num1 = "2";
        String num2 = "3";
        String multiply = solution.multiply(num1, num2);
        System.out.println(multiply);
        Assert.assertEquals("6", multiply);

        num1 = "123";
        num2 = "456";
        multiply = solution.multiply(num1, num2);
        System.out.println(multiply);
        Assert.assertEquals("56088", multiply);

//        num1 = "123456789";
//        num2 = "987654321";
//        multiply = solution.multiply(num1, num2);
//        System.out.println(multiply);
//        Assert.assertEquals("121932631112635269", multiply);


        num1 = "123456789";
        num2 = "3";
        multiply = solution.multiply(num1, num2);
        System.out.println(multiply);
        Assert.assertEquals("370370367", multiply);


    }
}
