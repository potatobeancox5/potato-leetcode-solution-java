package com.potato.study.leetcodecn.p00897.t001;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreePrintUtil;

/**
 * 897. 递增顺序查找树
 *
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。

  

 示例 ：

 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]

 5
 / \
 3    6
 / \    \
 2   4    8
  /        / \
 1        7   9

 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
   \
    2
     \
      3
       \
        4
         \
          5
           \
            6
             \
              7
               \
                8
                 \
 9
  

 提示：

 给定树中的结点数介于 1 和 100 之间。
 每个结点都有一个从 0 到 1000 范围内的唯一整数值。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 中序遍历 树
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null, false);
    }

    /**
     * 展开二叉树 将 left 的右孩子 设置为 root
     * @param node 当前节点
     * @param next node right 指向节点
     */
    private TreeNode increasingBST(TreeNode node, TreeNode next, boolean canConnect) {
        // 当前 node 为空 直接返回
        if (node == null) {
            return null;
        }
        // 如果当前节点又做孩子 先处理左孩子的问题 左孩子下一个节点 就是当前跟 中序遍历 做孩子 当前 右孩子
        TreeNode leftMostChild = node;
        if (node.left != null) {
            leftMostChild = increasingBST(node.left, node, true);
        }
        TreeNode rightChild = node.right;
        // 当前点没有左孩子 连接当前节点
        if (canConnect) {
            node.right = node;
        } else {
            node.right = increasingBST(rightChild, null, false);
        }
        // 当前节点有右孩子
        if (rightChild != null) {
            increasingBST(rightChild, null, false);
        }
        // 返回最左的孩子
        return leftMostChild;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode node = solution.increasingBST(root);
        TreePrintUtil.pirnt(node);
    }
}
