package com.potato.study.leetcode.p0106;

import java.util.Arrays;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *  106. Construct Binary Tree from Inorder and Postorder Traversal
 *         
 *Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 *       
]
 *
 *         思路：
 */
public class Solution {

	/**
	 * 根据后序遍历和中序遍历 建立一颗二叉树
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
			return null;
		}
		int curVal = postorder[postorder.length - 1];
		TreeNode node = new TreeNode(curVal);
		// 查找当前node index
		int curIndex = 0;
		while (inorder[curIndex] != curVal) {
			curIndex++;
		}
		if (inorder.length == 1) { // 当前节点为叶子节点
			return node;
		} else if (curIndex == 0) { // 只有右子树
			node.right = buildTree(Arrays.copyOfRange(inorder, 1, inorder.length), 
					Arrays.copyOf(postorder, postorder.length - 1));
		} else if (curIndex == inorder.length - 1) { // 只有左子树
			node.left = buildTree(Arrays.copyOf(inorder, inorder.length - 1), 
					Arrays.copyOf(postorder, postorder.length - 1));
		} else {
			node.right = buildTree(Arrays.copyOfRange(inorder, curIndex + 1, inorder.length),
					Arrays.copyOfRange(postorder, curIndex, postorder.length - 1));
			node.left = buildTree(Arrays.copyOf(inorder, curIndex), 
					Arrays.copyOfRange(postorder, 0, curIndex)); 
		}
		return node;
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode root = solution.buildTree(inorder, postorder);
		TreeNodeUtil.printBSTTreeNodeInArrayString(root, 3);
	}
}
