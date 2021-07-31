package com.potato.study.leetcodecn.p00671.t001;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 *
 *
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    private int minValue;
    private int secondMinValue;

    // 671 找到特定二叉树的第二小的点
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        this.minValue = root.val;
        this.secondMinValue = root.val;

        getSecondMinimumValue(root.left);
        getSecondMinimumValue(root.right);

        if (minValue == secondMinValue) {
            return -1;
        }
        return secondMinValue;
    }

    private void getSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return;
        }
        // 未找到 second
        if (root.val > minValue && minValue == secondMinValue) {
            secondMinValue = root.val;
        } else if (root.val > minValue && root.val < secondMinValue) {
            secondMinValue = root.val;
        } else if (root.val > minValue && root.val > secondMinValue) {
            // 当前点已经肯定不是第二小的了，孩子更不可能了
            return;
        }
        getSecondMinimumValue(root.left);
        getSecondMinimumValue(root.right);
    }


}
