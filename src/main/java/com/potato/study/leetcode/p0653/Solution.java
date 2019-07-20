package com.potato.study.leetcode.p0653;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         653. Two Sum IV - Input is a BST
 * 
 *         Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input:
5
/ \
3   6
/ \   \
2   4   7

Target = 9

Output: True


Example 2:

Input:
5
/ \
3   6
/ \   \
2   4   7

Target = 28

Output: False
 * 
 *         思路：
 *         遍历二叉树 使用一个map 记录节点 出现次数
 *         遍历map 找是否存在 k - value
 *
 */
public class Solution {

    private Map<Integer, Integer> valueTimesMap = new HashMap<>();

    public boolean findTarget(TreeNode root, int k) {
        preorderCountNode(root);
        for (Map.Entry<Integer, Integer> en : valueTimesMap.entrySet()) {
            if (k - en.getKey() == en.getKey() && en.getValue() >= 2) {
                return true;
            }
            if (k - en.getKey() != en.getKey() && valueTimesMap.containsKey(k - en.getKey())) {
                return true;
            }
        }
        return false;
    }

    private void preorderCountNode(TreeNode root) {
        if (null == root) {
            return;
        }
        Integer nodeVal = valueTimesMap.get(root.val);
        if (null == nodeVal) {
            valueTimesMap.put(root.val, 1);
        } else {
            valueTimesMap.put(root.val, nodeVal + 1);
        }
        if (root.left != null) {
            preorderCountNode(root.left);
        }
        if (root.right != null) {
            preorderCountNode(root.right);
        }
    }

	
	public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 10;
        boolean res = solution.findTarget(null, k);
        System.out.println(res);
    }
}
