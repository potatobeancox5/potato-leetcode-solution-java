package com.potato.study.leetcode.p0748;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	748. Shortest Completing Word
 *  
 *         Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
Note:
licensePlate will be a string with length in range [1, 7].
licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
words will have a length in the range [10, 1000].
Every words[i] will consist of lowercase letters, and have length in range [1, 15].


 * 思路：
子方法 统计单词中字母及出现次数
返回map 字母 出现次数
fore 单词
map.put if not 存在
map +1 存在
返回这个map

主方法
string minword
遍历words
统计单词出现次数
iscomplate = true
遍历map 取每个key 对应的次数比较
小于 iscomplate break
大于 继续比
if iscomplate
比较minword


返回minwords
 * 
 */
public class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> targetMap = getEveryCharactorCount(licensePlate);

        String minWord = "";
        int minLen = Integer.MAX_VALUE;

        for (String word : words) {
            Map<Character, Integer> wordMap = getEveryCharactorCount(word);

            boolean isComplate = true;
            // 遍历 targetMap 进行比较
            for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
                if (!wordMap.containsKey(entry.getKey())) {
                    isComplate = false;
                    break;
                }
                if (entry.getValue() > wordMap.get(entry.getKey())) {
                    isComplate = false;
                    break;
                }
            }

            if (isComplate && minLen > word.length()) {
                minLen = word.length();
                minWord = word;
            }
        }
        return minWord;
    }

    /**
     * 统计单词中，每个字母的出现次数
     * @param word
     * @return
     */
    private Map<Character, Integer> getEveryCharactorCount(String word) {
        Map<Character, Integer> map = new HashMap<>();
        if (null == word || word.length() == 0) {
            return map;
        }
        for (char ch : word.toCharArray()) {
            if ('0' <= ch && ch <= '9') {
                continue;
            }
            if (' ' == ch) {
                continue;
            }
            ch = Character.toLowerCase(ch);
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        return map;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String licensePlate = "1s3 456";
//		String[] words = {"looks", "pest", "stew", "show"};

        String licensePlate = "1s3 PSt";
		String[] words = {"step", "steps", "stripe", "stepple"};

		String totalCost = solution.shortestCompletingWord(licensePlate, words);
		System.out.println(totalCost);
	}
}
