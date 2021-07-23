package com.potato.study.leetcodecn.p00696.t001;


import java.util.HashMap;
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

    // 696
    public int countBinarySubstrings(String s) {
        // 统计 s 中 每个 位置 出现的 1-0 的个数差 然后进行组合 cn2
        Map<Integer, Integer> countMap = new HashMap<>();
        // key 是 0-1 结果 ， value 是该结果的个数
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('0' == s.charAt(i)) {
                diff++;
            } else {
                diff--;
            }
            Integer orDefault = countMap.getOrDefault(diff, 0);
            orDefault++;
            countMap.put(diff, orDefault);
        }
        // 数量
        int totalCount = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                continue;
            }
            totalCount += (entry.getValue() * (entry.getValue() - 1) / 2);
        }
        return totalCount;
    }

}
