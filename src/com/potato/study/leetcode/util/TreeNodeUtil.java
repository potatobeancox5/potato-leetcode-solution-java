package com.potato.study.leetcode.util;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * TreeNode 工具类 树节点
 * @author Administrator
 *
 */
public class TreeNodeUtil {
	private TreeNodeUtil() {
		
	}

	
	/**
	 * 将字符串  转换成 二叉树结构[5,1,4,null,null,3,6] 转换成树结构
	 * 字符串形式不进行判断 字符串结构必须合法
	 * @param arrStr
	 * @return
	 */
	public static TreeNode generateTreeByArrayString(String arrStr) {
		//去掉 【 和】
		String newArrStr = arrStr.substring(1, arrStr.length() - 1);
		// 分割字符串 
		String[] nodeValArr = newArrStr.split(",");
		// 生成的字符串数组对应一个满二叉树
		TreeNode head = generateTreeNode(0,nodeValArr);
		return head;
	}
	
	private static TreeNode generateTreeNode(int nodeIndex, String[] arr) {
		if(nodeIndex < arr.length) {
			if("null".equals(arr[nodeIndex])) {
				return null;
			} else {
				int val = Integer.parseInt(arr[nodeIndex]);
				TreeNode current = new TreeNode(val);
				current.left = generateTreeNode(2 * nodeIndex + 1, arr);
				current.right = generateTreeNode(2 * nodeIndex + 2, arr);
				return current;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		String arrStr = "[5,1,4,null,null,3,6]";
		TreeNode head = generateTreeByArrayString( arrStr);
		System.out.println(head);
	}
}
