package com.potato.study.leetcode.p1286;



import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1286. Iterator for Combination
 *  
 *
Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.


Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false


Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.
 *         
 *         思路：
 *
 *
 *
 *
 *
 */
public class CombinationIterator {


    private Queue<String> queue;

    public CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList<>();
        char[] word = new char[combinationLength];
        backtrack(characters, 0, 0, word);
    }

    public String next() {
        return queue.poll();
    }


    public boolean hasNext() {
        return !queue.isEmpty();
    }


    /**
     * characters 找到 positionOfCombination 位置 应该为 indexOfCharacters 并 放入 word
     * @param characters
     * @param positionOfCombination
     * @param indexOfCharacters
     * @param word
     */
    private void backtrack(String characters, int positionOfCombination, int indexOfCharacters, char[] word) {
        // 已经找完了一个 单词
        if (indexOfCharacters == word.length) {
            this.queue.add(new String(word));
            return;
        }
        // 否则确定当前字母 并递归确定其他字母
        for (int i = positionOfCombination; i < characters.length(); i++) {
            word[indexOfCharacters] = characters.charAt(i);
            backtrack(characters, i + 1, indexOfCharacters + 1, word);
        }
    }

}
