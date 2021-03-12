package com.potato.study.leetcodecn.p00543.t001;


import com.potato.study.leetcode.domain.TreeNode;
import org.junit.Assert;

/**
 * 543. 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

  

 示例 :
 给定二叉树

 1
 / \
 2   3
 / \
 4   5
 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

  

 注意：两结点之间的路径长度是以它们之间边的数目表示。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    private int max = 0;

    /**
     * 对于当前 点 分别找到 左孩子和右孩子的最大值 然后宽度 就是 左孩子的最大值和右孩子的最大值， + 当前节点（1）
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        this.getAndComputeLength(root);
        return max - 1;
    }


    private int getAndComputeLength (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPathLen = 0;
        if (root.left != null) {
            leftPathLen = getAndComputeLength(root.left);
        }
        int rightPathLen = 0;
        if (root.right != null) {
            rightPathLen = getAndComputeLength(root.right);
        }
        //  左孩子的最大值和右孩子的最大值， + 当前节点（1）
        int cur = leftPathLen + rightPathLen + 1;
        this.max = Math.max(this.max, cur);
        return Math.max(leftPathLen, rightPathLen) + 1;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int ints = solution.diameterOfBinaryTree(root);
        System.out.println(ints);
        Assert.assertEquals(3, ints);
    }
}
