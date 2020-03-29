package com.potato.study.leetcode.p1022;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	1022. Sum of Root To Leaf Binary Numbers
 *  
 *         Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.



Example 1:



Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22


Note:

The number of nodes in the tree is between 1 and 1000.
node.val is 0 or 1.
The answer will not exceed 2^31 - 1.
 *         
 *         思路：
 *
 *
 *
 */
public class Solution {

    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {

        if (null == root) {
            return 0;
        }
        sumRootToLeaf(root, 0);
        return sum;
    }

    private void sumRootToLeaf(TreeNode root, int parentNum) {

        int nodeValue = parentNum * 2;
        nodeValue += root.val;

        if (root.left == null && root.right == null) {
            this.sum += nodeValue;
        }

        if (root.left != null) {
            sumRootToLeaf(root.left, nodeValue);
        }

        if (root.right != null) {
            sumRootToLeaf(root.right, nodeValue);
        }
        return;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);


        int res = solution.sumRootToLeaf(root);
        System.out.println(res);
    }
}
