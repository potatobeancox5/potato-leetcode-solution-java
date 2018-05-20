package com.potato.study.leetcode.p0105;

import java.util.Arrays;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         105. Construct Binary Tree from Preorder and Inorder Traversal
 *         
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 *       
]
 *
 *         思路： 给两个数组 分别代表 二叉树的先序遍历序列和中序遍历序列 构造出一棵树
 *         如果两个数组有一个是null时 ，返回null
 *         取先序遍历的节点作为当前节点 即当前子树的根节点 返回这个节点哦
 *         		利用这个节点的值在中序遍历中查找当前节点的位置
 *         		四种情况
 *         			当前中序序列只有root一个值 那么 当前节点左右孩子都是null 直接返回
 *         			当前结点位于中序序列的第一个值
 *         				root。right = buildTree（先序序列的子数组（不要第一个值，中序序列的其它值））
 *         			当前节点位于中序序列的最后一个值
 *         				root。left = buildTree（先序序列的子数组（不要最后一个值，中序序列的其它值））
 *         			当前节点位于中序序列的中间
 *         				root。left = buildTree（先序序列的子数组（不要第一个值，中序序列的其它值））
 *         				root。right = buildTree（先序序列的子数组（不要第一个值，中序序列的其它值））
 *         			四种情况都返回root
 *         			q： 右子树第一个节点怎么确定 利用分割后中序序列的长度计算
 */
public class Solution {

	/**
	 * 根据先序遍历和中序遍历 建立一颗二叉树
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
        	return null;
        }
        int curVal = preorder[0];
        TreeNode node = new TreeNode(curVal);
        //查找当前node index
        int curIndex = 0;
        while(inorder[curIndex] != curVal) {
        	curIndex++;
        }
        if(inorder.length == 1) { // 当前节点为叶子节点
        	return node;
        } else if (curIndex == 0) { // 只有右子树
        	node.right = buildTree(Arrays.copyOfRange(preorder, 1, preorder.length), 
        			Arrays.copyOfRange(inorder, 1, inorder.length));
        } else if (curIndex == inorder.length - 1) { // 只有左子树
        	node.left = buildTree(Arrays.copyOfRange(preorder, 1, preorder.length), 
        			Arrays.copyOf(inorder, inorder.length - 1));
        } else {
        	node.left = buildTree(Arrays.copyOfRange(preorder, 1, curIndex + 1), 
        			Arrays.copyOf(inorder, curIndex)); // 截取inorder 的前面 curIndex个元素
        	node.right = buildTree(Arrays.copyOfRange(preorder, 1 + curIndex, preorder.length), 
        			Arrays.copyOfRange(inorder, curIndex + 1, inorder.length));
        }
        return node;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode root = solution.buildTree(preorder, inorder);
		TreeNodeUtil.printBSTTreeNodeInArrayString(root, 3);
	}
}
