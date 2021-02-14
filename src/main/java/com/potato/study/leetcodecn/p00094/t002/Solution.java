package com.potato.study.leetcodecn.p00094.t002;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

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

    /**
     * 使用迭代 完成算法
     * stack 模拟出入栈
     * 使用visit 记录已经访问的 TreeNode 防止重复访问
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null && !visited.contains(peek.left)) {
                // 依次入栈，对于目前栈顶元素 如果还有左孩子且左孩子还没有visited 左孩子入栈，
                stack.push(peek.left);
            } else {
                // 否则 出栈 visit 然后 如果有右孩子，右孩子入栈 重复1
                TreeNode node = stack.pop();
                visited.add(node);
                res.add(node.val);
                // 处理右孩子
                if (node.right != null && !visited.contains(node.right)) {
                    stack.push(node.right);
                }
            }
        }
        return res;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = solution.inorderTraversal(root);
        System.out.println(list);
    }
}
