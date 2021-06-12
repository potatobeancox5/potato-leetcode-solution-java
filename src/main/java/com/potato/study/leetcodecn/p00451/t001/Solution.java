package com.potato.study.leetcodecn.p00451.t001;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * 451. 根据字符出现频率排序
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

 示例 1:

 输入:
 "tree"

 输出:
 "eert"

 解释:
 'e'出现两次，'r'和't'都只出现一次。
 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 示例 2:

 输入:
 "cccaaa"

 输出:
 "cccaaa"

 解释:
 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 示例 3:

 输入:
 "Aabb"

 输出:
 "bbAa"

 解释:
 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 注意'A'和'a'被认为是两种不同的字符。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 统计出现次数
     * 2. 按照出现次数排序
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, CharCount> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            CharCount charCount = countMap.getOrDefault(ch, new CharCount(ch, 0));
            charCount.count ++;
            countMap.put(ch, charCount);
        }
        // 优先级队列
        PriorityQueue<CharCount> priorityQueue = new PriorityQueue<>(new Comparator<CharCount>() {
            @Override
            public int compare(CharCount o1, CharCount o2) {
                int compare = Integer.compare(o2.count, o1.count);
                if (0 != compare) {
                    return compare;
                }
                return Character.compare(o1.ch, o2.ch);
            }
        });
        for (CharCount charCount: countMap.values()) {
            priorityQueue.add(charCount);
        }
        StringBuilder builder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            CharCount poll = priorityQueue.poll();
            for (int i = 0; i < poll.count; i++) {
                builder.append(poll.ch);
            }
        }
        return builder.toString();
    }



    class CharCount {
        public char ch;
        public int count;

        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
