package com.potato.study.leetcode.p0623;

import com.potato.study.leetcode.domain.TreeNode;


/**
 * 
 * @author liuzhao11
 * 
 *         623. Add One Row to Tree
 * 
 *         Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

Example 1:
Input:
A binary tree as following:
4
/   \
2     6
/ \   /
3   1 5

v = 1

d = 2

Output:
4
/ \
1   1
/     \
2       6
/ \     /
3   1   5

Example 2:
Input:
A binary tree as following:
4
/
2
/ \
3   1

v = 1

d = 3

Output:
4
/
2
/ \
1   1
/     \
3       1
Note:
The given d is in range [1, maximum depth of the given tree + 1].
The given binary tree has at least one tree node.
 *
 * 	思路：
 * 	623. Add One Row to Tree

给树加一个层

https://blog.csdn.net/magicbean2/article/details/78993489



addroot 参数列表
node 当前结点连接的下个结点
val node值
n层数 n等于1时添加
isleft node放left 还是右孩子

if n是1
new  node
按照isleft 设置孩子
return new node

if node 是空 返回null

node left 等于 递归添加left
right 同理


return node
 *
 */
public class Solution {

    /**
     *
     * @param root
     * @param v     value
     * @param d     添加到第几层
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return addOneRow(root, v, true, d);
    }

    /**
     *
     * @param root
     * @param val
     * @param isSetLeft 是否设置到左孩子上
     * @param curLayerIndex  当前层号
     * @return
     */
    private TreeNode addOneRow(TreeNode root, int val, boolean isSetLeft, int curLayerIndex) {
        if (curLayerIndex == 1) {
            // if n是1
//        按照isleft 设置孩子
            //  new  node
            TreeNode node = new TreeNode(val);
            if (isSetLeft) {
                node.left = root;
            } else {
                node.right = root;
            }
//        return new node
            return node;
        }
//        if node 是空 返回null
        if (null == root) {
            return null;
        }
        root.left = addOneRow(root.left, val, true, curLayerIndex - 1);
        root.right = addOneRow(root.right, val, false, curLayerIndex - 1);
//        node left 等于 递归添加left
//        right 同理
//        return node
        return root;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        TreeNode root = null;
        int v = 10;
        int d = 1;
		int[] nums = {-4,-3,-2,-1,60};
        TreeNode maximumProduct = solution.addOneRow(root, v, d);
		System.out.println(maximumProduct);
	}
}
