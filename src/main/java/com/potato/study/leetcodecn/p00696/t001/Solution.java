package com.potato.study.leetcodecn.p00696.t001;


import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 696. 计数二进制子串
 *
 * 给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 *  
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 *  
 *
 * 提示：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 题目 含义是这样的
     * 要求 子串中 01 是连续的，且01 数量相同
     * 先对s进行计数，连续的01 个数，存在数组中
     * 遍历数组 看两个相邻的数字是否相同，相同 ++
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int len = 0;
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                len++;
                continue;
            }
            if (s.charAt(i) == s.charAt(i-1)) {
                len++;
            } else {
                countList.add(len);
                len = 1;
            }
        }
        countList.add(len);
        int count = 0;
        for (int i = 1; i < countList.size(); i++) {
            count += Math.min(countList.get(i), countList.get(i-1));
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "00110011";
        int i = solution.countBinarySubstrings(s);
        System.out.println(i);
        Assert.assertEquals(6, i);

        s = "10101";
        i = solution.countBinarySubstrings(s);
        System.out.println(i);
        Assert.assertEquals(4, i);
    }



}
