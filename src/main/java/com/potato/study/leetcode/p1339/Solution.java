package com.potato.study.leetcode.p1339;



import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	1339. Maximum Product of Splitted Binary Tree
 *  
 *
Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.

Since the answer may be too large, return it modulo 10^9 + 7.



Example 1:



Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
Example 2:



Input: root = [1,null,2,3,4,null,null,5,6]
Output: 90
Explanation:  Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
Example 3:

Input: root = [2,3,9,10,7,8,6,5,4,11,1]
Output: 1025
Example 4:

Input: root = [1,1]
Output: 1


Constraints:

Each tree has at most 50000 nodes and at least 2 nodes.
Each node's value is between [1, 10000].
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/solution/java-jian-dan-yi-dong-de-dai-ma-by-william-43/
 *
 *
 *
 *
 *

 *
 */
public class Solution {

    private double ans = Double.MIN_VALUE;
    private double allSum;
    private double nodeSum;


    public int maxProduct(TreeNode root) {
        allSum = sum(root);
        dfs(root);
        return (int)(ans % (int)(1e9 + 7));
    }

    private double sum(TreeNode node){
        if(node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

    private double dfs(TreeNode node){
        if(node == null) {
            return 0 ;
        }
        nodeSum = node.val + dfs(node.left) + dfs(node.right);
        ans = Math.max(ans, (allSum - nodeSum) * nodeSum);
        return nodeSum;
    }

	public static void main(String[] args) {
    }
}
