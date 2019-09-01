package com.potato.study.leetcode.p1028;


import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreePrintUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 	1028. Recover a Tree From Preorder Traversal
 *  
 *        We run a preorder depth first search on the root of a binary tree.

At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)

If a node has only one child, that child is guaranteed to be the left child.

Given the output S of this traversal, recover the tree and return its root.



Example 1:



Input: "1-2--3--4-5--6--7"
Output: [1,2,5,3,4,6,7]
Example 2:



Input: "1-2--3---4-5--6---7"
Output: [1,2,5,3,null,6,null,4,null,7]


Example 3:



Input: "1-401--349---90--88"
Output: [1,401,null,349,88,90]


Note:

The number of nodes in the original tree is between 1 and 1000.
Each node will have a value between 1 and 10^9.

 *         
 *         思路：
 *          给定一个字符串 代表一个数 每个节点前面的 - 代表是第几层的
 *
 *
 *
 */
public class Solution {

    private int indexBefore;

    public TreeNode recoverFromPreorder(String str) {
        indexBefore = -1;
        return builderTree(str, 0);
    }


    /**
     * 递归生成树，返回生成的树
     * @param s             待加工的原字符串
     * @param layerIndex    当前的层级别数字 从0开始计数
     * @return
     */
    private TreeNode builderTree(String s, int layerIndex) {
        // 保存中间态 只要不变动 就不改变属性值 而使用中间态
        int current = indexBefore + 1;
        // 计算indexBef + 1 是否合法
        if (current >= s.length()) {
            return null;
        }
        // 判断indexBef + 1 是啥 数字 -
        int blankNum = 0;
        while (current < s.length() && s.charAt(current) == '-') {
            blankNum++;
            current++;
        }
        // 层界别数不一致
        if (layerIndex != blankNum) {
            return null;
        }
        // 层级一致 计算数字
        int num = 0;
        while (current < s.length() && Character.isDigit(s.charAt(current))) {
            num = 10 * num;
            num += s.charAt(current) - '0';
            current++;
        }
        // 没有返回 因此可以修改中间态了
        this.indexBefore = current - 1;
        // 数字也有了 创建 树节点
        TreeNode node = new TreeNode(num);
        node.left = builderTree(s,layerIndex + 1);
        node.right = builderTree(s, layerIndex + 1);
        return node;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String str = "1-2--3--4-5--6--7";
        TreeNode root = solution.recoverFromPreorder(str);
        TreePrintUtil.pirnt(root);
    }
}
