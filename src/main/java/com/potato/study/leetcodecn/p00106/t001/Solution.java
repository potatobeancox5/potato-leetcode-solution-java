package com.potato.study.leetcodecn.p00106.t001;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreePrintUtil;

import java.util.Arrays;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 中序遍历 inorder = [9,3,15,20,7]
 后序遍历 postorder = [9,15,7,20,3]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 中序
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 1 根据 postorder 最后位置 生成首节点
        if (null == postorder || postorder.length == 0) {
            return null;
        }
        int value = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(value);
        // 2 根据 最后位置 将 inorder 拆分
        int[][] tmp = splitInorderArrayByValue(inorder, value);
        int[] leftInorder = tmp[0];
        int[] rightInorder = tmp[1];
        // 3 根据 2结果长度 从头带尾 拆分 inorder
        tmp = splitPostorderArrayByLenth(postorder, leftInorder.length, rightInorder.length);
        int[] leftPostorder = tmp[0];
        int[] rightPostorder = tmp[1];
        // 4 设置1 的左右孩子 递归
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        // 5 返回生成的root step 1
        return root;
    }

    /**
     * 按照 长度 分割 postorder
     * @param postorder
     * @param leftLen
     * @param rightLen
     * @return
     */
    private int[][] splitPostorderArrayByLenth(int[] postorder, int leftLen, int rightLen) {
        int[][] result = new int[2][];
        result[0] = new int[leftLen];
        result[1] = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            result[0][i] = postorder[i];
        }
        for (int i = leftLen; i < leftLen + rightLen; i++) {
            result[1][i-leftLen] = postorder[i];
        }
        return result;
    }

    /**
     * 用 value 分割 inorder
     * @param inorder
     * @param value
     * @return
     */
    private int[][] splitInorderArrayByValue(int[] inorder, int value) {
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value) {
                index = i;
                break;
            }
        }
        // 按照index 分割
        int[][] result = new int[2][];
        result[0] = Arrays.copyOfRange(inorder, 0, index);
        result[1] = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inorder = new int[] {9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode node = solution.buildTree(inorder,postorder);
        TreePrintUtil.pirnt(node);
    }

}
