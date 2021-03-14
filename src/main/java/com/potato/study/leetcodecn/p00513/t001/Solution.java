package com.potato.study.leetcodecn.p00513.t001;


import com.potato.study.leetcode.domain.TreeNode;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值。

 示例 1:

 输入:

 2
 / \
 1   3

 输出:
 1
  

 示例 2:

 输入:

 1
 / \
 2   3
 /   / \
 4   5   6
 /
 7

 输出:
 7
  

 注意: 您可以假设树（即给定的根节点）不为 NULL。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * bfs 每次记录 第一个 元素
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (null == root) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode leftMost = null;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    leftMost = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return leftMost.val;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int value = solution.findBottomLeftValue(root);
        System.out.println(value);
        Assert.assertEquals(1, value);
    }

}
