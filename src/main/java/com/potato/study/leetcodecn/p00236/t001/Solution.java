package com.potato.study.leetcodecn.p00236.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 236. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

  

 示例 1：


 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 输出：3
 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 示例 2：


 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 输出：5
 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 示例 3：

 输入：root = [1,2], p = 1, q = 2
 输出：1
  

 提示：

 树中节点数目在范围 [2, 105] 内。
 -109 <= Node.val <= 109
 所有 Node.val 互不相同 。
 p != q
 p 和 q 均存在于给定的二叉树中。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 从 root 开始 找 如果 pq 在同一个节点当前点下边 那就往下找找
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            throw new RuntimeException("这输入扯淡呢么");
        }
        // 当前点的孩子 左孩子是否包含 2个点 是的话 往左孩子找 公共点
        if (root.left != null && contain(root.left, p, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 当前点孩子 右孩子 是否 包含 2个点 是的话 往右孩子 找 公共点
        if (root.right != null && contain(root.right, p, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 两个点 分散于 当前 root的两侧 直接返回 root
        return root;
    }


    /**
     * 当前节点 的子树是否包含两个节点
     * 遍历 获得结果 层序吧
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean contain(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean contain1 = false;
        boolean contain2 = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == p) {
                contain1 = true;
            }
            if (poll == q) {
                contain2 = true;
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return contain1 && contain2;
    }
}
