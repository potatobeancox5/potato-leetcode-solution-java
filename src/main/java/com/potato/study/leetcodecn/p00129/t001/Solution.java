package com.potato.study.leetcodecn.p00129.t001;

import com.potato.study.leetcode.domain.TreeNode;
import org.junit.Assert;

/**
 * 129. 求根到叶子节点数字之和
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

 例如，从根到叶子节点路径 1->2->3 代表数字 123。

 计算从根到叶子节点生成的所有数字之和。

 说明: 叶子节点是指没有子节点的节点。

 示例 1:

 输入: [1,2,3]
 1
 / \
 2   3
 输出: 25
 解释:
 从根到叶子节点路径 1->2 代表数字 12.
 从根到叶子节点路径 1->3 代表数字 13.
 因此，数字总和 = 12 + 13 = 25.
 示例 2:

 输入: [4,9,0,5,1]
 4
 / \
 9   0
  / \
 5   1
 输出: 1026
 解释:
 从根到叶子节点路径 4->9->5 代表数字 495.
 从根到叶子节点路径 4->9->1 代表数字 491.
 从根到叶子节点路径 4->0 代表数字 40.
 因此，数字总和 = 495 + 491 + 40 = 1026.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        int num = 0;
        return getSum(root, num);
    }

    /**
     *
     * @param root
     * @param num
     * @return
     */
    private int getSum(TreeNode root, int num) {
        if (null == root) {
            return 0;
        }
        num *= 10;
        num += root.val;
        // 叶子了
        if (root.left == null && root.right == null) {
            return num;
        } else if (root.left == null) {
            return getSum(root.right, num);
        } else if (root.right == null) {
            return getSum(root.left, num);
        } else {
            return getSum(root.left, num) + getSum(root.right, num);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        int i = solution.sumNumbers(root);
        System.out.println(i);
        Assert.assertEquals(1, i);
    }




}
