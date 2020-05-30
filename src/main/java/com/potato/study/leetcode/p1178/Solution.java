package com.potato.study.leetcode.p1178;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1178. Number of Valid Words for Each Puzzle
 *  
 *
With respect to a given puzzle string, a word is valid if both the following conditions are satisfied:
word contains the first letter of puzzle.
For each letter in word, that letter is in puzzle.
For example, if the puzzle is "abcdefg", then valid words are "faced", "cabbage", and "baggage"; while invalid words are "beefed" (doesn't include "a") and "based" (includes "s" which isn't in the puzzle).
Return an array answer, where answer[i] is the number of words in the given word list words that are valid with respect to the puzzle puzzles[i].


Example :

Input:
words = ["aaaa","asas","able","ability","actt","actor","access"],
puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
Output: [1,1,3,2,4,0]
Explanation:
1 valid word for "aboveyz" : "aaaa"
1 valid word for "abrodyz" : "aaaa"
3 valid words for "abslute" : "aaaa", "asas", "able"
2 valid words for "absoryz" : "aaaa", "asas"
4 valid words for "actresz" : "aaaa", "asas", "actt", "access"
There're no valid words for "gaswxyz" cause none of the words in the list contains letter 'g'.


Constraints:

1 <= words.length <= 10^5
4 <= words[i].length <= 50
1 <= puzzles.length <= 10^4
puzzles[i].length == 7
words[i][j], puzzles[i][j] are English lowercase letters.
Each puzzles[i] doesn't contain repeated characters.
 *         
 *         思路：
 *
 *         https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/solution/wei-yun-suan-jie-ti-javaban-zi-dian-shu-by-levyjen/
 *
 *
 */
public class Solution {

    private int simplify(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res |= (1 << (c - 'a'));
        }
        return res;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> list = new LinkedList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (String s : words) {
            int sim = simplify(s);
            map.put(sim,map.getOrDefault(sim,0) + 1);
        }
        for (String s : puzzles) {
            int sim = simplify(s);
            int sum = 0;
            for (int i = sim; i > 0; i = (i - 1) & sim) {
                if(((1<<(s.charAt(0)-'a'))&i)!=0){
                    sum += map.getOrDefault(i, 0);
                }

            }
            list.add(sum);
        }
        return list;
    }
	
	public static void main(String[] args) {
//		Solution solution = new Solution();
    }
}
