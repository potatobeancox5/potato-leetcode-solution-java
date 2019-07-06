package com.potato.study.leetcode.p0538;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         538. Convert BST to Greater Tree
 * 
 *         Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
5
/   \
2     13

Output: The root of a Greater Tree like this:
18
/   \
20     13
 * 
 *         思路：
 *          right - mid - left 遍历
 *          
 */
public class Solution {

    int num = 0;

    public TreeNode convertBST(TreeNode root) {
        traverseTree(root);
        return root;
    }

    /**
     *
     * @param root
     * @return
     */
    private void traverseTree(TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.right != null) {
            traverseTree(root.right);
        }
        // do sth
        root.val += num;
        num = root.val;
        if (root.left != null) {
            traverseTree(root.left);
        }
    }
	
	public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
