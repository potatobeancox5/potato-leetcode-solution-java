package com.potato.study.leetcode.p0783;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	783. Minimum Distance Between BST Nodes
 *  
 *        Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

4
/   \
2      6
/ \
1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.

 *
 *
 *   解题思路：
 *   783. Minimum Distance Between BST Nodes
遍历二叉树 返回结果 中序
遍历结果 计算相邻值差 min

traverse root resList
if root is null
return
if root left is not null
traverse rootleft
list add root val
if root right is not null
traverse rootright
 * 
 */
public class Solution {

    public int minDiffInBST(TreeNode root) {

        List<Integer> tmpSortList = new ArrayList<>();
        // 中序遍历bst 获取递增的序列
        traverseBst(root, tmpSortList);
        // 遍历序列 寻找相邻val相差最小的地方
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < tmpSortList.size(); i++) {
            min = Math.min(min, tmpSortList.get(i) - tmpSortList.get(i - 1));
        }
        return min;
    }

    private void traverseBst(TreeNode root,  List<Integer> tmpSortList) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            traverseBst(root.left, tmpSortList);
        }
        // do sth
        tmpSortList.add(root.val);
        if (root.right != null) {
            traverseBst(root.right, tmpSortList);
        }
    }



	
	public static void main(String[] args) {
		Solution solution = new Solution();
    }
}
