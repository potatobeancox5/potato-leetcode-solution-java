package com.potato.study.leetcodecn.p00144.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。

  示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,2,3]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*
 */
public class Solution {

    /**
     * 先序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(result, root);
        return result;
    }

    /**
     * 访问 root 将其放入 result 中
     * @param result
     * @param root
     */
    private void preorderTraversal(List<Integer> result, TreeNode root) {
        if (null == root) {
            return;
        }
        // 当前
        result.add(root.val);
        // left right
        preorderTraversal(result, root.left);
        preorderTraversal(result, root.right);
    }
}
