package com.potato.study.leetcode.p0450;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *   450. Delete Node in a BST
 * 
 *      Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

5
/ \
3   6
/ \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

5
/ \
4   6
/     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

5
/ \
2   6
\   \
4   7
 * 
 *         思路：
 *          450. Delete Node in a BST

https://cloud.tencent.com/developer/article/1454583

如果当前值不等于 target 递归删除左右孩子

如果 tageet ==当前节点
 * 				
 */	
public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        if (root.val > key) {
            root.left = this.deleteNode(root.left, key);
        } else if (root.val < key){
            root.right = this.deleteNode(root.right, key);
        } else {
            // 相等
            if (root.left != null && root.right != null) {
                // 找到左孩子的最右边节点即为
                TreeNode left = root.left;
                while (null != left.right) {
                    left = left.right;
                }
                root.val = left.val;
                root.left = this.deleteNode(root.left, left.val);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {
                // 叶子节点直接删除
                return null;
            }
        }
        return root;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String s = "Aabb";
//        String str = solution.frequencySort(s);
//		System.out.println(str);
	}
}
