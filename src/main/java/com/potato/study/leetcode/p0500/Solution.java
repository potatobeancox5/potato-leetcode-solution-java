package com.potato.study.leetcode.p0500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *        500. Keyboard Row
 * 
 *         Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.






Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]


Note:

You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
 * 
 * 
 *         思路：
 *          
 */
public class Solution {



    public String[] findWords(String[] words) {
        // 初始化键盘表
        Map<Character, Integer> chLineMap = new HashMap<>();
        chLineMap.put('q',1);
        chLineMap.put('w',1);
        chLineMap.put('e',1);
        chLineMap.put('r',1);
        chLineMap.put('t',1);
        chLineMap.put('y',1);
        chLineMap.put('u',1);
        chLineMap.put('i',1);
        chLineMap.put('o',1);
        chLineMap.put('p',1);
        chLineMap.put('a',2);
        chLineMap.put('s',2);
        chLineMap.put('d',2);
        chLineMap.put('f',2);
        chLineMap.put('g',2);
        chLineMap.put('h',2);
        chLineMap.put('j',2);
        chLineMap.put('k',2);
        chLineMap.put('l',2);
        chLineMap.put('z',3);
        chLineMap.put('x',3);
        chLineMap.put('c',3);
        chLineMap.put('v',3);
        chLineMap.put('b',3);
        chLineMap.put('n',3);
        chLineMap.put('m',3);

        chLineMap.put('Q',1);
        chLineMap.put('W',1);
        chLineMap.put('E',1);
        chLineMap.put('R',1);
        chLineMap.put('T',1);
        chLineMap.put('Y',1);
        chLineMap.put('U',1);
        chLineMap.put('I',1);
        chLineMap.put('O',1);
        chLineMap.put('P',1);
        chLineMap.put('A',2);
        chLineMap.put('S',2);
        chLineMap.put('D',2);
        chLineMap.put('F',2);
        chLineMap.put('G',2);
        chLineMap.put('H',2);
        chLineMap.put('J',2);
        chLineMap.put('K',2);
        chLineMap.put('L',2);
        chLineMap.put('Z',3);
        chLineMap.put('X',3);
        chLineMap.put('C',3);
        chLineMap.put('V',3);
        chLineMap.put('B',3);
        chLineMap.put('N',3);
        chLineMap.put('M',3);

        // 对于每个单词进行判定
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean isInline = true;
            int line = chLineMap.get(word.charAt(0));
            for (char sh : word.toCharArray()) {
                if (line != chLineMap.get(sh)) {
                    isInline = false;
                    break;
                }
            }
            if (isInline) {
                result.add(word);
            }
        }
        String[] res = new String[result.size()];
        int index = 0;
        for (String str: result) {
            res[index++] = str;
        }
        return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String[] wordsl = {"Hello", "Alaska", "Dad", "Peace"};
        String[] words = solution.findWords(wordsl);
        System.out.println(Arrays.toString(words));

    }
}
