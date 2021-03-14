package com.potato.study.leetcodecn.p01038.t001;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 1038. 把二叉搜索树转换为累加树
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

 提醒一下，二叉搜索树满足下列约束条件：

 节点的左子树仅包含键 小于 节点键的节点。
 节点的右子树仅包含键 大于 节点键的节点。
 左右子树也必须是二叉搜索树。
 注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/  相同

  

 示例 1：



 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 示例 2：

 输入：root = [0,null,1]
 输出：[1,null,1]
 示例 3：

 输入：root = [1,0,2]
 输出：[3,3,2]
 示例 4：

 输入：root = [3,2,4,1]
 输出：[7,9,4,10]
  

 提示：

 树中的节点数介于 1 和 100 之间。
 每个节点的值介于 0 和 100 之间。
 树中的所有值 互不相同 。
 给定的树为二叉搜索树。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    private TreeNode preNode;

    /**
     * 如果当前节点 是空 或者叶子节点 直接返回 当前节点
     * 否则
     *
     * 如果当前节点有右孩子，先计算右孩子 并记录右孩子结果
     * 将右孩子计算结果加到当前值上
     *
     * 计算左孩子
     *
     * 返回
     * 存在 问题 如果当前点 是某个左孩子的右叶子，那么 它需要加上所有的右孩子的值
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {
        // 空节点 和叶子节点 可以直接返回
        if (null == root) {
            return null;
        }
        // 如果当前节点有右孩子，先计算右孩子 并记录右孩子结果
        if (root.right != null) {
            bstToGst(root.right);
            // 计算当前节点
//            root.val += root.right.val;
        }
        if (null != preNode) {
            root.val += preNode.val;
        }
        preNode = root;
        // 如果左边节点不空的话 左边节点 加上他的父亲节点目前的值
        if (root.left != null) {
            // 先加上双亲节点值 再往里算
//            root.left.val += root.val;
            bstToGst(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        TreeNode node = solution.bstToGst(root);
        System.out.println(node.left);
//        root.
//        System.out.println();
    }
}
