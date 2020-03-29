package com.potato.study.leetcode.p1026;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	1026. Maximum Difference Between Node and Ancestor
 *  
 *        Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

(A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)



Example 1:



Input: [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation:
We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.


Note:

The number of nodes in the tree is between 2 and 5000.
Each node will have value between 0 and 100000.

 *         
 *         思路：
 *          https://blog.csdn.net/ccystewart/article/details/90143382
 *
 */
public class Solution {

    public int maxAncestorDiff(TreeNode root) {
        return dfsGetTheDifference(root.val, root.val, root);
    }

    private int dfsGetTheDifference(int max, int min, TreeNode root) {
        if (null == root) {
            return max - min;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(dfsGetTheDifference(max, min, root.left), dfsGetTheDifference(max, min, root.right));
    }
	
	public static void main(String[] args) {}
}
