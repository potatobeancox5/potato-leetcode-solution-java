package com.potato.study.leetcode.p0297;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


/**
 * 
 * @author liuzhao11
 * 
 * 
 * 297. Serialize and Deserialize Binary Tree
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example:

You may serialize the following tree:

1
/ \
2   3
/ \
4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.*
* 
* 
* 思路：
* 使用层序遍历法吧
 * https://www.cnblogs.com/joannacode/p/6104056.html
 * 先序或者中序如下
 * https://www.cnblogs.com/yrbbest/p/5047035.html
 *
*
 */
public class Codec {

    private String emptyStr = "#";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return emptyStr;
        }
        // 先序列遍历
        StringBuilder sb = new StringBuilder();
        generatePreOrderStr(root, sb);
        return sb.toString();
    }

    /**
     * 递归先序遍历树
     * @param root
     * @param sb
     */
    private void generatePreOrderStr(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("n").append(",");
            return;
        }
        sb.append(root.val).append(",");
        // left child
        generatePreOrderStr(root.left, sb);
        // right child
        generatePreOrderStr(root.right, sb);
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (emptyStr.equals(data)) {
            return null;
        }
        // 使用双端队列
        Deque<String> dequeue = new LinkedList<>();
        String[] split = data.split(",");
        dequeue.addAll(Arrays.asList(split));
        return deserializeTree(dequeue);
    }

    private TreeNode deserializeTree(Deque<String> dequeue) {
        String s = dequeue.removeFirst();
        if ("n".equals(s)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserializeTree(dequeue);
        root.right = deserializeTree(dequeue);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = TreeNodeUtil.generateTreeByArrayString("[1,2,3,null,null,4,5]");
        String serialize = codec.serialize(root);
        System.out.println(serialize);


    }
}
