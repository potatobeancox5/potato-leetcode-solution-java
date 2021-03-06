package com.potato.study.leetcodecn.p00114.t001;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 114. 二叉树展开为链表

 *
 * 给定一个二叉树，原地将它展开为一个单链表。

  

 例如，给定二叉树

 1
 / \
 2   5
 / \   \
 3   4   6
 将其展开为：

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

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    private TreeNode pre;

    /**
     * 先序 遍历 展开的时候 改变  right 指向
     * @param root
     */
    public void flatten(TreeNode root) {
        // visit this node
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        pre.left = null;
        // visit left
        if (left != null) {
            flatten(left);
        }
        // visit right
        if (right != null) {
            flatten(right);
        }
    }


    /**
     *
     * @param root      当前需要修改的节点
     * @param isLeft    当前节点是不是左左孩子
     * @param last      上一个遍历的节点
     */
    private void preorderTraverse(TreeNode root, boolean isLeft, TreeNode last) {
        // 终止条件
//        if (null == root) {
//            return;
//        }
//        // 没有左孩子
//        if (root.left == null) {
//            last.right = ;
//        }
//        preorderTraverse(root.left);
//        // it
//        root.right = preorderTraverse(root.right);
    }

    public static void main(String[] args) {

    }
}
