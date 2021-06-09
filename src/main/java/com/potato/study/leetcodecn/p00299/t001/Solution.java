package com.potato.study.leetcodecn.p00299.t001;


import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 299. 猜数字游戏
 *
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：

 你写出一个秘密数字，并请朋友猜这个数字是多少。
 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 朋友根据提示继续猜，直到猜出秘密数字。
 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。

 xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。

  

 示例 1:

 输入: secret = "1807", guess = "7810"
 输出: "1A3B"
 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 示例 2:

 输入: secret = "1123", guess = "0111"
 输出: "1A1B"
 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
  

 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/bulls-and-cows
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     * 1. 遍历 一遍 如果 位置相同 A 增加
     * 2. 如果位置不同 计数 count 26 数组 比较各个位置小的数字 sum
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {

        if (null == secret || guess == null) {
            throw new RuntimeException("输入异常");
        }

        if ("".equals(secret) || "".equals(guess)
                || secret.length() != guess.length()) {
            throw new RuntimeException("输入异常");
        }
        int length = secret.length();
        int sameCount = 0;
        int[] count1 = new int[10];
        int[] count2 = new int[10];
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                sameCount++;
            } else {
                count1[secret.charAt(i) - '0']++;
                count2[guess.charAt(i) - '0']++;
            }
        }
        int sameCharCount = 0;
        for (int i = 0; i < 10; i++) {
            sameCharCount += Math.min(count1[i], count2[i]);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(sameCount)
                .append("A")
                .append(sameCharCount)
                .append("B");
        return builder.toString();
    }
}
