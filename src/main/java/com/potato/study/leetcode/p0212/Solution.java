package com.potato.study.leetcode.p0212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         212. Word Search II
 * 
 * 			Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input:
words = ["oath","pea","eat","rain"] and board =
[
['o','a','a','n'],
['e','t','a','e'],
['i','h','k','r'],
['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.


    题目需求：

    思路：
        从每个节点开始深度优先搜索
        dfs 实现用一个数组 记录 访问状态
        每次拿当前数组值去pretie去比较 前缀树包含这个结点 往下继续走

        https://www.jianshu.com/p/e1bf6aca0344
 */
public class Solution {

    public List<String> findWords(char[][] board, String[] words) {

        Set<String> result = new HashSet<>();
        // 构造trie数据结构
        TrieTreeNode root = new TrieTreeNode();
        if (null != words) {
            for (String word : words) {
                root.insert(word);
            }
        }
        boolean[][] hasVisited = new boolean[board.length][board[0].length];
        // 从每个位置开始进行排查 dfs 查找字符传是否存在
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从每个节点开始遍历节点
                int childIndex = board[i][j] - 'a';
                dfs(result, board, hasVisited, i, j, root);
            }
        }
        return new ArrayList<>(result);
    }


    /**
     * 深度优先搜索 获取单词 并查找
     * @param result    存放查找到的结果
     * @param board     被查找字符矩阵
     * @param hasVisited    状态矩阵，标记节点访问情况
     * @param x         横坐标
     * @param y         纵坐标
     */
    private void dfs (Set<String> result, char[][] board, boolean[][] hasVisited, int x, int y, TrieTreeNode root) {
        // 当前节点是trie的最后一个节点 找到单词
        if (null != root && root.isWordEnd) {
            result.add(root.word);
        }
        // 否则 获取当前节点board x y 判断当前xy 是否合法 状态量
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || hasVisited[x][y] || root == null) {
            return;
        }

        int childIndex = board[x][y] - 'a';

        // 更新状态量
        hasVisited[x][y] = true;
        // 找到对应trie child 继续dfs
        dfs(result, board, hasVisited, x - 1, y, root.children[childIndex]);
        // 还原状态量
        hasVisited[x][y] = false;

        hasVisited[x][y] = true;
        dfs(result, board, hasVisited, x, y - 1, root.children[childIndex]);
        hasVisited[x][y] = false;

        hasVisited[x][y] = true;
        dfs(result, board, hasVisited, x + 1, y, root.children[childIndex]);
        hasVisited[x][y] = false;

        hasVisited[x][y] = true;
        dfs(result, board, hasVisited, x, y + 1, root.children[childIndex]);
        hasVisited[x][y] = false;

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

        /**
         * 如果isWordEnd = true 记录单词的值
         */
        public String word;

        public TrieTreeNode() {
            children = new TrieTreeNode[26]; // 初始化孩子节点
        }


        /**
         * 向当前前缀树中追加word
         */
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
                    thisNode.word = word;
                }
                curNode = thisNode;
            }
        }

        /**
         * 在当前节点的前缀树种搜索给定单词，且满足结束的字符的is
         * <p>
         * 改写成递归实现 方便判断 .
         */
        public boolean search(String word) {
            return this.search(word, this, 0); // 正常此处不可达
        }

        /**
         * 查询当前trie 是否有 孩子是 index 位置的节点
         *
         * @param word
         * @param root
         * @return
         */
        public boolean search(String word, TrieTreeNode root, int index) {
            // 当前已经比较到最后一个节点 看是否结束了
            if (index == word.length()) {
                return root != null && root.isWordEnd;
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
        Solution solution = new Solution();
//        char[][] board = {
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//        };
//        String[] words = {"oath","pea","eat","rain"};

        char[][] board = {
                {'a'}
        };
        String[] words = {"a"};
        List<String> res = solution.findWords(board, words);
        System.out.println(res);
    }
}
