package com.potato.study.leetcodecn.p00173.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

 调用 next() 将返回二叉搜索树中的下一个最小的数。

  

 示例：



 BSTIterator iterator = new BSTIterator(root);
 iterator.next();    // 返回 3
 iterator.next();    // 返回 7
 iterator.hasNext(); // 返回 true
 iterator.next();    // 返回 9
 iterator.hasNext(); // 返回 true
 iterator.next();    // 返回 15
 iterator.hasNext(); // 返回 true
 iterator.next();    // 返回 20
 iterator.hasNext(); // 返回 false
  

 提示：

 next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BSTIterator {

    private TreeNode root;

    // 使用栈 模拟 一个 程序堆栈 peek 就是下一个要遍历的节点
    private Stack<TreeNode> stack;

    /**
     * 其实很简单 就是 二叉搜索树的先序遍历 使用 类遍历 记录 nextNode
     * @param root
     */
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.stack = new Stack<>();
        // 放入每个节点的左孩子
        stack.push(root);
        while (stack.peek().left != null) {
            stack.push(stack.peek().left);
        }
    }

    public int next() {
        // 用户 保证不能是空
        if (!hasNext()) {
            return -1;
        }
        // stack 栈顶就是最小的元素
        TreeNode smallest = stack.pop();
        // 处理右孩子门
        if (smallest.right != null) {
            TreeNode p = smallest.right;
            while (p != null) {
                stack.add(p);
                p = p.left;
            }
        }
        return smallest.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }



    private void bsf (TreeNode root) {
        if (root == null) {
            return;
        }
        bsf(root.left);
        // visit
        bsf(root.right);
    }
}
