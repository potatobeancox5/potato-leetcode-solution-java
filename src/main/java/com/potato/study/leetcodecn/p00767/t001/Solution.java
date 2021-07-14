package com.potato.study.leetcodecn.p00767.t001;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 767. 重构字符串
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

 若可行，输出任意可行的结果。若不可行，返回空字符串。

 示例 1:

 输入: S = "aab"
 输出: "aba"
 示例 2:

 输入: S = "aaab"
 输出: ""
 注意:

 S 只包含小写字母并且长度在[1, 500]区间内。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reorganize-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 767
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        // 统计字母出现数量
        int[] count = new int[26];
        int max = 0;
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
            max = Math.max(max, count[ch - 'a']);
        }
        // 最多的出现次数 大于 (x + 1 )/ 2 就不能构成了 aa
        if (max > (s.length() + 1)/2){
            return "";
        }
        // 用一个大根堆 创建 按照 出现次数进行排序
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(count[o2-'a'], count[o1-'a']);
            }
        });
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                priorityQueue.add((char)('a' + i));
            }
        }
        // 依次 从 堆中弹出2个字符
        StringBuilder builder = new StringBuilder();
        while (priorityQueue.size() > 1) {
            Character ch1 = priorityQueue.poll();
            Character ch2 = priorityQueue.poll();
            builder.append(ch1).append(ch2);
            count[ch1 - 'a']--;
            if (count[ch1 - 'a'] > 0) {
                priorityQueue.add(ch1);
            }
            count[ch2 - 'a']--;
            if (count[ch2 - 'a'] > 0) {
                priorityQueue.add(ch2);
            }
        }
        // 如果不满足 的话 看看 目前的是不是 1 是的话 直接组成传
        if (priorityQueue.size() == 1) {
            Character ch = priorityQueue.poll();
            if (count[ch - 'a'] > 1) {
                return "";
            }
            builder.append(ch);
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "aab";
        String s = solution.reorganizeString(word);
        System.out.println(s);
        Assert.assertEquals("aba", s);

        word = "aaab";
        s = solution.reorganizeString(word);
        System.out.println(s);
        Assert.assertEquals("", s);
    }
}
