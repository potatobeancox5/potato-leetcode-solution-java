package com.potato.study.leetcodecn.p00450.t001;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 450. 删除二叉搜索树中的节点
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

 一般来说，删除节点可分为两个步骤：

 首先找到需要删除的节点；
 如果找到了，删除它。
 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

 示例:

 root = [5,3,6,2,4,null,7]
 key = 3

 5
 / \
 3   6
 / \   \
 2   4   7

 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

 5
 / \
 4   6
 /     \
 2       7

 另一个正确答案是 [5,2,6,null,4,null,7]。

 5
 / \
 2   6
 \   \
 4   7

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return root;
        }
        // 已经找到了
        if (root.val < key) {
            // 左子树里边操作删除
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            // 右子树里边操作删除
            root.left = deleteNode(root.left, key);
        } else {
            // 相等 找到了 待删除的节点
            if (root.left == null && root.right == null) {
                // 叶子
                return null;
            }
            // 只有一个孩子
            if (root.left != null && root.right == null) {
                return root.left;
            }
            if (root.left == null && root.right != null) {
                return root.right;
            }
            // 2个孩子都有 找到右子树的 最左边的节点 替换
            TreeNode target = root.right;
            while (target.left != null) {
                target = target.left;
            }
            // replace and delete
            root.val = target.val;
            deleteNode(root.right, target.val);
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.generateTreeByArrayString("[5,3,6,2,4,null,7]");

        Solution solution = new Solution();
        TreeNode node = solution.deleteNode(root, 3);
        TreeNodeUtil.printBSTTreeNodeInArrayString(node, 3);
    }
}
