package com.potato.study.leetcodecn.p00530.t001;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

  

 示例：

 输入：

 1
 \
 3
 /
 2

 输出：
 1

 解释：
 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
  

 提示：

 树中至少有 2 个节点。
 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    private int min;
    private TreeNode last;

    /**
     * 中序遍历 二叉树， 每次拿到上一个点 然后计算最小值
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
        min = Integer.MAX_VALUE;
        getDifference(root);
        return min;
    }



    /**
     * 中序遍历节点
     * @param root
     * @return  本次返回的点
     */
    private void getDifference(TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            getDifference(root.left);
        }
        // visit root
        if (last != null) {
            min = Math.min(min, Math.abs(root.val - last.val));
        }
        last = root;
        getDifference(root.right);
    }
}
