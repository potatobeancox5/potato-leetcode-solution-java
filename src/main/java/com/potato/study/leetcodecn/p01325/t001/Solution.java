package com.potato.study.leetcodecn.p01325.t001;


import org.junit.Assert;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;
import com.potato.study.leetcode.util.TreePrintUtil;

/**
 * 1325. 删除给定值的叶子节点
 *
 * 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
 *
 * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
 *
 * 也就是说，你需要重复此过程直到不能继续删除。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,2,null,2,4], target = 2
 * 输出：[1,null,3,null,4]
 * 解释：
 * 上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
 * 有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,3,3,3,2], target = 3
 * 输出：[1,3,null,null,2]
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,null,2,null,2], target = 2
 * 输出：[1]
 * 解释：每一步都删除一个绿色的叶子节点（值为 2）。
 * 示例 4：
 *
 * 输入：root = [1,1,1], target = 1
 * 输出：[]
 * 示例 5：
 *
 * 输入：root = [1,2,3], target = 1
 * 输出：[1,2,3]
 *  
 *
 * 提示：
 *
 * 1 <= target <= 1000
 * 每一棵树最多有 3000 个节点。
 * 每一个节点值的范围是 [1, 1000] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-leaves-with-a-given-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 删除 叶子为 target节点的
     * 递归
     * 如果当前为叶子 直接删除 or 不删除返回 终止条件
     * 如果当前不是叶子 先进行递归 子树删除，再判断这个节点还是不是叶子了
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (null == root) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                return null;
            } else {
                return root;
            }
        }
        // 递归
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        root.left = left;
        root.right = right;
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "[2,5,2,7,null,null,null,null,2]";
        TreeNode root = TreeNodeUtil.generateTreeByArrayString(str);
        TreeNode treeNode = solution.removeLeafNodes(root, 2);
        TreePrintUtil.pirnt(treeNode);
    }
}
