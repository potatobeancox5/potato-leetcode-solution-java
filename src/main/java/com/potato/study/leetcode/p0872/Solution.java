package com.potato.study.leetcode.p0872;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhao11
 * <p>
 * 872. Leaf-Similar Trees
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.



Note:

Both of the given trees will have between 1 and 100 nodes.
 *
 *
 * 题目含义：
 *
 * 思路：
 *  分别对两个树 求它的叶子序列 然乎比较

 *
 */
public class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        this.getLeafSequence(root1, result1);
        this.getLeafSequence(root2, result2);
        // 比较是否是叶子相同
        if (result1.size() != result2.size()) {
            return false;
        }
        for (int i = 0; i < result1.size(); i++) {
            if (result1.get(i) != result2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void getLeafSequence(TreeNode root, List<Integer> result) {
        if (root.right == null && root.left == null) {
            result.add(root.val);
        }
        if (root.left != null) {
            getLeafSequence(root.left, result);
        }
        if (root.right != null) {
            getLeafSequence(root.right, result);
        }
    }


    public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();

    }
}
