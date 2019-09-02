package com.potato.study.leetcode.p0451;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *   451. Sort Characters By Frequency
 * 
 *      Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 * 
 *         思路：
 *          https://www.cnblogs.com/lightwindy/p/9552042.html
 * 				
 */	
public class Solution {

    public String frequencySort(String s) {
        // map 统计个数
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        // 全部加入大跟堆
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Character, Integer> en : countMap.entrySet()) {
            priorityQueue.add(en);
        }
        // 删除堆顶 根据次数生成字符串
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> en = priorityQueue.remove();
            for (int i = 0; i < en.getValue(); i++) {
                sb.append(en.getKey());
            }
        }
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "Aabb";
        String str = solution.frequencySort(s);
		System.out.println(str);
	}
}
