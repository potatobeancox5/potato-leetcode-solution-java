package com.potato.study.leetcodecn.p00124.t001;

import com.potato.study.leetcode.domain.TreeNode;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 124. 二叉树中的最大路径和
 *
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。

 路径和 是路径中各节点值的总和。

 给你一个二叉树的根节点 root ，返回其 最大路径和 。

  

 示例 1：


 输入：root = [1,2,3]
 输出：6
 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 示例 2：


 输入：root = [-10,9,20,null,null,15,7]
 输出：42
 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
  

 提示：

 树中节点数目范围是 [1, 3 * 104]
 -1000 <= Node.val <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    private int max;

    /**
     * 从root 点出发 遍历整个树，对于每个节点 找到节点中符合题目含义的最大路径
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            // visit
            int left = getMaxPathFromRoot2Leaf(poll.left);
            int right = getMaxPathFromRoot2Leaf(poll.right);
            int current = poll.val;
            if (left > 0) {
                current += left;
            }
            if (right > 0) {
                current += right;
            }
            max = Math.max(max, current);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return this.max;
    }

    /**
     * 找到从 root 开始 往 叶子走 权值最大的路径 必须包括 root 节点
     * @param root
     * @return
     */
    private int getMaxPathFromRoot2Leaf(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = getMaxPathFromRoot2Leaf(root.left);
        int right = getMaxPathFromRoot2Leaf(root.right);
        int maxPathVal = Math.max(0, Math.max(left, right));
        return root.val + maxPathVal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int maxPathSum = solution.maxPathSum(root);
        System.out.println(maxPathSum);
        Assert.assertEquals(6, maxPathSum);


        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        maxPathSum = solution.maxPathSum(root);
        System.out.println(maxPathSum);
        Assert.assertEquals(42, maxPathSum);
    }

}
