package com.potato.study.leetcode.p0863;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	863. All Nodes Distance K in Binary Tree
 *  
 *         We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.



Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation:
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.


Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.
 *         
 *
 *         题目含义：
 *
 *          返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *         思路：
 *
 *          https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/solution/er-cha-shu-zhong-suo-you-ju-chi-wei-k-de-jie-dian-/
 *
 *          计算节点之间的距离
 *
 *          dfs 查找 距离 当前节点距离root 多少距离 就找root 孩子距离为  k- l
 *
 *
 *
 */
public class Solution {

    private int k;
    /**
     * 目标
     */
    private TreeNode target;
    /**
     * 结果结合
     */
    private List<Integer> result;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        this.k = k;
        this.target = target;
        this.result = new ArrayList<>();

        dfs(root);
        return result;
    }

    /**
     * -1 代表 root 孩子中 没有target
     * @param root
     * @return  返回 root 中target 距离 target
     */
    private int dfs(TreeNode root) {
        if (null == root) {
            return -1;
        }
        if (target == root) {
            subtreeAdd(root, 0);
            return 1;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left != -1) {
            if (left == k) {
                result.add(root.val);
            }
            subtreeAdd(root.right, left + 1);
            return left + 1;
        } else if (right != -1) {
            if (right == k) {
                result.add(root.val);
            }
            subtreeAdd(root.left, right + 1);
            return right + 1;
        } else {
            return -1;
        }

    }

    /**
     * 将距离 root 距离 k 的节点 放入 answer
     * @param root
     * @param dis
     */
    private void subtreeAdd(TreeNode root, int dis) {
        if (null == root) {
            return;
        }
        // get
        if (dis == k) {
            result.add(root.val);
        } else {
            // 递归 左右孩子
            subtreeAdd(root.left, dis + 1);
            subtreeAdd(root.right, dis + 1);
        }
    }
}
