package com.potato.study.leetcodecn.p00105.t001;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreePrintUtil;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 通过 preorder 和 inorder 去生成 二叉树 可以确认的是 当前节点 就是 pre的第一个节点
     * 每次 生成节点
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (null == preorder || null == inorder || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        return buildTree(preorder, inorder, null, false, 0, preorder.length - 1,
                0, inorder.length - 1);
    }


    /**
     * 生成 二叉树
     * 每次 确定了一个 位置之后 就能确定左右子树 在 preorder 和 inorder 中对应的位置
     *
     * @param preorder  先序遍历 数组 preorder
     * @param inorder   中序遍历 数组 inorder 存放所有
     * @param parent    父亲节点
     * @param isLeft    是否是做孩子
     * @param preStart  当前 处理到先序列表的那个位置 开始位置 include
     * @param preEnd    当前 处理到先序列表的那个位置 结束位置 include
     * @param inStart   当前 处理到中序列表的那个位置
     * @param inEnd   当前 处理到中序列表的那个位置
     */
    private TreeNode buildTree(int[] preorder, int[] inorder, TreeNode parent, boolean isLeft, int preStart, int preEnd,
                           int inStart, int inEnd) {
        TreeNode node = new TreeNode(preorder[preStart]);
        // 处理父子关系
        if (parent != null) {
            if (isLeft) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        // 找到 preStart 对应 的 inorder 的位置
        int index;
        for (index = inStart; index <= inEnd; index++) {
            if (preorder[preStart] == inorder[index]) {
                break;
            }
        }
        // 计算左子树和 右子树的孩子数量
        int leftChildNum = index - inStart;
        int rightChildNum = inEnd - index;

        if (leftChildNum == 0 && rightChildNum == 0) {
            return node;
        } else if (leftChildNum == 0) {
            // 左子树为空了 直接构造右子树哈
            int rightPreStart = preStart + 1;
            int rightPreEnd = preEnd;
            int rightInStart = index + 1;
            int rightInEnd = inEnd;
            buildTree(preorder, inorder, node, false, rightPreStart, rightPreEnd, rightInStart, rightInEnd);

        } else if (rightChildNum == 0) {
            // 左子树
            int leftPreStart = preStart + 1;
            int leftPreEnd = preEnd;
            int leftInStart = inStart;
            int leftInEnd = index - 1;
            buildTree(preorder, inorder, node, true, leftPreStart, leftPreEnd, leftInStart, leftInEnd);

        } else {
            // 先序遍历的开始和结束位置
            int leftPreStart = preStart + 1;
            int leftPreEnd = leftPreStart + leftChildNum - 1;
            int leftInStart = inStart;
            int leftInEnd = index - 1;

            int rightPreStart = leftPreEnd + 1;
            int rightPreEnd = rightPreStart + rightChildNum - 1;
            int rightInStart = index + 1;
            int rightInEnd = inEnd;

            buildTree(preorder, inorder, node, true, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
            buildTree(preorder, inorder, node, false, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
        }
        return node;
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode node = solution.buildTree(preorder, inorder);
        TreePrintUtil.pirnt(node);
    }
}
