package com.potato.study.leetcode.p0222;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *      222. Count Complete Tree Nodes
 * 
 *
 * Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
1
/ \
2   3
/ \  /
4  5 6

Output: 6
 *
 * 题目需求： 查完全二叉树节点数量
 * 思路：直接递归会导致超时，每层都需要进行遍历
 *      减枝 采用 只计算两边树叶的深度判断是否需要进行进一步的计算
 *  https://blog.csdn.net/xudli/article/details/46385011
 */
public class Solution {

    /**
     * 通过树的高度 计算完全二叉树节点树
     * num = 2 ^ n - 1个节点树 对于
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = this.getLeftHeightOfHead(root.left);
        int rHeight = this.getRightHeightOfHead(root.right);
        if (lHeight == rHeight) {
            return (2 << lHeight) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    /**
     * 获取该树左边叶子深度
     * @param head
     * @return
     */
    private int getLeftHeightOfHead (TreeNode head) {
        int height = 0;
        TreeNode p = head;
        while (null != p) {
            p = p.left;
            height++;
        }
        return height;
    }

    /**
     * 获取该树右边叶子深度
     * @param head
     * @return
     */
    private int getRightHeightOfHead (TreeNode head) {
        int height = 0;
        TreeNode p = head;
        while (null != p) {
            p = p.right;
            height++;
        }
        return height;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		String tree = "[1,2,3,4,5,6]";
//		String tree = "[1,2,3,4]";
        TreeNode head = TreeNodeUtil.generateTreeByArrayString(tree);
		int count = solution.countNodes(head);
		System.out.println(count);
	}
}
