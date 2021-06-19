package com.potato.study.leetcodecn.p01026.t001;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Assert;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 1026. 节点与其祖先之间的最大差值
 *
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * 示例 2：
 *
 *
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 树中的节点数在 2 到 5000 之间。
 * 0 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 后续遍历
     *
     * 返回结果 是孩子中 最小值 和 最大值
     *
     * 记录当前值 和 最小值 之间的查询，使用类的成员变量记录，最终返回 成员变量1
     * @param root
     * @return
     */
    public int maxAncestorDiff(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = maxAncestorDiff(root.left);
        int right = maxAncestorDiff(root.right);
        int[] minMaxLeft = getMinMax(root.left);
        int[] minMaxRight = getMinMax(root.right);
        int val = root.val;
        int max = Math.max(left, right);
        if (minMaxLeft != null) {
            max = Math.max(max, Math.abs(val - minMaxLeft[0]));
            max = Math.max(max, Math.abs(val - minMaxLeft[1]));
        }
        if (minMaxRight != null) {
            max = Math.max(max, Math.abs(val - minMaxRight[0]));
            max = Math.max(max, Math.abs(val - minMaxRight[1]));
        }
        return max;
    }

    /**
     * 获取当前树的最大值和最小值
     * @param root
     * @return
     */
    private int[] getMinMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] leftMinMax = getMinMax(root.left);
        int[] rightMinMax = getMinMax(root.right);
        if (leftMinMax == null && rightMinMax == null) {
            return new int[]{
                    root.val,
                    root.val
            };
        } else if (leftMinMax == null) {
            return new int[] {
                    Math.min(root.val, rightMinMax[0]),
                    Math.max(root.val, rightMinMax[1])
            };
        } else if (rightMinMax == null) {
            return new int[] {
                    Math.min(root.val, leftMinMax[0]),
                    Math.max(root.val, leftMinMax[1])
            };
        } else {
            return new int[] {
                    Math.min(Math.min(leftMinMax[0], rightMinMax[0]), root.val),
                    Math.max(Math.max(leftMinMax[1], rightMinMax[1]), root.val)
            };
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "[8,3,10,1,6,null,14,null,null,4,7,13]";
        TreeNode root = TreeNodeUtil.generateTreeByArrayString(str);
        int i = solution.maxAncestorDiff(root);
        System.out.println(i);
        Assert.assertEquals(7, i);


        str = "[9,null,1,2,7,4,null,8,null,0,6,null,null,3,null,null,null,null,5]";
        root = new TreeNode(9);
        root.left = null;
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);

        root.right.left.left = new TreeNode(4);

        root.right.right.left = new TreeNode(7);
        i = solution.maxAncestorDiff(root);
        System.out.println(i);
        Assert.assertEquals(8, i);
    }
}
