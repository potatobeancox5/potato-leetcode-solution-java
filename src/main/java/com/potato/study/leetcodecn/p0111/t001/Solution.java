package com.potato.study.leetcodecn.p0111.t001;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 111. 二叉树的最小深度

 *
 * 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明：叶子节点是指没有子节点的节点。

  

 示例 1：


 输入：root = [3,9,20,null,null,15,7]
 输出：2
 示例 2：

 输入：root = [2,null,3,null,4,null,5,null,6]
 输出：5
  

 提示：

 树中节点数的范围在 [0, 105] 内
 -1000 <= Node.val <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public int minDepth(TreeNode root) {
        // 空树 返回 0
        if (null == root) {
            return 0;
        }
        // 只有一个叶子节点 返回 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 不止有一个叶子节点
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        // 不可能 同时 为 0 因为之前已经处理过
        if (leftMinDepth == 0) {
            return rightMinDepth + 1;
        } else if (rightMinDepth == 0) {
            return leftMinDepth + 1;
        } else {
            return 1 + Math.min(leftMinDepth, rightMinDepth);
        }
    }

    public static void main(String[] args) {

    }
}
