package com.potato.study.leetcode.p0965;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	965. Univalued Binary Tree
 *  
 *       A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.



Example 1:


Input: [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: [2,2,2,5,2]
Output: false


Note:

The number of nodes in the given tree will be in the range [1, 100].
Each node's value will be an integer in the range [0, 99].
 *         
 *         题目含义：
 *          判定一个树的节点是否都相同
 *         思路：
 *         先序列遍历整个树判定是否是
 *
 *
 *
 * 
 */
public class Solution {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 判断当前节点关系
        if (root.left != null && root.val != root.left.val) {
            return false;
        }

        if (root.right != null && root.val != root.right.val) {
            return false;
        }
        // 根据子树状态判断，该树状态
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }




    public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();

    }
}
