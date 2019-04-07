package com.potato.study.leetcode.p0937;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	937. Reorder Log Files
 *  
 *       You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.



Example 1:

Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]


Note:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
 *         
 *         题目含义：
 *
 *
 *         思路：
 *          https://www.jianshu.com/p/07e21b554855
            分别排序
 *
 *
 * 
 */
public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> numLog = new ArrayList<>();
        List<String> stringLog = new ArrayList<>();
        if (null != logs) {
            for (String log : logs) {
                // 数字直接进入list
                String[] splits = log.split(" ");

                if (splits[1].charAt(0) >= '0' && splits[1].charAt(0) <= '9') {
                    numLog.add(log);
                } else {
                    //  字母进入字母list
                    stringLog.add(log);
                }
            }
            // 对字母进行排序
            stringLog.sort(new Comparator<String>() {
                @Override
                public int compare(String log1, String log2) {
                    String[] splits1 = log1.split(" ");
                    String[] splits2 = log2.split(" ");
                    for (int i = 1; i < splits1.length; i++) {
                        if (splits1[i].compareTo(splits2[i]) == 0) {
                            continue;
                        } else {
                            return splits1[i].compareTo(splits2[i]);
                        }
                    }
                    if (splits2.length > splits1.length) {
                        return -1;
                    }
                    return 0;
                }
            });
            // 插入字母
            for (int i = 0; i < stringLog.size(); i++) {
                logs[i] = stringLog.get(i);
            }

            // 插入数字
            for (int i = 0; i < numLog.size(); i++) {
                logs[i + stringLog.size()] = numLog.get(i);
            }
        }
        return logs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] logs = {"qi ir oo i", "cp vnzw i", "0 fkbikbts", "4 j trouka", "gn j q al", "5r w wgqc", "m8 x haje", "fg 28694 6", "i gf mwdoa", "ao 0850716"};
        String[] strings = solution.reorderLogFiles(logs);
        System.out.println(Arrays.toString(strings));
    }
}
