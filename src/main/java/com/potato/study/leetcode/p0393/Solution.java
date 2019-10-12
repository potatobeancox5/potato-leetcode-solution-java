package com.potato.study.leetcode.p0393;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *       393. UTF-8 Validation
 * 
 *     A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

For 1-byte character, the first bit is a 0, followed by its unicode code.
For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
This is how the UTF-8 encoding would work:

Char. number range  |        UTF-8 octet sequence
(hexadecimal)    |              (binary)
--------------------+---------------------------------------------
0000 0000-0000 007F | 0xxxxxxx
0000 0080-0000 07FF | 110xxxxx 10xxxxxx
0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
Given an array of integers representing the data, return whether it is a valid utf-8 encoding.

Note:
The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.

Example 1:

data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.

Return true.
It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
Example 2:

data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.

Return false.
The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
The next byte is a continuation byte which starts with 10 and that's correct.
But the second continuation byte does not start with 10, so it is invalid.
 *         
 *         思路：
 *         注意data 是一个字符串
 *         需要通过判断第一个数之后才能确定是否ok
 *
 *
 *         
 */
public class Solution {


    /**
     * 判断一个字符是否买组utf-8 编码规则
     * @param data
     * @return
     */
    private boolean validUtf8ForSingleChar(int[] data) {
        if (null == data || data.length == 0) {
            return false;
        }
        // 1 byte
        if (data.length == 1) {
            int max = 0b1111111;
            int min = 0;
            if (data[0] >= min && data[0] <= max) {
                return true;
            } else {
                return false;
            }
        }
        // 多余1个bit
        // 1. 构造第一个bit的最小数字
        int oneBitCount = data.length;
        StringBuilder sb = new StringBuilder("00000000");
        for (int i = 0; i < oneBitCount; i++) {
            sb.replace(i, i+1, "1");
        }
        int min = Integer.parseInt(sb.toString(), 2);
        sb = new StringBuilder("11111111");
        sb.replace(oneBitCount, oneBitCount+1, "0");
        int max = Integer.parseInt(sb.toString(), 2);
        if (data[0] < min || data[0] > max) {
            return false;
        }
        // 处理其他的位置
        min = Integer.parseInt("10000000", 2);
        max = Integer.parseInt("10111111", 2);
        for (int i = 1; i < data.length; i++) {
//            System.out.println("data" + data[i]);
            if (data[i] < min || data[i] > max) {
                return false;
            }
        }
        return true;
    }


    private int firstMax = 0b1111111;
    private int seconeMax = 0b11011111;
    private int thirdMax = 0b11101111;
    private int fourthMax = 0b11110111;
    /**
     * 做的事实将字符串分成几个子串
     *
     * @param data
     * @return
     */
    public boolean validUtf8(int[] data) {
        if (null == data || data.length == 0) {
            return true;
        }
        boolean res = true;
        // 遍历data 判断data 有几个属于一个字符
        for (int i = 0; i < data.length; i++) {
            if (data[i] <= firstMax) {
                res = this.validUtf8ForSingleChar(Arrays.copyOfRange(data, i, i + 1));
            } else if (data[i] <= seconeMax) {
                res = this.validUtf8ForSingleChar(Arrays.copyOfRange(data, i, i + 2));
                i += 1;
            } else if (data[i] <= thirdMax) {
                res = this.validUtf8ForSingleChar(Arrays.copyOfRange(data, i, i + 3));
                i += 2;
            } else if (data[i] <= fourthMax) {
                res = this.validUtf8ForSingleChar(Arrays.copyOfRange(data, i, i + 4));
                i = i + 3;
            } else {
                return false;
            }
            if (!res) {
                return res;
            }
        }
        return res;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] data = {197, 130, 1};
		boolean res = solution.validUtf8(data);
		System.out.println(res);
        Assert.assertEquals(true, res);

        int[] data1 = {235, 140, 4};
        res = solution.validUtf8(data1);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}

