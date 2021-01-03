package com.potato.study.leetcodecn.p00102.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

  

 示例：
 二叉树：[3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        // 当前层需要遍历的队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 缓存下一个要遍历的队列
        Queue<TreeNode> layerQueue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        List<Integer> partResult = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            partResult.add(node.val);
            if (null != node.left) {
                layerQueue.add(node.left);
            }
            if (null != node.right) {
                layerQueue.add(node.right);
            }

            // 当前层已经遍历 完了 去遍历下一层
            if (queue.isEmpty()) {
                // 生成每层结果
                result.add(partResult);
                partResult = new ArrayList<>();
                // 如果还有下一层的话 进行遍历
                if (!layerQueue.isEmpty()) {
                    queue.addAll(layerQueue);
                    layerQueue = new LinkedList<>();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
