package com.potato.study.leetcode.p1008;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	1008. Construct Binary Search Tree from Preorder Traversal
 *  
 *         Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)



Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]



Note:

1 <= preorder.length <= 100
The values of preorder are distinct.
 *         
 *         思路：
 *         数组首元素为树根，找到第一个大于首元素的索引i，则数组[1,i)都是左子树节点，数组[i,n)都是右子树节点。
 *         https://blog.csdn.net/yrk0556/article/details/88380044
 *

 *
 */
public class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        return this.buildTree(preorder, 0, preorder.length - 1);
    }

    /**
     * 构造树
     * @param preorder      先根遍历序列
     * @param rootIndex     根节点位置（起始位置）
     * @param endIndex      结束节点位置
     * @return
     */
    private TreeNode buildTree(int[] preorder, int rootIndex, int endIndex) {
        // 构造root节点
        TreeNode root = new TreeNode(preorder[rootIndex]);

        if (rootIndex == endIndex) {
            return root;
        }
        if (rootIndex > endIndex) {
            return null;
        }

        // 找到第一个大于root的节点 可以分别构造左子树和右子树
        int rightChildIndex = endIndex + 1;
        for (int i = rootIndex + 1; i <= endIndex; i++) {
            if (preorder[i] > preorder[rootIndex]) {
                rightChildIndex = i;
                break;
            }
        }
        if (rightChildIndex == endIndex + 1) { // 到了最后一个节点都没有找到右孩子还是节点，都是左孩子
            root.left = buildTree(preorder, rootIndex + 1, rightChildIndex - 1);
        } else {
            root.left = buildTree(preorder, rootIndex + 1, rightChildIndex - 1);
            root.right = buildTree(preorder, rightChildIndex, endIndex);
        }
        return root;
    }
	
	public static void main(String[] args) {
//		Solution solution = new Solution();

    }
}
