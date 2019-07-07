package com.potato.study.leetcode.p0543;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         543. Diameter of Binary Tree
 * 
 *         Given a string and an integer k, you need to reverse the first k
 *         characters for every 2k characters counting from the start of the
 *         string. If there are less than k characters left, reverse all of
 *         them. If there are less than 2k but greater than or equal to k
 *         characters, then reverse the first k characters and left the other as
 *         original. Example: Input: s = "abcdefg", k = 2 Output: "bacdfeg"
 *         Restrictions: The string consists of lower English letters only.
 *         Length of the given string and k will in the range [1, 10000]
 * 
 * 
 *         思路： 交换前k 个 0- k-1 2k~ 3k-1 ... 
 *         // 计算需要正常交换几次 有n个k 需要交换 （n+1） / 2 次
 *          //余数r 若n为奇数 不动了 //若n为偶数 交换最后的r个数
 *          
 *          直接对0 - k-1 倒序遍历 使用StringBuilder 添加
 *       
 *          
 */
public class Solution {

	private int maxDiameter = 0;


	public int diameterOfBinaryTree(TreeNode root) {
		this.getDepthOfRoot(root);
		return maxDiameter;
	}

	private int getDepthOfRoot(TreeNode root) {
		// 空节点 定义为高度啊 高度-1
		if (null == root) {
			return -1;
		}
		// 计算两个子树的深度
		int leftDepth = getDepthOfRoot(root.left);
		int rightDepth = getDepthOfRoot(root.right);

		int currentDiameter = leftDepth + rightDepth + 2;

		// 判断是否是最大值
		if (currentDiameter > maxDiameter) {
			maxDiameter = currentDiameter;
		}
		// 返回 当前树深度
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = null;
		int diameter = solution.diameterOfBinaryTree(root);
		System.out.println(diameter);
	}
}
