package com.potato.study.leetcode.p0530;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         530. Minimum Absolute Difference in BST
 * 
 *        Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

1
\
3
/
2

Output:
1
i
Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


Note: There are at least two nodes in this BST.

 *         思路：
 *         中序遍历二叉树， 记下上一个的数字，比较两个差
 */
public class Solution {

    private int minDIf = Integer.MAX_VALUE;
    private int lastNodeValue;
    private boolean isFirstNode = true;

    public int getMinimumDifference(TreeNode root) {
        traverseInorder(root);
        return minDIf;
    }

    private void traverseInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            traverseInorder(root.left);
        }
        // do sth
        if (isFirstNode) {
            isFirstNode = false;
            lastNodeValue = root.val;
        } else {
            int currentDif = Math.abs(root.val - lastNodeValue);
            if (minDIf > currentDif) {
                minDIf = currentDif;
            }
            lastNodeValue = root.val;
        }
        if (root.right != null) {
            traverseInorder(root.right);
        }

    }
	
	public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        root.right = root1;
        root1.left = root2;



        int minimumDifference = solution.getMinimumDifference(root);
        System.out.println(minimumDifference);
    }
}
