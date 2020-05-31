package com.potato.study.leetcode.p1032;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1032. Stream of Characters
 *  
 *        Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.


Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist


Note:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/stream-of-characters/solution/javashi-xian-aczi-dong-ji-by-mazw-2/
 *
 *
 *
 */
public class StreamChecker {

    private ACNode root;
    private ACNode p;

    public StreamChecker(String[] words) {
        // 构造字典树
        this.root = new ACNode(' ');
        this.p = root;
        for (String word : words) {
            ACNode temp = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (temp.children[idx] == null) {
                    temp.children[idx] = new ACNode(c);
                }
                temp = temp.children[idx];
            }
            temp.isEnding = true;
            temp.length = word.length();
        }
        // 维护失败指针
        buildFailPointer();
    }

    private void buildFailPointer() {
        Queue<ACNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ACNode p = queue.poll();
            for (int i = 0; i < 26; i++) {
                ACNode pc = p.children[i];
                if (pc == null) {
                    continue;
                }
                if (p == root) {
                    pc.fail = root;
                } else {
                    ACNode q = p.fail;
                    while (q != null && q.children[i] == null) {
                        q = q.fail;
                    }

                    if (q == null) {
                        pc.fail = root;
                    } else {
                        pc.fail = q.children[i];
                    }
                }
                queue.add(pc);
            }
        }
    }

    public boolean query(char letter) {
        int idx = letter - 'a';
        while (this.p != root && p.children[idx] == null) {
            p = p.fail;
        }
        p = p.children[idx];
        if (p == null) {
            p = root;
        }

        ACNode temp = p;
        while (temp != root) {
            if (temp.isEnding) {
                return true;
            }
            temp = temp.fail;
        }

        return false;
    }
    class ACNode {
        char c;
        boolean isEnding;
        int length = -1;

        ACNode[] children = new ACNode[26];
        ACNode fail;

        ACNode(char c) {
            this.c = c;
        }
    }

}
