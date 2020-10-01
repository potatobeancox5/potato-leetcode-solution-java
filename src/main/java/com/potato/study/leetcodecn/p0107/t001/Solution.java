package com.potato.study.leetcodecn.p0107.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层次遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其自底向上的层次遍历为：

 [
 [15,7],
 [9,20],
 [3]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 输出是从底层网上的， 还是用层序遍历，速出的时候 直接插入到index 0 位置即可 使用linklist
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode> currentLayer = new LinkedList<>();
        currentLayer.add(root);
        Queue<TreeNode> nextLayer = new LinkedList<>();

        List<Integer> layerResult = new ArrayList<>();

        while (!currentLayer.isEmpty()) {

            TreeNode node = currentLayer.poll();
            layerResult.add(node.val);

            if (null != node.left) {
                nextLayer.add(node.left);
            }

            if (null != node.right) {
                nextLayer.add(node.right);
            }

            if (currentLayer.isEmpty()) {
                result.add(0, layerResult);
                layerResult = new ArrayList<>();
                if (!nextLayer.isEmpty()) {
                    currentLayer.addAll(nextLayer);
                    nextLayer.clear();
                }
            }
        }
        return result;
    }
}
