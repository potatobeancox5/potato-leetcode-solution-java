package com.potato.study.leetcode.p1110;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.*;

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
 *          遍历树 bfs
 *
 *          https://leetcode.com/problems/delete-nodes-and-return-forest/discuss/554346/JAVA-non-recursive-BFS-solution
 *
 *

 *
 */
public class Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        // 0 root null 处理
        if (null == root) {
            return null;
        }
        // 1 todelete 去重复
        Set<Integer> deleteSet = new HashSet<>();
        for (int delete : toDelete) {
            deleteSet.add(delete);
        }
        // 2 将root 放入queue中 set res 记录当前结果
        Set<TreeNode> resultSet = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        resultSet.add(root);

        // 3 queue feikong pop 如果当前 当前节点要被删除 将孩子们 插入res 且 res 删除当前节点
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (deleteSet.contains(node.val)) {
                resultSet.remove(node);
                if (null != node.left) {
                    resultSet.add(node.left);
                }
                if (null != node.right) {
                    resultSet.add(node.right);
                }
            }
            if (null != node.left) {
                queue.add(node.left);
                if (deleteSet.contains(node.left.val)) {
                    node.left = null;
                }
            }
            if (null != node.right) {
                queue.add(node.right);
                if (deleteSet.contains(node.right.val)) {
                    node.right = null;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

	
	public static void main(String[] args) {

    }
}
