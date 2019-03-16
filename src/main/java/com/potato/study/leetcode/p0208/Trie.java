package com.potato.study.leetcode.p0208;

/**
 * 
 * @author liuzhao11
 * 
 *         208. Implement Trie (Prefix Tree)
 * 
 * 			Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
    题目需求：
        构建一个前缀树
        实现前缀树的方法
        采用左孩子，右兄弟的存储方法
    思路：
        https://www.cnblogs.com/strugglion/p/6426979.html
        前缀树 结构 数组保存下一个节点 boolean 标记到当前节点是否结束
 */
public class Trie {

    /**
     * 根节点
     */
    private TrieTreeNode rootNode;
    /** Initialize your data structure here. */
    public Trie() {
        rootNode = new TrieTreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (null == word || "".equals(word)) {
            return;
        }
        rootNode.insert(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return rootNode.search(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return rootNode.startsWith(prefix);
    }

    /**
     * 前缀树节点数据结构
     */
    class TrieTreeNode {
        /**
         * 下一个节点的位置
         * 26 个节点 每个对应字母 a - z
         */
        public TrieTreeNode[] children;

        /**
         * 标志是否是一个单词的结束
         * true ： 此节点是一个单词的结束
         * false ： 此节点不是一个单词的结束
         */
        public boolean isWordEnd;

        public TrieTreeNode() {
            children = new TrieTreeNode[26]; // 初始化孩子节点
        }


        /** 向当前前缀树中追加word */
        public void insert(String word) {
            // 获取根节点
            TrieTreeNode curNode = this;
            // 取出每个字符
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                // 如果存在 判断是否结束 不是的话 再往里塞
                if (null == curNode.children[ch - 'a']) {
                    curNode.children[ch - 'a'] = new TrieTreeNode();
                }
                TrieTreeNode thisNode = curNode.children[ch - 'a'];
                // 判断当前节点是否是单词最后一个节点
                if (i == word.length() - 1) {
                    thisNode.isWordEnd = true;
                }
                curNode = thisNode;
            }
        }

        /** 在当前节点的前缀树种搜索给定单词，且满足结束的字符的is */
        public boolean search(String word) {
            // 获取根节点
            TrieTreeNode curNode = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                // 如果存在 判断是否结束 不是的话 再往里塞
                if (null == curNode.children[ch - 'a']) {
                    return false;
                }
                TrieTreeNode thisNode = curNode.children[ch - 'a'];
                // 判断当前节点是否是单词最后一个节点
                if (i == word.length() - 1 && thisNode.isWordEnd) {
                    return true;
                }
                curNode = thisNode;
            }
            return false; // 正常此处不可达
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            // 获取根节点
            TrieTreeNode curNode = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                // 如果存在 判断是否结束 不是的话 再往里塞
                if (null == curNode.children[ch - 'a']) {
                    return false;
                }
                TrieTreeNode thisNode = curNode.children[ch - 'a'];
                curNode = thisNode;
            }
            return true; // 正常此处不可达
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");// returns true
        System.out.println("apple:" +  apple);
        assert apple;
        boolean app = trie.search("app");// returns false
        assert !app;
        System.out.println("app:" +  app);
        boolean app1 = trie.startsWith("app");// returns true
        assert app1;
        System.out.println("app1:" +  app1);
        trie.insert("app");
        boolean app2 = trie.search("app");// returns true
        assert app2;
        System.out.println("app2:" +  app2);
    }
}
