package com.potato.study.leetcodecn.p00404.t001;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 404. 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。

 示例：

 3
 / \
 9  20
 /  \
 15   7

 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        return getLeftLeaves(root, 0);
    }


    /**
     *
     * @param root
     * @param leafType  当前叶子类型 1 是左孩子
     * @return
     */
    private int getLeftLeaves(TreeNode root, int leafType) {
        // root 是空
        if (null == root) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (leafType == 1) {
                return root.val;
            } else {
                return 0;
            }
        }
        return getLeftLeaves(root.left, 1) + getLeftLeaves(root.right, 0);
    }



//    public static void main(String[] args) {
//        TreeNode root = TreeNodeUtil.generateTreeByArrayString("[5,3,6,2,4,null,7]");
//
//        Solution solution = new Solution();
//        TreeNode node = solution.deleteNode(root, 3);
//        TreeNodeUtil.printBSTTreeNodeInArrayString(node, 3);
//    }
}
