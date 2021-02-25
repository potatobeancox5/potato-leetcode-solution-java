package com.potato.study.leetcodecn.p00096.t001;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

 假设一个二叉搜索树具有如下特征：

 节点的左子树只包含小于当前节点的数。
 节点的右子树只包含大于当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。
 示例 1:

 输入:
 2
 / \
 1   3
 输出: true
 示例 2:

 输入:
 5
 / \
 1   4
      / \
     3   6
 输出: false
 解释: 输入为: [5,1,4,null,null,3,6]。
      根节点的值为 5 ，但是其右子节点值为 4 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 按照定义 当前节点 大于左孩子最大值，小于右子树的最小值
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        return isAllChildSmall(root.val, root.left) && isAllChildBig(root.val, root.right)
                && isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isAllChildBig(int val, TreeNode node) {
        if (null == node) {
            return true;
        }
        if (node.val <= val) {
            return false;
        }
        // 孩子呢
        return isAllChildBig(val, node.left) && isAllChildBig(val, node.right);
    }

    /**
     * node 和 他的孩子是否不超过val
     * @param val
     * @param node
     * @return
     */
    private boolean isAllChildSmall(int val, TreeNode node) {
        if (null == node) {
            return true;
        }
        if (node.val >= val) {
            return false;
        }
        // 孩子呢
        return isAllChildSmall(val, node.left) && isAllChildSmall(val, node.right);
    }


    public static void main(String[] args) {

    }
}
