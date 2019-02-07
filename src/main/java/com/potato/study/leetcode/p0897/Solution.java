package com.potato.study.leetcode.p0897;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author liuzhao11
 * <p>
 * 897. Increasing Order Search Tree
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

5
/ \
3    6
/ \    \
2   4    8
/        / \
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

1
\
2
\
3
\
4
\
5
\
6
\
7
\
8
\
9
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.


 * 题目含义：
 *
 *
 *
 * 思路：
 *
 * 中序遍历树 生成list 将list变成一个树
https://blog.csdn.net/qq_38959715/article/details/82454642
 *
 *
 *
 */
public class Solution {

    public TreeNode increasingBST(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        this.inorder(root, treeNodeQueue);
        // 创建新树
        TreeNode head = treeNodeQueue.peek();
        TreeNode pre = new TreeNode(0);
        pre.right = head;
        while (!treeNodeQueue.isEmpty()) {
            TreeNode treeNode = treeNodeQueue.remove();
            pre.right = treeNode;
            pre.left = null;
            pre = pre.right;
        }
        return head;
    }

    private void inorder(TreeNode root, Queue<TreeNode> treeNodeQueue) {
        if (root == null) {
            return;
        }
        // left child
        if (root.left != null) {
            inorder(root.left, treeNodeQueue);
        }
        // this root
        treeNodeQueue.add(new TreeNode(root.val));
        // right child
        if (root.right != null) {
            inorder(root.right, treeNodeQueue);
        }
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        TreeNode head =
                TreeNodeUtil.generateTreeByArrayString("[5,3,6,2,4,null,8,1,null,null,null,7,9]");
        TreeNode treeNode = solution.increasingBST(head);
        System.out.println(treeNode);
    }
}
