package com.potato.study.leetcode.p0257;

import java.util.ArrayList;
import java.util.List;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *      257. Binary Tree Paths
 * 
 *Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

* 
* 
* 思路：二叉树 从root 到叶节点的路径全集
* 
* 
 */
public class Solution {
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> whole = new ArrayList<>(); 
		if(root == null) {
			return whole;
		}
		if(root.left == null && root.right == null) {
			whole.add("" + root.val);
			return whole;
		}
		if(root.left != null) {
			whole.addAll(generateTreePaths("" + root.val, root.left));
		}
		if(root.right !=null) {
			whole.addAll(generateTreePaths("" + root.val,root.right));
		}
		return whole;
    }
	
	/**
	 * 生成 字符串
	 * @param tmpStr
	 * @param root
	 * @return
	 */
	private List<String> generateTreePaths(String tmpStr, TreeNode root) {
		List<String> result = new ArrayList<>();
		tmpStr = tmpStr + "->" + root.val;
        if(root.left == null && root.right == null) {
        	result.add(tmpStr);
        	return result;
        } 
        if(root.left != null) {
        	result.addAll(generateTreePaths(tmpStr, root.left));
        }
        if(root.right != null) {
        	result.addAll(generateTreePaths(tmpStr, root.right));
        }
        return result;
    }
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	String arrStr = "[1,2,3,null,5]";
    	TreeNode root = TreeNodeUtil.generateTreeByArrayString(arrStr);
    	List<String> paths = solution.binaryTreePaths(root);
    	System.out.println(paths);
	}
}
