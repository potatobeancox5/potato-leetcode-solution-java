package com.potato.study.leetcode.p1302;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1302. Deepest Leaves Sum
 *  
 *Given a binary tree, return the sum of values of its deepest leaves.


Example 1:



Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15


Constraints:

The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
 *         
 *
 *         思路：
 *          bsf 一直维护 当前层的叶子数量
 *
 *
 *
 *

 *
 */
public class Solution {

    public int deepestLeavesSum(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int layerSum = 0;
        while (!queue.isEmpty()) {
            // layer
            int layerSize = queue.size();
            layerSum = 0;
            for (int i = 0; i < layerSize; i++) {
                TreeNode node = queue.poll();
                layerSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return layerSum;
    }

	public static void main(String[] args) {
    }
}
