package com.potato.study.leetcode.p0099;

import java.util.ArrayList;
import java.util.List;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *        99. Recover Binary Search Tree
 *         
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?
 * 
 *   思路： 
 *   一颗二叉树中有两个节点被错误的交换了 找出来 将这两个节点 换回原位置
 *   中序遍历 BST 遍历出来的序列 应该是升序排列的 
 *   通过记录当前遍历节点 之前的节点 并与当前节点值比较 可以找到两个不是升序排列的位置 在这个两个位置中 
 *   第一个错误的节点为第一次降序时较大的节点(pre)，第二个错误节点为第二次降序时较小的节点（p）
 *   也可能只有一次降序出现 这个时候 直接交换记录下来的两个点的值
 *   
 *   交换两个位置 
 *   pre 记录当前遍历节点 上一个节点的值 p 记录当前遍历节点的值 
 *   
 * 		
 */
public class Solution {	

	public void recoverTree(TreeNode root) {
        if(null == root) {
        	return;
        }
        List<TreeNode> faultNode = new ArrayList<>(4);
        List<TreeNode> pre = new ArrayList<>(1);
        inOrderTraversal(root, pre, faultNode);
        // 交换两个错误节点的值
        if(!faultNode.isEmpty()) {
        	if(faultNode.size() == 2) {
        		int temp = faultNode.get(0).val;
        		faultNode.get(0).val = faultNode.get(1).val;
        		faultNode.get(1).val = temp;
        	} else {        		
        		int temp = faultNode.get(0).val;
        		faultNode.get(0).val = faultNode.get(3).val;
        		faultNode.get(3).val = temp;
        	}
        }
    }
	
	/**
	 * 中序遍历一个BST
	 * @param root			当前遍历的节点
	 * @param pre			上一个遍历的节点  如果之前没有遍历到节点的话 pre = null
	 * @param faultNode 	错误的节点 默认传入 size=2 的ArrayList 有助于记录次序
	 */
	private void inOrderTraversal(TreeNode root, List<TreeNode> pre, List<TreeNode> faultNode) {
		if(null == root) {
			return;
		}
		//遍历左子树
		if(root.left != null) {
			inOrderTraversal(root.left, pre, faultNode);
		}
		// 遍历当前节点
		if(pre.size() > 0 && pre.get(0).val > root.val) { // 遍历过程中出现了中序遍历， 记录当前遍历的界节点 
			faultNode.addAll(pre);
			faultNode.add(root);
		}
		pre.clear();
		pre.add(root);
		// 遍历右子树
		if(root.right != null) {
			inOrderTraversal(root.right, pre, faultNode);
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[3,1,4,null,null,2]");
		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[1,3,null,null,2]");
		solution.recoverTree(root);
		TreeNodeUtil.printBSTTreeNodeInArrayString(root, 3);
	}
}
