package com.potato.study.leetcode.p1110;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1110. Delete Nodes And Return Forest
 *  
 *         Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.



Example 1:



Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]


Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
 *         
 *         思路：
 *          每找到一个点 进行删除 将孩子们放入 set中 以便于下一步删除
 *
 *

 *
 */
public class Solution {

    private Set<TreeNode> treeSet;

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        // 初始化set 并按照 toelete 进行删除
        treeSet = new HashSet<>();
        treeSet.add(root);
        deleteTheNode(toDelete);
        return new ArrayList<>(treeSet);
    }

    /**
     * 删除 toDelete 的值的节点，并将删除后的结果加入到set中
     * @param toDelete      要删除的树
     */
    private void deleteTheNode(int[] toDelete) {
        for (int target : toDelete) {
            for (TreeNode tree : treeSet) {
                // 找到删除节点
                TreeNode targetNode = findTheNodeWithVal(target, tree);
                if (null == targetNode) {
                    continue;
                }
            }

        }
    }

    /**
     * 找到指定数字的节点
     * @param target
     * @return
     */
    private TreeNode findTheNodeWithVal(int target, TreeNode root) {
        if (null == root) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        if (root.left != null) {
            TreeNode leftRes = findTheNodeWithVal(target, root.left);
            if (leftRes != null) {
                return leftRes;
            }
        }
        if (root.right != null) {
            TreeNode rightRes = findTheNodeWithVal(target, root.right);
            if (rightRes != null) {
                return rightRes;
            }
        }
        // 没有命中节点
        return null;
    }
	
	public static void main(String[] args) {

    }
}
