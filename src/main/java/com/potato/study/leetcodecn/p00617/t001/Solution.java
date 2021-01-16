package com.potato.study.leetcodecn.p00617.t001;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 617. 合并二叉树
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

 示例 1:

 输入:
 Tree 1                     Tree 2
 1                         2
 / \                       / \
 3   2                     1   3
 /                           \   \
 5                             4   7
 输出:
 合并后的树:
 3
 / \
 4   5
 / \   \
 5   4   7
 注意: 合并必须从两个树的根节点开始。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 合并二叉树
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode node = new TreeNode(0);
        if (t1 != null) {
            node.val += t1.val;
        }
        if (t2 != null) {
            node.val += t2.val;
        }
        if (t1 != null && t2 != null) {
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
        } else if (t1 != null) {
            node.left = mergeTrees(t1.left, null);
            node.right = mergeTrees(t1.right, null);
        } else if (t2 != null) {
            node.left = mergeTrees(null, t2.left);
            node.right = mergeTrees(null, t2.right);
        }
        return node;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

        TreeNode root = solution.mergeTrees(null, null);


    }
}
