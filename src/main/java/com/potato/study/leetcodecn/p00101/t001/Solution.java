package com.potato.study.leetcodecn.p00101.t001;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。

  

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3
  

 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
  

 进阶：

 你可以运用递归和迭代两种方法解决这个问题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/symmetric-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 每次 往下传2个节点 进行比较
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return compareNodes(root.left, root.right);
    }


    public boolean compareNodes(TreeNode left, TreeNode right) {
        if (null == right && null == left) {
            return true;
        }

        if (null != right && null != left) {
            if (right.val != left.val) {
                return false;
            }
            return compareNodes(left.left, right.right) && compareNodes(left.right, right.left);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
