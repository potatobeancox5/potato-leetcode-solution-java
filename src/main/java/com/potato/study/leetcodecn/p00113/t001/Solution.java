package com.potato.study.leetcodecn.p00113.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II

 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

 说明: 叶子节点是指没有子节点的节点。

 示例:
 给定如下二叉树，以及目标和 sum = 22，

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 返回:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/path-sum-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 递归找根到叶子节点 距离 等于targetSum 的值
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        this.pathSum(result, root, targetSum, new ArrayList<>());
        return result;
    }

    /**
     *
     * @param result
     * @param root          当前节点
     * @param targetSum     目标数字
     * @param current       当前 结果
     */
    private void pathSum(List<List<Integer>> result, TreeNode root, int targetSum, List<Integer> current) {
        if (root == null) {
            return;
        }
        // 叶子节点 且 target
        List<Integer> list = new ArrayList<>(current);
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(list);
            return;
        }
        if (root.left != null) {
            pathSum(result, root.left, targetSum - root.val, list);
        }
        if (root.right != null) {
            pathSum(result, root.right, targetSum - root.val, list);
        }
    }

    public static void main(String[] args) {

    }
}
