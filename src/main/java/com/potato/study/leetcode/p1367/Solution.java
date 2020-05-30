package com.potato.study.leetcode.p1367;


import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	1367. Linked List in Binary Tree
 *  
 *
Given a binary tree root and a linked list with head as the first node.

Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.

In this context downward path means a path that starts at some node and goes downwards.



Example 1:



Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.
Example 2:



Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Example 3:

Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.


Constraints:

1 <= node.val <= 100 for each node in the linked list and binary tree.
The given linked list will contain between 1 and 100 nodes.
The given binary tree will contain between 1 and 2500 nodes.
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/linked-list-in-binary-tree/solution/qiao-miao-li-yong-shen-du-you-xian-sou-suo-gai-jin/
 *
 *
 *
 *
 */
public class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val == root.val) {
            return isHeadPath(head.next, root.left) || isHeadPath(head.next, root.right) || isSubPath(head, root.left)
                    || isSubPath(head, root.right);
        } else {
            return isSubPath(head, root.left) || isSubPath(head, root.right);
        }
    }

    private boolean isHeadPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != head.val) {
            return false;
        } else {
            return isHeadPath(head.next, root.left) || isHeadPath(head.next, root.right);
        }
    }

}
