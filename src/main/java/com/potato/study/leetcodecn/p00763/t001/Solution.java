package com.potato.study.leetcodecn.p00763.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 763. 划分字母区间
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。

  

 示例：

 输入：S = "ababcbacadefegdehijhklij"
 输出：[9,7,8]
 解释：
 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 每个字母最多出现在一个片段中。
 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
  

 提示：

 S的长度在[1, 500]之间。
 S只包含小写字母 'a' 到 'z' 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/partition-labels
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 使用 map 记录 字母 第一个出现的位置和最后一个出现位置
     * 2。遍历 str 一遍 生成 1中的mao
     * 3. 遍历 str 每个 字母 ch 从 map 中 获取 开始位置和最终位置，
     *      从 map 中获取 开始和结束位置，用set 记录当前有多少字符 然后遍历 set 确定开始终止位置
     *      然后跳到终止位置 在进行上面的步骤
     * @param str
     * @return
     */
    public List<Integer> partitionLabels(String str) {
        Map<Character, int[]> startEndMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int[] position = startEndMap.getOrDefault(ch, new int[]{i, i});
            // 如果位置 i
            position[1] = Math.max(i, position[1]);
            startEndMap.put(ch, position);
        }
        // 遍历 str 每个 字母 ch 从 map 中 获取 开始位置和最终位置，用set 记录中间有的字符 并根据字符
        int index  = 0;
        List<Integer> resultList = new ArrayList<>();
        while (index < str.length()) {
            // 新的一个串开始
            char ch = str.charAt(index);
            int[] position = startEndMap.get(ch);
            Set<Character> set = new HashSet<>();
            int start = position[0];
            int end = position[1];
            for (int i = start; i <= end; i++) {
                char target = str.charAt(i);
                set.add(target);
                int[] newPosition = startEndMap.get(target);
                end = Math.max(end, newPosition[1]);
            }
            index = end + 1;
            // 计算记过长度
            resultList.add(index - start);
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "ababcbacadefegdehijhklij";
        // [9,7,8]
        List<Integer> list = solution.partitionLabels(str);
        System.out.println(list);



    }
}
