package com.potato.study.leetcode.util;

import org.junit.Test;

import java.util.Arrays;

/**
 * leetcode 题目中输入生成的工具类
 */
public class LeetcodeInputUtils {


    /**
     * deadends = ["0201","0101","0102","1212","2002"]
     * 测试用例
     * []
     * null
     * 返回 string 数组
     * @param input
     * @return
     */
    public static String[] inputString2StringArray(String input) {
        if (input == null) {
            return null;
        }
        if ("".equals(input) || "[]".equals(input)) {
            return new String[0];
        }
        // 去掉"[]"
        String substring = input.substring(1, input.length() - 1);
        // ，拆分
        String[] split = substring.split(",");
        // 去掉引号
        String[] result = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            String word = split[i].trim();
            word = word.substring(1, word.length() - 1);
            result[i] = word;
        }
        // 返回数组
        return result;
    }


    @Test
    public void testInputString2StringArray() {
        String input = "[\"0201\",\"0101\",\"0102\",\"1212\",\"2002\"]";
        String[] array = inputString2StringArray(input);
        System.out.println(Arrays.toString(array));
    }
}
