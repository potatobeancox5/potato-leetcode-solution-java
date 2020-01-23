package com.potato.study.leetcode.p0692;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	692. Top K Frequent Words
 *  
 *        Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 *
 *
 *         题目解释：
 *
 *         思路：
 *
 *         https://www.cnblogs.com/J1ac/p/9728878.html
 *
 *         直接使用 java 内部提供的有效队列 实现
 *
 *
 *
 *         
 *
 *
 * 
 */
public class Solution {

    class WordFrequent{
        public String word;
        public int count;

        public WordFrequent(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }


    public List<String> topKFrequent(String[] words, int k) {
        //  初始化计数
        Map<String, WordFrequent> countMap = new HashMap<>();
        for (String word : words) {
            WordFrequent wordFrequent = countMap.getOrDefault(word, new WordFrequent(word, 0));
            wordFrequent.count++;
            countMap.put(word, wordFrequent);
        }
        // k 个元素的 大根堆
        PriorityQueue<WordFrequent> priorityQueue = new PriorityQueue<>(new Comparator<WordFrequent>() {
            @Override
            public int compare(WordFrequent o1, WordFrequent o2) {
                if (o1.count == o2.count) {
                    return o1.word.compareTo(o2.word);
                }
                return o2.count - o1.count;
            }
        });
        // 将 map 直接放入
        priorityQueue.addAll(countMap.values());
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            resultList.add(priorityQueue.poll().word);
        }
        return resultList;
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        List<String> list = solution.topKFrequent(words, k);
        System.out.println(list); //"i", "love"

        String[] words1 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        k = 4;

        List<String> list1 = solution.topKFrequent(words1, k);
        System.out.println(list1); // "the", "is", "sunny", "day"

    }
}
