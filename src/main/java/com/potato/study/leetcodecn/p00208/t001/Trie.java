package com.potato.study.leetcodecn.p00208.t001;

import org.junit.Assert;

/**
 * 208. 实现 Trie (前缀树)
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

 请你实现 Trie 类：

 Trie() 初始化前缀树对象。
 void insert(String word) 向前缀树中插入字符串 word 。
 boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
  

 示例：

 输入
 ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 输出
 [null, null, true, false, true, null, true]

 解释
 Trie trie = new Trie();
 trie.insert("apple");
 trie.search("apple");   // 返回 True
 trie.search("app");     // 返回 False
 trie.startsWith("app"); // 返回 True
 trie.insert("app");
 trie.search("app");     // 返回 True
  

 提示：

 1 <= word.length, prefix.length <= 2000
 word 和 prefix 仅由小写英文字母组成
 insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Trie {

    // 首节点
    private TrieNode head;

    /** Initialize your data structure here. */
    public Trie() {
        this.head = new TrieNode();
        // 初始化 next 节点
        head.next = new TrieNode[26];
    }

    /**
     *
     * @param word
     */
    public void insert(String word) {
        head.insert(word);
    }


    /**
     * 遍历 word  使用 每个位置 和 node记性比较
     * @param word
     * @return
     */
    public boolean search(String word) {
        return head.search(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return head.startsWith(prefix);
    }

    class TrieNode {
        // 当前节点的 字母
        public char ch;
        // 当前节点对应的next节点 一般有26个
        public TrieNode[] next;
        // 当前节点是不是可以作为结束节点
        public boolean isEndNode;


        /**
         * 将 插入 word点
         * @param word
         */
        public void insert(String word) {
            // 边界判断 不能为空 空了也就没啥意义了
            if (word == null || "".equals(word)) {
                return;
            }
            // 遍历 word 对于每个字母 生成下一个节点的node 并且移动
            TrieNode node = this;
            TrieNode[] nextArr = node.next;
            for (int i = 0; i < word.length(); i++) {
                // 可能需要先对 arr 进行初始化
                if (nextArr == null) {
                    nextArr = new TrieNode[26];
                }
                char c = word.charAt(i);
                // 仅由小写英文字母组成
                if (nextArr[c - 'a'] == null) {
                    nextArr[c - 'a'] = new TrieNode();
                    nextArr[c - 'a'].next = new TrieNode[26];
                    nextArr[c - 'a'].ch = c;
                }
                // 非空 说明 node 可以往下走了
                node = nextArr[c - 'a'];
                nextArr = node.next;
                // 如果是 最终节点 设置标记为
                if (i == word.length() - 1) {
                    node.isEndNode = true;
                }

            }
        }

        /**
         * 在当前点中找到是否有word
         * @param word
         * @return
         */
        public boolean search(String word) {
            // 边界判断 不能为空 空了也就没啥意义了
            if (word == null || "".equals(word)) {
                return false;
            }
            // 遍历 word 对于每个字母 生成下一个节点的node 并且移动
            TrieNode node = this;
            TrieNode[] nextArr = node.next;
            for (int i = 0; i < word.length(); i++) {
                // 可能需要先对 arr 进行初始化
                if (nextArr == null) {
                    return false;
                }
                char c = word.charAt(i);
                // 仅由小写英文字母组成
                if (nextArr[c - 'a'] == null) {
                    return false;
                }
                // 非空说明是包含的
                node = nextArr[c - 'a'];
                nextArr = node.next;
                // 如果是 最终节点 设置标记为
                if (i == word.length() - 1) {
                    return node.isEndNode;
                }
            }
            return false;
        }

        /**
         *
         * @param word
         * @return
         */
        public boolean startsWith(String word) {
            // 边界判断 不能为空 空了也就没啥意义了
            if (word == null || "".equals(word)) {
                return false;
            }
            // 遍历 word 对于每个字母 生成下一个节点的node 并且移动
            TrieNode node = this;
            TrieNode[] nextArr = node.next;
            for (int i = 0; i < word.length(); i++) {
                // 可能需要先对 arr 进行初始化
                if (nextArr == null) {
                    return false;
                }
                char c = word.charAt(i);
                // 仅由小写英文字母组成
                if (nextArr[c - 'a'] == null) {
                    return false;
                }
                // 非空说明是包含的
                node = nextArr[c - 'a'];
                nextArr = node.next;
            }
            return true;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));// 返回 True
        System.out.println(trie.search("app"));// 返回 False
        System.out.println(trie.startsWith("app"));// 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));// 返回 True
    }
}



