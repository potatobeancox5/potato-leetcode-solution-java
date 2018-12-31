package com.potato.study.leetcode.p0199;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 *         199. Binary Tree Right Side View
 * 
 *         Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

1            <---
/   \
2     3         <---
\     \
5     4       <---
 * 
 *         思路：
 *         从右边看二叉树的样子
 *         解法：
 *         按层次遍历，打印每层最后一个节点，需要记录当前层有多少个节点
 *
 * 		
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSidelist = new ArrayList<>();
        if(root == null) {
            return rightSidelist;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int thisLayerdNum = 1;
        int currentNodeNum = 0;
        int nextLayerNum = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (node.left != null) { // left child
                queue.add(node.left);
                nextLayerNum++;
            }
            if (node.right != null) { // right child
                queue.add(node.right);
                nextLayerNum++;
            }
            currentNodeNum++;
            if (currentNodeNum == thisLayerdNum) { // 当前节点是本层最后一个节点
                rightSidelist.add(node.val);
                currentNodeNum = 0;
                thisLayerdNum = nextLayerNum;
                nextLayerNum = 0;
            }
        }
        return rightSidelist;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();

	}
}
