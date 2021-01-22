package com.potato.study.leetcodecn.p00500.t001;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 500. 键盘行
 *
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。

  



  

 示例：

 输入: ["Hello", "Alaska", "Dad", "Peace"]
 输出: ["Alaska", "Dad"]
  

 注意：

 你可以重复使用键盘上同一字符。
 你可以假设输入的字符串将只包含字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/keyboard-row
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        if (null == words || words.length == 0) {
            return new String[]{};
        }
        Map<Character, Integer> chIndexMap = new HashMap<>();
        chIndexMap.put('q', 1);
        chIndexMap.put('w', 1);
        chIndexMap.put('e', 1);
        chIndexMap.put('r', 1);
        chIndexMap.put('t', 1);
        chIndexMap.put('y', 1);
        chIndexMap.put('u', 1);
        chIndexMap.put('i', 1);
        chIndexMap.put('o', 1);
        chIndexMap.put('p', 1);
        chIndexMap.put('a', 2);
        chIndexMap.put('s', 2);
        chIndexMap.put('d', 2);
        chIndexMap.put('f', 2);
        chIndexMap.put('g', 2);
        chIndexMap.put('h', 2);
        chIndexMap.put('j', 2);
        chIndexMap.put('k', 2);
        chIndexMap.put('l', 2);
        chIndexMap.put('z', 3);
        chIndexMap.put('x', 3);
        chIndexMap.put('c', 3);
        chIndexMap.put('v', 3);
        chIndexMap.put('b', 3);
        chIndexMap.put('n', 3);
        chIndexMap.put('m', 3);
        // 遍历 每个单词 看会不会出现串行
        List<String> rightWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            char cc = word.charAt(0);
            Integer index = chIndexMap.get(Character.toLowerCase(cc));
            boolean isSame = true;
            for (int i = 1; i < word.length(); i++) {
                char ch = word.charAt(i);
                Integer otherIndex = chIndexMap.get(Character.toLowerCase(ch));
                if (index != otherIndex) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                rightWords.add(word);
            }
        }
        String[] result = new String[rightWords.size()];
        result = rightWords.toArray(result);
        return result;
    }

}
