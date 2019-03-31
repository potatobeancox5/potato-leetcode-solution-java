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
        有个区别就是需要支持通配符
 */
public class WordDictionary {

    /**
     * 根节点
     */
    private TrieTreeNode rootNode;

    /** Initialize your data structure here. */
    public WordDictionary() {
        rootNode = new TrieTreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (null == word || "".equals(word)) {
            return;
        }
        rootNode.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (null == word || "".equals(word)) {
            return true;
        }
        return rootNode.search(word);
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

        /** 在当前节点的前缀树种搜索给定单词，且满足结束的字符的is
         *
         * 改写成递归实现 方便判断 .
         * */
        public boolean search(String word) {
            return this.search(word, this, 0); // 正常此处不可达
        }

        /**
         * 查询当前trie 是否有 孩子是 index 位置的节点
         * @param word
         * @param root
         * @return
         */
        public boolean search(String word, TrieTreeNode root, int index) {
            // 当前已经比较到最后一个节点 看是否结束了
            if (index == word.length()) {
                return root!= null && root.isWordEnd;
            }
            if (root == null) {
                return false;
            }
            // 获取 当前节点
            TrieTreeNode curNode = root;
            // 获取 要判断的字符
            char ch = word.charAt(index);
            if (ch == '.') { // 对于通配符 直接遍历每个孩子的值
                for (TrieTreeNode child : curNode.children) {
                    if (child == null) {
                        continue;
                    }
                    if (search(word, child, index + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                return search(word, curNode.children[ch - 'a'], index + 1);
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary trie = new WordDictionary();
//        trie.addWord("apple");
//        boolean apple = trie.search("apple");// returns true
//        System.out.println("apple:" +  apple);
//
//        boolean app = trie.search("app");// returns false
//        System.out.println("app:1" +  app);


        trie.addWord("");
        boolean app2 = trie.search("a");// returns true
        System.out.println("app2:" +  app2);
    }
}
