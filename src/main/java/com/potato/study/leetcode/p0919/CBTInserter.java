package com.potato.study.leetcode.p0919;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	919. Complete Binary Tree Inserter
 *  
 *      A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:

CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
CBTInserter.get_root() will return the head node of the tree.


Example 1:

Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
Output: [null,1,[1,2]]
Example 2:

Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
Output: [null,3,4,[1,2,3,4,5,6,7,8]]


Note:

The initial given tree is complete and contains between 1 and 1000 nodes.
CBTInserter.insert is called at most 10000 times per test case.
Every value of a given or inserted node is between 0 and 5000.

 *         
 *         题目含义：
 *
 *         思路：
 *
 *         https://blog.csdn.net/weixin_30800807/article/details/99645691
 *
 *
 *
 *
 */
public class CBTInserter {

    // 存储 root 和当前结点 使用 queue 标志当前可以插入位置
    private TreeNode root;
    private TreeNode cur;
    private Queue<TreeNode> queue;


    public CBTInserter(TreeNode root) {
        // init
        this.root = root;
        queue = new LinkedList<>();
        queue.add(root);
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode top = queue.poll();
            queue.add(top.left);
            queue.add(top.right);
        }

        cur = queue.poll();
        if(cur.left != null){
            queue.add(cur.left);
        }
    }

    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        queue.add(newNode);
        if (cur.left == null) {
            cur.left = newNode;
        } else if (cur.right == null) {
            cur.right = newNode;
        } else {
            cur = queue.poll();
            cur.left = newNode;
        }

        return cur.val;
    }


    public TreeNode get_root() {
        return root;
    }
}
