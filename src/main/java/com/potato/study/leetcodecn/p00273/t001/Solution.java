package com.potato.study.leetcodecn.p00273.t001;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 273. 整数转换英文表示
 *
 * 将非负整数 num 转换为其对应的英文表示。

  

 示例 1：

 输入：num = 123
 输出："One Hundred Twenty Three"
 示例 2：

 输入：num = 12345
 输出："Twelve Thousand Three Hundred Forty Five"
 示例 3：

 输入：num = 1234567
 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 示例 4：

 输入：num = 1234567891
 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
  

 提示：

 0 <= num <= 231 - 1


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/integer-to-english-words
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param num
     * @return
     */
    public String numberToWords(int num) {
        int[] numChar = new int[10];
        for (int i = 9; i >= 0; i--) {
            numChar[i] = num % 10;
            num /= 10;
        }
        // 生成字符串
        StringBuilder builder = new StringBuilder();
//        if (numChar[9] != 0) {
//            builder.append().append();
//        }
//        if (numChar[8] != 0) {
//            builder.append().append();
//        }
//        if (numChar[7] != 0) {
//            builder.append().append();
//        }
//        if (numChar[6] != 0) {
//            builder.append().append();
//        }
//        if (numChar[5] != 0) {
//            builder.append().append();
//        }
//        if (numChar[4] != 0) {
//            builder.append().append();
//        }
//        if (numChar[3] != 0) {
//            builder.append().append();
//        }
//        if (numChar[2] != 0) {
//            builder.append().append();
//        }
        if (numChar[1] != 0) {
            getTen(numChar[1]);
        }
        if (numChar[0] != 0) {
            String word = getDigit(numChar[0]);
            builder.append(word).append(" ");
        }
        return builder.toString();
    }

    /**
     * 获取 十位字符串
     * @param i
     */
    private String getTen(int i) {
        switch (i) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "Zero";
    }

//    private String getDozen(int i) {
//        switch (i) {
//            case 2:
//                return "Twenty";
//            case 3:
//                return "Thirty";
//            case 4:
//                return "Forty";
//            case 5:
//                return "Fifty";
//            case 6:
//                return "Sixty";
//            case 7:
//                return "Seventy";
//            case 8:
//                return "Eighty";
//            case 9:
//                return "Ninety";
//        }
//        return "Zero";
//    }

    /**
     * 生成个位数
     * @param i
     * @return
     */
    private String getDigit(int i) {
        switch (i) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "Zero";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String nn = solution.numberToWords(12);
        System.out.println(nn);
        Assert.assertEquals(3, nn);


    }
}

