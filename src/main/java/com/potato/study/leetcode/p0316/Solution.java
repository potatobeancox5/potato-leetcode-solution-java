package com.potato.study.leetcode.p0316;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Administrator
 *
 *         316. Remove Duplicate Letters
 *         
 *          
 *         Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"
Example 2:

Input: "cbacdcbc"
Output: "acdb"
 *         
 *         
 *         
 *         思路： 
 *         xx
 *         timesmap 存放当前字符出现次数
 *         res 缓存存放当前结果
 *         遍历字符传
 *          当前字符与res最后一个字符比较
 *              result空 直接添加
 *              否则
 *                  当前字符比res last 大
 *                      且没有出现过 加到res最后 次数--；
 *                      出现过 次数--
 *                  当前字符比 res last 小
 *                      res 中出现过 次数--；
 *                      没出现过
 *                          如果last 字符次数 等于0 说明 只能添加到最后了 添加当前字符 次数--
 *                          如果last 字符次数 大于 0 说明 可以pop 并添加当前字符 次数--
 *
 *
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> timesMap = new HashMap<>();
        // 计次数
        for (char ch : s.toCharArray()) {
            if (timesMap.containsKey(ch)) {
                timesMap.put(ch, timesMap.get(ch) + 1);
            } else {
                timesMap.put(ch, 1);
            }
        }
        // 缓存当前结果
        StringBuffer res = new StringBuffer();
        for (char ch : s.toCharArray()) {
            // 处理第一个字符
            if (res.length() == 0) {
                res.append(ch);
                timesMap.put(ch, timesMap.get(ch) - 1);
                continue;
            }
            // 处理其他字符
            char lastResultCh = res.charAt(res.length() - 1);
            // 新字符比res最后一个字符大 如果这个字符没在res中 则加入
            if (ch >= lastResultCh && !res.toString().contains(ch + "")) {
                res.append(ch);
            } else if (ch < lastResultCh && !res.toString().contains(ch + "")) {
                if (timesMap.get(lastResultCh) == 0) {
                    //如果last 字符次数 等于0 说明 只能添加到最后了 添加当前字符 次数--
                    res.append(ch);
                } else {
                    // 如果last 字符次数 大于 0 说明可以删除最后一个字符 并添加当前字符 当前次数-- last也--
                    char lastCh = res.charAt(res.length() - 1);
                    while (lastCh > ch && res.length() > 0 &&  timesMap.get(lastCh) > 0) {
                        res.deleteCharAt(res.length() - 1);
                        if (res.length() > 0) {
                            lastCh = res.charAt(res.length() - 1);
                        }
                    }
                    res.append(ch);
                }
            }
            timesMap.put(ch, timesMap.get(ch) - 1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "cbacdcbc"; // acdb
//        String s = "bcabc";// abc
//        String s = "edebbed"; // bed
        String s = "bbcaac"; // bac
        String str = solution.removeDuplicateLetters(s);
        System.out.println(str);
    }
}
