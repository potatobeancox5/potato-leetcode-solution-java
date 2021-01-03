package com.potato.study.leetcodecn.p00103.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回锯齿形层次遍历如下：

 [
 [3],
 [20,9],
 [15,7]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 还是层序遍历 在处理结果时做手脚
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        //
        Queue<TreeNode> currentLayer = new LinkedList<>();
        currentLayer.add(root);
        // 双端队列
        Queue<TreeNode> nextLayerDeque = new LinkedList<>();

        LinkedList<Integer> layerResult = new LinkedList<>();
        // 计数器
        int count = 0;

        while (!currentLayer.isEmpty()) {
            TreeNode node = currentLayer.poll();
            if (count % 2 == 0) {
                layerResult.addLast(node.val);
            } else {
                layerResult.addFirst(node.val);
            }

            if (node.left != null) {
                nextLayerDeque.add(node.left);
            }
            if (node.right != null) {
                nextLayerDeque.add(node.right);
            }
            // 是否需要换行
            if (currentLayer.isEmpty()) {
                result.add(layerResult);
                layerResult = new LinkedList<>();
                count++;
                if ((!nextLayerDeque.isEmpty())) {
                    currentLayer.addAll(nextLayerDeque);
                    nextLayerDeque.clear();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
