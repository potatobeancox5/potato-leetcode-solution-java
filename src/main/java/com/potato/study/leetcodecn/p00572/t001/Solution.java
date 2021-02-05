package com.potato.study.leetcodecn.p00572.t001;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 572. 另一个树的子树
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

 示例 1:
 给定的树 s:

 3
 / \
 4   5
 / \
 1   2
 给定的树 t：

 4
 / \
 1   2
 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

 示例 2:
 给定的树 s：

 3
 / \
 4   5
 / \
 1   2
 /
 0
 给定的树 t：

 4
 / \
 1   2
 返回 false。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 从 s 的某个节点开始 ，如果与 t 类似开始找 如果不类似 往子树里边找，
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        // 当前点就不同
        if (s.val != t.val) {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        } else {
            return (isSame(s.left, t.left) && isSame(s.right, t.right))
                    || (isSubtree(s.left, t) || isSubtree(s.right, t));
        }
    }

    /**
     *
     * @return
     */
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
