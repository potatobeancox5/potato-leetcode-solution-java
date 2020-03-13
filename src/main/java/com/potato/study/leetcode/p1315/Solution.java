package com.potato.study.leetcode.p1315;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	1315. Sum of Nodes with Even-Valued Grandparent
 *  
 *
Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)

If there are no nodes with an even-valued grandparent, return 0.



Example 1:



Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.


Constraints:

The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
 *         
 *         思路：
 *          当前节点 如果为 偶数 直接 计算 孙子节点值 并奇数 直接往下走
 *
 *
 *
 *

 *
 */
public class Solution {

    public int sumEvenGrandparent(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int sum = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    sum += root.left.left.val;
                }
                if (root.left.right != null) {
                    sum += root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    sum += root.right.left.val;
                }
                if (root.right.right != null) {
                    sum += root.right.right.val;
                }
            }
        }
        sum += sumEvenGrandparent(root.left);
        sum += sumEvenGrandparent(root.right);
        return sum;
    }

	public static void main(String[] args) {
    }
}
