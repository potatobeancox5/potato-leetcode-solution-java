package com.potato.study.leetcode.p0804;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	804. Unique Morse Code Words
 *  
 *         International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation:
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
Note:

The length of words will be at most 100.
Each words[i] will have length in range [1, 12].
words[i] will only consist of lowercase letters.
 *         
 *         思路：
 *         生成对应的值
 *
 * 
 */
public class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> morseSet = new HashSet<>();
        // 生成对应map
        Map<Character, String> morseMap = new HashMap<>();
        buildMorseMap(morseMap);
        // 生成morse 密码 放到set中
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                String morseStrPart = morseMap.get(word.charAt(i));
                sb.append(morseStrPart);
            }
            morseSet.add(sb.toString());
        }
        return morseSet.size();
    }

    /**
     *
     * @param morseMap
     */
    private void buildMorseMap(Map<Character, String> morseMap) {
        String[] morseStr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---"
                ,"-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-"
                ,".--","-..-","-.--","--.."};
        morseMap.put('a', morseStr[0]);
        morseMap.put('b', morseStr[1]);
        morseMap.put('c', morseStr[2]);
        morseMap.put('d', morseStr[3]);
        morseMap.put('e', morseStr[4]);
        morseMap.put('f', morseStr[5]);
        morseMap.put('g', morseStr[6]);
        morseMap.put('h', morseStr[7]);
        morseMap.put('i', morseStr[8]);
        morseMap.put('j', morseStr[9]);
        morseMap.put('k', morseStr[10]);
        morseMap.put('l', morseStr[11]);
        morseMap.put('m', morseStr[12]);
        morseMap.put('n', morseStr[13]);
        morseMap.put('o', morseStr[14]);
        morseMap.put('p', morseStr[15]);
        morseMap.put('q', morseStr[16]);
        morseMap.put('r', morseStr[17]);
        morseMap.put('s', morseStr[18]);
        morseMap.put('t', morseStr[19]);
        morseMap.put('u', morseStr[20]);
        morseMap.put('v', morseStr[21]);
        morseMap.put('w', morseStr[22]);
        morseMap.put('x', morseStr[23]);
        morseMap.put('y', morseStr[24]);
        morseMap.put('z', morseStr[25]);
    }

    public static void main(String[] args) {
		Solution solution = new Solution();
		String[] words = {"gin", "zen", "gig", "msg"};
        int result = solution.uniqueMorseRepresentations(words);
        System.out.println(result);
    }
}
