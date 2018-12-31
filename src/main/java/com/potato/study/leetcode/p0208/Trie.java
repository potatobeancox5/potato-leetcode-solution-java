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
 */
public class Trie {

    private TreeNode treeNodeHead;

    /** Initialize your data structure here. */
    public Trie() {
        treeNodeHead = new TreeNode('A');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        // 获取第一层节点
        TreeNode current = treeNodeHead.left;
        TreeNode preHead = new TreeNode('B');
        TreeNode pre = preHead;
        TreeNode parent = treeNodeHead;
        pre.right = current;
        for (int i = 0; i < word.length(); i++) {
            while (current != null && current.val != word.charAt(i)) { // 向右找
                current = current.right;
                pre = pre.right;
            }
            if (current == null) { // 找到了节点, 找下一个节点
                parent = current; // 修改副节点
                current = current.left;
                pre = preHead;
                pre.right = current;
                continue;
            } else { // 最后都没有找到, 在最后创建一个字母 拼上去
                if (pre == preHead) { // 第一个孩子 需要连接到父亲的left上边
                    TreeNode treeNode = new TreeNode(word.charAt(i));
                    parent.left = treeNode;
                    parent = treeNode;
                    i++;
                    while (i < word.length()) {
                        TreeNode child = new TreeNode(word.charAt(i));
                        parent.left = child;
                        parent = child;
                        i++;
                    }
                } else {
                    TreeNode treeNode = new TreeNode(word.charAt(i));
                    pre.right = treeNode;
                    current = treeNode.left; // 往下层移动
                }
            }
        }


        // 找到响应的位置 ，如果最终没有找到 那么 之前的那个位置就是插入点
    }

    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        if(null == word || "".equals(word)) {
//            return false;
//        }
//        char headch = word.charAt(0);
//        TreeNode head = treeNodeHead[headch - 'a'];
//        if (null == head) {
//            return false;
//        }
//        TreeNode p = head.left;
//        int index = 1;
//        while (index < word.length()) {
//            while(null != p && p.val != (word.charAt(index) - 'a')) {
//                p = p.right;
//            }
//            if (p == null) { // 最终没有这个单词
//                return false;
//            } else { // 找到了 p
//                p = p.left;
//                index++;
//            }
//        }
//        if (p.left != null) {
//            return false;
//        }
//        return true;
//    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        if(null == prefix || "".equals(prefix)) {
//            return false;
//        }
//        char headch = prefix.charAt(0);
//        TreeNode head = treeNodeHead[headch - 'a'];
//        if (null == head) {
//            return false;
//        }
//        TreeNode p = head.left;
//        int index = 1;
//        while (index < prefix.length()) {
//            while(null != p && p.val != (prefix.charAt(index) - 'a')) {
//                p = p.right;
//            }
//            if (p == null) { // 最终没有这个单词
//                return false;
//            } else { // 找到了 p
//                p = p.left;
//                index++;
//            }
//        }
//        return true;
//    }


    class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char x) {
            val = x;
        }
    }
}
