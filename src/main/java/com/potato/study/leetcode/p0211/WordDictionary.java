package com.potato.study.leetcode.p0211;

/**
 * 
 * @author liuzhao11
 * 
 *         211. Add and Search Word - Data structure design
 * 
 * 			Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.


    题目需求：

    思路：
        前缀树实现 可以复用之前前缀树代码
 */
public class WordDictionary {

    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

        return false;
    }
}
