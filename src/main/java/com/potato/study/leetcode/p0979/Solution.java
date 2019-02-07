package com.potato.study.leetcode.p0979;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 	979. Distribute Coins in Binary Tree
 *  
 *         Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.



Example 1:



Input: [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
Example 2:



Input: [0,3,0]
Output: 3
Explanation: From the left child of the root, we move two coins to the root [taking two moves].  Then, we move one coin from the root of the tree to the right child.
Example 3:



Input: [1,0,2]
Output: 2
Example 4:



Input: [1,0,0,null,3]
Output: 4


Note:

1<= N <= 100
0 <= node.val <= N

 *         
 *         思路：
 *         https://blog.csdn.net/fuxuemingzhu/article/details/86563872
 *         移动次数等于 当前节点的叶子节点左右多出来的或者缺少的节点的绝对值的和，遍历一下记录总次数就好了
 */
public class Solution {

    public int distributeCoins(TreeNode root) {
        if (null == root) {
            return 0;
        }
        // 当前字节点树 - 当前字节点有金币数字
//        if (root.left == null && root.right == null) {
//            return ;
//        }
        int sum = 0;
//        int[] result = new int[2];// 0 child node num ；1 child coin num
        int[] result = this.getNodeInfo(root);
        sum += (Math.abs(result[0] - result[1]));
        if (root.left != null) {
            sum += distributeCoins(root.left);
        }
        if (root.right != null) {
            sum += distributeCoins(root.right);
        }
        return sum;
    }

    /**
     * 获取当前节点 所在树又多少个节点 又多少哥硬币
     * @param root
     */
    private int[] getNodeInfo(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] thisResult = new int[2];
        if (root.left == null && root.right == null) {
            thisResult[0]++;
            thisResult[1] += root.val;
            return thisResult;
        }
        if (null != root.left) {
            int[] nodeInfo = getNodeInfo(root.left);
            thisResult[0] += nodeInfo[0];
            thisResult[1] += nodeInfo[1];
        }
        if (null != root.right) {
            int[] nodeInfo = getNodeInfo(root.right);
            thisResult[0] += nodeInfo[0];
            thisResult[1] += nodeInfo[1];
        }
        thisResult[0] += 1;
        thisResult[1] += root.val;
        return thisResult;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[3,0,0]");
        int result = solution.distributeCoins(root);
        System.out.println(result);
    }
}
