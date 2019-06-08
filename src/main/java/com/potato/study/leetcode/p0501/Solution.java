package com.potato.study.leetcode.p0501;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *        501. Find Mode in Binary Search Tree
 * 
 *         Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.


For example:
Given BST [1,null,2,2],

1
\
2
/
2


return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).


 * 
 *         题目含义：
 *          找到二叉树中出现次数最多的节点
 *         思路：
 *          https://www.cnblogs.com/grandyang/p/6436150.html
 *          中序遍历数组 使用 pre记录上一个节点的值 count 记录当前数字出现次数 max记录最多出现次数 数组记录结果
 *          如果当前value == pre count ++ 如果count > max 清空数组 如果count == max 向数组内追加当前value
 *          
 */
public class Solution {


    private int pre;
    private int count;
    private int maxCount;
    private int[] resArr;

    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        pre = Integer.MIN_VALUE;
        count = 0;
        maxCount = 0;

        inOrderTraversing(root, res);

        resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return this.resArr;
    }

    /**
     *
     * @param root      当前节点
     * @param res       当前结果
     *  count     本次积累的次数
     * maxCount  历史上出现最多的次数
     */
    private void inOrderTraversing(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        inOrderTraversing(root.left, res);
        // visit this node
        if (pre == root.val) {
            count++;
        } else {
            count = 1;
            pre = root.val;
        }
        // 设置最大值
        if (count == maxCount) {
            res.add(root.val);
        } else if (count > maxCount) {
            res.clear();
            res.add(root.val);
            maxCount = count;
        }
        inOrderTraversing(root.right, res);
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode rightChild = new TreeNode(2);
//        TreeNode rightChild2 = new TreeNode(2);
        root.left = rightChild;
//        rightChild.left = rightChild2;

        int[] mode = solution.findMode(root);
        System.out.println(Arrays.toString(mode));
//
//
//
//        System.out.println(Arrays.toString(words));

    }
}
