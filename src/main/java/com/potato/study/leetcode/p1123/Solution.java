package com.potato.study.leetcode.p1123;


import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreePrintUtil;


/**
 * 
 * @author liuzhao11
 * 
 * 	1123. Lowest Common Ancestor of Deepest Leaves
 *  
 *         Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.

Recall that:

The node of a binary tree is a leaf if and only if it has no children
The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.


Example 1:

Input: root = [1,2,3]
Output: [1,2,3]
Explanation:
The deepest leaves are the nodes with values 2 and 3.
The lowest common ancestor of these leaves is the node with value 1.
The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".
Example 2:

Input: root = [1,2,3,4]
Output: [4]
Example 3:

Input: root = [1,2,3,4,5]
Output: [2,4,5]


Constraints:

The given tree will have between 1 and 1000 nodes.
Each node of the tree will have a distinct value between 1 and 1000.

 *         
 *         思路：
 *
 *          https://github.com/grandyang/leetcode/issues/1123
 *          从根节点开始连接树
 *          如果当前节点 左右节点深度一致说明 这个节点是要得到的父亲节点，
 *          否则比较左右孩子深度 父亲节点是左右孩子中深的那一个
 *
 */
public class Solution {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (null == root) {
            return null;
        }
        int leftHeight = getTheDepth(root.left);
        int rightHeight = getTheDepth(root.right);
        if (leftHeight == rightHeight) {
            return root;
        }
        return leftHeight > rightHeight ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
    }

    private int getTheDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int depth = Math.max(getTheDepth(root.left), getTheDepth(root.right)) + 1;
        return depth;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        TreeNode root = null;
        TreeNode array = solution.lcaDeepestLeaves(root);
        TreePrintUtil.pirnt(array);
    }
}
