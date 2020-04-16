package com.potato.study.leetcode.p0865;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	865. Smallest Subtree with all the Deepest Nodes
 *  
 *        Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.

A node is deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is that node, plus the set of all descendants of that node.

Return the node with the largest depth such that it contains all the deepest nodes in its subtree.



Example 1:

Input: [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation:



We return the node with value 2, colored in yellow in the diagram.
The nodes colored in blue are the deepest nodes of the tree.
The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
Both the input and output have TreeNode type.


Note:

The number of nodes in the tree will be between 1 and 500.
The values of each node are unique.
 *         
 *
 *         题目含义：
 *              返回 一个子树 子树必须 包含左右的 最深的节点

 *         思路：
 *          https://www.cnblogs.com/grandyang/p/10703653.html
 *

 *
 *
 *
 */
public class Solution {

    private Map<TreeNode, Integer> depthMap = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (null == root) {
            return root;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) {
            return root;
        } else if (left < right) {
            return subtreeWithAllDeepest(root.right);
        } else {
            // left > right
            return subtreeWithAllDeepest(root.left);
        }
    }

    /**
     * 递归 计算深度
     * @param root
     * @return
     */
    private int getDepth(TreeNode root) {
        if (depthMap.containsKey(root)) {
            return depthMap.get(root);
        }
        if (root == null) {
            return 0;
        }
        int maxDep = Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        depthMap.put(root, maxDep);
        return maxDep;
    }




	public static void main(String[] args) {}
}
