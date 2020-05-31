package com.potato.study.leetcode.p0988;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	988. Smallest String Starting From Leaf
 *  
 *        Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)



Example 1:



Input: [0,1,2,3,4,3,4]
Output: "dba"
Example 2:



Input: [25,1,3,1,3,0,2]
Output: "adz"
Example 3:



Input: [2,2,1,null,1,0,null,0]
Output: "abc"


Note:

The number of nodes in the given tree will be between 1 and 8500.
Each node in the tree will have a value between 0 and 25.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/solution/tong-yong-shu-xing-dfs-by-user8772-4/
 *
 *
 */
public class Solution {

    private String ans = "~";
    private StringBuilder tmp = new StringBuilder();

    public String smallestFromLeaf(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        tmp.append((char) ('a' + node.val));
        if (node.left == null && node.right == null) {
            String tmpStr = tmp.reverse().toString();
            ans = tmpStr.compareTo(ans) < 0 ? tmpStr : ans;
            tmp.reverse();
        }
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
        tmp.deleteCharAt(tmp.length() - 1);
    }
}
