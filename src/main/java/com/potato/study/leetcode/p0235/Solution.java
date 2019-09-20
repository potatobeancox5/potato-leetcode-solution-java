package com.potato.study.leetcode.p0235;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *      235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
Example 1:

Input: root, p = 2, q = 8
Output: 6 
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root, p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
             according to the LCA definition.      
 * 
 * 思路：寻找两个节点的公共祖先
 * [思路]
	因为给定的节点已经是树中的节点了
如果如果p,q 比root小, 则LCA必定在左子树, 如果p,q比root大, 则LCA必定在右子树. 如果一大一小, 则root即为LCA.
 *  https://blog.csdn.net/xudli/article/details/46838747
 */
public class Solution {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
        	return null;
        }
        if(root.val > p.val && root.val > q.val) {
        	return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val){
        	return lowestCommonAncestor(root.right, p, q);
        } else { // 一个大一个小 或者其中有一个相等 说明 此节点 就是lca
        	return root;
        } 	
    }
	
    public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();
//		
//		int val = solution.lowestCommonAncestor(root, p, q).val;
	}
}
