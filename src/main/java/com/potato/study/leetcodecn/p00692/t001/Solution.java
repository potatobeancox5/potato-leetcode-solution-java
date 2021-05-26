package com.potato.study.leetcodecn.p00692.t001;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 692. 前K个高频单词
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *  
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *  
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 words 优先级队列 顺序入队列，
     *
     * 依次出队列 k 次
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        // 统计次数
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            Integer count = countMap.getOrDefault(word, 0);
            count++;
            countMap.put(word, count);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (countMap.get(o1) == countMap.get(o2)) {
                    // 字母顺序 比较
                    return compareWord(o1, o2);
                }
                return Integer.compare(countMap.get(o2), countMap.get(o1));
            }
        });
        // 插入
        for (String word : countMap.keySet()) {
            priorityQueue.add(word);
        }
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            resultList.add(priorityQueue.poll());
        }
        return resultList;
    }

    /**
     * 按照 字母顺序 比较 o1 和 o2
     * @param o1
     * @param o2
     * @return
     */
    private int compareWord(String o1, String o2) {
        int index = 0;
        while (index < o1.length() && index < o2.length()) {
            char ch1 = o1.charAt(index);
            char ch2 = o2.charAt(index);
            int compare = Character.compare(ch1, ch2);
            if (compare != 0) {
                return compare;
            }
            index++;
        }
        if (index < o1.length()) {
            return 1;
        }
        if (index < o2.length()) {
            return -1;
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> strings = solution.topKFrequent(words, k);
        System.out.println(strings);

        words = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        k = 4;
        strings = solution.topKFrequent(words, k);
        System.out.println(strings);
    }
}
