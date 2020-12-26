package com.potato.study.leetcodecn.p0067.t001;


import org.junit.Assert;

/**
 * 67. 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。

 输入为 非空 字符串且只包含数字 1 和 0。

  

 示例 1:

 输入: a = "11", b = "1"
 输出: "100"
 示例 2:

 输入: a = "1010", b = "1011"
 输出: "10101"
  

 提示：

 每个字符串仅由字符 '0' 或 '1' 组成。
 1 <= a.length, b.length <= 10^4
 字符串如果不是 "0" ，就都不含前导零。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-binary
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 求和就求和 从最后位置向前进行加和
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        boolean needAddOne = false;
        StringBuilder builder = new StringBuilder();
        while (index1 >= 0 && index2 >= 0) {
            int num1 = a.charAt(index1) - '0';
            int num2 = b.charAt(index2) - '0';
            int total = num1 + num2;
            if (needAddOne) {
                total++;
            }
            if (total >= 2) {
                needAddOne = true;
                total %= 2;
            } else {
                needAddOne = false;
            }
            builder.insert(0, total);
            index1--;
            index2--;
        }
        // 只有一个没有到0
        needAddOne = dealWithOneStr(a, index1, needAddOne, builder);
        needAddOne = dealWithOneStr(b, index2, needAddOne, builder);
        if (needAddOne) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }

    /**
     * 处理一个字符串耗尽，另一个字符串还存在的情况
     * @param b
     * @param index2
     * @param needAddOne
     * @param builder
     * @return
     */
    private boolean dealWithOneStr(String b, int index2, boolean needAddOne, StringBuilder builder) {
        while (index2 >= 0) {
            int num2 = b.charAt(index2) - '0';
            int total = num2;
            if (needAddOne) {
                total++;
            }
            if (total >= 2) {
                needAddOne = true;
                total %= 2;
            } else {
                needAddOne = false;
            }
            builder.insert(0, total);
            index2--;
        }
        return needAddOne;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "11";
        String b = "1";
        String res = solution.addBinary(a, b);
        System.out.println(res);
        Assert.assertEquals("100", res);

        a = "1010";
        b = "1011";
        res = solution.addBinary(a, b);
        System.out.println(res);
        Assert.assertEquals("10101", res);


        a = "1";
        b = "111";
        res = solution.addBinary(a, b);
        System.out.println(res);
        Assert.assertEquals("1000", res);


    }
}
