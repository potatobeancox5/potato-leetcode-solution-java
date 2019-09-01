package com.potato.study.leetcode.p1078;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1078. Occurrences After Bigram
 *  
 *       Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

For each such occurrence, add "third" to the answer, and return the answer.



Example 1:

Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]
Example 2:

Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]


Note:

1 <= text.length <= 1000
text consists of space separated words, where each word consists of lowercase English letters.
1 <= first.length, second.length <= 10
first and second consist of lowercase English letters.
 *         
 *
 *
 *
 *         思路：
 *
 *
 */
public class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> thirdList = new ArrayList<>();
        String[] targetWords = text.split(" ");
        int index = 0;
        // 找到first 往后找两个 是就记录要不找下一个
        while (index < targetWords.length) {
            if (targetWords[index].equals(first) && index + 1 < targetWords.length
                    && targetWords[index + 1].equals(second) && index + 2 < targetWords.length) {
                thirdList.add(targetWords[index + 2]);
            }
            index++;
        }
        return thirdList.toArray(new String[thirdList.size()]);
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String text = "we will we will rock you";
        String first = "we";
        String second = "will";
        String[] words = solution.findOcurrences(text, first, second);
        System.out.println(Arrays.toString(words));
    }
}
