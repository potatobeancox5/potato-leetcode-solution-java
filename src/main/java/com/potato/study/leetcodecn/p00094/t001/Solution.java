package com.potato.study.leetcodecn.p00094.t001;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,3,2]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(result, root);
        return result;
    }

    /**
     *
     * @param result 记录结果
     * @param root
     */
    private void inorderTraversal(List<Integer> result, TreeNode root) {
        if (null == root) {
            return;
        }
        inorderTraversal(result, root.left);
        result.add(root.val);
        inorderTraversal(result, root.right);
        return;
    }


    public static void main(String[] args) {

    }
}
